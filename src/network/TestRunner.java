package network;

import java.util.Hashtable;
import java.util.Enumeration;

public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vertex albert = new Node<Integer>(1,"hello",1);
		Vertex andrew = new Node<Integer>(1,"hi",1);
		Vertex bobby = new Vertex(3);
		Vertex del = new Vertex(2);
		albert.addEdge(andrew, 1);
		System.out.println(albert.addEdge(bobby, 2));
		albert.addEdge(del, 3);
		System.out.println(albert.toString());
		
		TestRunner a = new TestRunner();
		
		a.test(1);
	}
	
	public TestRunner() {
		
	}
	


	 
	 public static void boi() {
	 
	   Enumeration<String> names;
	   String key;
	 
	   // Creating a Hashtable
	   Hashtable<String, String> hashtable = new Hashtable<String, String>();
	 
	   // Adding Key and Value pairs to Hashtable
	   hashtable.put("Key1","Chaitanya");
	   hashtable.put("Key2","Ajeet");
	   hashtable.put("Key3","Peter");
	   hashtable.put("Key4","Ricky");
	   hashtable.put("Key5","Mona");
	 
	   names = hashtable.keys();
	   while(names.hasMoreElements()) {
	      key = (String) names.nextElement();
	      System.out.println("Key: " +key+ " & Value: " +
	      hashtable.get(key));
	   }
	 }
	}
	
	public void test(Integer i) {
		
	}

}
