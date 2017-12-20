package gui;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

 
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.Connection;



public class Main extends Application {
	
	public static SessionFactory sessionFactory;
	public static Stage windowPrimary;

	public static void main(String[] args) {
		
		boolean con = new Connection().checkConnection();
		if (con) {
			System.out.println("Internet Connection available");
			sessionFactory = new Configuration().configure().buildSessionFactory();
			launch(args);
			sessionFactory.close();
		}
		else {
			System.out.println("No connection");
		}

	}

	@Override
	public void start(Stage window) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("loginGUI.fxml"));
	
		Scene loginScene = new Scene(root);
		
	    windowPrimary = window;
		window.setScene(loginScene);
		window.setResizable(false);
		window.show();
		
	}
	
}
