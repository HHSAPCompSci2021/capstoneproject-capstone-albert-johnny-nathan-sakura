package entities.projectiles;

import java.util.ArrayList;

import processing.core.PApplet;

/**
 * this class represents a collection of bullets that follow a certain pattern
 * @author Johnny Zhang
 *
 */
public class PatternBullet {
	private ArrayList<Bullet> bullets;
	private int type;
	/**
	 * Creates a new instance of Bullet with the properties of Entity
	 * @param x X-Coordinate
	 * @param y Y-Coordinate
	 * @param type The type of bullet
	 * @param dmg The damage of the bullet
	 */
	public PatternBullet(int x, int y, int type, int dmg) {
		this.type = type;
		bullets = new ArrayList<Bullet>();
		if (type == 1 || type == 2) {
			bullets.add(new Bullet(x, y, 30, 30, -10, -10, true, false, dmg));
			bullets.add(new Bullet(x, y, 30, 30, -10, 0, true, false, dmg));
			bullets.add(new Bullet(x, y, 30, 30, -10, 10, true, false, dmg));
			bullets.add(new Bullet(x, y, 30, 30, 0, -10, true, false, dmg));
			bullets.add(new Bullet(x, y, 30, 30, 0, 10, true, false, dmg));
			bullets.add(new Bullet(x, y, 30, 30, 10, -10, true, false, dmg));
			bullets.add(new Bullet(x, y, 30, 30, 10, 0, true, false, dmg));
			bullets.add(new Bullet(x, y, 30, 30, 10, 10, true, false, dmg));
		}
		if (type == 3) {
			for (int i = -5; i < 5; i++) {
				for (int j = -5; j < 5; j++) {
					bullets.add(new Bullet(x + i * 10, y + i * 10, 30, 30, 0, -10, true, false, dmg));
				}
			}
		}
	}
	
	public void act() {
		if (type == 2) {
			for (Bullet b : bullets) {
				b.act();
				double temp = b.getvx();
				b.setvx(b.getvy() / 2);
				b.setvy(temp / 2);
			}
		}
	}
	
	public ArrayList<Bullet> getBullets() {
		return bullets;
	}
	
	public void setup(PApplet surface) {
		//PImage temp;
		for (Bullet b : bullets) {
			b.setup(surface);
		}
	}
}
