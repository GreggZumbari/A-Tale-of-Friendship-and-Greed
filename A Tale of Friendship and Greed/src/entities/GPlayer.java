/**
 * Game Object Player. The character that the user may control in-game.
 * Moves with W, S, A, D, or controller support.
 */
package entities;

public class GPlayer extends GEntity {
	
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

}
