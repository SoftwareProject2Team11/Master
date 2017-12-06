package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateNewTrainingController {

	@FXML
	private Button logoutButton;
	@FXML
	private Button backButton;
	@FXML
	private Tab trainingTab;
	@FXML
	private Button traininginfoMenu;
	@FXML
	private Button createTrainingMenu;
	@FXML
	private Button feedbackMenu;
	@FXML
	private Button createSurveyMenuButton;
	@FXML
	private Label trainerName;
	@FXML
	private TextField fillInTrainerName;
	@FXML
	private Label startDate;
	@FXML
	private Label street;
	@FXML
	private TextField fillInStreetName;
	@FXML
	private Label streetNumber;
	@FXML
	private TextField fillInStreetNumber;
	@FXML
	private TextField fillInTrainerEmail;
	@FXML
	private Label trainingName;
	@FXML
	private TextField fillInTrainingName;
	@FXML
	private Label city;
	@FXML
	private TextField fillInCity;
	@FXML
	private Label postalCode;
	@FXML
	private TextField fillInPostalCode;
	@FXML
	private Label country;
	@FXML
	private TextField fillInCountry;
	@FXML
	private Label emailTrainer;
	@FXML
	private CheckBox checkDaily;
	@FXML
	private CheckBox checkWeekly;
	@FXML
	private Label repeat;
	@FXML
	private Label time;
	@FXML
	private Label courseMaterial;
	@FXML
	private JFXDatePicker chooseEndDate;
	@FXML
	private JFXDatePicker chooseDate;
	@FXML
	private JFXTimePicker chooseStartTime;
	@FXML
	private JFXTimePicker chooseEndTime;
	@FXML
	private Button saveButton;
	@FXML
	private Tab inboxTab;
	@FXML
	private Tab statisticsTab;
	@FXML
	private Tab employeesTab;
	@FXML
	private Button trainingInfoMenu;
	

	
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
	public void back()
	{
		//idk
	}
	
	@FXML 
	public void trainingInfoMenu(ActionEvent event) throws IOException
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
	
	public void fillInTrainerName()
	{
		//control veiliginv
	}
	public void fillInStreetName()
	{
		//control veiliginv
	}
	@FXML 
	public void fillInStreetNumber()
	{
		//control veiliginv
	}
	
	@FXML 
	public void fillInTrainingName()
	{
		//control veiliginv
	}
	
	@FXML 
	public void fillInCity()
	{
		//control veiliginv
	}
	
	@FXML 
	public void fillInCountry()
	{
		//control veiliginv
	}
	@FXML 
	public void fillInPostalCode()
	{
		//control veiliginv
	}
	@FXML 
	public void fillInTrainerEmail()
	{
		//control veiliginv
	}
	@FXML 
	public void add()
	{
		//idk
	}
	
	@FXML 
	public void remove()
	{
		//idk
	}
	@FXML 
	public void save()
	{
		//save the training
	}
	
	
}
