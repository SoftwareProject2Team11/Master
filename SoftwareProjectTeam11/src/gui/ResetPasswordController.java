package gui;

import java.io.IOException;
import java.util.Random;

import db.LoginDAO;
import gui.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ResetPasswordController {
	
	@FXML
	private Button backButton;
	@FXML
	private Button resetButton;
	@FXML
	private Label errorText;
	@FXML
	private TextField codeTextfield;
	@FXML
	private PasswordField newPasswordOne;
	@FXML
	private PasswordField newPasswordTwo;
	
	

	@FXML
	public void resetPassword()
	{
		
		
		String controllermail = "" + new LoginDAO().getReset(Controller.mail);
		if (codeTextfield.getText().equals(controllermail) && newPasswordOne.getText().equals(newPasswordTwo.getText()))
		{
			
			boolean check = new LoginDAO().setNewPassword(Controller.mail, newPasswordOne.getText());
			
			if (check) {
				new LoginDAO().setReset(Controller.getUser(), -1);
				errorText.setTextFill(Color.GREEN);
				errorText.setText("Password was succesfully changed");
			}
			else
			{
				errorText.setTextFill(Color.RED);
				errorText.setText("Error: try again");
			}
			
		}
	}
	
	@FXML
	public void passwordForgottenMenu(ActionEvent event) throws IOException
	{
		Parent passwordForgottenParent = FXMLLoader.load(getClass().getResource("passwordForgottenGUI.fxml"));
		Scene passwordForgottenScene = new Scene(passwordForgottenParent);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(passwordForgottenScene);
		window.setResizable(false);
		window.show();
	}
}
