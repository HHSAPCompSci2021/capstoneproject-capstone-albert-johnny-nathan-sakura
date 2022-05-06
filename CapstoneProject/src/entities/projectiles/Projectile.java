package entities.projectiles;
import entities.Entity;
import processing.core.PImage;

public class Projectile extends Entity {
	public Projectile(double x, double y, double w, double h, double vx, double vy, boolean circle, double dmg, PImage image) {
		super(x, y, w, h, circle, image);
		setvx(vx);
		setvy(vy);
		setDmg(dmg);
	}
	
	public void act(Entity e) {
		e.setHp(e.getHp()-getDmg());
	}

}
