package com.mycompany.a2;

import java.util.Random;

public abstract class MovableGameObject extends GameObjects {
	
	private int maximumSpeed = 10;
	private int speed;
	private int heading;
	
   // Constructor method to create an instance of MovableGameObject and assigns the x and y parameters as the starting location for the game object
	public MovableGameObject(float x, float y) {
		
		super(x, y);
		
	}
	
	// Constructor method to create an instance of MovableGameObject and assigns random values for speed and heading
	public MovableGameObject() {
		// TODO Auto-generated constructor stub
		Random rand = new Random();
		this.speed = rand.nextInt(6) + 5;
		this.heading = rand.nextInt(360);
		
	}

	// Method to move the game object and update its location according to its heading and speed
	public void move() {
		
		float theta = (float) Math.toRadians(90 - this.heading);
		
		float deltaX = (float) (Math.cos(theta)*this.speed);
		float deltaY = (float) (Math.sin(theta)*this.speed);
		
		float newX = this.getLocationX() + deltaX;
		float newY = this.getLocationY() + deltaY;
				
		if(newX > 1000) {
			this.heading = 270;
			newX = 1000;
		}
		else if(newX < 0) {
			this.heading = 90;
			newX = 0;
		}
		else if(newY > 1000) {
			this.heading = 180;
			newY = 1000;
		}
		else if(newY < 0) {
			this.heading = 0;
			newY = 0;
		}
		
		this.setLocation(newX, newY);
		
	}
	
   // Method to update the speed of the game object
	public void setSpeed(int newSpeed) {
		
		this.speed = newSpeed;
		
	}
	
   // Method to retrieve the speed of the game object
	public int getSpeed() {
		
		return this.speed;
		
	}
	
   // Method to update the heading of the game object
	public void setHeading(int x) {
		
		this.heading = x;
		
	}
	
   // Method to retrieve the current heading of the game object
	public int getHeading() {
		
		return this.heading;
		
	}
	
	// Method to set location of game object
	public void setLocation(float x, float y) {
		
		super.setLocation(x, y);
		
	}
	
	// Method to retrieve x coordinate of game object location
	public float getLocationX() {
		return super.getLocationX();
	}
	
	// Method to retrieve y coordinate of game object location
	public float getLocationY() {
		return super.getLocationY();
	}
}