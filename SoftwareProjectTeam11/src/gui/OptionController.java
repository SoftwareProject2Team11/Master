package gui;

import java.awt.Window;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import db.ColorDAO;
import db.KeyCodeDAO;
import db.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.KeyCodes;
import odata.EmployeeOdata;

public class OptionController {

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
	private TitledPane paneMenu;
	@FXML
	private Button optionButton;
	@FXML
	private ListView<String> lijstEmployee;
	@FXML
	private Label keyLabel;
	
	
	@FXML
	public void initialize()
	{
		List<String> lijst = new UserDAO().getAll();
		for (int i = 0; i < lijst.size(); i++) {
			lijstEmployee.getItems().add(lijst.get(i));
		}
	}
	
	@FXML
	public void generate()
	{
		Random r= new Random();
		int code = r.nextInt(10000);
		
		keyLabel.setText(code+"");
		KeyCodes k = new KeyCodes(0,code+"", 0);
		new KeyCodeDAO().addKeyCode(k);
		
	}

	@FXML
	public void openOption() {
		errorText.setText("You are already in this menu");
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

	public void statisticsMenu(ActionEvent event) throws IOException {
		Parent loginParent = FXMLLoader.load(getClass().getResource("StatisticGUI.fxml"));
		Scene loginScene = new Scene(loginParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(loginScene);
		// window.setResizable(false);

		window.show();
	}

	public void logout(ActionEvent event) throws IOException {
		Parent loginParent = FXMLLoader.load(getClass().getResource("loginGUI.fxml"));
		Scene loginScene = new Scene(loginParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(loginScene);
		// window.setResizable(false);

		window.show();
	}

	public void showTrainings(ActionEvent event) throws IOException {
		errorText.setTextFill(Color.RED);
		Parent loginParent = FXMLLoader.load(getClass().getResource("TrainingsGUI.fxml"));
		Scene loginScene = new Scene(loginParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(loginScene);
		window.show();
	}

	// for this
	/*
	 * @FXML private Button submitButton;
	 * 
	 * @FXML private ColorPicker colorPicker;
	 * 
	 * @FXML private BorderPane pane;
	 * 
	 * @FXML private Button certificateButton;
	 * 
	 * @FXML public void certif(ActionEvent event) throws IOException { Parent
	 * homepageParent =
	 * FXMLLoader.load(getClass().getResource("TrainingCertificatGUI.fxml")); Scene
	 * homepageScene = new Scene(homepageParent);
	 * 
	 * Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	 * window.setScene(homepageScene); window.setResizable(true);
	 * window.setTitle("Homepage");
	 * 
	 * window.show(); }
	 */
	/*
	 * @FXML public void submit() {
	 * 
	 * 
	 * if (colorPicker.getValue().toString().equals("0x000000ff")) {
	 * pane.setStyle("-fx-background-color: black");
	 * paneMenu.setStyle("-fx-background-color: black"); new
	 * ColorDAO().updateColor("black"); }else { String a =
	 * Integer.toHexString(colorPicker.getValue().hashCode()).substring(0,
	 * 6).toUpperCase();
	 * 
	 * new ColorDAO().updateColor(a); String kleur = new ColorDAO().getColor();
	 * pane.setStyle("-fx-background-color: #" + kleur);
	 * paneMenu.setStyle("-fx-background-color: #" + kleur);
	 * 
	 * }
	 * 
	 * }
	 */
}
