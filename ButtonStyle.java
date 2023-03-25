package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.plaf.Border;


public class ButtonStyle extends Button {	
	
	// method to create a Button and style it for the commands
	public ButtonStyle(String label) {
		super(label);
		this.getAllStyles().setPadding(5, 5, 5, 5);
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setBgColor(ColorUtil.BLUE);
		this.getAllStyles().setFgColor(ColorUtil.CYAN);
		this.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
	}
	
}