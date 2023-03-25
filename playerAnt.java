package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class playerAnt extends MovableGameObject implements ISteerable {
	
	private static playerAnt thisAnt;
	
	private int foodLevel;
	private int foodConsumptionRate;
	private int healthLevel;
	private int lastFlagReached;
	private int size;
	
   // Constructor method to create a new instance of the player ant
	private playerAnt(float x, float y) {
		
		super(x, y);
		
		this.lastFlagReached = 1;
		this.size = 40;
		this.foodConsumptionRate = 2;
		this.healthLevel = 10;
		this.foodLevel = 10;
		this.setColor(ColorUtil.rgb(255,0,0));
		this.setHeading(0);
		this.setSpeed(5);
	
	}
	
	//Method for clients to retrieve player ant
	public static playerAnt getPlayerAnt(float x, float y) {
		if(thisAnt == null) {
			thisAnt = new playerAnt(x, y);
		}
		
		return thisAnt;
	}
	
   // Method to set the speed of the ant
	public void setSpeed(int newSpeed) {
		
      // Checks to see if the new speed will be above the maximum speed and doesn't change if it is
		if(newSpeed > 10) {
			System.out.println("Cannot increase speed. Maximum speed has been reached.");
		}
      
      // Checks to see if the new speed is lower than 0 and doesn't change if it is
		else if(newSpeed < 0) {
			System.out.println("Cannot decrease speed. Minimum speed has been reached.");
		}
		
      /*
         Checks to see if the new speed will go above the health that the ant currently has
         and doesn't change if it is
      */   
		else if(newSpeed > this.healthLevel){
			System.out.println("Cannot increase speed due to health.");
		}
      
      // If the new speed passes all of the previous tests, then set the new speed of the ant
		else {
			super.setSpeed(newSpeed);
		}
		
	}
	
   // Method to retrieve the highest numbered flag that the ant has reached in the game
	public int getLastFlagReached() {
		return this.lastFlagReached;
	}
	
   // Method to update the ant's highest numbered flag that it reached in the game
	public void updateLastFlagReached() {
		
		lastFlagReached++;
		
	}
	
   // Method to retrieve the ant's size
	public int getSize() {
		
		return this.size;
		
	}
	
   // Method to retrieve the ant's current food level
	public int getFoodLevel() {
		
		return this.foodLevel;
		
	}
	
   // Method to retrieve the ant's food consumption rate
	public int getFoodConsumptionRate() {
		
		return this.foodConsumptionRate;
		
	}
	
   // Method to overwrite ant's health level when taking damage or when losing a life and resetting 
	public void setHealthLevel(int newHealth) {
		
		this.healthLevel = newHealth;
		
	}
	
   // Method to retrieve ant's current health level
	public int getHealthLevel() {
		
		return this.healthLevel;
		
	}
	
   /* 
      Method to update ant's food level when colliding with food station
      or when clock has ticked and food is consumed
   */
	public void updateFoodLevel(int x) {
		
		this.foodLevel += x;
      
      // Checks to see if food level is under 0 after being consumed. If so, overwrite and set to 0.
		if(this.foodLevel < 0) {
			this.foodLevel = 0;
		}
      
	}
	
   // Method to overwrite the ant's food level after losing a life
	public void setFoodLevel(int x) {
		
		this.foodLevel = x;
		
	}
	
	
	// Method to change the heading of the ant's direction of movement
	public void steer(int newHead) {
		
		this.setHeading(newHead);
		
	}
	
	// Method to assign the location of the game object
		public void setLocation(float x, float y) {
			
			super.setLocation(x, y);
			
		}
		
	   // Method to retrieve x coordinate of the game object
		public float getLocationX() {
			
			return super.getLocationX();
			
		}
		
		// Method to retrieve y coordinate of the game object
		public float getLocationY() {
				
			return super.getLocationY();
				
		}
	
   // Converts all data of player Ant into a string for output
	public String toString() {
		
		
		String ant = "Ant: loc=" + Math.round(this.getLocationX())+"," + Math.round(this.getLocationY()) +
					" color: [" + ColorUtil.red(this.getColor()) + "," + ColorUtil.green(this.getColor()) + ","
					+ ColorUtil.blue(this.getColor()) + "] heading=" + this.getHeading() + " speed=" + this.getSpeed()
					+ " size=" + this.getSize() + " maxSpeed=10" + " foodConsumptionRate=" + 
					this.getFoodConsumptionRate();
		
		return ant;
		
	}
	
}