/**
 * This class contains code for a GTile. An individual 
 * tile which contains all information that is happening 
 * on that tile, and may update if something changes.
 */
import java.util.ArrayList;

public class GTile {
	
	int id;
	ArrayList<Integer> aspects;
	
	public GTile(int id, ArrayList<Integer> aspects) {
		this.id = id;
		this.aspects = aspects;
	}
	
	//Get this tile's type
	public int getTileType() {
		return id;
	}
	
	//Change this tile's type
	public void setTileType(int id) {
		this.id = id;
	}
	
	//Get the list of this tile's aspects
	public ArrayList<Integer> getAspectsArrayList() {
		return aspects;
	}
	
	//Get the list of this tile's aspects, parsed into int array format
	public int[] getAspectsArray() {
		int[] out = new int[aspects.size()];
		for (int i = 0; i < out.length; i++)
			out[i] = aspects.get(i);
		return out;
	}
	
	//Add an aspect unless this tile already has that aspect
	public void addAspect(int aspect) {
		if (hasAspect(aspect) == false) {
			aspects.add(aspect);
		}
	}
	
	//Remove an aspect if we have it
	public void removeAspect(int aspect) {
		for (int i = 0; i < aspects.size(); i++) {
			if (aspects.get(i) == aspect) {
				aspects.remove(i);
			}
		}
	}
	
	//Return true if this tile currently has the specified aspect
	public boolean hasAspect(int aspect) {
		for (int i = 0; i < aspects.size(); i++) {
			if (aspects.get(i) == aspect)
				return true;
		}
		return false;
	}
}
