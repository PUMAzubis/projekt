package de.dpma.pumaz.bvs.util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenFile {
	
	public static void main(String[] args) throws IOException {
		
		File Idea = new File("");
		String buildPath = Idea.getAbsolutePath();
		System.out.println(Idea.getAbsolutePath());
		File Idea1 = new File(buildPath + "/resources/Ideen.txt");
		System.out.println(Idea1.getAbsolutePath());
		// text file, should be opening in default text editor
		
		// first check if Desktop is supported by Platform or not
		if (!Desktop.isDesktopSupported()) {
			System.out.println("Desktop is not supported");
			return;
		}
		Desktop desktop = Desktop.getDesktop();
		if (Idea1.exists())
			desktop.open(Idea1);
	}
	
}
