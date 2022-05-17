package game;
import java.util.ArrayList;

import entities.mobs.Player;
import processing.core.PApplet;

/**A Statistics class that contains a Player p and can display it's statistics
 * nicely
 * @author ayu663
 */
public class Statistics {
	private double hp;
	private boolean[] skillsUsable;
	private boolean[] trapsUsable;
	private double progress, coins;
	private int x,y,width,height;
	private Player p;
	
	/**
	 * Constructing a Statistics class with a Player class 
	 * @param p The Player
	 * @param x X-coordinate Statistics box
	 * @param y Y-coordinate Statistics box
	 * @param width Width of the Statistics box
	 * @param height Height of the Statistics box
	 */
	public Statistics(Player p, int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.p = p;
		this.width = width;
		this.height = height;
		
		//note: put info in player so below methods dont have to be used
	}
	
	/**
	 * Draws out the Statistics in a concise manner
	 * @param surface The surface to draw on
	 */
	public void draw(PApplet surface) {
		//System.out.println("iambeingdrawn at " +x + " " + y);
		//surface.fill(200);
		///surface.rect(x, y, width, height);
		surface.fill(225);
		String s = "HP: " + p.getHp() + "\nPowerups: \n";
		if (p.multishotActive()) {
			s+="Multishot, ";
		}
		if (p.penetrateActive()) {
			s+="Penetrate, ";
		}
		if (p.rateIncreaseActive()) {
			s+="Increased Rate, ";
		}
		if (p.dmgIncreaseActive()) {
			s+="Increased Damage, ";
		}
		s = s.substring(0, s.length()-2);
		surface.text(s, x, y, width, height);
//		surface.text("HP: " + p.getHp(), x, y, width, height);
//		surface.text("HP: " + p.getHp(), x, y, width, height);
	}
	/**
	 * Updates the hp by num amount
	 * @param num positive for adding HP, negative for subtracting
	 */
	public void updateHP(double num) {
		hp += num;
	}
	
	/**
	 * Updates the Statistics class to show that a skill is usable
	 * @param i number of the skill
	 * @pre i must be 0 less than the number of trap
	 */
	public void makeSkillUsable(int i) {
		skillsUsable[i] = true;
	}
	
	/**
	 * Updates the Statistics class to show that a trap is usable
	 * @param i number of the trap
	 * @pre i must be 0 less than the number of trap
	 */
	public void makeTrapUsable(int i) {
		trapsUsable[i] = true;
	}
	
	/**
	 * Updates the Statistics class to show that a trap is usable
	 * @param i number of the trap
	 * @pre i must be 0 less than the number of trap
	 */
	public void useSkill(int i) {
		skillsUsable[i] = false;
	}
	
	/**
	 * Updates the Statistics class to show that a trap is usable
	 * @param i number of the trap
	 * @pre i must be 0 less than the number of trap
	 */
	public void useTrap(int i) {
		trapsUsable[i] = true;
	}


}
