package de.dpma.pumaz.bvs.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import java.sql.SQLException;		
import java.util.logging.Logger;		
		
import de.dpma.pumaz.bvs.FXML_GUI;
public class EmployeeListController {

@FXML 
private Tooltip ButtonbearbeitenToolTip;
@FXML 
private Tooltip ButtonneuToolTip;
@FXML 
private Tooltip ButtonloeschenToolTip;
@FXML 
private Tooltip ButtonzurueckToolTip;
@FXML
private Label firstnameColumnLabel;

@FXML
private Label lastnameColumnLabel;

@FXML
private Label headerLabel;

@FXML
private Label detailsLabel;

@FXML
private Label idLabel;

@FXML
private Label firstnameLabel;

@FXML
private Label lastnameLabel;

@FXML
private Label workIDLabel;

@FXML
private Label statusLabel;

@FXML
private Button editButton;

@FXML
private Button newButton;

@FXML
private Button deleteButton;

@FXML
private Button cancelButton;
	
	Stage stage = new Stage();		
			
	FXML_GUI fxml_gui;		
			
	Logger log = Logger.getLogger(EmployeeListController.class.getName());		
		
	public void handleEdit() throws SQLException{		
	}		
			
	public void handleNew() throws SQLException{		
	}		
			
	public void handleDelete() throws SQLException{		
	}		
			
	public void handleBack() throws SQLException{		
	}


}
