package game;
import java.util.ArrayList;

import processing.core.PApplet;

public class Game {
	private int gameNum;
	private ArrayList<Stage> stages;
	private Stage curStage;
	private Statistics playerStats;
	
	/**Constructs a new Game window
	 * @param gameNum denoting the game for player 1 or 2 
	 * @param width the width of the processing window
	 * @param height the height of the processing window
	 */
	public Game(int gameNum, int width, int height) {
		this.gameNum = gameNum;
		int x = 0;
		if (gameNum == 2) x = width/2;
		for (int i = 0; i < 4; i++) {
			stages.add(new Stage(i, x, 0, width/2, height/2));
		}
	}
	
	//switches stage
	private boolean switchStage(int i) {
		if (i < stages.size() && i > 0) {
			curStage = stages.get(i-1);
			return true;
		}
		return false;
	}
	
	/** Draws the current Game on the PApplet
	 * @param surface PApplet to draw things on
	 */
	public void draw(PApplet surface) {
		playerStats = curStage.getStats();
		curStage.draw(surface);
		playerStats.draw(surface);
	}
	
	/**Forwards player inputs into Player class stored in current stage
	 * 
	 * @param surface DrawingSurface class that has keypresses
	 */
	public void giveInputs(DrawingSurface surface) {
		curStage.giveInputs(surface, gameNum);
	}
}
