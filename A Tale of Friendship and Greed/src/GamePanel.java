import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	
	//Tile ids
	final int EMPTY = 0;
	final int GRASS = 1;
	final int DIRT = 2;
	final int PATH = 3;
	final int ROCK = 4;
	
	//GMap "grid" stores info for each square on the board
	int itemListSize = 4;
	//int[][] grid;
	GMap grid;
	Color BROWN = new Color(110,66,0);
	Color LIGHT_BROWN = new Color(175,150,125);
	
	//Unimportant variables, program will not break without these
	boolean aioobe = false;
	
	public GamePanel(GMap grid) {
		this.grid = grid;
	}
	
	/**
	 * Hardcode tile colors onto the starting board, for use in testing
	 */
	public void setMap() throws Exception {
		
	}
	
	/**
	 * Outputs the id of a specified tile
	 */
	public GTile getTile(int x, int y) {
		return grid.getTile(x, y);
	}
	
	/**
	 * Set the tile at the specified x,y coords to be the specified tile
	 */
	public void setTile(int x, int y, int id) {
		if (id <= itemListSize && id >= 0) {
			if (grid.getTile(x, y).getTileType() == id) {
				id = EMPTY;
			}
			grid.getTile(x, y).setTileType(id);
		}
		else {
			if ((id > 0 && id < itemListSize) || id < 0) {
				JOptionPane.showMessageDialog(this, "ID number must be a positive whole number");
			}
			else {
				JOptionPane.showMessageDialog(this, "That number does not correspond to an existing tile type. Highest number is " + itemListSize);
			}
		}
	}	
	
	/**
	 * Return the unrounded tile width
	 */
	public double getTileWidth() {
		return (double)this.getWidth() / grid.height();
	}
	
	/**
	 * Return the unrounded tile height
	 */
	public double getTileHeight() {
		return (double)this.getHeight() / grid.width();
	}
	
	/**
	 * Load a pre-loaded file onto the player's screen
	 * 
	 * @format Comma means to move onto the next tile,
	 * Period means to go to the next row,
	 * A number means to set the current tile to that number id
	 * Anything else does nothing, and shouldn't break the code
	 */
	public void loadFromFile(File f) throws Exception {
		System.out.println(f);
		BufferedReader b = new BufferedReader(new FileReader(f));
		String output = b.readLine();
		b.close();
		int x = 0;
		int y = 0;
		for (int i = 0; i < output.length(); i++) {
			try {
				if (Character.isDigit(output.charAt(i))) //Set the current tile to be that tile type
					grid.getTile(x, y).setTileType((int)output.charAt(i) - 48);
			} catch (ArrayIndexOutOfBoundsException ex) {
				if (aioobe == false) {
					System.out.println("The map file has bigger dimensions than the dimensions of the current GMap");
					aioobe = true;
				}
			}
			if (output.charAt(i) == ',') //Next block of the same row
				y++;
			if (output.charAt(i) == '.') { //Next row, back to the top
				x++;
				y = 0;
			}
		}
		repaint();
	}
			
	/**
	 * Outputs a string which is in the correct ".atofag" format
	 * to be outputted into a file
	 * Currently unused in current form of the game
	 */
	public String saveToFile() {
		String output = "";
		String sep;
		for (int i = 0; i < grid.width(); i++) {
			for (int j = 0; j < grid.height(); j++) {
				if (j + 1 == grid.height()) //End of the row?
					sep = ".";
				else 
					sep = ",";
				output = (output + (grid.getTile(i, j).getTileType()) + sep);
			}
		}
		return output;
	}
	
	/**
	 * Paint Component
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		double width = (double)this.getWidth() / grid.height();
		double height = (double)this.getHeight() / grid.width();
		
		//Paint each sqaure
		for (int x = 0; x < grid.width(); x++) {
			for (int y = 0; y < grid.height(); y++) {
				if (grid.getTile(x, y).getTileType() == EMPTY) 
					g.setColor(Color.WHITE);
				if (grid.getTile(x, y).getTileType() == GRASS) 
					g.setColor(Color.GREEN);
				if (grid.getTile(x, y).getTileType() == DIRT) 
					g.setColor(BROWN);
				if (grid.getTile(x, y).getTileType() == PATH)
					g.setColor(LIGHT_BROWN);
				if (grid.getTile(x, y).getTileType() == ROCK)
					g.setColor(Color.GRAY);
				g.fillRect((int)Math.round(x*width + 1),
						   (int)Math.round(y*height + 1), 
						   (int)Math.round(width), 
						   (int)Math.round(height));
			}
		}
		
		//Drawing the grid,
		//Vertical lines
		g.setColor(new Color(240, 240, 240));
		g.setColor(Color.GRAY);
		for (int x = 0; x < grid.height + 1; x++) {	
			g.drawLine((int)Math.round(x*width), 0, (int)Math.round(x*width), this.getHeight());	
		}
		g.drawLine(getWidth() - 1, 0, getWidth() - 1, getHeight());
				
		//Horizontal lines
		for (int y = 0; y < grid.width + 1; y++) {
			g.drawLine(0, (int)Math.round(y*height), this.getWidth(), (int)Math.round(y*height));	
		}
		g.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
		
	}

}

