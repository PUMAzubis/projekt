package de.dpma.pumaz.bvs.view;

import java.sql.SQLException;
import java.util.Optional;

import de.dpma.pumaz.bvs.FXML_GUI;
import de.dpma.pumaz.bvs.MainApp;
import de.dpma.pumaz.bvs.dao.BookDAO;
import de.dpma.pumaz.bvs.model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BookListController {

	@FXML
	private Tooltip textFieldSearchToolTip;

	@FXML
	private Tooltip buttonLendToolTip;

	@FXML
	private Tooltip buttonEditToolTip;

	@FXML
	private Tooltip buttonNewBookToolTip;

	@FXML
	private Tooltip buttonDeleteToolTip;

	@FXML
	private Text headerText;

	@FXML
	private TableView<Book> bookTable;

	@FXML
	private TableColumn<Book, String> nameColumn;

	@FXML
	private TableColumn<Book, String> authorColumn;

	@FXML
	private TableColumn<Book, String> releaseYearColumn;

	@FXML
	private TableColumn<Book, String> isbnColumn;

	@FXML
	private TableColumn<Book, String> categoryColumn;

	@FXML
	private TableColumn<Book, String> availableColumn;

	@FXML
	private Button lendBookButton;

	@FXML
	private TextField searchTextField;

	@FXML
	private Button editBookButtom;

	@FXML
	private Button newBookButton;

	@FXML
	private Button deleteBookButton;

	@FXML
	private Label nameColumnLabel;

	@FXML
	private Label authorColumnLabel;

	@FXML
	private Label releaseColumnLabel;

	@FXML
	private Label isbnColumnLabel;

	@FXML
	private Label availableColumnLabel;

	@FXML
	private Label categoryColumnLabel;

	@FXML
	private Label searchLabel;

	public BookListController() {

		// textFieldSearchToolTip.setText("Type in title, year of release,
		// author or ISBN to search for a book");
		// buttonLendToolTip.setText("Click to lend book");
		// buttonEditToolTip.setText("Click to edit");
		// buttonNewBookToolTip.setText("Click to create new book");
		// buttonDeleteToolTip.setText("Click to delete selected book");
		// headerLabel.setText("Menu");
		// nameColumn.setText("Name");
		// authorColumn.setText("Author");
		// releaseYearColumn.setText("Year of release");
		// isbnColumn.setText("ISBN");
		// categoryColumn.setText("Category");
		// searchTextField.setText("Search");
		// lendBookButton.setText("Lend");
		// editBookButtom.setText("Edit");
		// newBookButton.setText("New");
		// deleteBookButton.setText("Delete");
		// nameColumnLabel.setText("Name");
		// authorColumnLabel.setText("Author");
		// releaseColumnLabel.setText("Year of release");
		// isbnColumnLabel.setText("ISBN");
		// categoryColumnLabel.setText("Category");
		// searchLabel.setText("Search");
		//
		// textFieldSearchToolTip.setText("Hier den Titel, ISBN, Jahr, oder
		// Autor des Buches eingeben");
		// buttonLendToolTip.setText("Hier klicken um das ausgew�hlte Buch zu
		// verleihen.");
		// buttonEditToolTip.setText("Hier Klicken um das ausgew�hlte Buch zu
		// bearbeiten.");
		// buttonNewBookToolTip.setText("Hier klicken um ein neues Buch
		// anzulegen.");
		// buttonDeleteToolTip.setText("Hier klicken um das ausgew�hlte Buch zu
		// l�schen.");
		// headerLabel.setText("Men�");
		// nameColumn.setText("Name");
		// authorColumn.setText("Autor");
		// releaseYearColumn.setText("Erscheinungsjahr");
		// isbnColumn.setText("ISBN");
		// categoryColumn.setText("Kategorie");
		// searchTextField.setText("Suche");
		// lendBookButton.setText("Verleihen");
		// editBookButtom.setText("Bearbeiten");
		// newBookButton.setText("Neu");
		// deleteBookButton.setText("L�schen");
		// nameColumnLabel.setText("Name");
		// authorColumnLabel.setText("Autor");
		// releaseColumnLabel.setText("Erscheinungsjahr");
		// isbnColumnLabel.setText("ISBN");
		// categoryColumnLabel.setText("Kategorie");
		// searchLabel.setText("Suche");
	}

	Stage stage = new Stage();

	BorderPane borderPane = new BorderPane();

	FXML_GUI fxml_gui;

	RootLayoutController root = new RootLayoutController();

	private ObservableList<Book> bookData = FXCollections.observableArrayList();

	static BookDAO bookDao = new BookDAO(MainApp.dbcon.getConnection());

	@FXML
	public void initialize() throws SQLException {

		bookData = FXCollections.observableArrayList((bookDao.allBooks()));
		bookTable.setItems(bookData);

		nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		authorColumn.setCellValueFactory(cellData -> cellData.getValue().authorProperty());
		releaseYearColumn.setCellValueFactory(cellData -> cellData.getValue().release_yearProperty());
		isbnColumn.setCellValueFactory(cellData -> cellData.getValue().ISBNProperty());
		categoryColumn.setCellValueFactory(cellData -> cellData.getValue().categoryName());
		availableColumn.setCellValueFactory(cellData -> cellData.getValue().overviewCountProperty());
	}

	@FXML
	private void searchBooks() throws SQLException {

		if (searchTextField.getText().equals("")) {
			initialize();
		} else {
			bookData = FXCollections.observableArrayList((bookDao.searchBooks(searchTextField.getText())));
			bookTable.setItems(bookData);

			nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
			authorColumn.setCellValueFactory(cellData -> cellData.getValue().authorProperty());
			releaseYearColumn.setCellValueFactory(cellData -> cellData.getValue().release_yearProperty());
			isbnColumn.setCellValueFactory(cellData -> cellData.getValue().ISBNProperty());
			categoryColumn.setCellValueFactory(cellData -> cellData.getValue().categoryName());
			availableColumn.setCellValueFactory(cellData -> cellData.getValue().overviewCountProperty());
		}
	}

	@FXML
	public void handleNewBook() {
		root.handleGUI("newBook");
	}

	@FXML
	public void handleEditBook() {
		int selectedIndex = bookTable.getSelectionModel().getSelectedIndex();

		if (selectedIndex >= 0) {
			Book book = bookTable.getSelectionModel().getSelectedItem();
			root.handleGUI("editBook", book);
			EditBookController edit = new EditBookController();
			edit.inputContent(book);
		} else {
			nothingSelected();
		}
	}

	@FXML
	public void handleLendBook() {
		root.handleGUI("lendBook");
	}

	@FXML
	public void handleDeleteBook() {
		int selectedIndex = bookTable.getSelectionModel().getSelectedIndex();

		if (selectedIndex >= 0) {
			Alert alert = new Alert(AlertType.CONFIRMATION);

			DialogPane dialogPane = alert.getDialogPane();
			dialogPane.getStylesheets().add(getClass().getResource("dialog.css").toExternalForm());
			dialogPane.getStyleClass().add("myDialog");

			alert.setTitle("Warnung");
			alert.setHeaderText("M�chten Sie das Buch wirklich l�schen?");
			alert.setContentText(null);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				Book book = bookTable.getSelectionModel().getSelectedItem();
				try {
					bookDao.deleteBook(book);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				bookTable.getItems().remove(selectedIndex);
			}
		} else {
			nothingSelected();
		}

	}

	private void nothingSelected() {
		Alert alert = new Alert(AlertType.WARNING);

		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("dialog.css").toExternalForm());
		dialogPane.getStyleClass().add("myDialog");

		alert.setTitle("Warnung");
		alert.setHeaderText("Es ist kein Buch ausgew�hlt worden.");
		alert.setContentText(null);

		alert.showAndWait();
	}
}
