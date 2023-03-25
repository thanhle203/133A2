package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class RightTurn extends Command {
	
	private GameWorld gw;//reference to GameWorld class in order to invoke functions
	
	// method to instantiate right turn command
	public RightTurn(GameWorld realGW) {
		
		super("Right Turn");
		this.gw = realGW;
		
	}
	
	//method to invoke the required right turn function after button or key press
	public void actionPerformed(ActionEvent e) {
		this.gw.right();
		System.out.println("Right Turn is invoked...");
	}
	
}