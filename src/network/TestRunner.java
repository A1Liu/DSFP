package network;


public class TestRunner {

	public static void main(String[] args) {
		
		UndirectedGraph albert = new UndirectedGraph();
		albert.addVertex(' ');
		albert.addVertex('b');
		albert.addVertex('c');
		albert.addVertex('a');
		albert.addVertex('#');
		albert.addEdge(' ', ' ');
		albert.addEdge(' ', '#');
		albert.addEdge(' ', 'a');
		albert.addEdge('b', 'c');
		System.out.println(albert.cytoScape());
		System.out.println();
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
		
		
		System.out.println(x);
		
	}

}
