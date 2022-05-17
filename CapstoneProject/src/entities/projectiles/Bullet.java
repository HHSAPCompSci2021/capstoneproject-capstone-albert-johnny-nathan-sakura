
package entities.projectiles;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class is basically the same as projectile, i don't know why we have it
 * @author Johnny Zhang
 *
 */
public class Bullet extends Projectile {
	private static PImage thisSprite;
	/**
	 * Creates a new instance of Bullet with the properties of Entity
	 * @param x X-Coordinate
	 * @param y Y-Coordinate
	 * @param w Width of hitbox
	 * @param h Height of hitbox
	 * @param vx X velocity
	 * @param vy Y velocity
	 * @param circle If hitbox a circle
	 * @param p If the Bullet is from the Player
	 * @param dmg Damage of the Bullet
	 */
	public Bullet(double x, double y, double w, double h, double vx, double vy, boolean circle, boolean p, double dmg) {
		super(x, y, 10, 30, vx, vy, circle, p, dmg);
		this.setHp(1);
	}
	
	/**
	 * Sets up the image for the Bullet
	 * @param surface the drawing surface
	 */
	public void setup(PApplet surface) {
		//PImage temp;
		if (thisSprite == null) {
			System.out.println("loaded image");
			thisSprite = (surface.loadImage("sprites/projectile-bullet.png"));
			thisSprite.resize((int)getWidth(), (int)getHeight());
		}
		setSprite(thisSprite);
	}

	
	
}
