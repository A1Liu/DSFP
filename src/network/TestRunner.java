package network;

import java.io.IOException;

public class TestRunner {

	public static void main(String[] args) throws IOException {
		
		
		//Graph a = Graph.getGraph("Ratings Graph");
		
		RatingsGraph graph = new RatingsGraph();
		
		graph.loadNetwork("lib/Network.txt");
		
		System.out.println(graph.cytoScape());
		
		/*UndirectedGraph albert = new UndirectedGraph();
		
		Character[] vertices = {'A','B','D','C'};
		
		albert.addVertex(vertices);
		albert.addEdge('A', 'A');
		albert.addEdge('A', 'B');
		albert.addEdge('A', 'B');
		albert.addEdge('D', 'C');
		System.out.println(albert.cytoScape());
		System.out.println();
		System.out.println(albert.getVertex(103));
		System.out.println(albert.getVertex(104));
		
		
		
		String x;
		//x = albert.listVertices().toString();
		//x = albert.toList().toString();
		//x = albert.cytoScape();
		x = albert.countEdges() + "";
		
		//boolean c = albert.rmEdge(2, 1);
		//boolean b = albert.rmEdge(1, 2);
		
		
		System.out.println(x);*/
		
	}

}
