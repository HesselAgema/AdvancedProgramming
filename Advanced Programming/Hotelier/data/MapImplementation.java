package data;

public class MapImplementation<K,V> implements Map<K,V> {
	
	private LinkedList<Pair> pairs;
	
	private class Pair {
		K key;
		V value;
		
		Pair(K key, V value){
			this.key = key;
			this.value = value;
		}
	}
	
	public MapImplementation() {
		pairs = new LinkedList<Pair>(); // pair niet nodig maar wel handig om te lezen voor nu
	}

	@Override
	public void add(K key, V value) {
		Pair newPair = new Pair(key,value);

		for(int i = 0; i < pairs.size() ; i++) {
			Pair currentPair = pairs.get(i);
			if(currentPair.key.equals(newPair.key)) { 		// we gebruiken .equals omdat bij Integers == fout kan gaan kennelijk 
															// blijkt te zijn omdat == niet werkt bij objecten maar alleen primitive type.
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
		boolean yes;
		for(int i = 0; i < pairs.size(); i++) {
			Pair currentPair = pairs.get(i);
			if(currentPair.key.equals(key)) {
				pairs.remove(i);				//gebruiken hier de remove(int index) dus returnt geen boolean maar <T> T = Pair object
			}
		}
		
	}

	@Override
	public boolean contains(K key) {
	    for(int i = 0 ; i < pairs.size(); i++) {
	    	if(pairs.get(i).key == key) {
	    		return true;
	    	}
	    }
	    return false;
	}

	@Override
	public int size() {
		
		return pairs.size();
	}

	@Override
	public LinkedList<K> getKeys() {
		LinkedList<K> keys = new LinkedList<K>();
		for(int i = 0 ; i < pairs.size(); i++) {
			keys.add(pairs.get(i).key);
			
		}
		return keys;
		
	}


}
