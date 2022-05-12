
package entities.projectiles;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class is basically the same as projectile, i don't know why we have it
 * @author Johnny Zhang
 *
 */
public class Bullet extends Projectile {
	public static PImage img;
	/**
	 * Creates a new instance of Bullet with the properties of Entity
	 * @param x X-Coordinate
	 * @param y Y-Coordinate
	 * @param w Width of hitbox
	 * @param h Height of hitbox
	 * @param circle If the hitbox is a circle
	 * @param image Image of the player sprite
	 */
	public Bullet(double x, double y, double w, double h, double vx, double vy, boolean circle, double dmg) {
		super(x, y, w, h, vx, vy, circle, dmg);
		this.setHp(1);
	}
	
	
	public void setup(PApplet surface) {
		PImage temp;
		System.out.println("loaded image");
		temp = (surface.loadImage("sprites/projectile-bullet.png"));
		temp.resize((int)getWidth(), (int)getHeight());
		setSprite(temp);
	}

	
	
}
