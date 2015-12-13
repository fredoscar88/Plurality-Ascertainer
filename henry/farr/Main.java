package henry.farr;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JTextArea;

public class Main {

	static File subjects;
	static Scanner sc;
	static JTextArea textArea;
	
	public static void main(String args[]) throws IOException {
		
		GUI outputWindow = new GUI();
		outputWindow.appendText("\u00A9Henry Farr 2015\nBuilt for Yearbook staff");

		subjects = new File("Entries.txt");
		subjects.createNewFile();

		sc = new Scanner(subjects);
		
		new Determiner(sc, subjects, outputWindow);
		
/*		while (sc.hasNextLine()) {
			outputWindow.addLineOfText(sc.nextLine());
		}*/
	
		System.out.println("Finished! again!");
		
	}
	
	
	
//	Runtime.getRuntime().exec("color 0a", null, null);
//	StringTokenizer st = new StringTokenizer(str);
//	System.out.println(st.nextToken());
//	System.out.println(st.nextToken());
//	System.out.println(st.nextToken());
	
}
