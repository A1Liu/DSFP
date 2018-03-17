package network;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public abstract class Network<T,E extends Vertex<T>> {

	private Hashtable<T,Vertex<T>> vertices;//I want this hashtable to use a key that is the same as the keytype of the vertex object
	
	public Network() {
		vertices = new Hashtable<T, Vertex<T>>();
	}
	
	/**
	 * default way to add a vertex
	 */
	public abstract void addVertex();
	
	/**
	 * add a vertex of specific index
	 * @param t the key of the vertex
	 * @return whether operation was successful
	 */
	public abstract boolean addVertex(T t);
	
	/**
	 * specified way to add a vertex
	 * @param e vertex to add
	 */
	public boolean addVertex(T t, E e) {
		if (vertices.containsKey(t))
			return false;
		else {
			vertices.put(t, e);
			return true;
		}
	}
	
	/**
	 * removes a vertex with identifier id
	 * @param id identifier integer of vertex
	 * @return whether successful
	 */
	public boolean rmVertex(T id) {
		return vertices.remove(id)!=null;
	}
	
	/**
	 * returns the vertex of a certain id
	 * @param id identifier integer of the vertex
	 * @return vertex matching id
	 */
	public Vertex<T> getVertex(T id) {
		return vertices.get(id);
	}
	
	/**
	 * adds edge from a vertex to another vertex
	 * @param v1 vertex sending edge
	 * @param v2 vertex receiving edge
	 * @param l length of edge
	 * @return whether successful
	 */
	public boolean addEdge(T v1, T v2, int l) {
		return vertices.get(v1).addEdge(vertices.get(v2), l);
	}
	
	public boolean addEdge(T v1, T v2) {return addEdge(v1,v2,1);}
	
	/**
	 * removes an edge from vertex v1 to vertex v2
	 * @param v1 vertex edge is coming from
	 * @param v2 vertex edge is going to
	 * @return whether successfully removed
	 */
	public boolean rmEdge(T v1, T v2) {
		return vertices.get(v1).rmEdge(vertices.get(v2));
	}
	
	/**
	 * finds amount of vertices
	 * @return count of vertices
	 */
	public int size() {
		return vertices.size();
	}
	
	/**
	 * finds amount of edges in the network
	 * @return returns amount of edges
	 */
	public int countEdges() {
		int count = 0;
		ArrayList<Vertex<T>> vertexList = listVertices();
		for (int x = 0;x<size();x++) {
			count+=vertexList.get(x).countEdges();
		}
		return count;
	}
	
	/**
	 * TUrns network into arrayList
	 * @return ArrayList of edgepair objects
	 */
	public ArrayList<EdgePair> toList() {
		Vertex<T> current;
		ListNode<Edge> currentEdge;
		ArrayList<Vertex<T>> vertexList = listVertices();
		LinkedList<Edge> currentEdges;
		ArrayList<EdgePair> edgeList = new ArrayList<EdgePair>();
		for (int x = 0;x<size();x++) {
			current = vertexList.get(x);
			currentEdges = current.getEdges();
			currentEdge = currentEdges.getFront();
			while (currentEdge != null) {
				EdgePair e = new EdgePair(current,currentEdge.getData());
				edgeList.add(e);
				currentEdge=currentEdge.getNext();
			}
		}
		return edgeList;
	}
	
	/**
	 * toString for all edges in network
	 * @return a cytoscape-formatted csv string
	 */
	public String cytoScape() {
		Vertex<T> current;
		ListNode<Edge> currentEdge;
		ArrayList<Vertex<T>> vertexList = listVertices();
		LinkedList<Edge> currentEdges;
		String csv = "";
		for (int x = 0;x<size();x++) {
			current = vertexList.get(x);
			currentEdges = current.getEdges();
			currentEdge = currentEdges.getFront();
			while(currentEdge != null) {
				EdgePair e = new EdgePair(current,currentEdge.getData());
				csv+=e.toString();
				currentEdge=currentEdge.getNext();
			}
		}
		return csv;
	}
	
	/**
	 * returns an enumeration of vertices
	 * @return enumeration with all the vertices
	 */
	public Enumeration<T> enumVertices() {
		return vertices.keys();
	}
	
	/**
	 * Turns the network into an arrayList of vertices
	 * @return an arrayList of vertices
	 */
	public ArrayList<Vertex<T>> listVertices() {
		
		ArrayList<Vertex<T>> vertexList = new ArrayList<Vertex<T>>(size());
		Enumeration<T> keys = enumVertices();
		
		while(keys.hasMoreElements()) {
			vertexList.add(vertices.get(keys.nextElement()));
		}
		
		return vertexList;
	}
	
	/**
	 * toString
	 */
	public String toString() {
		return null;
	}
}

/* --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 */


class Vertex<T> extends Point {

	private final T label;
	
	Vertex(T t) {
		super();
		label = t;
	}
	
	@Override
	public String getLabel() {
		
		if(label==null)
			return null;
		
		return label.toString();
	}
	
	/**
	 * toString for vertices
	 * @return identifier for vertex and all edges of vertex
	 */
	@Override
	public String toString() {
		
		try {
			int label = Integer.parseInt(getLabel());
			return "\nV" + label + ": [" + getEdges().toString() + "]";
		} catch (NumberFormatException e) {
			String label = "'" + getLabel() + "'";
			return "\nV" + label + ": [" + getEdges().toString() + "]";
		}
	}
}

/* --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 */

class EdgePair extends Edge {
	
	private final Point source;
	
	public EdgePair(Point p1, Point p2, int l) {
		super(p2,l);
		source = p1;
	}
	
	public EdgePair(Point p, Edge e) {
		this(p,e.getDestination(),e.getLength());
	}
	
	/**
	 * getter for source point
	 * @return source
	 */
	public Point getSource() {
		return source;
	}
	
	/**
	 * toString, also a line in the csv
	 */
	public String toString() {
		return source.getLabel() + "," + getDestination().getLabel() + "," + getLength() + "\n";
	}
}

/* --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 */

class Point implements Comparable<Point> {
	
	private EdgeList edges;
	
	Point() {
		edges = new EdgeList();
	}
	
	@Override
	public int compareTo(Point p) {
		return countEdges()-p.countEdges();
	}

	/**
	 * gets a list of the edges
	 * @return EdgeList of edges
	 */
	public EdgeList getEdges() {
		return edges;
	}
	
	/**
	 * counts edges
	 * @return amount of edges coming from vertex
	 */
	public int countEdges() {
		return edges.countElements();
	}
	
	/**
	 * adds an edge
	 * @param p vertex to point edge to
	 * @param l length of edge
	 * @return whether edge was successfully added
	 */
	boolean addEdge(Point p, int l) {
		Edge newEdge = new Edge(p,l);
		return addEdge(newEdge);
	}
	
	/**
	 * adds an edge
	 * @param newEdge edge to be added
	 * @return whether edge was successfully added
	 */
	boolean addEdge(Edge newEdge) {
		return edges.addElement(newEdge);
	}
	
	/**
	 * This method returns the closest possible match to the given vertex
	 * @param e edge to find
	 * @return the edge with the same destination as e, or null if there is none.
	 */
	Edge findEdge(Edge e) {
		if (edges.getFront() == null)
			return null;
		
		if(edges.getFront().getData().equals(e))
			return edges.getFront().getData();
		
		ListNode<Edge> current = edges.findPrevious(e).getNext();
		
		if(current == null)
			return null;
		else return current.getData();
	}
	
	/**
	 * This method returns the closest possible match to the given vertex
	 * @param p destination of edge to find
	 * @return the edge with destination v, or null if there is none.
	 */
	Edge findEdge(Point p) {
		Edge e = new Edge(p,0);
		return findEdge(e);
	}
	
	/**
	 * removes all edges from the point
	 */
	void rmAllEdges() {
		edges.setFront(null);
	}
	
	/**
	 * moves an edge -- THIS METHOD IS NOT VERY GOOD RIGHT NOW AVOID IF POSSIBLE
	 * @param e1 edge to remove
	 * @param e2 edge to add
	 * @return whether successful in both operations
	 */
	boolean setEdge(Edge e1, Edge e2) {
		return edges.remElement(e1) && edges.addElement(e2);
	}
	
	/**
	 * removes the edge with the same destination as input edge
	 * @param e edge to remove
	 * @return whether the edge was present in the vertex to begin with
	 */
	boolean rmEdge(Edge e) {
		return edges.remElement(e);
	}
	
	/**
	 * removes the edge with destination of input edge
	 * @param v destination of edge to remove
	 * @return whether the edge was present in the vertex to begin with
	 */
	boolean rmEdge(Point p) {
		Edge e = new Edge(p,0);
		return rmEdge(e);
	}
	
	/**
	 * getter for label
	 * @return label
	 */
	public String getLabel() {
		return "Point";
	}
	
	/**
	 * toString for vertices
	 * @return identifier for vertex and all edges of vertex
	 */
	@Override
	public String toString() {
		
		return "{Point with " + countEdges() + " Edges.}";
	}
}

