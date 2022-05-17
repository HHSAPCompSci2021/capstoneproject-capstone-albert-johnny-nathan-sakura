package game;
import java.awt.Point;
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
	private int curStageInd;
	private Statistics playerStats;
	private Point dimensions, topLeft;
	private Player p;
	//somehow add black bars in the game - set the Game's dimensions to 
	//fit within these black bars
	//plan: 50 on the left of game1, 50 in middle, 50 on the right of
	//		game2, 50 on top, 100 at bottom for statistics (within game
	//		x bounds also)
	
	
	/**Constructs a new Game window
	 * @param gameNum denoting the game for player 1 or 2 
	 * @param width the width of the processing window
	 * @param height the height of the processing window
	 */
	public Game(int gameNum, int width, int height) {
		//System.out.println(gameNum + " width: " + width);
		dimensions = new Point(width/2,height);
		p = null;
		if (gameNum == 1) p = new Player(width/4-50, height/4*3-50, 150, 75, false, gameNum);
		if (gameNum == 2) p = new Player(width/4*3-50, height/4*3-50, 150, 75, false, gameNum);
		this.gameNum = gameNum;
		int x = 0;
		stages = new ArrayList<Stage>();
		if (gameNum == 2) {
			x = width/2;
			//System.out.println("game2x is " + x);
		} else {
			//System.out.println("game1x is " + x);
		}
		for (int i = 1; i < 4; i++) {
			stages.add(new Stage(i, x+50, 0+50, width/2-50-50, height-200-50,p)); //100 on the bottom saved for statistics
		}
		curStage = stages.get(0);
		topLeft = new Point(x, 0);
	}
	
	//switches stage
	private boolean switchStage(int i) {
		if (i <= stages.size() && i > 0) {
			//System.out.println(i);
			curStage = stages.get(i-1);
			curStageInd++;
			return true;
		}
		curStageInd++;
		return false;
	}
	private boolean nextStage() {
		return switchStage(stages.indexOf(curStage)+2);
	}
	
	/**
	 * Sets up the stages
	 * @param surface PApplet to setup things with
	 */
	public void setup(PApplet surface) {
		for (Stage s : stages) s.setup(surface);
	}
	/** 
	 * Draws the current Game on the PApplet
	 * @param surface PApplet to draw things on
	 */
	public void draw(PApplet surface) {
		if (curStage.isCompleted()) {
			System.out.println(nextStage());
			return;
		}
		playerStats = curStage.getStats();
		curStage.draw(surface);
		surface.noStroke();
		if (gameNum == 1) {
			surface.fill(130, 7, 0);
		}
		if (gameNum == 2) {
			surface.fill(0, 95, 143);
		}
		//System.out.println("Drawing game:" + gameNum);
		surface.rect(topLeft.x, topLeft.y, dimensions.x, 50);
		surface.rect(topLeft.x, topLeft.y+dimensions.y-200, dimensions.x, 200);

		surface.rect(topLeft.x, topLeft.y, 50, dimensions.y);
		surface.rect(topLeft.x+dimensions.x-50, topLeft.y, 50, dimensions.y);
		playerStats.draw(surface);
		
	}
	
	/**
	 * Returns if game is completed (the last Stage is completed)
	 * @return true if all stages are completed
	 */
	public boolean gameCompleted() {
		return curStageInd >= stages.size();
	}
	
	/**
	 * Returns if game is over (stage game over or player is dead)
	 * @return true if player is dead in stages
	 */
	public boolean gameOver() {
		return curStage.gameOver();
	}
	
	/**
	 * Forwards player inputs into Player class stored in current stage
	 * @param surface DrawingSurface class that has keypresses
	 */
	public void giveInputs(DrawingSurface surface) {
		curStage.giveInputs(surface, gameNum);
	}
}
