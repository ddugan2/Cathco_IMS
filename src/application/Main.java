package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import session.Session;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		new Session();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
