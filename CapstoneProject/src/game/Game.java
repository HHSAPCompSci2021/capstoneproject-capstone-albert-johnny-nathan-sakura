package game;
import java.util.ArrayList;

import entities.mobs.Player;
import processing.core.PApplet;

/**A game class that contains all menus, stages, and other elements in it's half
 * of the processing screen
 * @author ayu663
 */
public class Game {
	private int gameNum;
	private ArrayList<Stage> stages;
	private Stage curStage;
	private Statistics playerStats;
	private Player p;
	
	/**Constructs a new Game window
	 * @param gameNum denoting the game for player 1 or 2 
	 * @param width the width of the processing window
	 * @param height the height of the processing window
	 */
	public Game(int gameNum, int width, int height) {
		Player p = new Player(0, 0, 0, 0, false, null);
		this.gameNum = gameNum;
		int x = 0;
		stages = new ArrayList<Stage>();
		if (gameNum == 2) {
			x = width/2;
			System.out.println("game2x is " + x);
		} else {
			System.out.println("game1x is " + x);
		}
		for (int i = 0; i < 4; i++) {
			stages.add(new Stage(i, x, 0, width/2, height-200,p)); //100 on the bottom saved for statistics
		}
		curStage = stages.get(0);
	}
	
	//switches stage
	private boolean switchStage(int i) {
		if (i < stages.size() && i > 0) {
			curStage = stages.get(i-1);
			return true;
		}
		return false;
	}
	private boolean nextStage() {
		return switchStage(stages.indexOf(curStage)+1);
	}
	
	/**Sets up the stages
	 * @param surface PApplet to setup things with
	 */
	public void setup(PApplet surface) {
		for (Stage s : stages) s.setup(surface);
	}
	/** Draws the current Game on the PApplet
	 * @param surface PApplet to draw things on
	 */
	public void draw(PApplet surface) {
		if (curStage.isDone()) {
			nextStage();
		}
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
