package henry.farr;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI {

	private Frame mainFrame;
	private Panel controlPanel;
	TextArea commentTextArea; 
	
	public GUI() {
		prepareGUI();
		showTextAreaDemo();
	}
	
	private void prepareGUI(){
	      mainFrame = new Frame("Plurality Ascertainer v1.0");
	      mainFrame.setSize(600,600);
	      mainFrame.setResizable(false);
	      mainFrame.setLayout(new GridLayout(1, 1));
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
//	      headerLabel = new Label();
//	      headerLabel.setAlignment(Label.CENTER);
//	      statusLabel = new Label();        
//	      statusLabel.setAlignment(Label.CENTER);
//	      statusLabel.setSize(350,100);

	      controlPanel = new Panel();
	      controlPanel.setLayout(new FlowLayout());

	      mainFrame.add(controlPanel);
	      mainFrame.setVisible(true);  
	   }

	private void showTextAreaDemo(){

	      commentTextArea = new TextArea(30,70);
	      commentTextArea.setEditable(false);
	      
	      controlPanel.add(commentTextArea);
	      mainFrame.setVisible(true);  
	   }
	
	public void addLineOfText(String text) {
		text = "\n".concat(text);
		commentTextArea.append(text);
	}
	public void appendText(String text) {
		commentTextArea.append(text);
	}
	
}
