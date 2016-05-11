package vokabelspiel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Spielfeld extends JPanel {
	private int y = 0;
	private int x = 5;
	Wort wort1 = new Wort(this, 5);
	Wort wort2 = new Wort(this, 155);
	Wort wort3 = new Wort(this, 305);
	Wort wort4 = new Wort(this, 455);
	Balken balken = new Balken(this);
	private static int a = (int) (Math.random() * (Verwaltung.vokabeln.size() - 1));
	private static int b = (int) (Math.random() * (Verwaltung.vokabeln.size() - 1));
	private static int c = (int) (Math.random() * (Verwaltung.vokabeln.size() - 1));
	private static int d = (int) (Math.random() * (Verwaltung.vokabeln.size() - 1));
	private static int e = (int) (Math.random() * 4);
	private static int z = (int) (Math.random() * 11);

	private String getWort(int a) {
		if ((z % 2) == 1) {
			return Verwaltung.vokabeln.get(a).getDeutsch();
		} else if ((z % 2) != 1) {
			return Verwaltung.vokabeln.get(a).getEnglisch();
		} else {
			return "";
		}
	}

	public Spielfeld() {
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

	public void move() {
		wort1.move();
		wort2.move();
		wort3.move();
		wort4.move();
		balken.move();
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		wort1.paint(g2d, "wort");
		wort2.paint(g2d, "wort");
		wort3.paint(g2d, "wort");
		wort4.paint(g2d, "wort");
		balken.paint(g2d);
	}
}
