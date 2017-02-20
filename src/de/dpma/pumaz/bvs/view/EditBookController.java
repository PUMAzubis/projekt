package de.dpma.pumaz.bvs.view;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.FXML_GUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

public class EditBookController {
	
	@FXML
	private Tooltip textFieldTitleToolTip;
	
	@FXML
	private Tooltip textFieldAuthorToolTip;
	
	@FXML
	private Tooltip textFieldIsbnToolTip;
	
	@FXML
	private Tooltip textFieldReleaseToolTip;
	
	@FXML
	private Tooltip textFieldCategorieToolTip;
	
	@FXML
	private Tooltip buttonSafeToolTip;
	
	@FXML
	private Tooltip buttonCancelToolTip;
	
	@FXML
	private Label titleLabel;
	
	@FXML
	private Label headerLabel;
	
	@FXML
	private Label authorLabel;
	
	@FXML
	private Label releaseLabel;
	
	@FXML
	private Label isbnLabel;
	
	@FXML
	private Label categoryLabel;
	
	@FXML
	private Button saveButton;
	
	@FXML
	private Button cancelButton;
	
	@FXML
	private Label hintLabel;
	
	@FXML
	private TextField titleTextField;
	
	@FXML
	private TextField authorTextField;
	
	@FXML
	private TextField isbnTextField;
	
	@FXML
	private TextField yearTextField;
	
	@FXML
	private TextField categoryTextField;
	
	public EditBookController() {
		categoryTextField.setText("Category");
		yearTextField.setText("Year of release");
		isbnTextField.setText("ISBN");
		authorTextField.setText("Author");
		titleTextField.setText("Title");
		hintLabel.setText("Fields marked with an asterisk* are obligatory.");
		cancelButton.setText("Cancel");
		saveButton.setText("Save");
		categoryLabel.setText("Category");
		isbnLabel.setText("ISBN");
		releaseLabel.setText("Year of release");
		authorLabel.setText("Author");
		headerLabel.setText("Edit Book");
		titleLabel.setText("Title");
		textFieldTitleToolTip.setText("Type in books title");
		textFieldAuthorToolTip.setText("Type in books author");
		textFieldIsbnToolTip.setText("Type in books ISBN");
		textFieldReleaseToolTip.setText("Type in books year of release");
		textFieldCategorieToolTip.setText("Type in books category");
		buttonSafeToolTip.setText("Press to save");
		buttonCancelToolTip.setText("Press to cancel");
		
	}
	
	Stage stage = new Stage();
	
	FXML_GUI fxml_gui;
	
	RootLayoutController root = new RootLayoutController();
	
	Logger log = Logger.getLogger(EditBookController.class.getName());
	
	public void handleEditTitle() throws SQLException {
		
		// if(titleText.getText().isEmpty() || isNumeric(titleText.getText())){
		// log.info("Bitte Titel eingeben!");
		// }
		// return;
	}
	
	public void handleEditAuthor() throws SQLException {
		
		// if(authorText.getText().isEmpty() ||
		// isNumeric(authorText.getText())){
		// log.info("Bitte Author eingeben!");
		// }
		// return;
	}
	
	public void handleEditISBN() throws SQLException {
		
		// if(ISBNText.getText().isEmpty() || !isNumeric(ISBNText.getText()) ||
		// ISBNText.getText().length())
	}
	
	public void handleEditYear() throws SQLException {
	
	}
	
	public void handleEditCategory() throws SQLException {
	
	}
	
	public void handleSave() throws SQLException {
	
	}
	
	public void handleCancel() throws SQLException {
	
	}
	
	public static boolean isNumeric(String str) {
		
		NumberFormat formatter = NumberFormat.getInstance();
		ParsePosition pos = new ParsePosition(0);
		formatter.parse(str, pos);
		return str.length() == pos.getIndex();
	}
	
}
