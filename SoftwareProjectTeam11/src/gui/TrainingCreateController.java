package gui;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.Address;
import logic.GoogleBooksApi;
import db.AddressDAO;
import logic.Location;
import logic.Material;
import db.LocationDAO;
import db.MaterialDAO;
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
	private TextField books;
	@FXML
	private Button saveButton;
	@FXML
	private Button searchButton;

	@FXML
	private Button optionButton;
	@FXML
	private Button certificateButton;
	@FXML
	private ListView<String> lijst;

	@FXML
	public void initialize() {

		lijst.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}

	@FXML
	public void searchBook() {
		try {
			List<String> lst = new GoogleBooksApi().sendGetRequestChrome(books.getText());
			for (int i = 0; i < lst.size(); i++) {
				lijst.getItems().add(lst.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void certif(ActionEvent event) throws IOException {
		Parent homepageParent = FXMLLoader.load(getClass().getResource("TrainingCertificatGUI.fxml"));
		Scene homepageScene = new Scene(homepageParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(homepageScene);
		window.setResizable(true);
		window.setTitle("Homepage");

		window.show();
	}

	@FXML
	public void openOption(ActionEvent event) throws IOException {
		Parent homepageParent = FXMLLoader.load(getClass().getResource("OptionGUI.fxml"));
		Scene homepageScene = new Scene(homepageParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(homepageScene);
		window.setResizable(true);
		window.setTitle("Homepage");

		window.show();
	}

	public void surveyMenu(ActionEvent event) throws IOException {
		Parent homepageParent = FXMLLoader.load(getClass().getResource("SurveyHome.fxml"));
		Scene homepageScene = new Scene(homepageParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(homepageScene);
		window.setResizable(true);
		window.setTitle("Homepage");

		window.show();

	}

	public void statisticsMenu() {
		errorText.setText("You are already in this menu");
	}

	public void logout(ActionEvent event) throws IOException {
		Parent loginParent = FXMLLoader.load(getClass().getResource("loginGUI.fxml"));
		Scene loginScene = new Scene(loginParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(loginScene);
		window.show();
	}

	public void showTrainings(ActionEvent event) throws IOException {
		Parent loginParent = FXMLLoader.load(getClass().getResource("TrainingsGUI.fxml"));
		Scene loginScene = new Scene(loginParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(loginScene);
		window.show();
	}

	public void createTraining() {
		errorText.setText("You are already in this menu");
	}

	public void assignTraining(ActionEvent event) throws IOException {
		Parent homepageParent = FXMLLoader.load(getClass().getResource("TrainingAssignGUI.fxml"));
		Scene homepageScene = new Scene(homepageParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(homepageScene);
		window.setResizable(true);
		window.setTitle("Homepage");

		window.show();

	}

	public void demandsTraining(ActionEvent event) throws IOException {
		Parent homepageParent = FXMLLoader.load(getClass().getResource("TrainingDemands.fxml"));
		Scene homepageScene = new Scene(homepageParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(homepageScene);
		window.setResizable(true);
		window.setTitle("Homepage");

		window.show();
	}

	public void saveTraining() {
		String nameTraining = name.getText();
		String desc = description.getText();
		LocalDate begin = beginDate.getValue();
		LocalDate end = endDate.getValue();
		String streetName = street.getText();
		String housNumber = number.getText();
		String ct = city.getText();

		if (nameTraining.equals("") || desc.equals("") || begin.equals("") || end.equals("") || streetName.equals("")
				|| housNumber.equals("") || ct.equals("")) {

			errorText.setText("Please fill in all the blanks");
		} else {

			if (!beginDate.getValue().isAfter(endDate.getValue()) || beginDate.getValue().equals(endDate.getValue())) {

				new AddressDAO().addAddress(streetName, Integer.parseInt(housNumber), ct);
				int i = new AddressDAO().getAddressByStreet(streetName).getAddressId();
				Location l = new Location(0, i, " ", " ");
				new LocationDAO().addLocation(l);
				int lid = new LocationDAO().getLocationByAddressId(i).getLocationId();
				Training t = new Training(0, lid, String.valueOf(begin), String.valueOf(end), nameTraining, desc, 1);
				new TrainingDAO().addTraining(t);

				int trainingid = new TrainingDAO().getTrainingByNameAndDesc(nameTraining, desc).getTrainingId();

				String selectedBook = lijst.getSelectionModel().getSelectedItem();

				Material m = new Material(0, trainingid, selectedBook);
				new MaterialDAO().addMaterial(m);

				errorText.setText(nameTraining + " was created succesfully");
			} else {
				errorText.setText("Selected end date is before begin date");
			}

		}

	}

}
