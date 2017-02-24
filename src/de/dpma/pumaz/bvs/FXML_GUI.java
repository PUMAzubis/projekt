package de.dpma.pumaz.bvs;

import java.io.IOException;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.model.Book;
import de.dpma.pumaz.bvs.view.EditBookController;
import de.dpma.pumaz.bvs.view.RootLayoutController;
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
	
	RootLayoutController root;
	
	EditBookController editBookController;
	
	// SetSizeOfRootLayout ssorl;
	
	public FXML_GUI() {
		
	}
	
	public FXML_GUI(Stage primaryStage, BorderPane rootLayout) {
		
		this.primaryStage = primaryStage;
		this.rootLayout = rootLayout;
		
		initRootLayout(false);
	}
	
	public FXML_GUI(Stage primaryStage, BorderPane rootLayout, String check) {
		
		this.primaryStage = primaryStage;
		this.rootLayout = rootLayout;
		
		initRootLayout(true);
	}
	
	public void initRootLayout(boolean bool) {
		
		try {
			log.info("RootLayout wird initalisiert");
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(FXML_GUI.class.getResource("view/RootLayout.fxml"));
			primaryStage.getIcons().add(new Image("file:resources/book.png"));
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			if (!bool) {
				primaryStage.show();
			}
			
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
			setSizeOfRootLayout(login.getPrefHeight(), login.getPrefWidth());
			rootLayout.setCenter(login);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void showRegistration() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(FXML_GUI.class.getResource("view/Registration.fxml"));
			
			AnchorPane register;
			register = (AnchorPane) loader.load();
			setSizeOfRootLayout(register.getPrefHeight(), register.getPrefWidth());
			rootLayout.setCenter(register);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showAbout() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/About.fxml"));
			AnchorPane about;
			about = (AnchorPane) loader.load();
			// Stage stage = new Stage();
			Scene scene = new Scene(about);
			primaryStage.setScene(scene);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showBookList() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(FXML_GUI.class.getResource("view/BookList.fxml"));
			AnchorPane bookList;
			bookList = (AnchorPane) loader.load();
			setSizeOfRootLayout(bookList.getPrefHeight(), bookList.getPrefWidth());
			rootLayout.setCenter(bookList);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showEditBook(Book book) {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(FXML_GUI.class.getResource("view/EditBook.fxml"));
			AnchorPane editBook;
			editBook = (AnchorPane) loader.load();
			editBookController = loader.getController();
			editBookController.inputContent(book);
			setSizeOfRootLayout(editBook.getPrefHeight(), editBook.getPrefWidth());
			rootLayout.setCenter(editBook);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showNewBook() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(FXML_GUI.class.getResource("view/NewBook.fxml"));
			AnchorPane newBook;
			newBook = (AnchorPane) loader.load();
			setSizeOfRootLayout(newBook.getPrefHeight(), newBook.getPrefWidth());
			rootLayout.setCenter(newBook);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
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
	public void showLendBook() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(FXML_GUI.class.getResource("view/LendBook.fxml"));
			AnchorPane lendBook;
			lendBook = (AnchorPane) loader.load();
			setSizeOfRootLayout(lendBook.getPrefHeight(), lendBook.getPrefWidth());
			rootLayout.setCenter(lendBook);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showPasswordChange() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(FXML_GUI.class.getResource("view/PasswordChange.fxml"));
			
			AnchorPane passwordChange;
			passwordChange = (AnchorPane) loader.load();
			setSizeOfRootLayout(passwordChange.getPrefWidth(), passwordChange.getPrefWidth());
			rootLayout.setCenter(passwordChange);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showPasswordForgott() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(FXML_GUI.class.getResource("view/PasswordForgott.fxml"));
			
			AnchorPane passwordForgott;
			passwordForgott = (AnchorPane) loader.load();
			setSizeOfRootLayout(passwordForgott.getPrefWidth(), passwordForgott.getPrefWidth());
			rootLayout.setCenter(passwordForgott);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setSizeOfRootLayout(double height, double width) {
		
		primaryStage.setMaxWidth(width + 20);
		primaryStage.setMinWidth(width + 20);
		primaryStage.setMaxHeight(height + 173 + 50);
		primaryStage.setMinHeight(height + 173 + 50);
	}
	
	public void stageClose() {
		
		primaryStage.close();
	}
}
