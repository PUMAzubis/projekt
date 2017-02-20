package de.dpma.pumaz.bvs.view;

import de.dpma.pumaz.bvs.model.Book;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;

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
	
}
