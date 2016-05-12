package vokabelspiel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Spielfeld extends JPanel {
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
	private Balken balken = new Balken(this);
	private static int e = rand.nextInt(4) + 1;

	public static void setRand() {

		e = rand.nextInt(4) + 1;
	}

	public static int getRand() {

		return e;
	}

	public Spielfeld() {
		try {

			// Gamplay.setWords();
			wort1 = new Wort(this, 5, Verwaltung.vokabeln.get(a).rndLang(z));
			wort2 = new Wort(this, 205, Verwaltung.vokabeln.get(b).rndLang(z));
			wort3 = new Wort(this, 405, Verwaltung.vokabeln.get(c).rndLang(z));
			wort4 = new Wort(this, 605, Verwaltung.vokabeln.get(d).rndLang(z));
		} catch (IndexOutOfBoundsException e) {

		}
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				balken.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				balken.keyPressed(e);
			}
		});
		setFocusable(true);
	}

	public static void newRnd() {
		a = (int) (Math.random() * (Verwaltung.vokabeln.size() - 1));
		b = (int) (Math.random() * (Verwaltung.vokabeln.size() - 1));
		c = (int) (Math.random() * (Verwaltung.vokabeln.size() - 1));
		d = (int) (Math.random() * (Verwaltung.vokabeln.size() - 1));
		z = (int) (Math.random() * 11);
	}

	public void move() {
		wort1.move();
		wort2.move();
		wort3.move();
		if (wort4.move()) {

			setRand();
		}
		balken.move();

	}

	public void reset() {
		wort1.setY(30);
		wort2.setY(30);
		wort3.setY(30);
		wort4.setY(30);
		newRnd();
	}

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

		}
		balken.paint(g2d);
	}

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
}
