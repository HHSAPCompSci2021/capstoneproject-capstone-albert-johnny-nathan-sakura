package entities.mobs;

public class Goon extends Enemy{
	
	
	public Goon(double hp, double damage, double speed, boolean isCircle) {
		super(hp, damage, speed, isCircle);
	}
	
	public void shootBullet() {
		shoot();
	}
	
	public void removeOutBullets() {
		
	}
	public void move() {
		
	}
	
}
