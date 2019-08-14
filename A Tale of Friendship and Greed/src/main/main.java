/**
 * The main class for A Tale of Friendship and Greed, a top-down rpg about
 * a hero who will save the world from destruction or something like that.
 * 
 * @author Greggory Hickman
 * @version dev 1.0, May-July 2019
 */
package main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class main implements MouseListener, ActionListener, Runnable {
	
	final int EMPTY = 0;
	int masterWidth = 20;
	int masterHeight = 20;
	GMap grid = new GMap(masterWidth, masterHeight); //Width,height
	JFrame window = new JFrame();
	Container center = new Container();
	GamePanel panel = new GamePanel(grid);
	//DialoguePanel firstDialogue = new DialoguePanel("main_menu.txt");
	
	public main() {
		
		window.setTitle("A Tale of Friendship and Greed");
		window.setSize(900,900);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		window.setLayout(new BorderLayout());
		center.setLayout(new GridLayout(1,1));
		
		panel.addKeyListener(new KeyListener());
		panel.setFocusable(true);
		
		window.add(center, BorderLayout.CENTER);
		center.addMouseListener(this);
		center.add(panel);
		
		window.setVisible(true);
		
		try {
			panel.loadMap("testMap");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		new main();
	}
	
	void triggerDialogue(DialoguePanel d) {
		center.add(d);
	}
	
	void terminateWindow(Object d) {
		d = null;
		System.gc();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		//When the user clicks on a tile, say in console which tile was clicked.
		System.out.println("Clicked tile: " +
				Math.min(masterWidth - 1, (int)(e.getX() / panel.getTileWidth())) +
				", " +
				Math.min(masterHeight - 1, (int)(e.getY() / panel.getTileHeight())));
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void run() {
		
	}

}

class KeyListener extends KeyAdapter {
	 
    public void keyTyped(KeyEvent e) {}
    
    public void keyPressed(KeyEvent e) {}
    
    public void keyReleased(KeyEvent e) {
    	if (e.getKeyChar() == 'w') {
    		//Move players up
    	}
    		
    }
    
}
