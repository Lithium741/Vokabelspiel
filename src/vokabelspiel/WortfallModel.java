package vokabelspiel;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class WortfallModel {

	public static void move(Wort wort) {
		int y = wort.getY();
		y += 2;
		if (y >= 500) {
			y = 30;
		}
		wort.setY(y);
	}
	
	public static void move(int a, Balken balken) {
		int x = balken.getX();
		int xa = balken.getXa();
		if (x + xa > 0 && x + xa < a - 60) {
			balken.setX(balken.getX() + xa);
		}
	}
	
	public static void balkenKeyPressed(KeyEvent e, Balken balken) {
		int xa = 0;
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			xa = -6;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xa = 6;
		}
		balken.setXa(xa);
	}
	
	public static void balkenKeyReleased(KeyEvent e, Balken balken) {
		int xa = 0;
		balken.setXa(xa);
	}
	
	public static Rectangle getBounds(int x, int y, int WIDTH, int HEIGHT) {
		return new Rectangle(x, y - 20, WIDTH, HEIGHT);
	}
}
