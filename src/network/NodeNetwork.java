package network;

public class NodeNetwork<E> extends Vertex {
	
	private String name;
	private E data;
	
	NodeNetwork() {

	}
	
	NodeNetwork(String n, E e) {
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
