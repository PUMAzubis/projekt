package de.dpma.pumaz.bvs.view;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.FXML_GUI;
import de.dpma.pumaz.bvs.model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewBookController {

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
	private Text headerText;

	@FXML
	private Label authorLabel;

	@FXML
	private Label releaseLabel;

	@FXML
	private Label isbnLabel;

	@FXML
	private Label categoryLabel;

	@FXML
	private Label availableLabel;

	@FXML
	private Button saveButton;

	@FXML
	private Button cancelButton;

	@FXML
	private Label hintLabel;

	@FXML
	private TextField titleTextField = new TextField();

	@FXML
	private TextField authorTextField = new TextField();

	@FXML
	private TextField isbnTextField = new TextField();

	@FXML
	private TextField yearTextField = new TextField();

	@FXML
	private TextField availableTextField = new TextField();

	@FXML
	private ComboBox categoryComboBox = new ComboBox();

	ObservableList<String> categoryComboBoxList = FXCollections.observableArrayList("Patente", "Marken", "Lernbücher",
			"Zeitschriften");

	BookListController bookList = new BookListController();

	Stage stage = new Stage();

	FXML_GUI fxml_gui;

	RootLayoutController root = new RootLayoutController();

	Logger log = Logger.getLogger(NewBookController.class.getName());

	Book newBook = new Book();

	public NewBookController() {
	}

	@FXML
	public void initialize() throws SQLException {

		categoryComboBox.setItems(categoryComboBoxList);
	}

	@FXML
	public void handleSave() throws SQLException {

		// TODO Alert
		if (titleTextField.getText().isEmpty() || isNumeric(titleTextField.getText())) {
			root.handleDialog("Titel ungültig",
					"Es wurde kein gültiger Titel eingegeben. Bitte geben Sie einen validen Titel an und versuchen Sie es erneut.",
					"warning");
			log.warning("Bitte Titel eingeben!");
		} else if (authorTextField.getText().isEmpty() || isNumeric(authorTextField.getText())) {
			root.handleDialog("Autor ungültig",
					"Es wurde kein gültiger Autor eingegeben. Bitte geben Sie einen validen Autor an und versuchen Sie es erneut.",
					"warning");
			log.warning("Bitte Author eingeben!");
		} else if (isbnTextField.getText().isEmpty() || !isNumeric(isbnTextField.getText())
				|| isbnTextField.getText().length() <= 9) {
			root.handleDialog("ISBN ungültig",
					"Es wurde keine gültige ISBN eingegeben. Bitte geben Sie eine valide ISBN an und versuchen Sie es erneut.",
					"warning");
			log.warning("Bitte ISBN eingeben!");
		} else if (yearTextField.getText().isEmpty() || !isNumeric(yearTextField.getText())) {
			root.handleDialog("Erscheinungsjahr ungültig",
					"Es wurde keine gültige ISBN eingegeben. Bitte geben Sie eine valide ISBN an und versuchen Sie es erneut.",
					"warning");
			log.warning("Bitte Jahr eingeben!");
		} else if (availableTextField.getText().isEmpty() || !isNumeric(availableTextField.getText())) {
			root.handleDialog("Verfügbarkeit ungültig",
					"Es wurde keine gültige Verfügbarkeit eingegeben. Bitte geben Sie eine valide Verfügbarkeit an und versuchen Sie es erneut.",
					"warning");
			log.warning("Bitte Verfügbarkeit eingeben!");
		} else {
			this.newBook.setName(titleTextField.getText());
			this.newBook.setAuthor(authorTextField.getText());
			this.newBook.setISBN(isbnTextField.getText());
			this.newBook.setRelease_year(yearTextField.getText());

			this.newBook
					.setId_categorys(BookListController.bookDao.getCategoryId(categoryComboBox.getValue().toString()));

			bookList.bookDao.insertBook(this.newBook);

			int lastBook = bookList.bookDao.getLastBookId();

			for (int i = 0; i < (Integer.parseInt(availableTextField.getText())); i++) {
				bookList.bookDao.insertBookInstance(new Book(lastBook));
			}

			bookList.initialize();
		}
	}

	@FXML
	public void handleCancel() throws SQLException {

		root.handleGUI("back");
	}

	public static boolean isNumeric(String str) {

		NumberFormat formatter = NumberFormat.getInstance();
		ParsePosition pos = new ParsePosition(0);
		formatter.parse(str, pos);
		return str.length() == pos.getIndex();
	}

	public void handleLanguage() {

		categoryLabel.setText("Category");
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
		headerText.setText("Edit Book");
		titleLabel.setText("Title");
		textFieldTitleToolTip.setText("Type in books title");
		textFieldAuthorToolTip.setText("Type in books author");
		textFieldIsbnToolTip.setText("Type in books ISBN");
		textFieldReleaseToolTip.setText("Type in books year of release");
		textFieldCategorieToolTip.setText("Type in books category");
		buttonSafeToolTip.setText("Press to save");
		buttonCancelToolTip.setText("Press to cancel");

		categoryLabel.setText("Kategorie");
		yearTextField.setText("Erscheinungsjahr");
		isbnTextField.setText("ISBN");
		authorTextField.setText("Autor");
		titleTextField.setText("Titel");
		hintLabel.setText("Mit * markierte Felder sind Pflichtfelder.");
		cancelButton.setText("Abbrechen");
		saveButton.setText("Speichern");
		categoryLabel.setText("Kategorie");
		isbnLabel.setText("ISBN");
		releaseLabel.setText("Erscheinungsjahr");
		authorLabel.setText("Autor");
		headerText.setText("Buch bearbeiten");
		titleLabel.setText("Titel");
		textFieldTitleToolTip.setText("Titel des Buches eingeben");
		textFieldAuthorToolTip.setText("Autor des Buches eingeben");
		textFieldIsbnToolTip.setText("ISBN des Buches eingeben");
		textFieldReleaseToolTip.setText("Erscheinungsjahr des Buches eingeben");
		textFieldCategorieToolTip.setText("Kategorie des Buches eingeben");
		buttonSafeToolTip.setText("Drücken um Änderung zu speichern");
		buttonCancelToolTip.setText("Drücken um abzubrechen");
	}

}