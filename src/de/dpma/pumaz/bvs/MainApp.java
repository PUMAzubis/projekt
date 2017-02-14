package de.dpma.pumaz.bvs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.dao.DatabaseConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	private Stage primaryStage;
	
	private BorderPane rootLayout;
	
	Logger log = Logger.getLogger(MainApp.class.getName());
	
	@Override
	public void start(Stage primaryStage) throws Exception, ClassNotFoundException, SQLException {
		
		this.primaryStage = primaryStage;
		initRootLayout();
		showLogin();
	}
	
	private void showLogin() {
		
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/Login.fxml"));
			
			AnchorPane login;
			login = (AnchorPane) loader.load();
			rootLayout.setCenter(login);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void initRootLayout() throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
		
		// Parent parent = null;
		rootLayout = (BorderPane) loader.load();
		Scene scene = new Scene(rootLayout);
		// stage.initOwner(primaryStage);
		// stage.setScene();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		
		DatabaseConnection dbcon = null;
		try {
			dbcon = new DatabaseConnection();
			
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				dbcon.closeConnection();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		launch(args);
		
	}
}
