package entities.projectiles;

import entities.mobs.Player;
import processing.core.PImage;

public class Wind extends Projectile {

	public Wind(double x, double y, double w, double h, double vx, double vy, boolean circle, double dmg,
			PImage image) {
		super(x, y, w, h, vx, vy, circle, dmg, image);
		// TODO Auto-generated constructor stub
	}
	
	public void act(Player player) {
		player.setvy(player.getvy() - 10);
	}
	
}
