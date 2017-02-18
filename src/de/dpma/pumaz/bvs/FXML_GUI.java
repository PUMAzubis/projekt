package de.dpma.pumaz.bvs;

import java.io.IOException;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FXML_GUI {
	
	Logger log = Logger.getLogger(FXML_GUI.class.getName());
	
	public Stage primaryStage;
	
	public BorderPane rootLayout;
	
	MainApp mainApp;
	
	public FXML_GUI() {
		
	}
	
	public FXML_GUI(Stage primaryStage, BorderPane rootLayout, String check) {
		this.primaryStage = primaryStage;
		this.rootLayout = rootLayout;
		initRootLayout();
		if (check.equals("about")) {
			showAbout();
		}
		else if (check.equals("register")) {
			showRegistration();
		}
		else {
			log.warning(check + "wurde nicht gefunden");
		}
		
	}
	
	public void initRootLayout() {
		
		try {
			log.info("RootLayout wird initalisiert");
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(FXML_GUI.class.getResource("view/RootLayout.fxml"));
			primaryStage.getIcons().add(new Image("file:resources/book.png"));
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			log.info("RootLayout sollte dargestellt sein");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showLogin() {
		
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(FXML_GUI.class.getResource("view/Login.fxml"));
			
			AnchorPane login;
			login = (AnchorPane) loader.load();
			rootLayout.setCenter(login);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void showRegistration() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(FXML_GUI.class.getResource("view/Registration.fxml"));
			primaryStage.getIcons().add(new Image("file:resources/book.png"));
			AnchorPane register;
			register = (AnchorPane) loader.load();
			rootLayout.setCenter(register);
			primaryStage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showAbout() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(FXML_GUI.class.getResource("view/About.fxml"));
			AnchorPane about;
			about = (AnchorPane) loader.load();
			Stage stage = new Stage();
			Scene scene = new Scene(about);
			stage.setScene(scene);
			stage.showAndWait();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showBookList() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(FXML_GUI.class.getResource("view/BookList.fxml"));
			AnchorPane about;
			about = (AnchorPane) loader.load();
			Stage stage = new Stage();
			Scene scene = new Scene(about);
			stage.setScene(scene);
			stage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// public void showEditBook() {
	//
	// try {
	// FXMLLoader loader = new FXMLLoader();
	// loader.setLocation(FXML_GUI.class.getResource("view/EditBook.fxml"));
	// }
	// catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// public void showEditEmployees() {
	//
	// try {
	// FXMLLoader loader = new FXMLLoader();
	// loader.setLocation(FXML_GUI.class.getResource("view/EditEmployees"));
	// }
	// catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// public void showEmployeeList() {
	//
	// try {
	// FXMLLoader loader = new FXMLLoader();
	// loader.setLocation(FXML_GUI.class.getResource("view/EmployeeList"));
	// }
	// catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// public void showLendBook() {
	//
	// try {
	// FXMLLoader loader = new FXMLLoader();
	// loader.setLocation(FXML_GUI.class.getResource("view/LendBook"));
	// }
	// catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// public void showPasswordChange() {
	//
	// try {
	// FXMLLoader loader = new FXMLLoader();
	// loader.setLocation(FXML_GUI.class.getResource("view/PasswordChange"));
	// }
	// catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
}
