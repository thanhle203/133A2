package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Brake extends Command {
	
	private GameWorld gw;//reference to GameWorld class in order to invoke functions
	
	// method to instantiate a brake command
	public Brake(GameWorld realGW) {
		
		super("Brake");
		this.gw = realGW;
		
	}
	
	// method to invoke the brake function after key or button is pressed
	public void actionPerformed(ActionEvent e) {
		this.gw.brake();
		System.out.println("Brake is invoked...");
	}
	
}