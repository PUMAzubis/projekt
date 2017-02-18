package de.dpma.pumaz.bvs.util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenFile {
	
	public OpenFile(String eing) {
		
		File Idea = new File("");
		String buildPath = Idea.getAbsolutePath();
		File Idea1 = new File(buildPath + "/resources/" + eing);
		// text file, should be opening in default text editor
		
		// first check if Desktop is supported by Platform or not
		if (!Desktop.isDesktopSupported()) {
			System.out.println("Desktop is not supported");
			return;
		}
		Desktop desktop = Desktop.getDesktop();
		if (Idea1.exists())
			try {
				desktop.open(Idea1);
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
