package com.mycompany.a2;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;

public class GameWorld extends Observable implements IGameWorld {
	
	private int lives;
	private int clock = 0;
	private playerAnt myAnt;
	@SuppressWarnings("unused")
	private ArrayList<GameObjects> gameObject;
	private int b = 20;
	private int g = 20;
	private boolean sound;
	private GameObjectCollection gameObjectCollection;
	private IIterator goi;
	private int worldWidth;
	private int worldHeight;
	
	private int maxLives = 3;
	
		// Constructor that defaults sound to false and initializes the game world
		public GameWorld() {
			sound = false;
			this.init();
			this.setChanged();
			this.notifyObservers(this);
		}
	
		// Initiates game world and constructs all game objects necessary to world
		public void init() {
			
			if(this.myAnt == null) {
				this.myAnt = playerAnt.getPlayerAnt(this.worldWidth/2, this.worldHeight/2);
			}
			
			this.lives = maxLives;
			this.gameObjectCollection= new GameObjectCollection();
			
			for(int i = 0; i < 9; i++) {
				
				this.gameObjectCollection.add(new Flag(i));
				
			}
			

			this.gameObjectCollection.add(this.myAnt);
			
				
			this.gameObjectCollection.add(new Spider());	
			this.gameObjectCollection.add(new Spider());
				
			this.gameObjectCollection.add(new FoodStations());
			this.gameObjectCollection.add(new FoodStations());
			
			this.setChanged();
			this.notifyObservers(this);
		}
		
		// method to retrieve the amount of lives player ant has
		public int getLives() {
			return this.lives;
		}
		
		//Method to retrieve if sound is on or off
		public boolean getSound() {
			return this.sound;
		}
		
		// Method to set game sound
		public void setSound() {
			this.sound = !this.sound;
			this.setChanged();
			this.notifyObservers(this);
		}
		
      // Method to increment the ant's speed
		public void accelerate() {
			
			this.myAnt.setSpeed(this.myAnt.getSpeed() + 1);
			this.setChanged();
			this.notifyObservers(this);
			
		}
		
      // Method to decrement the ant's speed
		public void brake() {
			
			this.myAnt.setSpeed(this.myAnt.getSpeed() - 1);
			this.setChanged();
			this.notifyObservers(this);
		}
		
      /*
         Method to PRETEND that ant has collided with flag number x,
		 Updates the last flag reached for the ant and displays an 
         error message if the flag is not next in the sequence
      */
      public void flag(int x) {
			
			System.out.println("You have collided with Flag Number " + x + " .");
			
			GameObjects go;
			int num = 0;
			
			goi = gameObjectCollection.getIterator();
			
			while(goi.hasNext()) {
				go = goi.getNext();
				
				if(go instanceof Flag) {
					Flag flagNum = (Flag) go;
					if(flagNum.getFlag() == x) {
						num = flagNum.getFlag();
					}
				}
			}
			
			
			if(num > this.myAnt.getLastFlagReached() && Math.abs(this.myAnt.getLastFlagReached()-num) == 1) {
				
				this.myAnt.updateLastFlagReached();
				
			}
			else {
				System.out.println("Cannot Update Flag. You have reached a flag that is not next in the sequence.");
			}
			
			if(this.myAnt.getLastFlagReached() == 9) {
				System.out.println("Game Over, You Win! Total time: " + this.clock);
				this.yes();
			}
			
			this.setChanged();
			this.notifyObservers(this);
		}
		
      /*
         Method that pretends that the ant has collided with a food station.
         The method will pick a random food station for the ant to consume and 
         then add a new food station to the list of game objects in the world
         while fading the food station that was consumed to a light green.
      
      */
		public void foodCollision() {
			
			GameObjects go;
			
			System.out.println("You have collided with a food station.");
			
			Random rand = new Random();
			
			ArrayList<GameObjects> temp = new ArrayList<>();
			
			goi = gameObjectCollection.getIterator();
			
			while(goi.hasNext()) {
				
				go = goi.getNext();
				
				if(go instanceof FoodStations) {
					
					temp.add((FoodStations) go);
					
				}
				
			}
			
			int x = rand.nextInt(temp.size());
			
			this.myAnt.updateFoodLevel(((FoodStations) temp.get(x)).getFoodCapacity());
			
			((FoodStations) temp.get(x)).updateFoodCapacity(((FoodStations) temp.get(x)).getFoodCapacity());
			
			temp.get(x).setColor(ColorUtil.rgb(144, 238, 144));
			
			gameObjectCollection.add(new FoodStations());
			
			this.setChanged();
			this.notifyObservers(this);
		}
		
		/*
		 	Method to simulate any colliding with a spider,
		 	if health reaches zero, all game objects will clear except for ant 
		 	and they will be reinitialized, ant will maintain position in world
		 	but will reset food level and health and lose a life. Clock ticks will
		 	remain the same as well. Otherwise, ant just loses 1 health point, maximum speed
		 	of ant will be set to health level due to being hurt, and will 
		 	gradually fade in color.
		*/
		public void spiderCollision() {
			
			GameObjects go;
			
			System.out.println("You have collided with a spider.");
			
			this.myAnt.setHealthLevel(this.myAnt.getHealthLevel() - 1);
			
			if(this.myAnt.getHealthLevel() == 0) {
				
				this.maxLives -= 1;
				
				goi = gameObjectCollection.getIterator();
				
				while(goi.hasNext()) {
					go = goi.getNext();
					gameObjectCollection.remove(go);
				}
				
				g = 20;
				b = 20;
				
				
				
				this.myAnt.setHealthLevel(10);
				this.myAnt.setFoodLevel(10);
				
				if(this.maxLives == 0) {
					
					System.out.println("Game Over");
					System.exit(0);;
					
				}
				
				this.init();
				
			}
			else {
				
				this.myAnt.setColor(ColorUtil.rgb( 255, g, b));
				
				if(this.myAnt.getSpeed() > this.myAnt.getHealthLevel()) {
					
					this.myAnt.setSpeed(this.myAnt.getHealthLevel());
					
				}
				g += 20;
				b += 20;
				
			}
			
			this.setChanged();
			this.notifyObservers(this);
			
		}
		
		// Method to steer the ant to the left by 5 degrees
		public void left() {
			
			int newHeading = this.myAnt.getHeading() - 5;
			
			if(newHeading < 0) {
				
				this.myAnt.steer(newHeading + 360);
				
			}
			else {
				this.myAnt.steer(newHeading);
			}
			
			this.setChanged();
			this.notifyObservers(this);
			
		}
		
		// Method to steer the ant to the right by 5 degrees
		public void right() {
			
			int newHeading = this.myAnt.getHeading() + 5;
			
			if(newHeading > 359) {
				
				this.myAnt.steer(newHeading - 360);
				
			}
			else {
				this.myAnt.steer(newHeading);
			}
			
			this.setChanged();
			this.notifyObservers(this);
		}
		
		/*
		 	Method to signify that the game world's clock has been ticked and 
		 	all movable game objects will move according to their heading and speed.
		 	Spider will change their heading randomly by 5 degrees to avoid straight line.
		 	This will check if spider will collide with out of bounds world limit as well
		 	when it moves and then resets its heading to move it back towards the game world.
		 	Ant's food level will decrease according to food consumption rate.
		 */
		public void clock() {
			
			clock++;
			
			Random rand = new Random();
			GameObjects go;
			goi = gameObjectCollection.getIterator();
			int decider = rand.nextInt(2);
			if(decider == 0) {
				while(goi.hasNext()) {
					go = goi.getNext();
					if(go instanceof Spider) {
						MovableGameObject temp = (MovableGameObject) go;
						temp.setHeading(temp.getHeading()+5);
					}
				}
				
			}
			else {
				goi = gameObjectCollection.getIterator();
				while(goi.hasNext()) {
					go = goi.getNext();
					if(go instanceof Spider) {
						MovableGameObject temp = (MovableGameObject) go;
						temp.setHeading(temp.getHeading()-5);
					}
				}
				
				
			}
			goi = gameObjectCollection.getIterator();
			while(goi.hasNext()) {
				go = goi.getNext();
				if(go instanceof MovableGameObject) {
					
					MovableGameObject temp = (MovableGameObject) go;
					temp.move();
					
				}
				
			}
			
			
			this.myAnt.updateFoodLevel(-(this.myAnt.getFoodConsumptionRate()));
			
			if(this.myAnt.getFoodLevel() == 0) {
				this.maxLives -= 1;
				
				goi = gameObjectCollection.getIterator();
				
				while(goi.hasNext()) {
					go = goi.getNext();
					gameObjectCollection.remove(go);
				}
				
				g = 20;
				b = 20;
				
				this.myAnt.setHealthLevel(10);
				this.myAnt.setFoodLevel(10);
				
				if(this.maxLives == 0) {
					
					System.out.println("No lives remaining. Game Over. Total Time: " + this.getClock());
					System.exit(0);;
					
				}
				
				this.init();
				
			}
			
			System.out.println("Clock has ticked. All game objects have been updated.");
			
			this.setChanged();
			this.notifyObservers(this);
			
		}
		
		// Method to display the current score or stats of the Ant
		public void display() {
			
			System.out.print("Lives: " + this.lives);
			System.out.print(" | Clock: " + this.clock);
			System.out.print(" | Highest Flag Reached: " + this.myAnt.getLastFlagReached());
			System.out.print(" | Food Level: " + this.myAnt.getFoodLevel());
			System.out.print(" | Health Level: " + this.myAnt.getHealthLevel() + "\n");
			
			this.setChanged();
			this.notifyObservers(this);
		}
		
		// Method to display the location of all game objects in the game world
		public String map() {
			
			GameObjects go;
			String str = "";
			String newLine = System.getProperty("line.separator");
			
			goi = gameObjectCollection.getIterator();
			
			while(goi.hasNext()) {
				go = goi.getNext();
				str = str + go.toString() + newLine;
				
			}
			
			
			return str;
		}
		
		// Method that asks the user if they want to quit the game
		public void exit() {
			
			this.yes();
			this.setChanged();
			this.notifyObservers(this);
		}
		
		// Method to quit game if user chooses yes to quitting game
		public void yes() {
			
			Display.getInstance().exitApplication();
			
		}
		
		// Method to continue game if user chooses to say no when asked if they wanted to quit the game
		public void no() {
			
			System.out.println("You have denied exiting. Continuing game.");
			this.setChanged();
			this.notifyObservers(this);
		}

		// method to retrieve the clock time
		@Override
		public int getClock() {
			// TODO Auto-generated method stub
			return this.clock;
		}

		// method to retrieve the last flag reached by player ant
		@Override
		public int getFlag() {
			// TODO Auto-generated method stub
			return this.myAnt.getLastFlagReached();
		}

		// method to retrieve food level of ant
		@Override
		public int getFoodLevel() {
			// TODO Auto-generated method stub
			return this.myAnt.getFoodLevel();
		}

		// method to retrieve health level of ant
		@Override
		public int getHealthLevel() {
			// TODO Auto-generated method stub
			return this.myAnt.getHealthLevel();
		}

		// method to set the dimensions of the world to the MapView container size
		public void setDimensions(int width, int height) {
			// TODO Auto-generated method stub
			this.worldWidth = width;
			this.worldHeight = height;
			this.setChanged();
			this.notifyObservers(this);
		}
		
		// method to retrieve the width of the world
		public int getWidth() {
			return this.worldWidth;
		}
		
		// method to retrieve the height of the world
		public int getHeight() {
			return this.worldHeight;
		}

	

		
		
	}