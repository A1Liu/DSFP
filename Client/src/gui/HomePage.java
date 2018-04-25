package gui;

import javafx.scene.*;
import static util.Const.HEIGHT;
import static util.Const.WIDTH;

class HomePage extends Page {

	private final static Group g;
	
	static {
		g = new Group();
	}
	
	public HomePage(Controller c) {
		super(g, c, WIDTH, HEIGHT);
	}

}
