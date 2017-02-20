package de.dpma.pumaz.bvs.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.util.logging.Logger;		
		
import de.dpma.pumaz.bvs.FXML_GUI;
public class LendBookController {
	
	@FXML 
	private Tooltip ButtonzurueckToolTip;
	@FXML 
	private Tooltip ButtonausleihenToolTip;
	@FXML 
	private Tooltip textfieldAusweissnummerToolTip;
	@FXML
	private Label headerLabel;
	
	@FXML
	private Label idLabel;
	
	@FXML
	private Button cancelButton;
	
	@FXML
	private Button lendButton;
	
	@FXML
	private TextField idText;
	Stage stage = new Stage();		
	 			
	 	FXML_GUI fxml_gui;		
	 			
	 	Logger log = Logger.getLogger(LendBookController.class.getName());		
	 			
	 	public void handleIdText(){		
	 	}		
	 			
	 	public void handleLend(){		
	 	}		
	 			
	 	public void handleBack(){		
	 	}
}
