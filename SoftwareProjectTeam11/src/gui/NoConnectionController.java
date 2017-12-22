package gui;

import java.io.IOException;

import org.hibernate.cfg.Configuration;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.Connection;

public class NoConnectionController {
	
	@FXML
	private Button tryButton;
	@FXML
	private Label errorText;
	private int count;
	
	@FXML
	public void tryAgain(ActionEvent event) throws IOException
	{
		Main.con = new Connection().checkConnection();
		
		if (Main.con) {
			errorText.setTextFill(Color.GREEN);
			errorText.setText("Connection is back");
			Main.sessionFactory = new Configuration().configure().buildSessionFactory();		
			Parent loginParent = FXMLLoader.load(getClass().getResource("loginGUI.fxml"));
			Scene loginScene = new Scene(loginParent);
			
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setScene(loginScene);
			window.show();
		}
		else {
			count = count +1;
			errorText.setText("Try number: " + count + ": No connection");
		}
		
	}

}
