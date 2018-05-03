package gui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import static util.Const.HEIGHT;
import static util.Const.WIDTH;

class Page extends Scene {

	private Controller control;
	
	protected Page(Parent root, Controller control) {
		super(root, WIDTH, HEIGHT);
		this.setController(control);
		// TODO Auto-generated constructor stub
	}

	public Controller getController() {
		return control;
	}

	protected void setController(Controller control) {
		this.control = control;
	}

	
	
	
}
