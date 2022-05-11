package entities.mobs;

import processing.core.PImage;

/**
 * The class Goon class represents an Enemy
 */
public class Goon extends Enemy{
	private double shotFrequency;
	/**
	 * Creates a new instance of Goon
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 * @param w Width of the hitbox
	 * @param h Height of the hitbox
	 * @param circle If the hitbox is a circle
	 * @param image Image of the entity
	 */
	public Goon(double x, double y, double w, double h, boolean circle, double frequency, PImage image) {
		super(x, y, w, h, circle, image);
		shotFrequency = frequency;
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
	 * Allows the Goon to move
	 */
	public void move() {
		shootBullet();
		act();
	}
	
}
