package data;

public class LinkedList<T> implements List<T> {
	
	private class Node {
		private T value;
		private Node next;
		
		Node(T value) {
			this.value = value;
			next = null;
		}
	}
	
	private Node first;
	private int size;
	private Node last;
	
	public LinkedList() {
		first = null;
		size = 0;
		last = null;
	}

	@Override
	public boolean add(T t) {
		Node newNode = new Node(t);
		if (size == 0) {
			first = newNode;
		} else {
			last.next = newNode;
		}
		last = newNode;
		size++;
		return true;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		
		Node currentNode = first;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		return currentNode.value;
	}

	@Override
	public T remove(int index) {
		if (index < 0) {
			throw new RuntimeException("Cannot remove negative index element from LinkedList.");
		}
		if (size == 0) {
			throw new RuntimeException("Cannot remove element from empty LinkedList.");
		}
		
		if (index >= size) {
			throw new RuntimeException("Index out of bounds.");
		}
		
		if (index == 0) {
			// Trying to remove the first element
			Node oldFirst = first;
			first = first.next;
			size--;
			
			if (size == 0) {
				last = null;
			}
			return oldFirst.value;
		}
		
		Node currentNode = first;
		for (int i = 0; i < index - 1; i++) {
			currentNode = currentNode.next;
		}
		// Current node is prior to the node to be deleted
		Node oldNode = currentNode.next;
		currentNode.next = currentNode.next.next;
		size--;
		
		if (size == index) {
			last = currentNode;
		}
		
		
		return oldNode.value;
	}

	@Override
	public boolean remove(T value) {
 		if (size == 0) {
			return false;
		}
		
		if (first.value == value) {
			// Trying to remove the first element
			first = first.next;
			size--;
			
			if (size == 0) {
				last = null;
			}
			return true;
		}
		
		Node currentNode = first;
		while (currentNode.next.value != value) {
			currentNode = currentNode.next;
			if (currentNode.next == null) {
				return false;
			}
		}
		
		currentNode.next = currentNode.next.next;
		size--;
		
		if (currentNode.next == null) {
			last = currentNode;
		}
		
		return true;
	}

	@Override
	public boolean contains(T t) {
		Node currentNode = first;
		for (int i = 0; i < size; i++) {
			if (currentNode.value == t) {
				return true;
			}
			
			currentNode = currentNode.next;
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}
	

}
