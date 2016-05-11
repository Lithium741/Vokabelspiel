package vokabelspiel;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Karteikasten {
	private static int a = (int) (Math.random() * (Verwaltung.vokabeln.size()-1));
	private static int b = (int) (Math.random() * 11);
	
	public static String getRandomVokabel() {
		if ((b % 2) == 1) {
			return Verwaltung.vokabeln.get(a).getDeutsch();
		} else if ((b % 2) != 1) {
			return Verwaltung.vokabeln.get(a).getEnglisch();
		} else {
			return "";
		}
	}

	public static int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public static int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
}
