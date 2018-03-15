package network;

public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vertex albert = new Vertex(1);
		Vertex andrew = new Vertex(2);
		Vertex bobby = new Vertex(3);
		Vertex del = new Vertex(4);
		albert.addEdge(andrew, 1);
		System.out.println(albert.addEdge(bobby, 2));
		albert.addEdge(del, 3);
		System.out.println(albert.toString());
	}

}
