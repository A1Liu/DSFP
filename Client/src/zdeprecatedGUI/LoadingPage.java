package zdeprecatedGUI;

import javafx.scene.layout.GridPane;

import static util.Const.*;

class LoadingPage extends Page {

	private static GridPane grid;
	
	static {
		grid = new GridPane();
	}
	
	protected LoadingPage(Controller control) {
		super(grid, control);
	}

}
