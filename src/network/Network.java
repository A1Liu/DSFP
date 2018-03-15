package network;

import java.util.ArrayList;

public class Network<E extends Vertex> {

	ArrayList<Vertex> vertices;//maybe vertex class doesn't need id field
	int maxID;
	
	public Network(int size) {
		vertices = new ArrayList<Vertex>();
		maxID = 0;
	}
	
	public Network() {
		this(10);
	}
	
	/**
	 * adds another vertex
	 * @return whether successful
	 */
	public void addVertex() {
		
	}
	
	public void rmVertex(int v) {
		
	}
	
	/**
	 * 
	 * @param v1 vertex sending edge
	 * @param v2 vertex receiving edge
	 * @param l length of edge
	 * @return whether successful
	 */
	public boolean addEdge(int v1, int v2, int l) {
		return true;
	}
	
	public boolean rmEdge(int v1, int v2) {
		return true;
	}
	
	public int countVertices() {
		return vertices.size();
	}
	
	public int countEdges() {
		return 0;
	}
	
	public String getVertices() {
		return null;
	}
	
	public String getEdges() {
		return null;
	}
	
	public String toString() {
		return null;
	}
	
}

