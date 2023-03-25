package com.mycompany.a2;

import java.util.Random;
import com.codename1.charts.models.Point;

public abstract class GameObjects {
	
	private int color;
	private Point location;
	
   /* 
      Constructor method to create and instance of GameObjects, 
      creates a new vector and assigns a random value to its x and y position
   */
	public GameObjects() {
		
		Random rand = new Random();
		
		this.location = new Point(rand.nextFloat()*1000, rand.nextFloat()*1000);
		
	}
	
	// Constructor to create an instance of a game object at the specified x and y location
	public GameObjects(float x, float y) {
		this.location = new Point(x, y);
	}
	
	//Method to retrieve size of game object
	public int getSize() {
		return 0;
	}

   // Method to assign a color to the game object
	public void setColor(int newColor) {
		
		this.color = newColor;
		
	}
	
   // Method to retrieve the color of this game object
	public int getColor() {
		
		return this.color;
		
	}
	
   // Method to assign the location of the game object
	public void setLocation(float x, float y) {
		
		this.location.setX(x);
		this.location.setY(y);
		
	}
	
   // Method to retrieve x coordinate of the game object
	public float getLocationX() {
		
		return this.location.getX();
		
	}
	
	// Method to retrieve y coordinate of the game object
	public float getLocationY() {
			
		return this.location.getY();
			
	}
	
	
	
}