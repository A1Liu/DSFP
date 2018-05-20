package gui2;

import javafx.fxml.FXML;

public abstract class Controller {

	private App app;
	
	public Controller() {
		
	}
	
	@FXML
    public abstract void initialize();
	
	public void setApp(App app) {
		this.app = app;
	}
	
	public App getApp() {
		return app;
	}

}
