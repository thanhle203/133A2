package com.mycompany.a2;

import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class Spider extends MovableGameObject {
	
	private int size;
	private int color;
	private Point location;
	
   // Constructor method to create an instance of Spider, assigns a random value to size and sets its color
	public Spider() {
		
		super();
		
		Random rand = new Random();
		this.size = rand.nextInt(11) + 20;
		this.setColor();
		
	}
	
	//Method to set the spider color
	public void setColor() {
		this.color = ColorUtil.rgb(0,0,0);
	}
	
   // Method to retrieve the size of the spider
	public int getSize() {
		
		return this.size;
		
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
	
   // Method to convert all of the spider's data into a string for output
	public String toString() {
		

		String spider = "Spider: loc=" + Math.round(this.getLocationX()) + "," + 
		Math.round(this.getLocationY()) + " color=[" + ColorUtil.red(this.getColor()) + ","
		+ ColorUtil.green(this.getColor()) + "," + ColorUtil.blue(this.getColor()) + "] heading=" 
		+ this.getHeading() + " speed=" + this.getSpeed() + " size=" + this.getSize();
		
		
		return spider;
		
	}
	
}