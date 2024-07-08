package screens;

import data.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginScreen {

	private BorderPane borderPane = new BorderPane();
	private Scene scene;
	
	private Button btnLogin = new Button("Log In");
	private Label lblID = new Label("Employee ID:");
	private Label lblPassword = new Label("Password");
	private TextField txtID = new TextField();
	private TextField txtPassword = new TextField();
	
	private VBox vbox = new VBox();
	private HBox hboxID = new HBox();
	private HBox hboxPassword = new HBox();

	
	public LoginScreen(Database database) {
		hboxID.getChildren().addAll(lblID, txtID);
		hboxPassword.getChildren().addAll(lblPassword, txtPassword);
		vbox.getChildren().addAll(hboxID, hboxPassword, btnLogin);
		borderPane.setCenter(vbox);
		
		setupLoginButton(database);
		
		scene = new Scene(borderPane);
	}

	private void setupLoginButton(Database database) {
		btnLogin.setOnAction(e -> login(database));
	}
	
	private void login(Database database) {
		boolean loginSuccessful = database.checkLogin(txtID.getText(), txtPassword.getText());
	}

	public Scene getScene() {
		return scene;
	}
	
}
