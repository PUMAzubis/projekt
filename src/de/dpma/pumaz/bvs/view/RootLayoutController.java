package de.dpma.pumaz.bvs.view;

import java.sql.SQLException;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.FXML_GUI;
import de.dpma.pumaz.bvs.MainApp;
import de.dpma.pumaz.bvs.util.OpenFile;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RootLayoutController {
	
	FXML_GUI fxml_gui;
	
	Stage stage = new Stage();
	
	BorderPane borderPane = new BorderPane();
	
	Logger log = Logger.getLogger(this.getClass().getName());
	
	public void handleGUI(String check) {
		
		fxml_gui = new FXML_GUI(stage, borderPane);
		
		if (check.equals("login")) {
			fxml_gui.showLogin();
		}
		else if (check.equals("about")) {
			fxml_gui.showAbout();
		}
		else if (check.equals("register")) {
			// rootLayout.setCenter(null);
			fxml_gui.showRegistration();
		}
		else if (check.equals("bookList")) {
			fxml_gui.showBookList();
		}
		else if (check.equals("newBook")) {
			fxml_gui.showNewBook();
		}
		else if (check.equals("editBook")) {
			fxml_gui.showEditBook();
		}
		else if (check.equals("back")) {
			fxml_gui.primaryStage.close();
		}
		else {
			log.warning(check + "wurde nicht gefunden");
		}
	}
	
	@FXML
	public void initialize() {
		
	}
	
	@FXML
	public void handleExit() {
		
		try {
			MainApp.dbcon.closeConnection();
			System.exit(0);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	public void handleAbout() {
		
		handleGUI("about");
		// Stage stage = new Stage();
		// BorderPane borderPane = new BorderPane();
		// fxml_gui = new FXML_GUI(stage, borderPane);
	}
	
	@FXML
	public void handleHelp() {
		
		OpenFile open = new OpenFile("Hilfeseite/index.html");
		
	}
	
	public void handleDialog(String title, String content, String type) {
		
		if (type.equalsIgnoreCase("warning")) {
			Alert alert = new Alert(AlertType.WARNING);
			fxml_gui = new FXML_GUI(stage, borderPane, "Dummy String");
			
			DialogPane dialogPane = alert.getDialogPane();
			dialogPane.getStylesheets().add(getClass().getResource("dialog.css").toExternalForm());
			dialogPane.getStyleClass().add("myDialog");
			
			alert.setTitle("Warnung");
			alert.setHeaderText(title);
			alert.setContentText(content);
			alert.initOwner(stage);
			alert.showAndWait();
		}
		else if (type.equalsIgnoreCase("info")) {
			Alert alert = new Alert(AlertType.INFORMATION);
			fxml_gui = new FXML_GUI(stage, borderPane, "Dummy String");
			alert.setTitle("Information");
			alert.setHeaderText(title);
			alert.setContentText(null);
			alert.initOwner(stage);
			alert.showAndWait();
		}
	}
	
}
