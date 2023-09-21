package data;

public interface List<T> {

	boolean add(T t);
	
	T get(int index);
	
	T remove(int index);
	
	boolean remove(T value);
	
	boolean contains(T t);
	
	int size();
}
