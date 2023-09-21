package data;

import java.util.ArrayList;

public interface Map<K, V> {

	
	void add(K key, V value);
	
	V get (K key);
	
	void remove(K key);
	
	boolean contains(K key);
	
	int size();
	
	ArrayList<K> getKeys();
	
	
	
}
