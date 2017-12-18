package gui;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import db.TrainingDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.Address;
import db.AddressDAO;
import logic.Location;
import db.LocationDAO;
import logic.Training;


public class TrainingCreateController {

	// For all controllers
		@FXML
		private Button training;
		@FXML
		private Button surveyButton;
		@FXML
		private Button statisticsButton;
		@FXML
		private Button logoutButton;
		@FXML
		private Label errorText;
	// For Training controllers
		@FXML
		private Button trainingsButton;
		@FXML
		private Button createButton;
		@FXML
		private Button assignButton;
		@FXML
		private Button demandsButton;
		
	// For this
		@FXML
		private TextField name;
		@FXML
		private TextField description;
		@FXML
		private DatePicker beginDate;
		@FXML
		private DatePicker endDate;
		@FXML
		private TextField street;
		@FXML
		private TextField number;
		@FXML
		private TextField city;
		@FXML
		private TextField country;
		@FXML
		private Button saveButton;

		
		public void surveyMenu(ActionEvent event) throws IOException
		{
			Parent homepageParent = FXMLLoader.load(getClass().getResource("SurveyHome.fxml"));
			Scene homepageScene = new Scene(homepageParent);
			
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setScene(homepageScene);
			window.setResizable(true);
			window.setTitle("Homepage");


			window.show();
			
		}
		
		public void statisticsMenu()
		{
			errorText.setText("You are already in this menu");
		}
		
		public void logout(ActionEvent event) throws IOException
		{
			Parent loginParent = FXMLLoader.load(getClass().getResource("loginGUI.fxml"));
			Scene loginScene = new Scene(loginParent);
			
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setScene(loginScene);
			window.show();
		}
		
		public void showTrainings(ActionEvent event) throws IOException
		{
			Parent loginParent = FXMLLoader.load(getClass().getResource("TrainingsGUI.fxml"));
			Scene loginScene = new Scene(loginParent);
			
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setScene(loginScene);
			window.show();
		}
		
		public void createTraining()
		{
			errorText.setText("You are already in this menu");
		}
		
		public void assignTraining(ActionEvent event) throws IOException
		{
			Parent homepageParent = FXMLLoader.load(getClass().getResource("TrainingAssignGUI.fxml"));
			Scene homepageScene = new Scene(homepageParent);
			
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setScene(homepageScene);
			window.setResizable(true);
			window.setTitle("Homepage");


			window.show();
			
		}
		
		public void demandsTraining(ActionEvent event) throws IOException
		{
			Parent homepageParent = FXMLLoader.load(getClass().getResource("TrainingDemands.fxml"));
			Scene homepageScene = new Scene(homepageParent);
			
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setScene(homepageScene);
			window.setResizable(true);
			window.setTitle("Homepage");


			window.show();
		}
		
		public void saveTraining()
		{
			String nameTraining = name.getText();
			String desc = description.getText();
			LocalDate begin = beginDate.getValue();
			LocalDate end = endDate.getValue();
			String streetName = street.getText();
			String housNumber = number.getText();
			String countryTraining = country.getText();
			
			/*Address a = new Address(1, streetName, Integer.parseInt(housNumber), countryTraining);
			Location l = new Location(1, 1, "EHB", "1ste verdieping");
			new AddressDAO().addAddress(a);
			new LocationDAO().addLocation(l);*/
			Training t = new Training(1, 1,String.valueOf(begin), String.valueOf(end), nameTraining, desc, 1);
			new TrainingDAO().addTraining(t);
			
			errorText.setText(nameTraining + " was created succesfully");
		}
}
