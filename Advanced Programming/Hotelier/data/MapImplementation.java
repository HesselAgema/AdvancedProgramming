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
		pairs = new ArrayList<Pair>();
	}

	@Override
	public void add(K key, V value) {
		Pair newPair = new Pair(key,value);

		if(pairs.size() == 0) {
			pairs.add(0,newPair);
		}else {
			
		}
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public void keys(K key) {
//		// TODO Auto-generated method stub
//		
//	}


}
