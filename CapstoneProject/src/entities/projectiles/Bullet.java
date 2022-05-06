package entities.projectiles;

import processing.core.PImage;

public class Bullet extends Projectile {
	
	/**
	 * Creates a new instance of Bullet with the properties of Entity
	 * @param x X-Coordinate
	 * @param y Y-Coordinate
	 * @param w Width of hitbox
	 * @param h Height of hitbox
	 * @param circle If the hitbox is a circle
	 * @param image Image of the player sprite
	 */
	public Bullet(double x, double y, double w, double h, double vx, double vy, boolean circle, double dmg,
			PImage image) {
		super(x, y, w, h, vx, vy, circle, dmg, image);
		// TODO Auto-generated constructor stub
	}

}
