package com.mycompany.a2;

import java.util.Vector;

public class GameObjectCollection implements ICollection {

	private Vector<GameObjects> gameObjectCollection ;
	
	// create an instance of Game Object Collection to store all game objects
	public GameObjectCollection() {
		
		gameObjectCollection = new Vector<GameObjects>();  
		
	}
	
	// method to add new game object to the collection
	public void add(GameObjects newGameObject) {
		gameObjectCollection.addElement(newGameObject); 
	}
	
	// method to remove a game object from the collection
	public void remove(GameObjects gameObject) {
		gameObjectCollection.removeElement(gameObject);
	}
	
	// returns a new iterator for the game object collection
	public IIterator getIterator() {
		return new GameObjectIterator() ;  
	}

	// private class that iterates through the whole game object collection
	private class GameObjectIterator implements IIterator {
		
		private int currElementIndex;
		
		// method to create an instance of a GameObject Iterator
		public GameObjectIterator() {
			currElementIndex = -1;
		}
		
		// method to check if the next element in the iteration exists or not
		public boolean hasNext() {
			if (gameObjectCollection.size ( ) <= 0) {
				return false;
			}
			if (currElementIndex == gameObjectCollection.size() - 1 ) {
				return false;
			}
			return true;
		}
		
		// method to retrieve the game object at the current element index
		public GameObjects getNext ( ) {
				currElementIndex ++ ;
				return(gameObjectCollection.elementAt(currElementIndex));
		}
	}
}	
