package testingGrounds;

import server.Server;

public class Tester {

	public static void main(String[] args) {
		Server server = new Server(1100);
		server.start();
		server.stopServer();
	}

}
