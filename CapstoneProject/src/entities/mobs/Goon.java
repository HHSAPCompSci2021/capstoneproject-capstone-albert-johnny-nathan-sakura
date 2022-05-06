package entities.mobs;

import processing.core.PImage;

/**
 * The class Goon class represents an Enemy
 * @author 
 *
 */
public class Goon extends Enemy{
	
	/**
	 * Creates a new instance of Goon
	 * @param hp HP of the goon
	 * @param damage Damage per bullet of the goon
	 * @param speed Speed of the bullet
	 * @param isCircle If the hitbox is a circle
	 */
	public Goon(double x, double y, double w, double h, boolean circle, PImage image) {
		super(x, y, w, h, circle, image);
	}
	
	/**
	 * Shoots Bullets
	 */
	public void shootBullet() {
		shoot();
	}
	
	/**
	 * Removes the bullets out of the window
	 */
	public void removeOutBullets() {
		
	}
	/**
	 * Allows the goon to move
	 */
	public void move() {
		
	}
	
}
