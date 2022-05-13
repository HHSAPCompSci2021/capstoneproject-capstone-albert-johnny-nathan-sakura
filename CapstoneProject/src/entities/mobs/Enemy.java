package entities.mobs;

import entities.Entity;
import processing.core.PImage;

/**
 * The Enemy class represents an enemy with all the properties of the Entity class
 * @author nathangu
 */
public class Enemy extends Entity{
	
	
	/**
	 * Creates a new instance of Enemy
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 * @param w Width of the hitbox
	 * @param h Height of the hitbox
	 * @param circle If the hitbox is a circle
	 */
	public Enemy(double x, double y, double w, double h, boolean circle) {
		super(x, y, w, h, circle);
	}
	
	/**
	 * Allows the Enemy to fire Bullet
	 */
	public void shoot(){
		
	}
	
	
	/**
	 * Runs an enemy action
	 */
	public void act() {
		shoot();
		super.act();
	}
}
