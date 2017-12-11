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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SurveyCreateController {

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
	// For Survey controllers
		@FXML
		private Button trainingsButton;
		@FXML
		private Button createButton;
	// For this
		@FXML
		private TextField vraag1;
		@FXML
		private TextField vraag2;
		@FXML
		private TextField vraag3;
		@FXML
		private TextField vraag4;
		@FXML
		private TextField vraag5;
		@FXML
		private ChoiceBox<String> trainingChoice;
		@FXML
		private Button chooseButton;
		@FXML
		private Button submitButton;
		@FXML
		private Button trButton;
		
		@FXML
		public void trainingMenu(ActionEvent event) throws IOException
		{
			Parent loginParent = FXMLLoader.load(getClass().getResource("TrainingsGUI.fxml"));
			Scene loginScene = new Scene(loginParent);
			
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setScene(loginScene);
			window.show();
		}
		
		@FXML
		public void submit()
		{
			
		}

		@FXML
		public void chooseTraining()
		{
			
		}
		
		@FXML
		public void showSurveys(ActionEvent event) throws IOException
		{
			errorText.setText("");
			Parent loginParent = FXMLLoader.load(getClass().getResource("SurveyHome.fxml"));
			Scene loginScene = new Scene(loginParent);
			
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setScene(loginScene);
			window.show();
		}
		@FXML
		public void createSurvey()
		{
			errorText.setText("You are already in Create Survey Tab");
		}

		public void surveyMenu()
		{
			errorText.setText("You are already in Survey menu");
		}
		
		public void statisticsMenu()
		{
			errorText.setText("No statistics menu available");
		}
		
		public void logout(ActionEvent event) throws IOException
		{
			errorText.setText("");
			Parent loginParent = FXMLLoader.load(getClass().getResource("loginGUI.fxml"));
			Scene loginScene = new Scene(loginParent);
			
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setScene(loginScene);
			window.show();
		}
}
