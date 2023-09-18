package data;

import java.util.ArrayList;
import java.util.LinkedList;

public class MapImplementation<K,V> implements Map<K,V> {
	
	private ArrayList<Pair> pairs;
	
	private class Pair {
		K key;
		V value;
		
		Pair(K key, V value){
			this.key = key;
			this.value = value;
		}
	}
	
	public MapImplementation() {
		pairs = new ArrayList<Pair>(); // pair niet nodig maar wel handig om te lezen voor nu
	}

	@Override
	public void add(K key, V value) {
		Pair newPair = new Pair(key,value);


		for(int i = 0; i < pairs.size() ; i++) {
			Pair currentPair = pairs.get(i);
			if(currentPair.key.equals(newPair.key)) { 		// we gebruiken .equals omdat bij Integers == fout kan gaan kennelijk 
				currentPair.value = value;
				return;
			}
		}
		
		pairs.add(newPair);
	}

	@Override
	public V get(K key) {
		for(int i = 0; i < pairs.size(); i++) {
			Pair currentPair = pairs.get(i);
			if(currentPair.key.equals(key)) {
				return currentPair.value;
			}
		}
		return null;
	}
	

	@Override
	public void remove(K key) {
		for(int i = 0; i < pairs.size(); i++) {
			Pair currentPair = pairs.get(i);
			if(currentPair.key.equals(key)) {
				pairs.remove(i);
			}
		}
		
	}

	@Override
	public boolean contains(K key) {
		
		return pairs.contains(key);
	}

//	@Override
//	public void keys(K key) {
//		
//		
//		
//	}


}
