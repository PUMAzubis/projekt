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
	
	@FXML
	private Label smallHeaderLabel;
	
	Stage stage = new Stage();
	
	FXML_GUI fxml_gui;
	
	Logger log = Logger.getLogger(EmployeeListController.class.getName());
	
	private EmployeeListController() {
		// buttonEditToolTip.setText("Click to edit employee");
		// buttonNewToolTip.setText("Click to add a new employee");
		// buttonDeleteToolTip.setText("Click to delete employee");
		// buttonBackToolTip.setText("Click to get back");
		// firstNameColumnLabel.setText("First name");
		// lastNameColumnLabel.setText("Last name");
		// headerLabel.setText("Employee List");
		// detailsLabel.setText("Details");
		// idLabel.setText("Identification number");
		// firstNameLabel.setText("First name");
		// lastNameLabel.setText("Last name");
		// workerIdLabel.setText("Identification number");
		// statusLabel.setText("Status");
		// editButton.setText("Edit");
		// newButton.setText("New");
		// deleteButton.setText("Delete");
		// cancelButton.setText("Cancel");
		// smallHeaderLabel.setText("Employee Details");
		//
		//
		//
		// buttonEditToolTip.setText("Drücken um Mitarbeiter zu bearbeiten");
		// buttonNewToolTip.setText("Drücken um neuen Mitarbeiter anzulegen");
		// buttonDeleteToolTip.setText("Drücken um Mitarbeiter zu löschen");
		// buttonBackToolTip.setText("Drücken um zurück zu gelangen");
		// firstNameColumnLabel.setText("Vorname");
		// lastNameColumnLabel.setText("Nachname");
		// headerLabel.setText("Mitarbeiterbearbeitung");
		// detailsLabel.setText("Details");
		// idLabel.setText("Ausweisnummer");
		// firstNameLabel.setText("Vorname");
		// lastNameLabel.setText("Nachname");
		// workerIdLabel.setText("Ausweisnummer");
		// statusLabel.setText("Status");
		// editButton.setText("Bearbeiten");
		// newButton.setText("Neu");
		// deleteButton.setText("Löschen");
		// cancelButton.setText("Abbrechen");
		// smallHeaderLabel.setText("Mitarbeiter Details");
		
	}
	
	public void handleEdit() throws SQLException {
		
	}
	
	public void handleNew() throws SQLException {
		
	}
	
	public void handleDelete() throws SQLException {
		
	}
	
	public void handleBack() throws SQLException {
		
	}
}
