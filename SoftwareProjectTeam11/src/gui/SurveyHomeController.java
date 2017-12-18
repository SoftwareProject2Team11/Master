package gui;

import java.io.IOException;
import java.util.List;

import db.AnswerDAO;
import db.QuestionDAO;
import db.TrainingDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import logic.Answer;
import logic.Question;
import logic.Training;

public class SurveyHomeController {

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
	private ChoiceBox<String> trainingChoice;
	@FXML
	private Button chooseButton;
	@FXML
	private ListView<String> questions;
	@FXML
	private ListView<String> answers;
	@FXML
	private Button loadButton;
	@FXML
	private Button trButton;
	@FXML
	private List<Training> lijstTraining;
	@FXML
	private List<Question> lijstQuestion;
	
	@FXML
	public void initialize()
	{
		questions.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		answers.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		lijstTraining = new TrainingDAO().getAll();
		for (Training t : lijstTraining) {
			trainingChoice.getItems().add(t.getTrainingName());
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
	public void chooseTraining()
	{
		int index = trainingChoice.getSelectionModel().getSelectedIndex();
		int id = lijstTraining.get(index).getTrainingId();
		lijstQuestion = new QuestionDAO().getQuestionsByTrainingId(id);
		
		for (Question q : lijstQuestion) {
			questions.getItems().add(q.getQuestion());
		}
		
		
	}
	
	@FXML
	public void loadQuestions()
	{
		int index = questions.getSelectionModel().getSelectedIndex();
		Question q = lijstQuestion.get(index);
		List<Answer> lijstAnswers = new AnswerDAO().getAnswers(q.getQuestionId());
		
		for (Answer a : lijstAnswers) {
			answers.getItems().add(a.getAnswer());
		}
		
	}
	
	
	@FXML
	public void showSurveys()
	{
		errorText.setText("You are already in this Tab");
	}
	@FXML
	public void createSurvey(ActionEvent event) throws IOException
	{
		Parent homepageParent = FXMLLoader.load(getClass().getResource("SurveyCreate.fxml"));
		Scene homepageScene = new Scene(homepageParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(homepageScene);
		window.setResizable(true);
		window.setTitle("Homepage");


		window.show();
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
		Parent loginParent = FXMLLoader.load(getClass().getResource("loginGUI.fxml"));
		Scene loginScene = new Scene(loginParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(loginScene);
		window.show();
	}
}
