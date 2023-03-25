package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class About extends Command {
	
	private GameWorld gw; //reference to GameWorld class in order to invoke functions
	
	// method to instantiate the about command
	public About(GameWorld realGW) {
		
		super("About");
		this.gw = realGW;
		
	}
	
	// method to display dialog of the about me command
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("About is invoked...");
		
		Boolean c = Dialog.show("Ant Game Version 2", "CSC 133 Spring 2023\nThanh Le", "Ok", null);
		if(c) {
			System.out.println("Closing About...");
		}
		
	}
	
}