package entities.projectiles;

import entities.Entity;
import entities.mobs.Player;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This is a trap, which can be deployed by players.
 * @author Johnny Zhang
 *
 */
public class Trap extends Bullet {
	//1 = hurt, 2 = slow, 3 = subtractCoins
	private boolean available, cost;
	private int type;
	
	/**
	 * Creates a new instance of Trap with the properties of Entity
	 * @param x X-Coordinate
	 * @param y Y-Coordinate
	 * @param w Width of hitbox
	 * @param h Height of hitbox
	 * @param vx X velocity
	 * @param vy Y velocity
	 * @param type The type of trap
	 * @param circle If the hitbox is a circle
	 * @param dmg Damage of the Trap
	 */
	public Trap(double x, double y, double w, double h, double vx, double vy, int type, boolean circle, double dmg) {
		super(x, y, w, h, vx, vy, circle, false,  dmg);
		this.type = type;
	}
	
	/**
	 * Determines the type of trap and applies the effects on the specified Player
	 * @param player The Player that receives the trap effects
	 */
	public void interact(Player player) {
		if (type == 1) {
			player.setHp(player.getHp()-getDmg());
		}
		if (type == 2) {
			player.setvx(0);
			player.setvy(0);
		}
		if (type == 3) {
			player.addCoins(-10);
		}
		die();
	}
	
	/**
	 * Deploys a trap
	 * @param t the type of trap
	 */
	public void use(int t) {
		
	}
	
	/**
	 * Sets up the image for the trap
	 * @param surface The drawing surface
	 */
	public void setup(PApplet surface) {
		PImage temp;
		System.out.println("loaded image");
		String str = "sprites/trap-";
		str += type;
		str += ".png";
		temp = (surface.loadImage(str));
		temp.resize((int)getWidth(), (int)getHeight());
		setSprite(temp);
	}
}
