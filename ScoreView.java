package com.mycompany.a2;

import java.util.Observer;

import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;

import java.util.Observable;

public class ScoreView extends Container implements Observer {
	
	private GameWorldProxy gwp;
	private Label lives;
	private Label clock;
	private Label flag;
	private Label food;
	private Label health;
	
	// method to instantiate a Score view instance
	public ScoreView(IGameWorld igw) {
		
		this.gwp = (GameWorldProxy) igw;
		
		this.setLayout(new FlowLayout(Component.CENTER)); //center the labels for user experience
		
		// creates labels for all of the required stats to display
		this.lives = new Label("Lives: " + this.gwp.getLives());
		this.clock = new Label("Time: " + this.gwp.getClock());
		this.flag = new Label("Flag Reached: " + this.gwp.getFlag());
		this.food = new Label("Food Level: " + this.gwp.getFoodLevel());
		this.health = new Label("Health Level: " + this.gwp.getHealthLevel());
		
		// add all the labels to the layout 
		this.add(this.lives);
		this.add(this.clock);
		this.add(this.flag);
		this.add(this.food);
		this.add(this.health);
		
	}

	// method to refresh and update the score view after any function has been invoked
	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		IGameWorld igw = (IGameWorld) data;
		
		this.lives.setText("Lives: " + igw.getLives());
		this.clock.setText("Time: " + igw.getClock());
		this.flag.setText("Flag Reached: " + igw.getFlag());
		this.food.setText("Food Level: " + igw.getFoodLevel());
		this.health.setText("Health Level: " + igw.getHealthLevel());
		
		this.repaint();
	}

}
