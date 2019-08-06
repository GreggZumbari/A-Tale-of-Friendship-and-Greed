/**
 * This class contains the code for a GMap, which contains a grid of GTiles.
 * It is meant to keep track of all happenings from GTile to GTile.
 */
import java.io.File;
import java.util.ArrayList;

public class GMap {
	
	int umbrella;
	int width, height;
	GTile[][] map;

	public GMap(int width, int height) {
		this.width = width;
		this.height = height;
		map = new GTile[this.width][this.height];
		
		//Start out with a bunch of blank GTiles
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = new GTile(0, new ArrayList<Integer>());
			}
		}
	}
	
	public int width() {
		return width;
	}
	
	public int height() {
		return height;
	}
	
	//Return the specified tile
	public GTile getTile(int x, int y) {
		return map[x][y];
	}
	
	/*
	//Return the tile type (stone, path, etc.)
	public int getTileType(int x, int y) {
		return map[x][y].getTileType();
	}
	
	//Change the tile type (stone, path, etc.)
	public void setTileType(int x, int y, int id) {
		map[x][y].setTileType(id);
	}
	
	//Add an aspect to the tile
	public void addTileAspect(int x, int y, int aspect) {
		map[x][y].addAspect(aspect);
	}
	
	//Remove an aspect from the tile, if it has it, otherwise do nothing
	public void removeTileAspect(int x, int y, int aspect) {
		map[x][y].removeAspect(aspect);
	}
	*/
}
