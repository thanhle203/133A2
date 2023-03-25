package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class Exit extends Command {
	
	private GameWorld gw;//reference to GameWorld class in order to invoke functions
	
	// method to instantiate the exit command
	public Exit(GameWorld realGW) {
		
		super("Exit");
		this.gw = realGW;
		
	}
	
	// method to invoke the exit functions after button press
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("Exit is invoked...");
		
		Boolean bOk = Dialog.show("Confirm quit", "Are you sure you want to quit?", "Ok", "Cancel");
		
		if(bOk) {
			this.gw.exit();
		}
		else {
			this.gw.no();
		}
		
	}
	
}