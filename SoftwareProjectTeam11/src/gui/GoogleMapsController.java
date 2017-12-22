package gui;

import javafx.fxml.FXML;
import javafx.scene.web.WebView;

public class GoogleMapsController {
	
	@FXML
	private WebView wv;
	
	@FXML
	public void initialize()
	{
		wv.getEngine().load("https://maps.google.com/?q=" + TrainingsController.address);
	}

}
