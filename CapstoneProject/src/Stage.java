import java.util.ArrayList;

import processing.core.PApplet;

public class Stage {
	private int stageNum;
	private ArrayList<Entity> entityList;
	private Player curPlayer;
	private Statistics playerStats;
	public Stage(int stageNum) {
		this.stageNum = stageNum;
		entityList = new ArrayList<Entity>();
		entityList.add(new Player());
		for (int i = 0; i < 4; i++) {
			entityList.add(new Goon(stageNum));
		}
		
	}
	
	public void draw(PApplet surface) {
		act();
		playerControl()
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
		if () {
			
		}
	}
	
}
