package gui;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import db.AddressDAO;
import db.KeyCodeDAO;
import db.TrainingDAO;
import db.UserDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.Address;
import logic.Connection;
import logic.KeyCodes;
import logic.Statistics;
import logic.Training;

public class Main extends Application {

	public static SessionFactory sessionFactory;
	public static Stage windowPrimary;
	public static boolean con;

	public static void main(String[] args) {

		con = new Connection().checkConnection();
		if (con) {
			sessionFactory = new Configuration().configure().buildSessionFactory();		
			launch(args);
			sessionFactory.close();
		} else {
			
			launch(args);
			sessionFactory.close();
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
