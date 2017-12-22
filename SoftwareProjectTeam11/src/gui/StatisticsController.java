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
import javafx.stage.Stage;
import logic.Statistics;
import logic.Training;

public class StatisticsController {

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
			@FXML
			private Button optionButton;
			@FXML
			private Label popularTraining;
			@FXML
			private Label trainingFollowed;
			@FXML
			private ListView<String> employeeList;
			
			@FXML
			public void initialize()
			{
				
				Training t = new TrainingDAO().getTrainingById(new Statistics().mostFollowed().getTrainingId());
				String s = t.getTrainingName();
				
				popularTraining.setText(s);
				
				trainingFollowed.setText(new Statistics().mostFollowing());
				
				
				List<String> list = new Statistics().allFollowing();
				for (int i = 0; i < list.size(); i++) {
					employeeList.getItems().add(list.get(i));
				}
				
			}
			
			
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
			public void openOption(ActionEvent event)  throws IOException
			{
				Parent homepageParent = FXMLLoader.load(getClass().getResource("OptionGUI.fxml"));
				Scene homepageScene = new Scene(homepageParent);
				
				Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
				window.setScene(homepageScene);
				window.setResizable(true);
				window.setTitle("Homepage");

				window.show();
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
}
