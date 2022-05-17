package entities.projectiles;

import java.util.ArrayList;

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
			bullets.add(new Bullet(x, y, 10, 10, -10, -10, true, false, dmg));
			bullets.add(new Bullet(x, y, 10, 10, -10, 0, true, false, dmg));
			bullets.add(new Bullet(x, y, 10, 10, -10, 10, true, false, dmg));
			bullets.add(new Bullet(x, y, 10, 10, 0, -10, true, false, dmg));
			bullets.add(new Bullet(x, y, 10, 10, 0, 10, true, false, dmg));
			bullets.add(new Bullet(x, y, 10, 10, 10, -10, true, false, dmg));
			bullets.add(new Bullet(x, y, 10, 10, 10, 0, true, false, dmg));
			bullets.add(new Bullet(x, y, 10, 10, 10, 10, true, false, dmg));
		}
	}
	
	public void act() {
		if (type == 2) {
			for (Bullet b : bullets) {
				double temp = b.getvx();
				b.setvx(b.getvy() / 2);
				b.setvy(temp / 2);
			}
		}
	}
}
