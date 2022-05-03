import java.util.ArrayList;

import processing.core.PApplet;

public class Game {
	private ArrayList<Stage> stages;
	private Stage curStage;
	private Statistics playerStats;
	public Game() {
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
	
}
