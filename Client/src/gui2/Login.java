package gui2;

import javafx.fxml.FXML;

/**
 * 
 * @author aliu
 *
 */
public class Login extends Controller {
	
	public Login() {
		
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}
	
	
	@FXML
	private void signIn() {
		//TODO:
		
		
    	String username = userTextField.getText();
    	String password = pwBox.getText();
    	try {
    		if (!control.getApp().getConnection().isConnected()) {
    			control.getApp().getConnection().run();
    			if (!control.getApp().getConnection().isConnected()) {
    				errorText.setText("Can't connect to server.");
    				errorText.setVisible(true);
    				return;
    			}
    		}
    		
    		control.getApp().setUser(control.getApp().login(username, password));
    		errorText.setVisible(false);
    		control.homePage();
    	} catch (Exception e) {
    		errorText.setText("Incorrect login credentials.");
    		errorText.setVisible(true);
    		e.printStackTrace();
    	}
    }
	}
	
	@FXML
	private void newAccount() {
		//TODO:
	}




	
	
	
	
	
}
