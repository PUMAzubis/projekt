package de.dpma.pumaz.bvs.view;

import java.sql.SQLException;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.FXML_GUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

public class EmployeeListController {
	
	@FXML
	private Tooltip buttonEditToolTip;
	
	@FXML
	private Tooltip buttonNewToolTip;
	
	@FXML
	private Tooltip buttonDeleteToolTip;
	
	@FXML
	private Tooltip buttonBackToolTip;
	
	@FXML
	private Label firstNameColumnLabel;
	
	@FXML
	private Label lastNameColumnLabel;
	
	@FXML
	private Label headerLabel;
	
	@FXML
	private Label detailsLabel;
	
	@FXML
	private Label idLabel;
	
	@FXML
	private Label firstNameLabel;
	
	@FXML
	private Label lastNameLabel;
	
	@FXML
	private Label workerIdLabel;
	
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
	
	public void handleEdit() throws SQLException {
	
	}
	
	public void handleNew() throws SQLException {
	
	}
	
	public void handleDelete() throws SQLException {
	
	}
	
	public void handleBack() throws SQLException {
	
	}
	
}
