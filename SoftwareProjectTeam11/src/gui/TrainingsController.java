package gui;

import java.io.IOException;
import java.util.List;

import logic.Address;

import db.AddressDAO;
import db.LocationDAO;
import db.TrainingDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Callback;
import logic.Location;
import logic.Training;

public class TrainingsController {
	
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
	
	// For Training Controllers
	
	@FXML
	private Button trainingsButton;
	@FXML
	private Button createButton;
	@FXML
	private Button assignButton;
	@FXML
	private Button demandsButton;
	
	@FXML
	private Button certificateButton;
	
	private WebView wv;
	
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
	
	// For this Controller
	
	@FXML
	private TableView<Training> column;
	@FXML
	private TableColumn<Training,String> name;
	@FXML
	private TableColumn<Training,String> description;
	@FXML
	private TableColumn<Training,String> begin;
	@FXML
	private TableColumn<Training,String> end;
	@FXML
	private TableColumn<Training,String> loc;
	
	
	public static String address;

	
	
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
		name.setCellValueFactory(new Callback<CellDataFeatures<Training, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Training, String> data) {
				return new SimpleStringProperty(data.getValue().getTrainingName());
			}
		});
		
		description.setCellValueFactory(new Callback<CellDataFeatures<Training, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Training, String> data) {
				return new SimpleStringProperty(data.getValue().getTrainingSummary());
			}
		});
		
		 begin.setCellValueFactory(new Callback<CellDataFeatures<Training, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Training, String> data) {
				return new SimpleStringProperty(data.getValue().getstartDate());
			}
		});
		
		 end.setCellValueFactory(new Callback<CellDataFeatures<Training, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(CellDataFeatures<Training, String> data) {
					return new SimpleStringProperty(data.getValue().getendDate());
				}
			});
		 
		 loc.setCellValueFactory(new Callback<CellDataFeatures<Training, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(CellDataFeatures<Training, String> data) {
					return new SimpleStringProperty(data.getValue().getLocationId() + "");
					//Change address into String and change getter ici î
				}
			});
		 
		
		 
		 
		 
		 
		 ObservableList<Training> lijst = FXCollections.observableArrayList(new TrainingDAO().getAll());
		 column.setItems((ObservableList<Training>) lijst);
		 
	}
	
	
	@FXML
	public void clickedLoc()
	{
		Training t = column.getSelectionModel().getSelectedItem();
		Location l = new LocationDAO().getLocationById(t.getLocationId());
		Address a = new AddressDAO().getAddressById(l.getAddressId());
		
		address = a.getCity() + " " + a.getStreetname() + " " + a.getHouseNumber();
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("googleMaps.fxml"));
			Parent root;
			root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Location");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public void statisticsMenu(ActionEvent event) throws IOException
	{
		Parent loginParent = FXMLLoader.load(getClass().getResource("StatisticGUI.fxml"));
		Scene loginScene = new Scene(loginParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(loginScene);
		//window.setResizable(false);
		
		window.show();
	}
	
	public void logout(ActionEvent event) throws IOException
	{
		Parent loginParent = FXMLLoader.load(getClass().getResource("loginGUI.fxml"));
		Scene loginScene = new Scene(loginParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(loginScene);
		//window.setResizable(false);
		
		window.show();
	}
	public void showTrainings()
	{
		errorText.setText("You are already in this menu");
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
	
}



 