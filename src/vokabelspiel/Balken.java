package vokabelspiel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Balken {
	private static final int Y = 480;
	private static final int WIDTH = 45;
	private static final int HEIGHT = 10;
	private int x = 0;
	private int xa = 0;
	private Spielfeld feld;

	public Balken(Spielfeld feld) {
		this.feld = feld;
	}

	public void move() {
		if (x + xa > 0 && x + xa < feld.getWidth() - 60) {
			x += xa;
		}
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, Y, WIDTH, HEIGHT);
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			xa = -6;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xa = 6;
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, Y, WIDTH, HEIGHT);
	}
}
