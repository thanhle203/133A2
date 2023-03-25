package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Accelerate extends Command {
	
	private GameWorld gw;//reference to GameWorld class in order to invoke functions
	
	// method to instantiate an accelerate command
	public Accelerate(GameWorld realGW) {
		
		super("Accelerate");
		this.gw = realGW;
		
	}
	
	// method to invoke accelerate function after button or key is pressed
	public void actionPerformed(ActionEvent e) {
		this.gw.accelerate();
		System.out.println("Acceleration is invoked...");
	}
	
}