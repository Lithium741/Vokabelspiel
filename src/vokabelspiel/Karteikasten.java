package vokabelspiel;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Karteikasten-Klasse 
 * Funktioneller Teil des Karteikasten-Spiels
 * @author Manuel S., Mareen B., Alex B., Kevin K.
 *
 */
public class Karteikasten {
	/*
	 * generiert 2 Zufallszahlen, a für die Wahl der Vokabel und b für die Wahl
	 * der Sprache
	 */
	private static int a = (int) (Math.random() * (Verwaltung.vokabeln.size() - 1));
	private static int b = (int) (Math.random());

	/**
	 * Gibt eine Zufällige Vokabel in einer Zufälligen Sprache
	 * 
	 * @return String
	 */
	public static String getRandomVokabel() {
		if ((b % 2) == 0) {
			/*
			 * Stellt sicher, dass das Wort nicht im dritten Fach ist
			 */
			if (Verwaltung.vokabeln.get(a).getFach() > 3) {
				a = (int) (Math.random() * (Verwaltung.vokabeln.size() - 1));
				return getRandomVokabel();
			}
			return Verwaltung.vokabeln.get(a).getDeutsch();
		} else if ((b % 2) != 0) {
			if (Verwaltung.vokabeln.get(a).getFach() > 3) {
				a = (int) (Math.random() * (Verwaltung.vokabeln.size() - 1));
				return getRandomVokabel();
			}
			return Verwaltung.vokabeln.get(a).getEnglisch();
		} else {
			return "";
		}
	}

	/**
	 * Prüft, ob die eingegebene Übersetzung mit der Übersetzung der
	 * vorgegebenen Vokabel übereinstimmt und ruft die sprung-Methode der
	 * Vokabel auf, wenn sie richtig übersetzt wurde.
	 * 
	 * @param wort
	 * @return String
	 */
	public static String pruefen(JTextField wort) {
		if ((b % 2) == 0) {
			if (wort.getText().equals(Verwaltung.vokabeln.get(a).getEnglisch())) {
				Verwaltung.vokabeln.get(a).sprung();
				return "Richtig!" + "\n" + Verwaltung.vokabeln.get(a).getDeutsch() + " = "
						+ Verwaltung.vokabeln.get(a).getEnglisch();
			} else {
				return "Falsch" + "\n" + Verwaltung.vokabeln.get(a).getDeutsch() + " = "
						+ Verwaltung.vokabeln.get(a).getEnglisch();
			}
		} else if ((b % 2) != 0) {
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

	/**
	 * generiert ein neue Zufallswerte
	 */
	public static void neuesWort() {
		a = (int) (Math.random() * (Verwaltung.vokabeln.size() - 1));
		b = (int) (Math.random() * 11);
	}

	/**
	 * getter und setter
	 */
	public static int getA() {
		return a;
	}

	public static int getB() {
		return b;
	}
}
