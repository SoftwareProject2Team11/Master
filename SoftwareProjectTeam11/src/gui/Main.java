package gui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
		
		
		//CONVERTIR LE DATEPICKER EN SQLDATE
		//opleiding.setEinddatum(Date.valueOf(datepicker.getValue()));
		
		//MONTRER LE DATE EN STRING DANS LE TABEL
		/*SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(sdf.format(le date object));*/
		
	/*	LocalDate d2 
		String date = String.valueOf(d);
		Training t = new Training(1, 2, date, date, "C#", "Learn C#", 1);
		new TrainingDAO().addTraining(t);*/
		
		
	}

	@Override
	public void start(Stage window) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("loginGUI.fxml"));
		Scene loginScene = new Scene(root);
		
		window.setScene(loginScene);
		window.setResizable(false);
		window.show();
		
	}
	
}
