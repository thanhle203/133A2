package com.mycompany.a2;

public interface ICollection {

	public void add(GameObjects newGameObject);
	public void remove(GameObjects gameObject);
	public IIterator getIterator();
	
}
