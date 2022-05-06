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
	
	/**Constructing a Statistics class with a Player class 
	 * 
	 */
	public Statistics(Player p) {
		//note: put info in player so below methods dont have to be used
	}
	
	/**Updates the hp by num amount
	 * 
	 * @param num positive for adding HP, negative for subtracting
	 */
	public void updateHP(double num) {
		hp += num;
	}
	
	/**Updates the Statistics class to show that a skill is usable
	 * 
	 * @param i number of the skill
	 * @pre i must be 0 < the number of skills
	 */
	public void makeSkillUsable(int i) {
		skillsUsable[i] = true;
	}
	
	/**Updates the Statistics class to show that a trap is usable
	 * 
	 * @param i number of the trap
	 * @pre i must be 0 < the number of trap
	 */
	public void makeTrapUsable(int i) {
		trapsUsable[i] = true;
	}
	
	/**Updates the Statistics class to show that a trap is usable
	 * 
	 * @param i number of the trap
	 * @pre i must be 0 < the number of trap
	 */
	public void useSkill(int i) {
		skillsUsable[i] = false;
	}
	
	/**Updates the Statistics class to show that a trap is usable
	 * 
	 * @param i number of the trap
	 * @pre i must be 0 < the number of trap
	 */
	public void useTrap(int i) {
		trapsUsable[i] = true;
	}

	/**Draws out the Statistics in a consise manner
	 * 
	 * @param surface
	 */
	public void draw(PApplet surface) {
		//some cool design 
	}
}
