package com.mycompany.a2;

public interface IGameWorld {

	boolean getSound();
	void setSound();
	void accelerate();
	void brake();
	void flag(int x);
	void foodCollision();
	void spiderCollision();
	void left();
	void right();
	void clock();
	void display();
	String map();
	void exit();
	void yes();
	void no();
	int getLives();
	int getClock();
	int getFlag();
	int getFoodLevel();
	int getHealthLevel();
	
	
	
}
