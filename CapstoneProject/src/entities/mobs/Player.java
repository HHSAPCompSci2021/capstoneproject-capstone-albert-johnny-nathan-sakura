package entities.mobs;
import java.util.ArrayList;

import entities.Entity;
import entities.projectiles.*;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * The Player class represents the two users in the program that interact with the entities 
 */
public class Player extends Entity {
	private int coins;
	private int powerUpType;
	private int powerUpDuration;
	private ArrayList<Entity> entityList;
	private int playerNum;
	private int shawtyFramesCD;
	private int resetCD;
	private boolean multishot, penetrate;
	private long delay;
	private int bulletDMG;
	
	/**
	 * Creates a new instance of Player with the properties of Entity
	 * @param x X-Coordinate
	 * @param y Y-Coordinate
	 * @param w Width of hitbox
	 * @param h Height of hitbox
	 * @param circle If the hitbox is a circle
	 * @param gameNum The game number
	 */
	public Player(double x, double y, double w, double h, boolean circle, int gameNum) {
		super(x,y,w,h,circle);
		entityList = new ArrayList<Entity>();
		this.playerNum = gameNum;
		this.setHp(1000);
		multishot = false;
		resetCD = 10;
		
		//hello this is the new damage
		bulletDMG = 1000;
	}
	
	/**
	 * sets up the image for the player
	 * @param surface the drawing surface
	 */
	public void setup(PApplet surface) {
		PImage temp;
		temp = (surface.loadImage("sprites/player2.png"));
		if (playerNum == 1) temp = (surface.loadImage("sprites/player1.png"));
		temp.resize((int)getWidth(), (int)getHeight());
		setSprite(temp);
	}
	
	public boolean multishotActive() {
		return multishot;
	}
	public boolean penetrateActive() {
		return penetrate;
	}
	public boolean rateIncreaseActive() {
		return resetCD == 5;
	}

	public boolean dmgIncreaseActive() {
		return bulletDMG == 500;
	}
	
//	public void draw(PApplet surface) {
//		super.draw(surface);
//	}
	
	/**
	 * Sets the entity list
	 * @param e The list of entities
	 */
	public void setEntityList(ArrayList<Entity> e) {
		entityList = e;
	}
	
	public ArrayList<Entity> getEntityList(){
		return entityList;
	}
	
	/**
	 * Allows the player to interact with the surrounding Entities
	 */
	public void act() {
		System.out.println(bounds[0] + " " + bounds[1] + " " + bounds[2] + " " +bounds[3]);
		if (delay <= 0) {
			multishot = false;
			penetrate = false;
			resetCD = 10;
			//dmg here also
			bulletDMG = 1000;
		} else {
			delay--;
		}
		
		if (powerUpDuration > 0) {
			if (powerUpType == 1) {
				this.setHp(42069);
				powerUpType = 0;
			} 
			if (powerUpType == 2) {
				//System.out.println("HEY HEY!");
				multishot = true;
				powerUpType = 0;
				delay = 300;//5 seconds in frames
			}
			if (powerUpType == 3) {
				//System.out.println("ITS ME DIO!");
				penetrate = true;
				powerUpType = 0;
				delay = 300;
			}
			if (powerUpType == 4) {
				//System.out.println("RUN SMOKEY!");
				resetCD = 5;
				powerUpType = 0;
				delay = 300;
			}
			if (powerUpType == 5) {
				//System.out.println("Shinderu!");
				bulletDMG = 500;
				powerUpType = 0;
				delay = 300;
			}
		}
		
		if (shawtyFramesCD > 0) {
			shawtyFramesCD--;
		}
//		for (int i = 0; i < entityList.size(); i++) {
//			Entity e = entityList.get(i);
//			if (e != this && isTouching(e)) {
//				e.interact(this);
//				entityList.remove(i);
//				i--;
//			}
//		}
		if (powerUpDuration > 0) powerUpDuration -= 1;
	}
	
	/**
	 * Allows the player to move
	 * @param x X-coordinate to move to
	 * @param y Y-coordinate to move to
	 */
	public void move(double x, double y) {
		setX(getX() + x);
		setY(getY()+ y);
		//System.out.print("P" + playerNum + ":");
		//System.out.println("Bounds: " + bounds[2] + " by " + bounds[3] + " at " + bounds[0] + " " + bounds[1]);
		double midX = getX()+getWidth()/2;
		double midY = getY()+getHeight()/2;
		//System.out.println(midX + " " + midY);
		if (midX > bounds[0] + bounds[2]) {
			//System.out.println("Set X to right side");
			setX(bounds[0]-getWidth()/2 + bounds[2] );
		} else
		if (midX < bounds[0]) {
			//System.out.println("Set X to left side");
			setX(bounds[0]-getWidth()/2);
		}
		
		if (midY > bounds[1] + bounds[3]) {
			//System.out.println("Set Y to bottom");
			setY(bounds[1]-getHeight()/2 + bounds[3]);
		} else 
		if (midY < bounds[1]) {
			//System.out.println("Set Y to top");
			setY(bounds[1]-getHeight()/2);
		}
	}

	/**
	 * Adds coins to the total number of coins
	 * @param a Coins collected
	 */
	public void addCoins(int a) {
		coins += a;
	}
	/**
	 * Sets the power up type 
	 * @param a The type of power up
	 */
	public void setPowerUpType(int a) {
		powerUpType = a;
	}
	/**
	 * Sets the duration of the power up
	 * @param a Duration of the power up
	 */
	public void setPowerUpDuration(int a) {
		powerUpDuration = a;
	}
	
	/**
	 * Uses skill i
	 * @param i Skill number
	 */
	public void useSkill(int i) {
		//when i = 0 it is player default skill
		
		
		//when i = 1 it is powerup
		if (i == 1) {
			
		}
		//when i = 2 it is trap
		if (i == 2) {
			if(coins >= 5) {
				coins -= 5;
				//activate trap!!!!
					
			}
		}
		
		//when i = 3 it is wind
	}
	
	/**
	 * Allows the player to shoot
	 * @param surface The surface drawn on
	 */
	public void shoot(PApplet surface) {
		if (shawtyFramesCD > 0) return;
		//System.out.println("entityNum: " + entityList.size());
		Bullet b = new Bullet(this.getX()+getWidth()/2-15, this.getY() - 50, 30, 30, 0, -8, true, true, bulletDMG);
		b.setup(surface);
		b.setPenetrate(penetrate);
		entityList.add(b);
		if (multishot) {

			Bullet b1 = new Bullet(this.getX()+getWidth()/2-15, this.getY() - 50, 30, 30, 1, -6, true, true, bulletDMG);
			b1.setup(surface);
			b1.setPenetrate(penetrate);
			entityList.add(b1);
			Bullet b2 = new Bullet(this.getX()+getWidth()/2-15, this.getY() - 50, 30, 30, -1, -6, true, true, bulletDMG);
			b2.setup(surface);
			b2.setPenetrate(penetrate);
			entityList.add(b2);
		}
		shawtyFramesCD = resetCD;
	}
	
}
