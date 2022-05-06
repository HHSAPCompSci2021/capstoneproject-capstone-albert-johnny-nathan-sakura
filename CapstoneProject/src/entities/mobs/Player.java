package entities.mobs;
import java.util.ArrayList;

import entities.Entity;
import entities.projectiles.*;
import processing.core.PImage;

/**
 * The Player class represents the two users in the program that interact with the entities 
 * @author 
 */
public class Player extends Entity {
	private int playerNum;
	private int coins;
	private int powerUpType;
	private int powerUpDuration;
	private ArrayList<Entity> entityList;
	
	/**
	 * Creates a new instance of Player with the properties of Entity
	 * @param x X-Coordinate
	 * @param y Y-Coordinate
	 * @param w Width of hitbox
	 * @param h Height of hitbox
	 * @param circle If the hitbox is a circle
	 * @param image Image of the player sprite
	 */
	public Player(double x, double y, double w, double h, boolean circle, PImage image) {
		super(x,y,w,h,circle,image);
		entityList = new ArrayList<Entity>();
	}
	
	/**
	 * Sets the entity list
	 * @param e The list of entities
	 */
	public void setEntityList(ArrayList<Entity> e) {
		entityList = e;
	}
	
	/**
	 * Allows the playr to interact with the surrounding Entities
	 */
	public void act() {
		for (int i = 0; i < entityList.size(); i++) {
			Entity e = entityList.get(i);
			if (isTouching(e) && (e instanceof Projectile || e instanceof PowerUp || e instanceof Coin)) {
				e.act(this);
				entityList.remove(i);
				i--;
			}
		}
	}
	
	/**
	 * Allows the player to move
	 * @param x X-coordinate to move to
	 * @param y Y-coordinate to move to
	 */
	public void move(double x, double y) {
		
	}
	
	/**
	 * Adds coins to the total number of coins
	 * @param a Coins collected
	 */
	public void addCoins(int a) {
		coins += a;
	}
	
	public void setPowerUpType(int a) {
		powerUpType = a;
	}
	public void setPowerUpDuration(int a) {
		powerUpDuration = a;
	}
}
