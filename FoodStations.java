package com.mycompany.a2;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class FoodStations extends FixedGameObject {
	
	private int size;
	private int capacity;
	
   /* 
      Constructor method to create an instance of food station,
      assigns a random value to its size and assigns its color   
   */
	public FoodStations() {
		
		Random rand = new Random();
		this.size = rand.nextInt(10) + 1;
		this.capacity = this.size;
		this.setColor(ColorUtil.rgb(0,255,0));
		
	}
	
   // Method to retrieve the size of the food station
	public int getFoodSize() {
		
		return this.size;
		
	}
	
   // Method to retrieve the capacity of the food station
	public int getFoodCapacity() {
		
		return this.capacity;
		
	}
	
   // Method to update the amount of food in the food station's capacity
	public void updateFoodCapacity(int x) {
		
		this.capacity -= x;
		
	}
	
   // Method to convert all of the data in this Food Station to string for output
	public String toString() {
		
		String food = "FoodStation: loc=" + Math.round(this.getLocationX()) + "," + Math.round(this.getLocationY()) + " color=[" + ColorUtil.red(this.getColor()) + "," + ColorUtil.green(this.getColor()) + "," + ColorUtil.blue(this.getColor()) + "] size=" + this.size + " capacity=" + this.capacity;
		
		return food;
	}
	
	
}