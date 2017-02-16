package de.dpma.pumaz.bvs.view;

import java.sql.SQLException;

import de.dpma.pumaz.bvs.FXML_GUI;
import de.dpma.pumaz.bvs.MainApp;

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
}
