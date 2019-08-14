/**
 * Game Object Player. The character that the user may control in-game.
 * Moves with W, S, A, D, or controller support.
 */
package entities;

public class GPlayer {
	
	int x;
	int y;
	
	/**
	 * Input with custom starting coordinates
	 */
	public GPlayer(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * If no input, input with starting coordinates of 0,0
	 */
	public GPlayer() {
		this.x = 0;
		this.y = 0;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	//Add ability to move with W, S, A, D and controller support

}
