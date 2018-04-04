package network;

import static util.IOUtil.isNumber;
import static util.IOUtil.readFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * need to make new vertex object that holds values, otherwise this will become complicated quickly
 * @author liu_albert
 *
 */
public class RatingsGraph extends Graph<RatingsNode> {
	
	private Hashtable<Character,Double> values;
	
	public RatingsGraph() {
		values = new Hashtable<Character,Double>();
	}
	
	@Override
	public boolean addVertex(Character t) {
		if (getDefaultID()>127 || (t.toString().charAt(0) < 48))
			return false;
		RatingsNode v = new RatingsNode(t);
		return addVertex(t,v);
	}
	
	public void update() {
		ArrayList<Character> names = this.keys();
		ArrayList<Double> newValues = new ArrayList<Double>();
		
		for (int x = 0; x< names.size(); x++) {
			
		}
	}
	
	private Double updateVertex(Character t) {
		
		EdgeList edges = this.getVertex(t).getEdges();
		
		return null;
	}
	
	/**
	 * loads edges into the network
	 * @param document the name of the document to add from
	 * @throws IOException if the document doesn't exist
	 */
	public void loadNetwork(String document) throws IOException {
		ArrayList<String> input = readFile(document);
		String[] line;
		for (int x = 0; x< input.size(); x++) {
			line = input.get(x).split(",");
			loadEdge(line);
		}
	}
	
	/**
	 * loads an edge into the network given an array of strings
	 * @param edge the array of strings to input
	 */
	private void loadEdge(String[] edge) {
		
		if (edge.length < 3)
			return;
		
		if(edge[0].length()==1 || isNumber(edge[0])) {
			if (edge[1].length()==1 || isNumber(edge[1])) {
				int id1;
				int id2;
				
				if(getVertex(edge[0].charAt(0))==null && getVertex(Integer.parseInt((edge[0]))) == null) {
					if (isNumber(edge[0])) {
						id1 = Integer.parseInt(edge[0]);
						addVertex(id1);
						addEdge(id1,id1,1);
					} else {
						id1 = edge[0].charAt(0)-48;
						addVertex(id1);
						addEdge(id1,id1,1);
					}
				} else {
					if (isNumber(edge[0])) {
						id1 = Integer.parseInt(edge[0]);
					} else {
						id1 = edge[0].charAt(0)-48;
					}
				}
				
				if(getVertex(edge[1].charAt(0))==null && getVertex(Integer.parseInt((edge[1]))) == null) {
					if (isNumber(edge[1])) {
						id2 = Integer.parseInt(edge[1]);
						addVertex(id2);
						addEdge(id2,id2,1);
					} else {
						id2 = edge[1].charAt(0)-48;
						addVertex(id2);
						addEdge(id2,id2,1);
					}
				} else {
					if (isNumber(edge[0])) {
						id2 = Integer.parseInt(edge[0]);
					} else {
						id2 = edge[0].charAt(0)-48;
					}
				}
				
				if (isNumber(edge[2]))
					addEdge(id1,id2,Integer.parseInt(edge[2]));
				else
					addEdge(id1,id2,1);
			}
		}
	}
	
	@Override
	public void incrementID() {
		return;
	}
}

class RatingsNode extends Vertex<Character> {
	
	private double r;//this node's rating
	private double v;//this node's total votes
	private EdgeList ratings; //The list of ratings this node has made
	
	RatingsNode(Character t) {
		super(t);
		r = 1.0;
		v = 1.0;
		
		//adding self to the list of nodes that have rated this node. We don't need to add self to the list we've rated because we already have a reference to this node.
		super.addEdge(new Edge(this, 1));//addEdge adds to the edgelist, which is the list of ratings this node has received
	}
	
	/**
	 * Adds a rating from this node to another node
	 * @param n the node being rated
	 * @param r the rating being given
	 */
	void addRating(RatingsNode n, int r) {
		if (ratings.add(new Edge(n,r))) {
			n.addEdge(new Edge(this,r));
			return;
		} else {
			ratings.remove(new Edge(n,r));
			n.rmEdge(new Edge(this,r));
			ratings.add(new Edge(n,r));
			n.addEdge(new Edge(this,r));
		}
	}
	
	/**
	 * recalculates the value of r and v and stores them
	 */
	void update() {
		double rating;
		double votes;
		
		ArrayList<Edge> received = this.getEdges();
		
		
		for (int x = 0; x < this.countEdges(); x++) {
			
		}
	}
	
	public static double getVotingPower(double r, double v) {
		return 0;
	}
	
	double getVotingPower() {
		return getVotingPower(this.r,this.v);
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
