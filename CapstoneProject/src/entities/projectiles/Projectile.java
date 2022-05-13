package entities.projectiles;
import entities.Entity;
import entities.mobs.Enemy;
import entities.mobs.Player;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class is a projectile, which collides with entities and damages them
 * @author Johnny Zhang
 *
 */
public class Projectile extends Entity {
	private boolean fromPlayer;
	/**
	 * Creates a new instance of Projectile
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 * @param w Width of the hitbox
	 * @param h Height of the hitbox
	 * @param circle If the hitbox is a circle
	 * @param image Image of the entity
	 */
	public Projectile(double x, double y, double w, double h, double vx, double vy, boolean circle, boolean p, double dmg) {
		super(x, y, w, h, circle);
		setvx(vx);
		setvy(vy);
		setDmg(dmg);
		this.setHp(1);
		fromPlayer = p;
	}
	
	
	/**
	 * Causes the Entity hit by the bullet to lose HP
	 */
	public void interact(Entity e) {
		System.out.println("interact");
		if (fromPlayer == false && e instanceof Player) {
			e.setHp(e.getHp() - getDmg());
			die();
		}
		if (fromPlayer == true && e instanceof Enemy) {
			System.out.println("drain");
			e.setHp(e.getHp() - getDmg());
		}
	}
	
	/**
	 * checks if the projectile is out of bounds
	 * @return boolean if the projectile is out of bounds
	 */
	public boolean outOfBounds() {
		if (getX() < -10 || getX() > 1210 || getY() < -10 || getY() > 910) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * moves the projectile
	 */
	public void act() {
		System.out.println("cri");
		setX(getX()+getvx());
		setY(getY()+getvy());
		if (outOfBounds()) {
			System.out.println("die");
			die();
		}
	}
	
	/**
	 * sets up the image for the trap
	 * @param surface the drawing surface
	 */
	public void setup(PApplet surface) {
		PImage temp;
		System.out.println("loaded image");
		temp = (surface.loadImage("sprites/projectile.png"));
		temp.resize((int)getWidth(), (int)getHeight());
		setSprite(temp);
	}

}
