package vokabelspiel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Spielfeld-Klasse
 * regelt den Ablauf des Spiels
 * 
 * @author Manuel S., Mareen B., Alex B., Kevin K.
 *
 */
public class Spielfeld extends JPanel {
	Wortfall wFall;
	private int y = 0;
	private int x = 5;
	private static int score = 0;
	private static int life = 20;
	private static int a;
	private static int b;
	private static int c;
	private static int d;
	private static int z;
	private static Random rand = new Random();
	private Wort wort1;
	private Wort wort2;
	private Wort wort3;
	private Wort wort4;
	private Balken balken = new Balken();
	private static int e = rand.nextInt(4) + 1;

	/**
	 * generiert eine neue Zufallszahl
	 */
	public static void setRand() {

		e = rand.nextInt(4) + 1;
	}

	/**
	 * Konstruktor
	 * 
	 * @param wFall
	 */
	public Spielfeld(Wortfall wFall) {
		this.wFall = wFall;
		try {

			wort1 = new Wort(this, 10, Verwaltung.vokabeln.get(a).rndLang(z));
			wort2 = new Wort(this, 211, Verwaltung.vokabeln.get(b).rndLang(z));
			wort3 = new Wort(this, 412, Verwaltung.vokabeln.get(c).rndLang(z));
			wort4 = new Wort(this, 613, Verwaltung.vokabeln.get(d).rndLang(z));
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, Start.getBundle().getString("keineVok"));
			wFall.dispose();
		}
		/* keyListener der die Tastendrücke abfängt */
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				balken.keyPressed(e);
			}
		});
		setFocusable(true);
	}

	/**
	 * generiert neue Zufallszahlen
	 */
	public static void newRnd() {
		try {
		a = (int) (Math.random() * (Verwaltung.vokabeln.size() - 1));
		b = (int) (Math.random() * (Verwaltung.vokabeln.size() - 1));
		c = (int) (Math.random() * (Verwaltung.vokabeln.size() - 1));
		d = (int) (Math.random() * (Verwaltung.vokabeln.size() - 1));
		z = (int) (Math.random());
		} catch (IndexOutOfBoundsException e) {
		}
	}

	/**
	 * bewegt die Wörter auf dem Spielfeld und regelt die Kollisionsabfrage
	 */
	public void move() {
		wort1.move();
		wort2.move();
		wort3.move();
		wort4.move();
		if (wort1.getY() >= 480) {
			/*
			 * erhöht den Score bei richtiger Wahl und aktualisiert das Textfeld
			 */
			if (balken.getColumn() == Wortfall.getColumn()) {
				score++;
				setRand();
				wFall.getTxtrScore().setText("Score: " + score);
				reset();
			/*
			 * verringert das Leben bei falscher Auswahl und aktualisiert
			 * die Progressbar
			 */
			} else {
				life -= 2;
				setRand();
				wFall.getProgressBar().setValue(life);
				reset();
			}
		}
	}

	/**
	 * setzt die Position der Wörter zurück und ruft newRnd() auf, um neue
	 * Wörter zu bekommen
	 */
	public void reset() {
		wort1.setY(30);
		wort2.setY(30);
		wort3.setY(30);
		wort4.setY(30);
		newRnd();
	}

	/**
	 * gibt zufällige Wörter aus der Arraylist in Verwaltung und weist diesen
	 * eine Spalte (column) zu
	 * 
	 * @param a
	 * @return String
	 */
	public static String getWort(int a) {
		try {
		switch (a) {
		case 1:
			Wortfall.setColumn(1);
			return Verwaltung.vokabeln.get(a).rndLang(z - 1);
		case 2:
			Wortfall.setColumn(2);
			return Verwaltung.vokabeln.get(b).rndLang(z - 1);
		case 3:
			Wortfall.setColumn(3);
			return Verwaltung.vokabeln.get(c).rndLang(z - 1);
		case 4:
			Wortfall.setColumn(4);
			return Verwaltung.vokabeln.get(d).rndLang(z - 1);
		}
		return "";
		} catch (IndexOutOfBoundsException e) {
			return e.toString();
		}
	}
	
	/**
	 * Zeichnet das Panel sowie die Wörter und den Balken
	 */
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		try {
			wort1.paint(g2d, Verwaltung.vokabeln.get(a).rndLang(z));
			wort2.paint(g2d, Verwaltung.vokabeln.get(b).rndLang(z));
			wort3.paint(g2d, Verwaltung.vokabeln.get(c).rndLang(z));
			wort4.paint(g2d, Verwaltung.vokabeln.get(d).rndLang(z));
		} catch (IndexOutOfBoundsException e) {
			wFall.dispose();
		}
		balken.paint(g2d);
	}

	/**
	 * getter und setter
	 */
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		Spielfeld.score = score;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		Spielfeld.life = life;
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

	public static int getA() {
		return a;
	}

	public static void setA(int a) {
		Spielfeld.a = a;
	}

	public static int getB() {
		return b;
	}

	public static void setB(int b) {
		Spielfeld.b = b;
	}

	public static int getC() {
		return c;
	}

	public static void setC(int c) {
		Spielfeld.c = c;
	}

	public static int getD() {
		return d;
	}

	public static void setD(int d) {
		Spielfeld.d = d;
	}

	public static int getZ() {
		return z;
	}

	public static void setZ(int z) {
		Spielfeld.z = z;
	}

	public static void setRand(Random rand) {
		Spielfeld.rand = rand;
	}

	public Wort getWort1() {
		return wort1;
	}

	public void setWort1(Wort wort1) {
		this.wort1 = wort1;
	}

	public Wort getWort2() {
		return wort2;
	}

	public void setWort2(Wort wort2) {
		this.wort2 = wort2;
	}

	public Wort getWort3() {
		return wort3;
	}

	public void setWort3(Wort wort3) {
		this.wort3 = wort3;
	}

	public Wort getWort4() {
		return wort4;
	}

	public void setWort4(Wort wort4) {
		this.wort4 = wort4;
	}

	public Balken getBalken() {
		return balken;
	}

	public void setBalken(Balken balken) {
		this.balken = balken;
	}

	public static int getRand() {

		return e;
	}
}
