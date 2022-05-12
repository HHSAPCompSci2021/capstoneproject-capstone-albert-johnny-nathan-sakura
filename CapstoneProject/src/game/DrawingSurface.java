package game;
import java.util.ArrayList;

import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	private ArrayList<Integer> keys;
	private Game game1, game2;
	private boolean startMenu;
	private boolean pauseMenu;
	private int newWidth, newHeight;
	public DrawingSurface(int width1, int height1) {
		this.newWidth = width1;
		this.newHeight = height1;
		keys = new ArrayList<Integer>();
		startMenu = true;
		pauseMenu = false;
	}
	
	public void setup() {
		System.out.println(newWidth + " " + newHeight);
		game1 = new Game(1, newWidth, newHeight);
		game2 = new Game(2, newWidth, newHeight);
		game1.setup(this);
		game2.setup(this);
	}
	
	/**Draws both games
	 */
	public void draw() {
		game1.giveInputs(this);
		game2.giveInputs(this);
		if (isPressed(27)) {
			pauseMenu = true;
		}
		if (pauseMenu) {
			background(90);
			textSize(40);
			text("Paused", width/4,height/4,width/2,height/2);
			textSize(30);
			text("Press ENTER to start game",width/4,height/3,width/2,height/2*3);
			if (isPressed(10)) {
				pauseMenu = false;
			}
		}
		else if (startMenu) {
			background(200);
			textSize(40);
			text("Lunatic's Resolve", width/4,height/4,width/2,height/2);
			textSize(30);
			text("Press SPACE to start game",width/4,height/3,width/2,height/2*3);
			if (isPressed(32)) {
				startMenu = false;
			}
		}
		else {
			clear();
			
			//somehow add black bars in the game - set the Game's dimensions to 
			//fit within these black bars
			//plan: 50 on the left of game1, 50 in middle, 50 on the right of
			//		game2, 50 on top, 100 at bottom for statistics (within game
			//		x bounds also)
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
