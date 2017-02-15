package de.dpma.pumaz.bvs;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FXML_GUI {
	
	public Stage primaryStage;
	
	public BorderPane rootLayout;
	
	MainApp mainApp;
	
	public FXML_GUI() {
	}
	
	public void showLogin() {
		
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/Login.fxml"));
			
			AnchorPane login;
			login = (AnchorPane) loader.load();
			rootLayout.setCenter(login);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void initRootLayout() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			primaryStage.getIcons().add(new Image("file:resources/book.png"));
			
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
