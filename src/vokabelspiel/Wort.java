package vokabelspiel;

import java.awt.Color;
import java.awt.Graphics2D;
/**
 * Wort-Klasse
 * Wörter, die aufgefangen werden müssen
 * 
 * @author Manuel S., Mareen B., Alex B., Kevin K.
 *
 */
public class Wort {
	private int y = 30;
	private int x;
	private String wort;

	/**
	 * Konstruktor
	 * 
	 * @param feld
	 * @param x
	 * @param wort
	 */
	public Wort( int x, String wort) {
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
}
