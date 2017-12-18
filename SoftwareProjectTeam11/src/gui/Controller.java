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
import javafx.stage.Stage;
import logic.Email;
import db.LoginDAO;

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
	private static String user ="Hacker";
	
	
	
	public void checkLogin(ActionEvent event)throws IOException
	{
			
			boolean check = new LoginDAO().checkLogin(usernameText.getText(), passwordText.getText());
			if(/*check*/true) {
			setUser(usernameText.getText());
			System.out.println(getUser());
			Parent homepageParent = FXMLLoader.load(getClass().getResource("TrainingsGUI.fxml"));
			Scene homepageScene = new Scene(homepageParent);
			
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setScene(homepageScene);
			window.setResizable(true);
			window.setTitle("Homepage");
			/*
			Label l = (Label)homepageScene.lookup("#welcomeText");
			l.setText("Welcome ");*/

			window.show();
			}
			else {
				System.out.println("Wrong password!");
				usernameText.deleteText(0, usernameText.getLength());
				passwordText.deleteText(0, usernameText.getLength());
			}
			

	}
	
	public void logout(ActionEvent event) throws IOException
	{
		Parent loginParent = FXMLLoader.load(getClass().getResource("loginGUI.fxml"));
		Scene loginScene = new Scene(loginParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(loginScene);
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
	
	public void sendMail(ActionEvent event) throws IOException 
	{
		
		/*System.out.println(mailText.getText());
		new LoginDAO().setReset(Controller.getUser(),0);
		String a = ""+new LoginDAO().getReset(user);
		new Email().sendEmail("", a);*/
		/*
		new LoginDAO().setReset("Oussama", 0);
		int reset = new LoginDAO().getReset("Oussama");
		System.out.println(reset);
		int okeh = reset;
		
		if (okeh == reset) {
			String password = "OussOuss";
			new LoginDAO().setNewPassword("Oussama", password);
			System.out.println("ok");
		}

		/*
		Parent passwordForgottenParent = FXMLLoader.load(getClass().getResource("ResetPasswordGUI.fxml"));
		Scene passwordForgottenScene = new Scene(passwordForgottenParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(passwordForgottenScene);
		window.setResizable(false);
		window.show();*/
	}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		Controller.user = user;
	}
	
}
