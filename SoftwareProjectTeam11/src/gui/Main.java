package gui;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import db.TrainingDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.Training;


public class Main extends Application {
	
	public static SessionFactory sessionFactory;

	public static void main(String[] args) {

		sessionFactory = new Configuration().configure().buildSessionFactory();
		launch(args);
	
		sessionFactory.close();
		

		
	}

	@Override
	public void start(Stage window) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("loginGUI.fxml"));
		Scene loginScene = new Scene(root);
		
		window.setScene(loginScene);
		window.setResizable(false);
		window.show();
		
	}
	
}
