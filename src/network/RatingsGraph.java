package network;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import sun.misc.Queue;

/**
 * need to make new vertex object that holds values, otherwise this will become complicated quickly
 * @author liu_albert
 *
 */
public class RatingsGraph extends Graph<RatingsNode> {
	
	public RatingsGraph() {
	
	}
	
	@Override
	public boolean addVertex(Integer t) {
		if (getDefaultID()>127 || (t.toString().charAt(0) < 48))
			return false;
		RatingsNode v = new RatingsNode(t);
		return addVertex(t,v);
	}
	
	public void update() throws InterruptedException, IllegalArgumentException {
		if (size() == 0)
			return;
		
		update(getVertex().getLabel());
	}
	
	public void update(int i) throws IllegalArgumentException, InterruptedException {
		
		if (size() == 0)
			return;
		
		System.out.println(this.keys());
		System.out.println(getRatings());
		System.out.println(getVotes());
		System.out.println();
		for (int x = 0; x < i; x++) {
			update();
			System.out.println(x + ":\t " + getRatings());
			System.out.println("\t" + getVotes());
			System.out.println();
		}
	}
	
	/**
	 * Updates the network, starting at node t
	 * @param t the starting point of the breadth-first iteration
	 * @throws InterruptedException If the queue screws up
	 * @throws IllegalArgumentException If t isn't a node
	 */
	public void update(Integer t) throws InterruptedException, IllegalArgumentException {
		Queue<Integer> queue = new Queue<Integer>();
		
		if (size() == 0)
			return;
		
		if (getVertex(t) == null)
			throw new IllegalArgumentException("'" + t.toString() + "' is not a valid node identifier.");
		
		//creating necessary containers
		Hashtable<Integer, Boolean> reached = new Hashtable<Integer,Boolean>();
		Enumeration<Integer> vertexList = enumVertices();
		ArrayList<Edge> currentEdges;
		Integer current;
		Integer currentNeighbor;
		Integer start = t;
		
		while (reached.size()<size()) {
			//start at a vertex
			if (!reached.containsKey(start)) {
				queue.enqueue(start);
				while (!queue.isEmpty()) {
					current = queue.dequeue();
					if (!reached.containsKey(current)) {
						updateVertex(current);
						currentEdges = getVertex(current).getRatings();//list of edges
							for (int x = 0; x<currentEdges.size();x++) {
								currentNeighbor = (Integer) currentEdges.get(x).getDestination().getLabel(); //neighbor we're looking at
								if (!reached.containsKey(currentNeighbor)) {
										queue.enqueue(currentNeighbor);//only add the neighbor to the queue if it wasn't reached and isn't already in the queue
								}	
							}
						reached.put(current, true);
					}
				}
			}
			if (vertexList.hasMoreElements())
				start = vertexList.nextElement();
		}
	}
	
	private void updateVertex(Integer t) {
		this.getVertex(t).update();;
	}
	
	private ArrayList<Double> getRatings() {
		ArrayList<RatingsNode> vertices = listVertices();
		ArrayList<Double> ratings = new ArrayList<Double>();
		for (int x = 0; x< vertices.size(); x++) {
			ratings.add(Math.floor(vertices.get(x).getR()*100)/100);
		}
		return ratings;
	}
	
	private ArrayList<Double> getVotes() {
		ArrayList<RatingsNode> vertices = listVertices();
		ArrayList<Double> votes = new ArrayList<Double>();
		for (int x = 0; x< vertices.size(); x++) {
			votes.add(Math.floor(vertices.get(x).getV()*100)/100);
		}
		return votes;
	}
	
	@Override
	public boolean addEdge(Integer n1, Integer n2, int r) {
		if (getVertex(n1) == null || getVertex(n2) == null)
			return false;
		getVertex(n1).rate(getVertex(n2), r);
		return true;
	}
	
	
	
	@Override
	public void incrementID() {
		return;
	}
}

/**
 * edges in the inherited edgelist are the ratings this node has received
 * Edges in the ratings Edgelist are the ratings this node has given to others
 * @author Alyer
 *
 */
class RatingsNode extends Vertex<Integer> {
	
	private double r;//this node's rating
	private double v;//this node's total votes
	private EdgeList ratings; //The list of ratings this node has made
	
	RatingsNode(Integer t) {
		super(t);
		r = 1.0;
		v = 1.0;
		ratings = new EdgeList();
		//adding self to the list of nodes that have rated this node. We don't need to add self to the list we've rated because we already have a reference to this node.
		super.addEdge(new Edge(this, 1));//addEdge adds to the edgelist, which is the list of ratings this node has received
	}
	
	@Override
	boolean addEdge(Edge e) {
		
		if (e.getDestination() instanceof RatingsNode && !(e.getDestination()==this)) {
			return super.addEdge(e);
		}
		return false;
	}
	
	/**
	 * Adds a rating from this node to another node
	 * @param n the node being rated
	 * @param r the rating being given
	 * @return 
	 */
	void rate(RatingsNode n, int r) {
		if (ratings.add(new Edge(n,r))) {
			n.addEdge(new Edge(this,r));
		} else {
			ratings.remove(new Edge(n,r));
			n.rmEdge(new Edge(this,r));
			ratings.add(new Edge(n,r));
			n.addEdge(new Edge(this,r));
		}
	}
	
	EdgeList getRatings() {
		return this.ratings;
	}
	
	/**
	 * recalculates the value of r and v and stores them
	 */
	void update() {
		double ratingSum = 0;
		double votes = 0;
		RatingsNode current;
		
		for (int x = 0; x < this.countEdges(); x++) {
			current = (RatingsNode) this.getEdges().get(x).getDestination();
			ratingSum+=this.getEdges().get(x).getLength()*current.getPower();
			votes+=current.getPower();
		}
		
		r = ratingSum/votes;
		v = votes;
	}
	
	/**
	 * Function to determine the power of a node given its rating and its total votes
	 * @param r rating of the node
	 * @param v votes the node has received
	 * @return the power of the node
	 */
	static double getPower(double r, double v) {
		double x = 5.0 - Math.pow(1.5, 1-v);//first parameter of Math.power is the speed at which power increases relative to votes received
		return Math.pow(2,r)*x;
	}
	
	/**
	 * calculates the power of a specified rating node
	 * @param n the node whose power we are calculating
	 * @return the voting power
	 */
	static double getPower(RatingsNode n) {
		return getPower(n.getR(), n.getV());
	}
	
	/**
	 * calculates the power of this rating node
	 * @return the power
	 */
	double getPower() {
		return getPower(this.r,this.v);
	}

	double getR() {
		return r;
	}

	void setNode(double r, double v) {
		this.r = r;
		this.v = v;
	}

	double getV() {
		return v;
	}
	
	
	
}