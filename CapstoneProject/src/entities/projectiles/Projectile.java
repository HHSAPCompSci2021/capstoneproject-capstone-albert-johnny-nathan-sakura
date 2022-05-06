package entities.projectiles;
import entities.Entity;
import processing.core.PImage;

/**
 * This class is a projectile, which collides with entities and damages them
 * @author Johnny Zhang
 *
 */
public class Projectile extends Entity {
	/**
	 * Creates a new instance of Projectile
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 * @param w Width of the hitbox
	 * @param h Height of the hitbox
	 * @param circle If the hitbox is a circle
	 * @param image Image of the entity
	 */
	public Projectile(double x, double y, double w, double h, double vx, double vy, boolean circle, double dmg, PImage image) {
		super(x, y, w, h, circle, image);
		setvx(vx);
		setvy(vy);
		setDmg(dmg);
	}
	/**
	 * Causes the Entity hit by the bullet to lose HP
	 */
	public void act(Entity e) {
		e.setHp(e.getHp() - getDmg());
	}

}
