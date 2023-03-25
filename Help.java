package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class Help extends Command {
	
	private GameWorld gw;//reference to GameWorld class in order to invoke functions
	
	// Method to instantiate help command
	public Help(GameWorld realGW) {
		
		super("Help");
		this.gw = realGW;
		
	}
	
	// Method to display messages for when help button is pressed
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("Help is invoked...");
		
		Boolean c = Dialog.show("Help", 
				"Accelerate: 'a'\nBrake: 'b'\nLeft Turn: 'l'\nRight Turn: 'r'\nCollide With Food Station: 'f'\nCollide With Spider: 'g'\nTick: 't'\nEnjoy the game!", "Ok", null);
		if(c) {
			System.out.println("Closing Help...");
		}
		
	}
	
}