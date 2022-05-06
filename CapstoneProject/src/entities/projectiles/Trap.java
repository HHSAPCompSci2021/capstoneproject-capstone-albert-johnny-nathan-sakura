package entities.projectiles;

import entities.Entity;
import entities.mobs.Player;
import processing.core.PImage;

public class Trap extends Bullet {
	//1 = hurt, 2 = slow, 3 = subtractCoins
	private boolean available, cost;
	private int type;
	
	public Trap(double x, double y, double w, double h, double vx, double vy, int type, boolean circle, double dmg,
			PImage image) {
		super(x, y, w, h, vx, vy, circle, dmg, image);
		this.type = type;
	}
	
	public void act(Player player) {
		if (type == 1) {
			player.setHp(player.getHp()-getDmg());
		}
		if (type == 2) {
			player.setvx(0);
			player.setvy(0);
		}
		if (type == 3) {
			player.addCoins(-10);
		}
	}
}
