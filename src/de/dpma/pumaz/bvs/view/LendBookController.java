package de.dpma.pumaz.bvs.view;

import java.util.logging.Logger;

import de.dpma.pumaz.bvs.FXML_GUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

public class LendBookController {
	
	@FXML
	private Tooltip buttonBackToolTip;
	
	@FXML
	private Tooltip buttonLendToolTip;
	
	@FXML
	private Tooltip textFieldWorkerIdToolTip;
	
	@FXML
	private Label headerLabel;
	
	@FXML
	private Label workerIdLabel;
	
	@FXML
	private Button cancelButton;
	
	@FXML
	private Button lendBookButton;
	
	@FXML
	private TextField workerIdTextField;
	
	Stage stage = new Stage();
	
	FXML_GUI fxml_gui;
	
	Logger log = Logger.getLogger(LendBookController.class.getName());
	
	public void handleIdText() {
		
	}
	
	public void handleLend() {
		
	}
	
	public void handleBack() {
		
	}
}
