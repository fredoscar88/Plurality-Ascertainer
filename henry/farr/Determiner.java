package henry.farr;

import java.io.File;
import java.util.Scanner;

public class Determiner {

	Scanner dScan;
	File dFile;
	GUI dGUI;
	
	String line;
	Set set;
	
	public Determiner(Scanner sc, File file, GUI gui) {
		dScan = sc;
		dFile = file;
		dGUI = gui;
		
		Determine();
	}
	
	private void Determine() {
		boolean gotoSet;
		
		while (dScan.hasNextLine()) {
			gotoSet = true;
			line = dScan.nextLine();
			line.replaceAll(System.lineSeparator(), "\n");
			if (line.equals("")) gotoSet = false;
			
			if (gotoSet) {
				switch (line.charAt(0)) {
				case '#': set = new Set(line.substring(1)); break;
				case '-': set.newSubset(line.substring(1));	break;
				case '&':
					dGUI.addLineOfText("----------------");
					dGUI.addLineOfText(set.finish());		break;
				default : set.addToList(line);				break;
				}
			}

			
		}
		dGUI.addLineOfText("----------------");
		System.out.println("fini");
	}
	
	
}
