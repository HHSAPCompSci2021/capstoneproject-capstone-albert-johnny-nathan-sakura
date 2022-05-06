package entities.mobs;

import processing.core.PImage;

/**
 * The Boss class represent a Boss enemy with the properties of enemy
 * @author nathangu
 *
 */
public class Boss extends Enemy{

	
	/**
	 * Creates a new instance of Boss 
	 * @param maxHP The HP of the enemy
	 * @param damage Damage per bullet of the enemy
	 * @param velocity Velocity of the bullets
	 * @param isCircle If the hitbox is a circle
	 */
	public Boss(double x, double y, double w, double h, boolean circle, PImage image) {
		super(x, y, w, h, circle, image);
	}

}
