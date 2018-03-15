package network;

public class Node<E> extends Vertex {
	
	private String name;
	private E data;
	
	Node() {

	}
	
	Node(String n, E e) {
		super();
		name = n;
		data = e;
	}
	
	@Override
	public String getLabel() {
		return name;
	}
	
	public E getData() {
		return data;
	}
}
