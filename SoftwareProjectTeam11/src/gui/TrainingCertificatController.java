package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import db.CertificatDAO;
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
import javafx.scene.effect.Blend;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import logic.Certificat;
import logic.Training;
import odata.EmployeeOdata;

public class TrainingCertificatController {
	
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
		

		
	// For this controller
		@FXML
		private Button chooseButton;
		@FXML
		private Button uploadButton;
		@FXML
		private Button downloadButton;
		@FXML
		private ListView<String> trainingList;
		@FXML
		private ListView<String> employeeList;
		
		private List<Training> trainingen;
		private List<String> employees;

		


		
		
		@FXML
		public void certif()
		{
			errorText.setText("You are already in this menu");
		}
		@FXML
		public void initialize()
		{
			trainingList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			employeeList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			
			 trainingen = new TrainingDAO().getAll();			
			for (Training t : trainingen) {
				trainingList.getItems().add(t.getTrainingId() + ": " + t.getTrainingName());
			}
			//---------------------------------
			employees = new EmployeeOdata().getAll();
			
			for (int i = 1; i <= employees.size(); i++) {
				employeeList.getItems().add(i + ": " + employees.get(i-1));

			}
			
		}
		

		@FXML
		public void upload()
		{
			FileChooser fc = new FileChooser();
			File file = fc.showOpenDialog(Main.windowPrimary);
			System.out.println(file);
			byte[] content = new byte[(int) file.length()];
			
			if (file != null) {
				int selectedTraining = trainingList.getSelectionModel().getSelectedIndex();
				int selectedEmployee = employeeList.getSelectionModel().getSelectedIndex();
				String namefile = new EmployeeOdata().getEmployeeNameById(selectedEmployee+1) + trainingen.get(selectedTraining-1).getTrainingId();
				
				
				FileInputStream fis;
				try {
					 fis = new FileInputStream(file);
					 try {
						fis.read(content);
						
						System.out.println(1+ ":        " +content);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
		
				String extensie = file.getName().substring(file.getName().lastIndexOf(".")+1);
				
				Certificat c = new Certificat(0, trainingen.get(selectedTraining-1).getTrainingId(),namefile, content,extensie);
				new CertificatDAO().uploadCertificat(c);
			}
			else {
				errorText.setText("No file selected");
			}
			
		}
		@FXML
		public void download() throws IOException
		{
			int selectedTraining = trainingList.getSelectionModel().getSelectedIndex();
			int selectedEmployee = employeeList.getSelectionModel().getSelectedIndex();
			String namefile = new EmployeeOdata().getEmployeeNameById(selectedEmployee+1) + trainingen.get(selectedTraining-1).getTrainingId();
			Certificat c = new CertificatDAO().downloadCertificat(namefile);
			
			if (c != null) {
				
				DirectoryChooser dc = new DirectoryChooser();
				
				File file = dc.showDialog(Main.windowPrimary);
				
				if (file != null) {
					
				
					FileOutputStream fos = new FileOutputStream(file.getAbsolutePath() + "\\" + namefile + "." + c.getExtensie());
					fos.write(c.getCertificaat());
					errorText.setText("File downloaded succesfully ");
				}
				else {
					errorText.setText("No file selected");
				}
						
				
			}
			else {
				errorText.setText("No certificate available");
			}
			
		}
		
		
		
	// For all controllers
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
			errorText.setText("No statistics menu available");
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

		
		@FXML
		public void trainingMenu(ActionEvent event) throws IOException {
			errorText.setTextFill(Color.RED);
			Parent loginParent = FXMLLoader.load(getClass().getResource("TrainingsGUI.fxml"));
			Scene loginScene = new Scene(loginParent);

			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(loginScene);
			window.show();
		}
		
	// For training Controllers
		
		
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
