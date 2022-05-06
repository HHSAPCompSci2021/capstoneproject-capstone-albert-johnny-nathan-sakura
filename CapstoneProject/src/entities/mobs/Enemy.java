package entities.mobs;

import entities.Entity;
import processing.core.PImage;

/**
 * The Enemy class represents an enemy with all the properties of the Entity class, with a damage,
 * bullet velocity, and HP.
 * @author nathangu
 */
public class Enemy extends Entity{
	
	private double maxHP;
	private double damage;
	private double velocity;
	
	/**
	 * Creates a new instance of Enemy
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 * @param w Width of the hitbox
	 * @param h Height of the hitbox
	 * @param circle If the hitbox is a circle
	 * @param image Image of the entity
	 */
	public Enemy(double x, double y, double w, double h, boolean circle, PImage image) {
		super(x, y, w, h, circle, image);
		damage = 0;
		maxHP = 1;
		velocity = 0; 
	}
	/**
	 * Allows the Enemy to fire Bullet
	 */
	public void shoot(){
		
	}
	
	public double getBulletVelocity() {
		return velocity;
	}
	public void setBulletVelocity(double newVelo) {
		velocity = newVelo;
	}
	
	public void act() {
		shoot();
		super.act();
	}
}
