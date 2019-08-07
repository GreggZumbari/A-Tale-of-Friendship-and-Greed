package main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DialoguePanel extends JPanel {

	String fileName;
	Scanner console = new Scanner(System.in);
	String[] fileContents = new String[2];
	ArrayList<String> dialogueList = new ArrayList<String>();
	ArrayList<ArrayList<String>> responseList = new ArrayList<ArrayList<String>>();
	int choice;

	public DialoguePanel(String fileName) {
		this.fileName = fileName;
		try {
			Scanner s = new Scanner(new File(fileName));
			fileContents[0] = s.nextLine(); //fileContents[0] is all of the dialogue from the program
			fileContents[1] = s.nextLine(); //fileContents[1] is all of the possible answers the user
		} catch (Error ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Font font = new Font("Comic Sans MS", Font.BOLD, 36);
		
		g.setColor(Color.BLACK);
		g.setFont(font);
		
		for (int i = 0; i < dialogueList.size(); i++) {
			nextSetDialogue(g, dialogueList.get(i), getWidth() / 10, getWidth() / 10);
		}
	}
	
	//Move on to the next set of dialogue
	public void nextSetDialogue(Graphics g, String text, int x, int y) {
		g.drawString(text, x, y);
		repaint(); //Why are they all appearing at the very end???? Fix???????
		choice = console.nextLine().charAt(0);
		//Add an input for different choices that the user can make
		//Add a varying amount of boxes that the user can click on for different dialogue choices
		//Add an output for the choice the user makes
	}
	
}
