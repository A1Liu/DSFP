package gui;

import javafx.scene.Parent;
import javafx.scene.Scene;

class Page extends Scene {

	private Controller control;
	
	protected Page(Parent root, Controller control, double width, double height) {
		super(root, width, height);
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
