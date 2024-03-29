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

public class main extends KeyAdapter implements MouseListener, ActionListener, Runnable {
	
	public final int EMPTY = 0;
	int masterWidth = 20;
	int masterHeight = 20;
	GMap grid = new GMap(masterWidth, masterHeight); //Width,height
	JFrame window = new JFrame();
	Container center = new Container();
	GamePanel panel = new GamePanel(grid);
	KeyListener listener = new KeyListener();
	Thread thread = new Thread(this);
	//DialoguePanel firstDialogue = new DialoguePanel("main_menu.txt");
	
	//Unimportant variables
	int frameCount = 0;
	
	public main() {
		
		window.setTitle("A Tale of Friendship and Greed");
		window.setSize(900,900);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setLayout(new BorderLayout());
		center.setLayout(new GridLayout(1,1));
		
		panel.addKeyListener(listener);
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
		
		thread.start();

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
	public void actionPerformed(ActionEvent e) {}

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
				Math.min(masterWidth - 1, (int)e.getX() / panel.getTileWidth()) +
				", " +
				Math.min(masterHeight - 1, (int)e.getY() / panel.getTileHeight()));
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	/**
	 * What to do on each frame, very important!
	 */
	@Override
	public void run() {
		while (true) {
			System.out.println("Frame " + frameCount);
			frameCount++;
			
			if (listener.w)
				panel.movePlayers(0);
			if (listener.s)
				panel.movePlayers(1);
			if (listener.a)
				panel.movePlayers(2);
			if (listener.d)
				panel.movePlayers(3);
			
			//Start next frame
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class KeyListener extends KeyAdapter {
	
	boolean w = false;
	boolean s = false;
	boolean a = false;
	boolean d = false;
	
    public void keyTyped(KeyEvent e) {}
    
    public void keyPressed(KeyEvent e) {
    	if (e.getKeyChar() == 'w')
    		w = true;
    	if (e.getKeyChar() == 's')
    		s = true;
    	if (e.getKeyChar() == 'a')
    		a = true;
    	if (e.getKeyChar() == 'd')
    		d = true;
    }
    
    public void keyReleased(KeyEvent e) {
    	if (e.getKeyChar() == 'w')
    		w = false;
    	if (e.getKeyChar() == 's')
    		s = false;
    	if (e.getKeyChar() == 'a')
    		a = false;
    	if (e.getKeyChar() == 'd')
    		d = false;
    }
    
}
