package com.mycompany.a2;

import java.util.Observer;
import java.util.Observable;

public class GameWorldProxy extends Observable implements IGameWorld, Observer {
	
	private GameWorld realGW;//reference to GameWorld class in order to invoke functions
	
	// method to instantiate a game world proxy for the real game world class
	public GameWorldProxy(GameWorld gw) {
		realGW = gw;
	}
	
	@Override
	public boolean getSound() {
		// TODO Auto-generated method stub
		return realGW.getSound();
	}
	
	@Override
	public void update(Observable observable, Object data) {
		this.realGW = (GameWorld)data;
	    this.setChanged();
	    this.notifyObservers(this.realGW);
	}
	
	@Override
	public String map() {
		// TODO Auto-generated method stub
		
		return realGW.map();
	}
	
	public int getLives() {
		// TODO Auto-generated method stub
		return realGW.getLives();
	}

	@Override
	public int getClock() {
		// TODO Auto-generated method stub
		return realGW.getClock();
	}

	@Override
	public int getFlag() {
		// TODO Auto-generated method stub
		return realGW.getFlag();
	}

	@Override
	public int getFoodLevel() {
		// TODO Auto-generated method stub
		return realGW.getFoodLevel();
	}

	@Override
	public int getHealthLevel() {
		// TODO Auto-generated method stub
		return realGW.getHealthLevel();
	}
	
	public void setSound() {
		System.out.println("This is Proxy Method.");
	}

	public void accelerate() {
		System.out.println("This is Proxy Method.");
	}
	
	@Override
	public void brake() {
		// TODO Auto-generated method stub
		System.out.println("This is Proxy Method.");
	}

	@Override
	public void flag(int x) {
		// TODO Auto-generated method stub
		System.out.println("This is Proxy Method.");
	}

	@Override
	public void foodCollision() {
		// TODO Auto-generated method stub
		System.out.println("This is Proxy Method.");
	}

	@Override
	public void spiderCollision() {
		// TODO Auto-generated method stub
		System.out.println("This is Proxy Method.");
	}

	@Override
	public void left() {
		// TODO Auto-generated method stub
		System.out.println("This is Proxy Method.");
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		System.out.println("This is Proxy Method.");
	}

	@Override
	public void clock() {
		// TODO Auto-generated method stub
		System.out.println("This is Proxy Method.");
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("This is Proxy Method.");
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		System.out.println("This is Proxy Method.");
	}

	@Override
	public void yes() {
		// TODO Auto-generated method stub
		System.out.println("This is Proxy Method.");
	}

	@Override
	public void no() {
		// TODO Auto-generated method stub
		System.out.println("This is Proxy Method.");
	}

	
	
}