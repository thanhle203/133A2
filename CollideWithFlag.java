package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;

public class CollideWithFlag extends Command {
	
	private GameWorld gw;//reference to GameWorld class in order to invoke functions
	
	// method to instantiate a collide with flag command
	public CollideWithFlag(GameWorld realGW) {
		
		super("Flag");
		this.gw = realGW;
		
	}
	
	// method to invoke the required functions for flag collision after button is pressed
	public void actionPerformed(ActionEvent e) {
		try {
			Command ok = new Command("Ok");
		
			TextField myTF = new TextField("", "1-9", 1, TextArea.NUMERIC);
		
			Command c = Dialog.show("Enter a number between1 and 9: ", myTF, ok);
		
			if(c == ok) {
					int i = Integer.parseInt(myTF.getText());
				if(i < 1 || i > 9) {
					System.out.println("Invalid Value inputted...");
				}
				else {
					System.out.println("Collide With Flag is invoked...");
					this.gw.flag(i);
				}
			}
		} catch(Exception err) {
			System.out.println("Something went wrong...");
		}
	}
	
}