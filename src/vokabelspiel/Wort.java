package vokabelspiel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class Wort extends JPanel{
	private static final int WIDTH = 200;
	private static final int HEIGHT = 15;
	private int y = 30;
	private int x;
	private String wort;

	public Wort(int x, String wort) {
		this.x = x;
		this.wort = wort;
	}

	public void move() {
		y += 2;
		if (y >= 500) {
			y = 30;
		}
	}

	public void paint(Graphics2D g, String wort) {
		g.setColor(Color.BLACK);
		g.drawString(wort, x, y);
	}
	
	public Rectangle getBounds(int x) {
		return new Rectangle(x, y - 20, WIDTH, HEIGHT);
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public String getWort() {
		return wort;
	}

	public void setWort(String wort) {
		this.wort = wort;
	}
}
