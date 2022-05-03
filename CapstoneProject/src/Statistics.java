import java.util.ArrayList;

import processing.core.PApplet;

public class Statistics {
	private double hp;
	private boolean[] skillsUsable;
	private boolean[] trapsUsable;
	private double progress, coins;
	
	public Statistics() {
		
	}
	
	public void updateHP(double num) {
		hp += num;
	}
	
	public void makeSkillUsable(int i) {
		skillsUsable[i] = true;
	}
	
	public void makeTrapUsable(int i) {
		trapsUsable[i] = true;
	}
	
	public void useSkill(int i) {
		skillsUsable[i] = false;
	}
	
	public void useTrap(int i) {
		trapsUsable[i] = true;
	}

	
	public void draw(PApplet surface) {
		//some cool design 
	}
}
