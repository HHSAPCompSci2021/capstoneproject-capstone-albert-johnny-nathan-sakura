package entities.mobs;

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
	public Goon(double hp, double damage, double speed, boolean isCircle) {
		super(hp, damage, speed, isCircle);
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
