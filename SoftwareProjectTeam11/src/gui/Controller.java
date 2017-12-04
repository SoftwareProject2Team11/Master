package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Controller {
	@FXML
	private Button login;
	@FXML
	private Button passwordForgotten;
	@FXML
	private Button backButton;
	@FXML
	private TextField mailText;
	@FXML
	private TextField usernameText;
	@FXML
	private TextField passwordText;
	
	public void checkLogin(ActionEvent event)throws IOException
	{
		
			Parent passwordForgottenParent = FXMLLoader.load(getClass().getResource("homepage.fxml"));
			Scene passwordForgottenScene = new Scene(passwordForgottenParent);
			
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setScene(passwordForgottenScene);
			window.setResizable(true);
			window.setTitle("Homepage");
			
			Label l = (Label)passwordForgottenScene.lookup("#welcomeText");
			l.setText("Welcome ");

			window.show();

	}
	
	public void logout(ActionEvent event) throws IOException
	{
		Parent passwordForgottenParent = FXMLLoader.load(getClass().getResource("loginGUI.fxml"));
		Scene passwordForgottenScene = new Scene(passwordForgottenParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(passwordForgottenScene);
		window.show();
	}
	public void getNewPassword(ActionEvent event) throws IOException
	{
		Parent passwordForgottenParent = FXMLLoader.load(getClass().getResource("passwordForgottenGUI.fxml"));
		Scene passwordForgottenScene = new Scene(passwordForgottenParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(passwordForgottenScene);
		window.setResizable(false);
		window.show();
	}
	
	public void sendMail() 
	{
		
		System.out.println(mailText.getText());
		//sendMail("mailText.getText());
	}
	
}
