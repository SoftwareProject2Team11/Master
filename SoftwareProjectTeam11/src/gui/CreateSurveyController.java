package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateSurveyController {

	
	
	@FXML
	private Button traininginfoMenu;
	@FXML
	private Button createTrainingMenu;
	@FXML
	private Button feedbackMenu;
	@FXML
	private Button createSurveyMenu;
	@FXML
	private Button trainingInfoMenu;
	@FXML
	private Tab trainingTab;
	@FXML
	private Tab inboxTab;
	@FXML
	private Tab statisticsTab;
	@FXML
	private Tab employeesTab;
	@SuppressWarnings("rawtypes")
	@FXML
	private ChoiceBox chooseTraining;
	@FXML
	private TextField question1;
	@FXML
	private TextField question2;
	@FXML
	private TextField question3;
	@FXML
	private TextField question4;
	@FXML
	private TextField question5;
	@FXML
	private Button createSurveyButton;
	
	
	
	@FXML
	public void logout(ActionEvent event) throws IOException
	{
		Parent loginParent = FXMLLoader.load(getClass().getResource("loginGUI.fxml"));
		Scene loginScene = new Scene(loginParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(loginScene);
		window.show();
		
	}
	@FXML
	public void createSurvey()
	{
		
	}
	
	@FXML
	public void initializer()
	{
		// load 
	}
	
	@FXML 
	public void trainingInfo(ActionEvent event) throws IOException
	{
		Parent homepageParent = FXMLLoader.load(getClass().getResource("TrainingInfo.fxml"));
		Scene homepageScene = new Scene(homepageParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(homepageScene);
		window.setResizable(true);
		window.setTitle("Homepage");
		window.show();
	}
	@FXML 
	public void createTrainingMenu(ActionEvent event) throws IOException
	{
		Parent homepageParent = FXMLLoader.load(getClass().getResource("CreateNewTraining.fxml"));
		Scene homepageScene = new Scene(homepageParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(homepageScene);
		window.setResizable(true);
		window.setTitle("Homepage");
		window.show();
	}
	@FXML 
	public void feedbackMenu(ActionEvent event) throws IOException
	{
		Parent homepageParent = FXMLLoader.load(getClass().getResource("FeedbackMenu.fxml"));
		Scene homepageScene = new Scene(homepageParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(homepageScene);
		window.setResizable(true);
		window.setTitle("Homepage");
		window.show();
	}
	@FXML 
	public void createSurveyMenu(ActionEvent event) throws IOException
	{
		Parent homepageParent = FXMLLoader.load(getClass().getResource("CreateSurvey.fxml"));
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
}
