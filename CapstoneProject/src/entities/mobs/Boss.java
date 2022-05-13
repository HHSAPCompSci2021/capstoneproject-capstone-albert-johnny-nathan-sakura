package entities.mobs;

import processing.core.PImage;

/**
 * The Boss class represent a Boss enemy with the properties of enemy
 * @author nathangu
 *
 */
public class Boss extends Enemy{

	private double shotFrequency;
	/**
	 * Creates a new instance of Boss
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 * @param w Width of the hitbox
	 * @param h Height of the hitbox
	 * @param circle If the hitbox is a circle
	 * @param image Image of the entity
	 */
	public Boss(double x, double y, double w, double h, boolean circle, PImage image, double frequency) {
		super(x, y, w, h, circle);
		shotFrequency = frequency;
	}
	
	public void shootPatternBullet() {
		
	}
	
	/**
	 * Allows the Boss to move
	 */
	public void move() {
		act();
	}
}
