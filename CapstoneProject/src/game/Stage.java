package game;
import java.awt.Point;
import java.util.ArrayList;

import entities.Entity;
import entities.mobs.Boss;
import entities.mobs.Enemy;
import entities.mobs.Goon;
import entities.mobs.Player;
import entities.projectiles.Bullet;
import entities.projectiles.PowerUp;
import entities.projectiles.Projectile;
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
	private Boss b;
	
	/**Constructs a stage with stage number stageNum, top left corner x, y, 
	 * and dimensions width*height.
	 * @param stageNum the stage to construct (1-4)
	 * @param x topLeft x of the stage
	 * @param y topLeft y of the stage
	 * @param width width of the stage
	 * @param height height of the stage
	 * @param p player passed into the stage and to interact there
	 */
	public Stage(int stageNum, int x, int y, int width, int height, Player p) {
		//System.out.println(stageNum + " width: " + width);
		curWave = 1;
		gameOver = false;
		stageComplete = false;
		topLeft = new Point(x,y);
		dimensions = new Point(width, height);
		this.stageNum = stageNum;
		entityList = new ArrayList<Entity>();
		//entityList.add(new Player(0, 0, 0, 0, false, null));
		entityList.add(p);
		curPlayer = p;
		b = null;
		
		//Johnny requested below
		p.setEntityList(entityList);
		entityList.add(new Goon(topLeft.x+50, topLeft.y+50, 100, 100, false, stageNum, 1));
		entityList.add(new Goon(topLeft.x+350, topLeft.y+50, 100, 100, false, stageNum, 1));
		entityList.add(new Goon(topLeft.x+200, topLeft.y+200, 100, 100, false, stageNum, 2));
		for (int i = 0; i < 4; i++) {
		//	entityList.add(new Goon(stageNum)); we need different stageNum for
			//different enemy movement
			//entityList.add(new Goon(0, 0, 0, 0, false, null));
		}
		
		//entityList.add(new Boss(stageNum));
		//this is accounted in different waives
		//entityList.add(new Boss(0, 0, 0, 0, false, null));
		
		for (Entity e : entityList) {
			e.giveBounds(topLeft, dimensions);
		}
		playerStats = new Statistics(curPlayer, x, y+height, width, 200);
	}
	
	/**
	 * Sets up the stage with an image using processing
	 * @param surface PApplet to setup with
	 */
	public void setup(PApplet surface) {
		for (Entity e : entityList) {
			e.setup(surface);
			e.giveBounds(topLeft, dimensions);
		}
		//System.out.println("setup run");
		PImage cloud = surface.createImage(dimensions.x, dimensions.y, surface.RGB);
		cloud = surface.loadImage("sprites/cloud_tile.jpg");
		//System.out.println(topLeft.x);
		back = new Background(cloud, topLeft.x, topLeft.y, dimensions.x, cloud.height, stageNum);
	}
	
	/**
	 * Will visually draw and update the current frame of the Stage elements, and the getStatistics
	 * @param surface PApplet surface to draw on
	 */
	public void draw(PApplet surface) {
		//surface.clear();
		
		back.draw(surface);
		back.scroll(5);
		act(surface);
		///updateStats();
		//System.out.println("saygiydfiyfiyg: "+ entityList.size());
		for (Entity e : entityList) {
			//if (e.isVisble()) {
			if (e instanceof Goon) System.out.println("goon drawn");
			//e.setup(surface);
			e.draw(surface);
			//}
		}
		if (b!=null) {
			surface.fill(225);
			surface.text("BOSS HP: " + b.getHp(), topLeft.x, topLeft.y, dimensions.x, dimensions.y);
		} else {
			surface.fill(225);
			surface.text("Current Wave: " + curWave + "/3", topLeft.x, topLeft.y, dimensions.x, dimensions.y);
		}
	}
	
	/**
	 * Returns a Statistics object used for drawing outside of this class
	 * @return Statistics the statistics for this player
	 */
	public Statistics getStats() {
		return playerStats;
	}
	
	/**
	 * Forward inputs into the player for movement and skill activation
	 * @param surface Surface
	 * @param gameNum Game number
	 */
	public void giveInputs(DrawingSurface surface, int gameNum) {
		if (surface.isPressed(66) || surface.isPressed(98)) {
			//hard code stage skip
			curWave +=1;
		}
		
		
		
		if (gameNum == 1) {
			if (surface.isPressed(65) || surface.isPressed(97)) {
				System.out.println("a");
				curPlayer.move(-5, 0);
			}

			if (surface.isPressed(68) || surface.isPressed(100)) {
				System.out.println("d");
				curPlayer.move(5, 0);
			}

			if (surface.isPressed(87) || surface.isPressed(119)) {
				System.out.println("w");
				curPlayer.move(0, -5);
			}

			if (surface.isPressed(83) || surface.isPressed(115)) {

				System.out.println("s");
				curPlayer.move(0, 5);
			}
			if (surface.isPressed(102) || surface.isPressed(70)) {

				System.out.println("f");
				curPlayer.shoot(surface);
			}
			
			
			//curPlayer.shift(surface.isPressed(61) && !surface.isPressed(64) , surface.isPressed(77) && !surface.isPressed(73));
//			if (surface.isPressed(77)) {
//				curPlayer.shift(surface.isPressed(61) && !surface.isPressed(64) , surface.isPressed(77) && !surface.isPressed(73))
//				//bunch of ifs and moves/skill use methods in player
//			}
		}
		if (gameNum == 2) {
			if (surface.isPressed(74) || surface.isPressed(106)) {
				System.out.println("j");
				curPlayer.move(-5, 0);
			}

			if (surface.isPressed(76) || surface.isPressed(108)) {
				System.out.println("l");
				curPlayer.move(5, 0);
			}

			if (surface.isPressed(73) || surface.isPressed(105)) {
				System.out.println("i");
				curPlayer.move(0, -5);
			}

			if (surface.isPressed(75) || surface.isPressed(107)) {

				System.out.println("k");
				curPlayer.move(0, 5);
			}
			if (surface.isPressed(58) || surface.isPressed(59)) {
				System.out.println(";");
				curPlayer.shoot(surface);
			}
			
		}
	}
	
	/** 
	 * Returns true if the stage has been cleared
	 * @return true if all enemies are dead
	 */
	public boolean isCompleted() {
		return curWave > 3;
	}
	/** 
	 * Returns if the game is over
	 * @return true if player is dead
	 */
	public boolean gameOver() {
		return gameOver;
	}
	
	
	private void act(PApplet surface) {
		boolean playerExists = false;
		boolean entitiesExist = false;
		
		//entitiesExist = true;
		
		for (int i = 0; i < entityList.size(); i++) {
			Entity e = entityList.get(i);
			if (e.isDead()) {

				//if (e instanceof Projectile) System.out.println("didfdsfjdsuifyhdsue");
				entityList.remove(entityList.indexOf(e));
				continue;
			}
			if (e instanceof Player) {
				playerExists = true;
				curPlayer = (Player)e;
				curPlayer.setEntityList(entityList);
				//if (curPlayer != null)curPlayer.act();
			}
			if (e instanceof Enemy) {
				entitiesExist = true;
				((Enemy) e).setEntityList(entityList);
			}
			e.act();
			
		}

		//entityList removes all projectiles???
		
		//System.out.println(entityList.size());
		for (Entity e : entityList) if (e instanceof Projectile) System.out.println("proj exists");
		for (int i = 0; i < entityList.size(); i++) {
			Entity e = entityList.get(i);
			if (e instanceof Player || e instanceof Enemy) {
				//System.out.println("eva");
				for (int j = 0; j < entityList.size(); j++) {
					//System.out.println("eva2");
					Entity e2 = entityList.get(j);
					if (e2 instanceof Projectile) {
						//System.out.println("neva");
						if (e.isTouching(e2)) {
							//System.out.println("say neva");
							((Projectile)e2).interact(e);
						}
					}
					else if (e2 instanceof PowerUp && e instanceof Player) {
						//System.out.println("neva");
						if (e.isTouching(e2)) {
							//System.out.println("say neva2");
							((PowerUp)e2).interact((Player)e);
						}
					}
				}
			}
		}
		for (int i = 0; i < entityList.size(); i++) {
			Entity e = entityList.get(i);
			if (e instanceof Enemy) {
				entitiesExist = true;
				//e.act();
			} else {
				//e.act();
			}
		}
		if (!playerExists) gameOver = true;
		
		if (!entitiesExist) {
			curWave++;
			//you can add below another set of if conditions for each stage that
			//can change up wave number, enemy number, and other properties
			if (curWave == 3) {
				Boss b = new Boss(topLeft.x+100, topLeft.y+100, 100, 100, false, stageNum);
				b.setup(surface);
				b.giveBounds(topLeft, dimensions);
				this.b = b;
				entityList.add(b);
			} else if (curWave < 3) {
				
				Goon g = new Goon(topLeft.x+50, topLeft.y+50, 75, 75, false, stageNum, 1);
				g.setup(surface);
				g.giveBounds(topLeft, dimensions);
				entityList.add(g);
				g = new Goon(topLeft.x+75, topLeft.y+75, 75, 75, false, stageNum, 1);
				g.setup(surface);
				g.giveBounds(topLeft, dimensions);
				entityList.add(g);
				g = new Goon(topLeft.x+50, topLeft.y+50, 75, 75, false, stageNum, 2);
				g.setup(surface);
				g.giveBounds(topLeft, dimensions);
				entityList.add(g);
				g = new Goon(topLeft.x+100, topLeft.y+100, 75, 75, false, stageNum, 2);
				g.setup(surface);
				g.giveBounds(topLeft, dimensions);
				entityList.add(g);

			}
			PowerUp p = new PowerUp(topLeft.x+200, topLeft.y+200, 50, 50, 1, true);
			PowerUp p1 = new PowerUp(topLeft.x+200, topLeft.y+300, 50, 50, 2, true);
			PowerUp p2 = new PowerUp(topLeft.x+200, topLeft.y+400, 50, 50, 3, true);
			PowerUp p3 = new PowerUp(topLeft.x+200, topLeft.y+500, 50, 50, 4, true);
			PowerUp p4 = new PowerUp(topLeft.x+200, topLeft.y+600, 50, 50, 5, true);
			p.setup(surface);
			p1.setup(surface);
			p2.setup(surface);
			p3.setup(surface);
			p4.setup(surface);
			entityList.add(p);
			entityList.add(p1);
			entityList.add(p2);
			entityList.add(p3);
			entityList.add(p4);
		}
	}
	
	/**
	 * Returns the current player referenced in Stage
	 * @return Player current Player character
	 */
	public Player getPlayer() {
		return curPlayer;
	}

	
	private void updateStats() {
		//will update Statistics with data about the Player curPlayer
	}
	
}
