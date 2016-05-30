package vokabelspiel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 * Balken-Klasse
 * Balken, mit dem die Wörter aufgefangen werden
 * 
 * @author Manuel
 *
 *
 */
public class Balken {
	private static final int Y = 480;
	private static final int WIDTH = 45;
	private static final int HEIGHT = 10;
	private int column = 1;
	private int x = 10;

	/**
	 * Konstruktor
	 * 
	 * @param feld
	 */
	public Balken() {
	}

	/**
	 * zeichnet ein schwarzes Rechteck
	 * 
	 * @param g
	 */
	public void paint(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, Y, WIDTH, HEIGHT);
	}

	/**
	 * Bewegt den Balken durch die Spalten (column) wenn eine Pfeiltaste
	 * gedrückt wird, indem der x-Wert verändert wird
	 * 
	 * @param e
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (x > 10) {
				x -= 201;
				column--;
			} else {
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (x < 613) {
				x += 201;
				column++;
			} else {
			}
		}
	}

	/**
	 * getter und setter
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, Y, WIDTH, HEIGHT);
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
}
