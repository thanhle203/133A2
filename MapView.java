package com.mycompany.a2;

import java.util.Observer;
import java.util.Observable;

import com.codename1.charts.util.ColorUtil;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer {
	
	private GameWorldProxy gwp;
	
	// method to instantiate a Map View instance
	public MapView(GameWorldProxy gwp) {
		this.setLayout(new BoxLayout(BoxLayout.Y_AXIS)); // Set a box layout. 
		this.gwp = gwp;
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.rgb(255,0,0)));// create a red border around the center container
		
	}
	
	// method to update and refresh the map view after any function is invoked
	public void update (Observable o, Object arg) {
		
		this.gwp = (GameWorldProxy)o;
		
		System.out.println("");
		System.out.println(this.gwp.map());
		System.out.println("");
		
		this.repaint();

		
	}
	
}