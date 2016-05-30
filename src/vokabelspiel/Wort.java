package vokabelspiel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Wort-Klasse
 * Wörter, die aufgefangen werden müssen
 * 
 * @author Manuel S., Mareen B., Alex B., Kevin K.
 *
 */
public class Wort {
	private static final int WIDTH = 200;
	private static final int HEIGHT = 15;
	private int y = 30;
	private int x;
	private Spielfeld feld;
	private String wort;

	/**
	 * Konstruktor
	 * 
	 * @param feld
	 * @param x
	 * @param wort
	 */
	public Wort(Spielfeld feld, int x, String wort) {
		this.feld = feld;
		this.x = x;
		this.wort = wort;
	}

	/**
	 * bewegt das Wort abwärts
	 */
	public void move() {
		y += 2;
	}

	/**
	 * Zeichnet das wort
	 * 
	 * @param g
	 * @param wort
	 */
	public void paint(Graphics2D g, String wort) {
		g.setColor(Color.BLACK);
		g.drawString(wort, x, y);
	}

	/**
	 * getter und setter
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

	public Spielfeld getFeld() {
		return feld;
	}

	public void setFeld(Spielfeld feld) {
		this.feld = feld;
	}

	public String getWort() {
		return wort;
	}

	public void setWort(String wort) {
		this.wort = wort;
	}

	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}
}
