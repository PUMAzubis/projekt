package de.dpma.pumaz.bvs.view;

import java.util.logging.Logger;

import de.dpma.pumaz.bvs.FXML_GUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LendBookController {
	
	@FXML
	private Tooltip buttonBackToolTip;
	
	@FXML
	private Tooltip buttonLendToolTip;
	
	@FXML
	private Tooltip textFieldWorkerIdToolTip;
	
	@FXML
	private Text headerText;
	
	@FXML
	private Label workerIdLabel;
	
	@FXML
	private Button cancelButton;
	
	@FXML
	private Button lendBookButton;
	
	@FXML
	private TextField workerIdTextField;
	
	public LendBookController() {
		// buttonBackToolTip.setText("Click to get back to the last page");
		// buttonLendToolTip.setText("Click to lend book to a user");
		// textFieldWorkerIdToolTip.setText("Type in identification number");
		// headerLabel.setText("Lend book");
		// workerIdLabel.setText("Identification number");
		// cancelButton.setText("Cancel");
		// lendBookButton.setText("Lend");
		// workerIdTextField.setText("Identification number");
		//
		//
		// buttonBackToolTip.setText("Drücken um zurück zu gelangen");
		// buttonLendToolTip.setText("Drücken um Buch zu verleihen");
		// textFieldWorkerIdToolTip.setText("Ausweisnummer eingeben");
		// headerLabel.setText("Verleihen");
		// workerIdLabel.setText("Ausweisnummer");
		// cancelButton.setText("Abbrechen");
		// lendBookButton.setText("Verleihen");
		// workerIdTextField.setText("Ausweisnummer");
		
	}
	
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
