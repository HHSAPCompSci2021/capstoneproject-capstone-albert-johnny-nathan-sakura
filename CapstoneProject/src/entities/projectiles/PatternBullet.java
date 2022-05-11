package entities.projectiles;

import java.util.ArrayList;

public class PatternBullet {
	private ArrayList<Bullet> bullets;
	public PatternBullet(int x, int y, int type, int dmg) {
		bullets = new ArrayList<Bullet>();
		if (type == 1) {
			bullets.add(new Bullet(x, y, 10, 10, -10, -10, true, dmg));
			bullets.add(new Bullet(x, y, 10, 10, -10, 0, true, dmg));
			bullets.add(new Bullet(x, y, 10, 10, -10, 10, true, dmg));
			bullets.add(new Bullet(x, y, 10, 10, 0, -10, true, dmg));
			bullets.add(new Bullet(x, y, 10, 10, 0, 10, true, dmg));
			bullets.add(new Bullet(x, y, 10, 10, 10, -10, true, dmg));
			bullets.add(new Bullet(x, y, 10, 10, 10, 0, true, dmg));
			bullets.add(new Bullet(x, y, 10, 10, 10, 10, true, dmg));
		}
	}
}
