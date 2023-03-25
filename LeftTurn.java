package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class LeftTurn extends Command {
	
	private GameWorld gw;//reference to GameWorld class in order to invoke functions
	
	// method to instantiate left turn command
	public LeftTurn(GameWorld realGW) {
		
		super("Left Turn");
		this.gw = realGW;
		
	}
	
	// method to invoke the required left turn function after button or key press
	public void actionPerformed(ActionEvent e) {
		this.gw.left();
		System.out.println("Left Turn is invoked...");
	}
	
}