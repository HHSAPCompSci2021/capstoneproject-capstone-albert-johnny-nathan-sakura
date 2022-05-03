import java.util.ArrayList;

import processing.core.PApplet;

public class Game {
	private int gameNum;
	private ArrayList<Stage> stages;
	private Stage curStage;
	private Statistics playerStats;
	public Game(int gameNum) {
		this.gameNum = gameNum;
		for (int i = 0; i < 4; i++) {
			stages.add(new Stage(i));
		}
	}
	
	private boolean switchStage(int i) {
		if (i < stages.size() && i > 0) {
			curStage = stages.get(i);
			return true;
		}
		return false;
	}
	
	public void draw(PApplet surface) {
		playerStats = curStage.getStats();
		curStage.draw(surface);
		playerStats.draw(surface);
	}
	
	public void giveInputs(DrawingSurface surface) {
		if (gameNum == 1) {
			if (surface.isPressed(null)) {
				//bunch of ifs and moves/skill use methods in player
			}
		}
		if (gameNum == 2) {
			if (surface.isPressed(null)) {
				//bunch of ifs and moves/skill use methods in player
			}
		}
	}
}
