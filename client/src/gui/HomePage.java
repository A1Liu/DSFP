package gui;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import static util.Const.HEIGHT;
import static util.Const.WIDTH;

class HomePage extends Page {

	private final static StackPane container;
	private final static GridPane grid;
	
	static {
		grid = new GridPane();
		container = new StackPane();
		container.getChildren().add(grid);
	}
	
	public HomePage(Controller c) {
		super(container, c);

	}

}
