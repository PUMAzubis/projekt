package de.dpma.pumaz.bvs.view;

import java.util.logging.Logger;
import de.dpma.pumaz.bvs.FXML_GUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

public class PasswordResetController {
	
	@FXML 
	private Tooltip buttonBackToolTip;
	
	@FXML
	private Button backButton;
	
	Stage stage = new Stage();
	
	FXML_GUI fxml_gui;
	
	Logger log = Logger.getLogger(PasswordResetController.class.getName());
	
	public void handleBack(){
	}
}
