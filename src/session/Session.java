package session;

import data.Database;
import javafx.stage.Stage;
import screens.LoginScreen;

public class Session {

	private Database database = new Database();
	private LoginScreen loginScreen = new LoginScreen(database);
	private Stage stage = new Stage();

	public Session() {
		showLoginScreen();
	}

	private void showLoginScreen() {
		stage.setScene(loginScreen.getScene());
		stage.show();
	}
	
}
