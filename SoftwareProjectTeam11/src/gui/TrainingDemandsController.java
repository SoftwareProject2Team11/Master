package gui;

import java.io.IOException;
import java.util.List;

import db.TrainingDAO;
import db.TrainingRequestDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.paint.Color;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import logic.Training;
import logic.TrainingRequest;

public class TrainingDemandsController {

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
	
	// for this
	@FXML
	private TableView<String> column;
	@FXML
	private TableColumn<Training, String> trTable;
	@FXML
	private TableColumn<TrainingRequest, String> reason;
	@FXML
	private TableColumn<TrainingRequest, String> demandDate;
	@FXML
	private Button accept;
	@FXML
	private Button refuse;
	@FXML
	private ListView<String> lijstTraining;
	
	
	
	// For Training Controllers
	
	@FXML
	private Button trainingsButton;
	@FXML
	private Button createButton;
	@FXML
	private Button assignButton;
	@FXML
	private Button demandsButton;

	private List<TrainingRequest> lijst;
	
	@FXML
	private Button optionButton;
	@FXML
	private Button certificateButton;
	
	@FXML
	public void certif(ActionEvent event)  throws IOException
	{
		Parent homepageParent = FXMLLoader.load(getClass().getResource("TrainingCertificatGUI.fxml"));
		Scene homepageScene = new Scene(homepageParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(homepageScene);
		window.setResizable(true);
		window.setTitle("Homepage");

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

	
	@FXML
	public void initialize()
	{
		
		lijstTraining.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		lijst = new TrainingRequestDAO().getAllRequests();
		for (int i = 0; i < lijst.size(); i++) {
			
			String username = Controller.getUser();
			String trainingName = new TrainingDAO().getTrainingById(lijst.get(i).getTrainingId()).getTrainingName();
			String res = lijst.get(i).getReason();
			String date = lijst.get(i).getCreateDate();
			String tot = username + " Request for: " + trainingName  +"   on: " + date + "  Reason: " + res;
			lijstTraining.getItems().add(tot);
		}
	}
	
	public void surveyMenu(ActionEvent event) throws IOException
	{
		errorText.setTextFill(Color.RED);
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
		errorText.setTextFill(Color.RED);
		errorText.setText("No statistics menu available");
	}
	
	public void logout(ActionEvent event) throws IOException
	{
		errorText.setTextFill(Color.RED);
		Parent loginParent = FXMLLoader.load(getClass().getResource("loginGUI.fxml"));
		Scene loginScene = new Scene(loginParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(loginScene);
		window.show();
	}
	
	public void showTrainings(ActionEvent event) throws IOException
	{
		errorText.setTextFill(Color.RED);
		Parent loginParent = FXMLLoader.load(getClass().getResource("TrainingsGUI.fxml"));
		Scene loginScene = new Scene(loginParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(loginScene);
		window.show();
	}
	
	public void createTraining(ActionEvent event) throws IOException
	{
		errorText.setTextFill(Color.RED);
		Parent homepageParent = FXMLLoader.load(getClass().getResource("TrainingCreateGUI.fxml"));
		Scene homepageScene = new Scene(homepageParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(homepageScene);
		window.setResizable(true);
		window.setTitle("Homepage");


		window.show();
	}
	
	public void assignTraining(ActionEvent event) throws IOException
	{
		errorText.setTextFill(Color.RED);
		Parent homepageParent = FXMLLoader.load(getClass().getResource("TrainingAssignGUI.fxml"));
		Scene homepageScene = new Scene(homepageParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(homepageScene);
		window.setResizable(true);
		window.setTitle("Homepage");


		window.show();
		
	}
	
	public void demandsTraining()
	{
		errorText.setTextFill(Color.RED);
		errorText.setText("You are already in this menu");
	}
	
	public void acceptDemande()
	{
		int id = lijstTraining.getSelectionModel().getSelectedIndex();
		int i = lijst.get(id).getRequestId();
		new TrainingRequestDAO().acceptRequest(i);
		errorText.setTextFill(Color.GREEN);
		errorText.setText("Training accepted");
		lijstTraining.getItems().clear();
		initialize();
	}
	
	public void refuseDemande()
	{
		errorText.setTextFill(Color.RED);
		int id = lijstTraining.getSelectionModel().getSelectedIndex();
		int i = lijst.get(id).getRequestId();
		new TrainingRequestDAO().declineRequest(i);
		errorText.setText("Training declined");
		lijstTraining.getItems().clear();
		initialize();
	}
	
}
