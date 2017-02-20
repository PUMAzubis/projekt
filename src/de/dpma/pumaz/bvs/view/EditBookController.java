package de.dpma.pumaz.bvs.view;

import java.sql.SQLException;		
import java.text.NumberFormat;		
import java.text.ParsePosition;		
import java.util.logging.Logger;		
		
import de.dpma.pumaz.bvs.FXML_GUI;
import de.dpma.pumaz.bvs.model.Book;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditBookController {

	@FXML 
	private Tooltip textfieldtitleToolTip;
	@FXML 
	private Tooltip textfieldauthorToolTip;
	@FXML 
	private Tooltip textfieldisbnToolTip;
	@FXML 
	private Tooltip textfieldreleaseToolTip;
	@FXML 
	private Tooltip textfieldcategorieToolTip;
	@FXML 
	private Tooltip buttonsafeToolTip;
	@FXML 
	private Tooltip buttoncancelToolTip;
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
	 	private TextField titleText;		
	 	@FXML		
	 	private TextField authorText;		
	 	@FXML		
	 	private TextField ISBNText;		
	 	@FXML		
	 	private TextField yearText;		
	 	@FXML		
	 	private TextField categoryText;		
	 	public EditBookController() {
	 		categoryText.setText("Category");
	 		yearText.setText("Year of release");
	 		ISBNText.setText("ISBN");
	 		authorText.setText("Author");
	 		titleText.setText("Title");
	 		hintLabel.setText("Fields marked with an asterisk* are obligatory.");
	 		cancelButton.setText("Cancel");
	 		saveButton.setText("Save");
	 		categoryLabel.setText("Category");
	 		isbnLabel.setText("ISBN");
	 		releaseLabel.setText("Year of release");
	 		authorLabel.setText("Author");
	 		headerLabel.setText("Edit Book");
	 		titleLabel.setText("Title");
	 		textfieldtitleToolTip.setText("Type in books title");
	 		textfieldauthorToolTip.setText("Type in books author");
	 		textfieldisbnToolTip.setText("Type in books ISBN");
	 		textfieldreleaseToolTip.setText("Type in books year of release");
	 		textfieldcategorieToolTip.setText("Type in books category");
	 		buttonsafeToolTip.setText("Press to save");
	 		buttoncancelToolTip.setText("Press to cancel");
	 		
	 	}
	 			
	 	Stage stage = new Stage();		
	 			
	 	FXML_GUI fxml_gui;		
	 			
	 	RootLayoutController root = new RootLayoutController();		
	 			
	 	Logger log = Logger.getLogger(EditBookController.class.getName());		
	 			
	 	public void handleEditTitle() throws SQLException{		
	 				
	 //		if(titleText.getText().isEmpty() || isNumeric(titleText.getText())){		
	 //			log.info("Bitte Titel eingeben!");		
	 //		}		
	 //		return;		
	 	}		
	 			
	 	public void handleEditAuthor() throws SQLException{		
	 				
	 //		if(authorText.getText().isEmpty() || isNumeric(authorText.getText())){		
	 //			log.info("Bitte Author eingeben!");		
	 //		}		
	 //		return;		
	 	}		
				
	 	public void handleEditISBN() throws SQLException{		
	 //		if(ISBNText.getText().isEmpty() || !isNumeric(ISBNText.getText()) || ISBNText.getText().length())		
	 	}		
	 			
	 	public void handleEditYear() throws SQLException{		
	 	}		
	 			
	 	public void handleEditCategory() throws SQLException{		
	 	}		
	 			
	 	public void handleSave() throws SQLException{		
	 	}		
	 			
	 	public void handleCancel() throws SQLException{		
	 	}		
	  			  	
	 	public static boolean isNumeric(String str) {		
	 		NumberFormat formatter = NumberFormat.getInstance();		
	 	ParsePosition pos = new ParsePosition(0);		
	 		formatter.parse(str, pos);		
	 		return str.length() == pos.getIndex();		
	 	}	
	 			
	 
}
