package game;
import java.awt.Point;
import java.util.ArrayList;

import entities.Entity;
import entities.mobs.Boss;
import entities.mobs.Goon;
import entities.mobs.Player;
import processing.core.PApplet;

public class Stage {
	private int stageNum;
	private ArrayList<Entity> entityList;
	private Player curPlayer;
	private Statistics playerStats;
	private Point topLeft;
	private Point dimensions;
	public Stage(int stageNum) {
		
		topLeft = 
		this.stageNum = stageNum;
		entityList = new ArrayList<Entity>();
		entityList.add(new Player());
		for (int i = 0; i < 4; i++) {
			entityList.add(new Goon(stageNum));
		}
		
		entityList.add(new Boss(stageNum));
		
	}
	
	public void setBounds(int x, int y, int width, int height) {
		topLeft = new Point(x,y);
		dimensions = new Point(width, height);
		for (Entity e : entityList) {
			e.giveBounds(Point topLeft, Point dimensions);
		}
	}
	public void draw(PApplet surface) {
		act();
		updateStats();
		playerControls();
		for (Entity e : entityList) {
			if (e.isVisble()) e.draw(surface);
		}
	}
	
	public Statistics getStats() {
		return playerStats;
	}
	private void act() {
		for (Entity e : entityList) {
			if (e instanceof Player) {
				curPlayer = (Player)e;
			} else {
				e.act();
			}
		}
	}
	
	private void updateStats() {
		//will update Statistics with data about the Player curPlayer
	}
	
}
