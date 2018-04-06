package network;

import java.io.IOException;

/**
 * This class is the test harness for methods in the network package.
 * 
 * @author Alyer
 *
 */
public class TestRunner {

	public static void main(String[] args) throws IOException, IllegalArgumentException, InterruptedException {
		
		RatingsGraph graph = new RatingsGraph();
		
		graph.addVertex(1);
		
		String path = "lib/Network.csv";
		path = "C:/Users/Alyer/Desktop/Network.csv";
		graph.loadNetwork(path);
		
		graph.update(40);
		System.out.println(graph.cytoScape());
	}

}
