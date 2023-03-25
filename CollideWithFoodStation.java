package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;

public class CollideWithFoodStation extends Command {
	
	private GameWorld gw;//reference to GameWorld class in order to invoke functions
	
	// method to instantiate a collide with food station command
	public CollideWithFoodStation(GameWorld realGW) {
		
		super("Food Station");
		this.gw = realGW;
		
	}
	
	// method to invoke the food collision function after button or key is pressed
	public void actionPerformed(ActionEvent e) {
		
		this.gw.foodCollision();
		System.out.println("Collide With Food Station invoked ...");
	}
	
}