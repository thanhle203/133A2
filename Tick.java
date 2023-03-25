package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;

public class Tick extends Command {
	
	private GameWorld gw;//reference to gameworld in order to invoke the GameWorld functions
	
	// method to instantiate a command for tick
	public Tick(GameWorld realGW) {
		
		super("Tick");
		this.gw = realGW;
		
	}
	
	
	// method that invoke tick from GameWorld after button or key press
	public void actionPerformed(ActionEvent e) {
		
		this.gw.clock();
		System.out.println("Tick invoked...");
	}
	
}