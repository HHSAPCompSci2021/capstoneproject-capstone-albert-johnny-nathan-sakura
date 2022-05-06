package game;
import java.awt.Point;
import java.util.ArrayList;

import entities.Entity;
import entities.mobs.Boss;
import entities.mobs.Goon;
import entities.mobs.Player;
import processing.core.PApplet;
import processing.core.PImage;

/**A Stage class that contains all stage entities and makes them act
 * @author ayu663
 */
public class Stage {
	private int stageNum;
	private ArrayList<Entity> entityList;
	private Player curPlayer;
	private Statistics playerStats;
	private Point topLeft, dimensions;
	private boolean gameOver, stageComplete;
	private Background back;
	private int curWave;
	
	/**Constructs a stage with stage number stageNum, top left corner x, y, 
	 * and dimensions width*height.
	 * @param stageNum the stage to construct (1-4)
	 */
	public Stage(int stageNum, int x, int y, int width, int height) {
		curWave = 1;
		gameOver = false;
		stageComplete = false;
		topLeft = new Point(x,y);
		dimensions = new Point(width, height);
		this.stageNum = stageNum;
		entityList = new ArrayList<Entity>();
		entityList.add(new Player(0, 0, 0, 0, false, null));
		for (int i = 0; i < 4; i++) {
		//	entityList.add(new Goon(stageNum)); we need different stageNum for
			//different enemy movement
			entityList.add(new Goon(0, 0, 0, 0, false, null));
		}
		
		//entityList.add(new Boss(stageNum));
		//this is accounted in different waives
		//entityList.add(new Boss(0, 0, 0, 0, false, null));
		
		for (Entity e : entityList) {
			e.giveBounds(topLeft, dimensions);
		}
		playerStats = new Statistics(curPlayer);
	}
	
	/**Sets up the stage with an image using processing
	 * @param surface PApplet to setup with
	 */
	public void setup(PApplet surface) {
		PImage cloud = surface.createImage(dimensions.x, dimensions.y, surface.RGB);
		cloud = surface.loadImage("sprites/cloud_tile.jpg");
		back = new Background(cloud, topLeft.x, topLeft.y, dimensions.x, dimensions.y);
	}
	
	/**Will visually draw and update the current state of the Stage elements, and the getStatistics
	 * 
	 * @param surface PApplet surface to draw on
	 */
	public void draw(PApplet surface) {
		back.draw(surface);
		back.scroll(10);
		act();
		updateStats();
		for (Entity e : entityList) {
			if (e.isVisble()) e.draw(surface);
		}
	}
	
	/**Returns a Statistics object used for drawing outside of this class
	 * 
	 * @return Statistics the statistics for this player
	 */
	public Statistics getStats() {
		return playerStats;
	}
	
	/**Forward inputs into the player for movement and skill activation
	 * 
	 * @param surface
	 * @param gameNum
	 */
	public void giveInputs(DrawingSurface surface, int gameNum) {
		
		if (gameNum == 1) {
			if (surface.isPressed(null)) {
				//bunch of ifs and moves/skill use methods in player
			}
		}
		if (gameNum == 2) {
			if (surface.isPressed(null)) {
				//bunch of ifs and moves/skill use methods in player
			}
		}
	}
	
	/** Returns true if the stage has been cleared
	 * 
	 * @return true if all enemies are dead
	 */
	public boolean isCompleted() {
		return stageComplete;
	}
	/** Returns if the game is over
	 * @return true if player is dead
	 */
	public boolean gameOver() {
		return gameOver;
	}
	
	private void act() {
		boolean playerExists = false;
		boolean entitiesExist = false;
		for (Entity e : entityList) {
			if (e.isDead()) {
				entityList.remove(e);
				continue;
			}
			if (e instanceof Player) {
				playerExists = true;
				curPlayer = (Player)e;
				curPlayer.setEntityList(entityList);
			} else {
				entitiesExist = true;
				e.act();
			}
		}
		if (!playerExists) gameOver = true;
		
		if (!entitiesExist) {
			curWave++;
			//you can add below another set of if conditions for each stage that
			//can change up wave number, enemy number, and other properties
			if (curWave == 3) {
				//entityList.add(new Boss());
			} else {
				//add some regular enemies for each wave
			}
		}
	}
	
	/**Returns the current player referenced in Stage
	 * 
	 * @return Player current Player character
	 */
	public Player getPlayer() {
		return curPlayer;
	}

	
	private void updateStats() {
		//will update Statistics with data about the Player curPlayer
	}
	
}
