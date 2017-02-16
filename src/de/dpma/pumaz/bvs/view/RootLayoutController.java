package de.dpma.pumaz.bvs.view;

import java.io.IOException;
import java.sql.SQLException;

import de.dpma.pumaz.bvs.FXML_GUI;
import de.dpma.pumaz.bvs.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class RootLayoutController {
	
	private int height;
	
	private int width;
	
	FXML_GUI fxml_gui;
	
	public void getSizes(int height, int width) {
		
		this.height = height;
		this.width = width;
		
	}
	
	public void reziseHandling() {
		
		fxml_gui.rootLayout.setMinSize(width, height);
		fxml_gui.rootLayout.setPrefSize(width, height);
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
		
		// try {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FXML_GUI.class.getResource("view/About.fxml"));
		// AnchorPane about;
		// about = (AnchorPane) loader.load();
		// Stage stage = new Stage();
		// Scene scene = new Scene(about);
		// stage.setScene(scene);
		// stage.show();
		// }
		// catch (IOException e) {
		// e.printStackTrace();
		// }
		// fxml_gui.showAbout();
		// fxml_gui.showLogin();
	}
	
	@FXML
	public void handleAnleitung() {
		
	}
	
	@FXML
	public void handleRegistration() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(FXML_GUI.class.getResource("view/Registration.fxml"));
			AnchorPane register;
			register = (AnchorPane) loader.load();
			fxml_gui.rootLayout.setCenter(register);
			fxml_gui.primaryStage.show();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
