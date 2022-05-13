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
	 * @param circle If the hitbox is a circle
	 * @param image Image of the player sprite
	 */
	public Trap(double x, double y, double w, double h, double vx, double vy, int type, boolean circle, double dmg) {
		super(x, y, w, h, vx, vy, circle, false,  dmg);
		this.type = type;
	}
	
	/**
	 * Determines the type of trap and applies the effects on the specified Player
	 * @param player
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
	
	public void use(int t) {
		
	}
	
	
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
