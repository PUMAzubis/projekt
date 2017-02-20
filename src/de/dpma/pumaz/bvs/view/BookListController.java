package de.dpma.pumaz.bvs.view;

import java.sql.SQLException;

import de.dpma.pumaz.bvs.FXML_GUI;
import de.dpma.pumaz.bvs.MainApp;
import de.dpma.pumaz.bvs.dao.BookDAO;
import de.dpma.pumaz.bvs.model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
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
	private TextField searchTextField;
	
	@FXML
	private Button lendBookButton;
	
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
	private Label categoryColumnLabel;
	
	@FXML
	private Label searchLabel;
	
	Stage stage = new Stage();
	
	BorderPane borderPane = new BorderPane();
	
	FXML_GUI fxml_gui;
	
	RootLayoutController root = new RootLayoutController();
	
	private ObservableList<Book> bookData = FXCollections.observableArrayList();
	
	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public BookListController() {
		
	}
	
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() throws SQLException {
		
		BookDAO bookDao = new BookDAO(MainApp.dbcon.getConnection());
		bookData.addAll(bookDao.allBooksTogether());
		bookTable.setItems(bookData);
		
		// Initialize the person table with the two columns.
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		authorColumn.setCellValueFactory(cellData -> cellData.getValue().authorProperty());
		releaseYearColumn.setCellValueFactory(cellData -> cellData.getValue().release_yearProperty());
		isbnColumn.setCellValueFactory(cellData -> cellData.getValue().ISBNProperty());
		categoryColumn.setCellValueFactory(cellData -> {
			try {
				return cellData.getValue().categoryName();
			}
			catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		});
	}
	
	@FXML
	public void handleNewBook() {
		
		root.handleGUI("newBook");
	}
	
	@FXML
	public void handleEditBook() {
		
		root.handleGUI("editBook");
	}
	
	@FXML
	public void handleLendBook() {
		
	}
	
	@FXML
	public void handleDeleteBook() {
		
	}
	
	// @FXML
	// private void handleDeletePerson() {
	// int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
	// if (selectedIndex >= 0) {
	// personTable.getItems().remove(selectedIndex);
	// } else {
	// // Nothing selected.
	// Alert alert = new Alert(AlertType.WARNING);
	// alert.initOwner(mainApp.getPrimaryStage());
	// alert.setTitle("No Selection");
	// alert.setHeaderText("No Person Selected");
	// alert.setContentText("Please select a person in the table.");
	//
	// alert.showAndWait();
	// }
	// }
	//
	// /**
	// * Called when the user clicks the new button. Opens a dialog to edit
	// * details for a new person.
	// */
	// @FXML
	// private void handleNewPerson() {
	// Person tempPerson = new Person();
	// boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
	// if (okClicked) {
	// mainApp.getPersonData().add(tempPerson);
	// }
	// }
	//
	// /**
	// * Called when the user clicks the edit button. Opens a dialog to edit
	// * details for the selected person.
	// */
	// @FXML
	// private void handleEditPerson() {
	// Person selectedPerson =
	// personTable.getSelectionModel().getSelectedItem();
	// if (selectedPerson != null) {
	// boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
	// if (okClicked) {
	// showPersonDetails(selectedPerson);
	// }
	//
	// } else {
	// // Nothing selected.
	// Alert alert = new Alert(AlertType.WARNING);
	// alert.initOwner(mainApp.getPrimaryStage());
	// alert.setTitle("No Selection");
	// alert.setHeaderText("No Person Selected");
	// alert.setContentText("Please select a person in the table.");
	//
	// alert.showAndWait();
	// }
	// }
	//
	// /**
	// * Is called by the main application to give a reference back to itself.
	// *
	// * @param mainApp
	// */
	// public void setMainApp(Main mainApp) {
	// this.mainApp = mainApp;
	//
	// // Add observable list data to the table
	// personTable.setItems(mainApp.getPersonData());
	// }
	//
	// /**
	// * Fills all text fields to show details about the person. If the
	// specified
	// * person is null, all text fields are cleared.
	// *
	// * @param person
	// * the person or null
	// */
	// private void showPersonDetails(Person person) {
	// if (person != null) {
	// // Fill the labels with info from the person object.
	// firstNameLabel.setText(person.getFirstName());
	// lastNameLabel.setText(person.getLastName());
	// streetLabel.setText(person.getStreet());
	// postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
	// cityLabel.setText(person.getCity());
	//
	// birthdayLabel.setText(DateUtil.format(person.getBirthday()));
	// } else {
	// // Person is null, remove all the text.
	// firstNameLabel.setText("");
	// lastNameLabel.setText("");
	// streetLabel.setText("");
	// postalCodeLabel.setText("");
	// cityLabel.setText("");
	// birthdayLabel.setText("");
	// }
	// }
}
