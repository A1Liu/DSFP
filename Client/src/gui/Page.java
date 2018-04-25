package gui;

import javafx.scene.Parent;
import javafx.scene.Scene;

public abstract class Page extends Scene {

	private Controller control;
	
	protected Page(Parent root, Controller control, double width, double height) {
		super(root, width, height);
		this.setControl(control);
		// TODO Auto-generated constructor stub
	}

	public Controller getControl() {
		return control;
	}

	public void setControl(Controller control) {
		this.control = control;
	}

	
	
	
}
