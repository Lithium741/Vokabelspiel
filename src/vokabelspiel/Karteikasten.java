package vokabelspiel;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Karteikasten {
	private static int a = (int) (Math.random() * (Verwaltung.vokabeln.size() - 1));
	private static int b = (int) (Math.random() * 11);

	public static String getRandomVokabel() {
		if ((b % 2) == 1) {
			// stellt sicher, dass das Wort nicht im dritten Fach ist.
			if (Verwaltung.vokabeln.get(a).getFach() > 3) {
				a = (int) (Math.random() * (Verwaltung.vokabeln.size() - 1));
				return getRandomVokabel();
			}
			return Verwaltung.vokabeln.get(a).getDeutsch();
		} else if ((b % 2) != 1) {
			if (Verwaltung.vokabeln.get(a).getFach() > 3) {
				a = (int) (Math.random() * (Verwaltung.vokabeln.size() - 1));
				return getRandomVokabel();
			}
			return Verwaltung.vokabeln.get(a).getEnglisch();
		} else {
			return "";
		}
	}

	public static String pruefen(JTextField wort) {
		if ((b % 2) == 1) {
			if (wort.getText().equals(Verwaltung.vokabeln.get(a).getEnglisch())) {
				Verwaltung.vokabeln.get(a).sprung();
				return "Richtig!" + "\n" + Verwaltung.vokabeln.get(a).getDeutsch() + " = "
						+ Verwaltung.vokabeln.get(a).getEnglisch();
			} else {
				return "Falsch" + "\n" + Verwaltung.vokabeln.get(a).getDeutsch() + " = "
						+ Verwaltung.vokabeln.get(a).getEnglisch();
			}
		} else if ((b % 2) != 1) {
			if (wort.getText().equals(Verwaltung.vokabeln.get(a).getDeutsch())) {
				Verwaltung.vokabeln.get(a).sprung();
				return "Richtig!" + "\n" + Verwaltung.vokabeln.get(a).getDeutsch() + " = "
						+ Verwaltung.vokabeln.get(a).getEnglisch();
			} else {
				return "Falsch" + "\n" + Verwaltung.vokabeln.get(a).getDeutsch() + " = "
						+ Verwaltung.vokabeln.get(a).getEnglisch();
			}
		} else {
			return "";
		}
	}

	public static void neuesWort() {
		a = (int) (Math.random() * (Verwaltung.vokabeln.size() - 1));
		b = (int) (Math.random() * 11);
	}

	public static int getA() {
		return a;
	}

	public static int getB() {
		return b;
	}
}
