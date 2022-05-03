import java.util.ArrayList;

import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	private ArrayList<Integer> keys;
	private Game game1, game2;
	private boolean startMenu;
	public DrawingSurface() {
		keys = new ArrayList<Integer>();
		game1 = new Game(1);
		game2 = new Game(2);
		startMenu = false;
	}
	
	public void setup() {
		
	}
	
	public void draw() {
		if (isPressed(1)) {
			startMenu = true;
		}
		if (startMenu) {
			rect(0,0,100,100);
		}
		else {
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
			keys.remove(new Integer(keyCode));
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
	
}
