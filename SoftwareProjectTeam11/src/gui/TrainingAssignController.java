package gui;

import java.io.IOException;
import java.util.List;

import db.TrainingDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import logic.Training;
import odata.EmployeeOdata;

public class TrainingAssignController {
	
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
		
		// For Training Controllers
		
		@FXML
		private Button trainingsButton;
		@FXML
		private Button createButton;
		@FXML
		private Button assignButton;
		@FXML
		private Button demandsButton;
		
		// For this controller
		
		@FXML
		private ListView<String> trainingList;
		@FXML
		private ListView<String> employeeList;
		
		@FXML
		public void initialize()
		{
			trainingList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			employeeList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			
			List<Training> trainingen = new TrainingDAO().getAll();			
			for (Training t : trainingen) {
				trainingList.getItems().add(t.getTrainingId() + ": " + t.getTrainingName());
			}
			//---------------------------------
			List<String> employees = new EmployeeOdata().getAll();
			
			for (int i = 1; i <= employees.size()-1; i++) {
				employeeList.getItems().add(i + ": " + employees.get(i));
				System.out.println(employees.get(i));
			}
			
		}
		
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
			errorText.setText("No statistics menu available");
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
		
		public void createTraining(ActionEvent event) throws IOException
		{
			Parent homepageParent = FXMLLoader.load(getClass().getResource("TrainingCreateGUI.fxml"));
			Scene homepageScene = new Scene(homepageParent);
			
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setScene(homepageScene);
			window.setResizable(true);
			window.setTitle("Homepage");


			window.show();
		}
		
		public void assignTraining()
		{
			errorText.setText("You are already in this menu");
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
		
		public void assign()
		{
			String selectedTraining = trainingList.getSelectionModel().getSelectedItem();
			String selectedEmployee = employeeList.getSelectionModel().getSelectedItem();
			
			
		}
		
}
