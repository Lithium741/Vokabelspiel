package vokabelspiel;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class WortfallModel {

	public int moveWort(int y) {
		y += 2;
		if (y >= 500) {
			y = 30;
		}
		return y;
	}
	
	public int moveBalken(int a, int x, int xa) {
		if (x + xa > 0 && x + xa < a - 60) {
			x += xa;
		}
		return x;
	}
	
	public int balkenKeyPressed(KeyEvent e, int xa) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			xa = -6;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xa = 6;
		}
		return xa;
	}
	
	public int balkenKeyReleased(KeyEvent e, int xa) {
		xa = 0;
		return xa;
	}
	
	public Rectangle getBounds(int x, int y, int WIDTH, int HEIGHT) {
		return new Rectangle(x, y - 20, WIDTH, HEIGHT);
	}
}
