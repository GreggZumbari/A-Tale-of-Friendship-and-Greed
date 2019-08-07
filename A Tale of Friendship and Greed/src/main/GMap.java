package main;
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
	
}
