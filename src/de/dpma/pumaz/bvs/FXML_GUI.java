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
	
	public void initRootLayout() {
		
		try {
			log.info("RootLayout wird initalisiert");
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(FXML_GUI.class.getResource("view/RootLayout.fxml"));
			log.info("RootLayout wird");
			primaryStage.getIcons().add(new Image("file:resources/book.png"));
			log.info("Icon hinzugefügt");
			rootLayout = (BorderPane) loader.load();
			log.info("Icon hinzugefügt");
			Scene scene = new Scene(rootLayout);
			// rootLayout.sizeToScene();
			// primaryStage.setHeight();
			primaryStage.setScene(scene);
			primaryStage.show();
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
	
	public void showAbout() {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FXML_GUI.class.getResource("view/About.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(rootLayout);
		stage.setScene(scene);
		stage.show();
	}
}