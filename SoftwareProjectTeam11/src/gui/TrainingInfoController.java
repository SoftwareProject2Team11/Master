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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class TrainingInfoController {

	
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
	@FXML
	private ChoiceBox selectTraining;
	@FXML
	private Button viewSelectedTraining;
	@FXML
	private Button logoutButton;
	@FXML
	private Button backButton;
	@FXML
	private TableView table;
	@FXML
	private TableColumn trainerData;
	@FXML
	private TableColumn locationData;
	@FXML
	private TableColumn dateData;
	@FXML
	private TableColumn timeData;
	@FXML
	private TableColumn courseMaterialData;
	
	@FXML
	public void initializer()
	{
		//getAllTrainingen() into choicebox selectTraining
	}
	@FXML 
	public void viewButton()
	{
		//get selected training and put info into 
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
	@FXML
	public void back()
	{
		//idk
	}
	@FXML
	public void logout(ActionEvent event) throws IOException
	{
		Parent loginParent = FXMLLoader.load(getClass().getResource("loginGUI.fxml"));
		Scene loginScene = new Scene(loginParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(loginScene);
		window.show();
		
	}
}
