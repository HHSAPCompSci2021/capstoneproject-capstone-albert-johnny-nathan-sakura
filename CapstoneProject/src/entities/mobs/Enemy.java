package entities.mobs;

public class Enemy {
	
	private double maxHP;
	private double damage;
	private double velocity;
	
	public Enemy(double maxHP, double damage, double velocity, boolean isCircle) {
		this.damage = damage;
		this.maxHP = maxHP;
		this.velocity = velocity; 
	}
	
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
