package vokabelspiel;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Balken extends JPanel {
	private final int Y = 480;
	private final int WIDTH = 45;
	private final int HEIGHT = 10;
	private int x = 0;
	private int xa = 0;

	public Balken() {
	}

	/**
	 * Paint methode: zeichnet ein schwarzes Rechteck
	 */
	public void paint(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, Y, WIDTH, HEIGHT);
	}

	/**
	 * Getter und Setter
	 */
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getXa() {
		return xa;
	}

	public void setXa(int xa) {
		this.xa = xa;
	}
}
