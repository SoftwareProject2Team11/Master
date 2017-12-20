package gui;

import java.io.IOException;
import java.util.List;

import db.QuestionDAO;
import db.TrainingDAO;
import db.TrainingRequestDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.Question;
import logic.Training;

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
	private Button submitButton;
	@FXML
	private Button trButton;
	@FXML
	private List<Training> lijstTraining;
	
	@FXML
	private Button optionButton;

	
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

	@FXML
	public void initialize() {
		errorText.setTextFill(Color.RED);
		lijstTraining = new TrainingDAO().getAll();
		for (Training t : lijstTraining) {
			trainingChoice.getItems().add(t.getTrainingName());
		}

	}

	@FXML
	public void trainingMenu(ActionEvent event) throws IOException {
		errorText.setTextFill(Color.RED);
		Parent loginParent = FXMLLoader.load(getClass().getResource("TrainingsGUI.fxml"));
		Scene loginScene = new Scene(loginParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(loginScene);
		window.show();
	}

	@FXML
	public void submit() {
		errorText.setTextFill(Color.RED);
		int index = trainingChoice.getSelectionModel().getSelectedIndex();
		int count = 0;
		if (index != -1) {

			Training t = lijstTraining.get(index);

			if (!vraag1.getText().equals("")) {
				Question q1 = new Question(0, t.getTrainingId(), vraag1.getText());
				new QuestionDAO().addQuestion(q1);
				count = count +1;
			}

			if (!vraag2.getText().equals("")) {
				Question q2 = new Question(0, t.getTrainingId(), vraag2.getText());
				new QuestionDAO().addQuestion(q2);
				count = count +1;
			}

			if (!vraag3.getText().equals("")) {
				Question q3 = new Question(0, t.getTrainingId(), vraag3.getText());
				new QuestionDAO().addQuestion(q3);
				count = count +1;
			}

			if (!vraag4.getText().equals("")) {
				Question q4 = new Question(0, t.getTrainingId(), vraag4.getText());
				new QuestionDAO().addQuestion(q4);
				count = count +1;
			}

			if (!vraag5.getText().equals("")) {
				Question q5 = new Question(0, t.getTrainingId(), vraag5.getText());
				new QuestionDAO().addQuestion(q5);
				count = count +1;
			}
			errorText.setTextFill(Color.GREEN);
			errorText.setText(count + " question(s) added");
		}
		else {
			errorText.setText("Please select a training");
		}
		
		if (count == 0) {
			errorText.setText("Please add a question before submitting");
		}

	}

	@FXML
	public void showSurveys(ActionEvent event) throws IOException {
		errorText.setTextFill(Color.RED);
		errorText.setText("");
		Parent loginParent = FXMLLoader.load(getClass().getResource("SurveyHome.fxml"));
		Scene loginScene = new Scene(loginParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(loginScene);
		window.show();
	}

	@FXML
	public void createSurvey() {
		errorText.setTextFill(Color.RED);
		errorText.setText("You are already in Create Survey Tab");
	}

	public void surveyMenu() {
		errorText.setTextFill(Color.RED);
		errorText.setText("You are already in Survey menu");
	}

	public void statisticsMenu() {
		errorText.setTextFill(Color.RED);
		errorText.setText("No statistics menu available");
	}

	public void logout(ActionEvent event) throws IOException {
		errorText.setTextFill(Color.RED);
		errorText.setText("");
		Parent loginParent = FXMLLoader.load(getClass().getResource("loginGUI.fxml"));
		Scene loginScene = new Scene(loginParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(loginScene);
		window.show();
	}
}
