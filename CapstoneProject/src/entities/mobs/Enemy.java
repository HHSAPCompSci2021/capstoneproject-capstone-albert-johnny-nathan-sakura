package entities.mobs;

import entities.Entity;

/**
 * The Enemy class represents an enemy with all the properties of the Entity class, with a damage,
 * bullet velocity, and HP.
 * @author nathangu
 */
public class Enemy{
	
	private double maxHP;
	private double damage;
	private double velocity;
	
	/**
	 * Creates a new instance of Enemy 
	 * @param maxHP The HP of the enemy
	 * @param damage Damage per bullet of the enemy
	 * @param velocity Velocity of the bullets
	 * @param isCircle If the hitbox is a circle
	 */
	public Enemy(double maxHP, double damage, double velocity, boolean isCircle) {
		this.damage = damage;
		this.maxHP = maxHP;
		this.velocity = velocity; 
	}
	/**
	 * Fires Bullets
	 */
	public void shoot(){
	}
	
	
	public void setHP(double current) {
		maxHP = current;
	}

	public double getHP() {
		return maxHP;
	}
	
	public double getBulletVelocity() {
		return velocity;
	}
	public void setBulletVelocity(double newVelo) {
		velocity = newVelo;
	}
	
	public void setDamage(double newDmg) {
		damage = newDmg;
	}
	
	public double getDamage() {
		return damage;
	}
}
