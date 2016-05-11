package vokabelspiel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Wort {
	private static final int WIDTH = 50;
	private static final int HEIGHT = 15;
	int y = 0;
	int x;
	private Spielfeld feld;
	
	public Wort(Spielfeld feld, int x) {
		this.feld = feld;
		this.x = x;
	}
	
	public void move() {
		y++;
		if (collision()) {
			
		}
	}
	
	public void paint(Graphics2D g, String wort) {
		g.setColor(Color.GREEN);
		g.drawString(wort, x, y);
	}
	
	public boolean collision() {
		return feld.balken.getBounds().intersects(getBounds(x));
	}
	
	public Rectangle getBounds(int x) {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
}
