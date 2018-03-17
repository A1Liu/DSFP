package network;


public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestRunner a = new TestRunner();
		
		UndirectedGraph albert = new UndirectedGraph();
		albert.addVertex(101);
		albert.addVertex(102);
		albert.addVertex(103);
		albert.addVertex(104);
		albert.addVertex(105);
		albert.addEdge(101, 102);
		albert.addEdge(101, 103);
		albert.addEdge(101, 104);
		albert.addEdge(103, 104);
		albert.rmVertex(101);
		System.out.println(albert.rmEdge(101));
		System.out.println(albert.getVertex(102));
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
		
		
		a.test(1);
	}
	
	public TestRunner() {
		
	}
	
	public void test(Integer i) {
		
	}

}
