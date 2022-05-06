package entities.projectiles;

import entities.Entity;
import entities.mobs.Player;
import processing.core.PImage;

public class Coin extends Entity {
	int value;
	public Coin(double x, double y, double w, double h, boolean circle, PImage image) {
		super(x, y, w, h, circle, image);
		value = 5;
	}
	
	public void act(Player e) {
		e.addCoins(value);
	}

}
