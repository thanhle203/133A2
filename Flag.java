package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class Flag extends FixedGameObject {
	
	private int size = 10;
	@SuppressWarnings("unused")
	private int color;
	private int seqNum;
	private Point location;
	
   // Constructor method for creating an instance of Flag
	public Flag(int x) {
		
      // Sets sequence number of this instance of Flag by adding 1 to integer parameter
		seqNum = x + 1;
      
      // Sets color of instance of Flag
		this.setColor();
		
	}
	
	//Method to set color of Flag
	public void setColor() {
		this.color = ColorUtil.rgb(0,0,255);
	}
		
	
   // Method to retrieve the sequence number of this instance of Flag
	public int getFlag() {
		
		return this.seqNum;
		
	}
	
   // Method to retrieve size of this instance of Flag
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
	
	
   // Method to convert all data of this instance of Flag into a string for display
	public String toString() {
		
		String flag = "Flag: loc=" + Math.round(this.getLocationX()) + "," + Math.round(this.getLocationY())
		+ " color=[" + ColorUtil.red(this.getColor()) + "," + ColorUtil.green(this.getColor()) + "," + 
		ColorUtil.blue(this.getColor()) + "] size=" + this.getSize() + " seqNum=" + this.seqNum;
		
		return flag;
		
	}
	
}