package vokabelspiel;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Wort extends JPanel {
	private static final int WIDTH = 200;
	private static final int HEIGHT = 15;
	private int y;
	private int x;
	private String wort;

	public Wort() {
	}

	/**
	 * Paint methode: zeichnet ein Wort
	 */
	public void paint(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.drawString(wort, x, y);
	}

	/**
	 * Getter und Setter
	 */
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
