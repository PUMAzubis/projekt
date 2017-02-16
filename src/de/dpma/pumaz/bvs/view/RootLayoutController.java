package de.dpma.pumaz.bvs.view;

import de.dpma.pumaz.bvs.FXML_GUI;

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
}
