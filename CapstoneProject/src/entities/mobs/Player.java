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
	//private PImage image;
	private int playerNum;
	/**
	 * Creates a new instance of Player with the properties of Entity
	 * @param x X-Coordinate
	 * @param y Y-Coordinate
	 * @param w Width of hitbox
	 * @param h Height of hitbox
	 * @param circle If the hitbox is a circle
	 * @param image Image of the player sprite
	 */
	//can we hard code images and put the constructor as a playerNum?
	//
	public Player(double x, double y, double w, double h, boolean circle, int gameNum) {
		super(x,y,w,h,circle);
		entityList = new ArrayList<Entity>();
		this.playerNum = gameNum;
	}
	
	public void setup(PApplet surface) {
		PImage temp;
		temp = (surface.loadImage("sprites/player2.png"));
		if (playerNum == 1) temp = (surface.loadImage("sprites/player1.png"));
		temp.resize((int)getWidth(), (int)getHeight());
		setSprite(temp);
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
	
	/**
	 * Allows the player to interact with the surrounding Entities
	 */
	public void act() {
		for (int i = 0; i < entityList.size(); i++) {
			Entity e = entityList.get(i);
			if (isTouching(e)) {
				e.interact(this);
				entityList.remove(i);
				i--;
			}
		}
		powerUpDuration -= 1;
	}
	
	/**
	 * Allows the player to move
	 * @param x X-coordinate to move to
	 * @param y Y-coordinate to move to
	 */
	public void move(double x, double y) {
		setX(getX() + x);
		setY(getY()+ y);
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
}
