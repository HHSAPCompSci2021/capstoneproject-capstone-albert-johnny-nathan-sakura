package game;
import java.util.ArrayList;

import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	private ArrayList<Integer> keys;
	private Game game1, game2;
	private boolean startMenu;
	public DrawingSurface() {
		keys = new ArrayList<Integer>();
		game1 = new Game(1, width, height);
		game2 = new Game(2, width, height);
		startMenu = false;
	}
	
	public void setup() {
		game1.setup(this);
		game2.setup(this);
	}
	
	/**Draws both games
	 */
	public void draw() {
		if (isPressed(27)) {
			startMenu = true;
		}
		if (startMenu) {
			background(90);
			textSize(40);
			text("Paused", width/4,height/4,width/2,height/2);
			textSize(30);
			text("Press ENTER to start game",width/4,height/3,width/2,height/2*3);
			if (isPressed(10)) {
				startMenu = false;
			}
		}
		else {
			background(100);
			game1.draw(this);
			game2.draw(this);
		}
	}
	
	public void keyPressed() {
		keys.add(keyCode);
		if (key == ESC)  // This prevents a processing program from closing on escape key
			key = 0;
	}

	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(keys.indexOf(keyCode));
	}
	
	/**Detects if a key is pressed
	 * 
	 * @param code key number
	 * @return true if key is pressed
	 */
	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
	
}
