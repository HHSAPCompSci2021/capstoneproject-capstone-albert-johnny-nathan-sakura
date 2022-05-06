package entities.mobs;
import java.util.ArrayList;

import entities.Entity;
import entities.projectiles.*;
import processing.core.PImage;

public class Player extends Entity {
	private int playerNum;
	private int coins;
	private int powerUpType;
	private int powerUpDuration;
	private ArrayList<Entity> entityList;
	public Player(double x, double y, double w, double h, boolean circle, PImage image) {
		super(x,y,w,h,circle,image);
		entityList = new ArrayList<Entity>();
	}
	
	public void setEntityList(ArrayList<Entity> e) {
		entityList = e;
	}
	
	public void act() {
		for (int i = 0; i < entityList.size(); i++) {
			Entity e = entityList.get(i);
			if (isTouching(e) && (e instanceof Projectile || e instanceof PowerUp || e instanceof Coin)) {
				e.act(this);
				entityList.remove(i);
				i--;
			}
		}
	}
	
	public void move(double x, double y) {
		
	}
	
	public void addCoins(int a) {
		coins += a;
	}
	
	public void setPowerUpType(int a) {
		powerUpType = a;
	}
	public void setPowerUpDuration(int a) {
		powerUpDuration = a;
	}
}
