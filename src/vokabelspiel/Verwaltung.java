package vokabelspiel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Verwaltung-Klasse Funktioneller Teil des Hauptprogrammes
 * 
 * @author Manuel S., Mareen B., Alex B., Kevin K.
 *
 */
public class Verwaltung {

	/* Arraylist mit den Vokabel-Objekten */
	public static ArrayList<Vokabel> vokabeln = new ArrayList<Vokabel>();

	/**
	 * speichern/hinzuf�gen einer neuen Vokabel
	 */
	public static String speichern(JTextField wortA, JTextField wortB, String a, int b) {
		if (b == 0) {
			vokabeln.add(new Vokabel(wortA.getText(), wortB.getText(), a));
			return Start.getBundle().getString("gespeichert");
		} else {
			return Start.getBundle().getString("nGespeichert");
		}
	}

	/**
	 * L�schen eines Vokabel-Objektes aus der Arraylist
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static String loeschen(String a, int b) {
		for (Vokabel temp : vokabeln) {
			if (temp.getEnglisch().equals(a)) {
				if (b == 0) {
					vokabeln.remove(temp);
					/* aktualisiert die Listen */
					Start.list.removeAll();
					Start.list_1.removeAll();
					for (Vokabel temp1 : Verwaltung.vokabeln) {
						Start.list.add(temp1.getEnglisch());
						Start.list_1.add(temp1.getDeutsch());
					}
					return temp.getDeutsch() + " = " + temp.getEnglisch() + " " + Start.getBundle().getString("gel�scht");
				} else {

				}
			}
		}
		return Start.getBundle().getString("nichtGefunden");
	}

	/**
	 * L�dt Vokabel-Objekte aus der Ausgew�lten Text-Datei
	 * 
	 * @param a
	 * @param file
	 * @return
	 */
	public static String dateiLaden(int a, File file) {
		Scanner s = null;
		if (a == JFileChooser.APPROVE_OPTION) {
			try {
				/* startet den scanner, der die Datei liest */
				s = new Scanner(file);
				/* setzt Zeilenumbruch als Trennzeichen */
				s.useDelimiter("\n");
			} catch (FileNotFoundException e) {
				return "NoSuchElementException: " + e.getCause();
			}
		} else {
			return "";

		}
		/*
		 * liest die Datei und f�hrt funktionen aus, solange die Datei noch
		 * Eintr�ge hat
		 */
		while (s.hasNext()) {
			try {
				/* trennt die Zeile an den Kommas */
				String[] x = s.next().split(",");
				/*
				 * Schreibt die an den Kommas getrennten Eintr�ge in ein neues
				 * Vokabel-Objekt und f�gt dieses der Arraylist hinzu
				 */
				Vokabel temp = new Vokabel(x[0], x[1], x[2]);
				vokabeln.add(temp);
			} catch (NoSuchElementException e) {

			}
		}
		/* schlie�t den scanner */
		s.close();
		/* aktualisiert die Listen */
		Start.list.removeAll();
		Start.list_1.removeAll();
		for (Vokabel temp : Verwaltung.vokabeln) {
			Start.list.add(temp.getEnglisch());
			Start.list_1.add(temp.getDeutsch());
		}
		return file.getName() + " " + Start.getBundle().getString("geladen");
	}

	/**
	 * Speichert die Eintr�ge der Arraylist in einer Datei
	 * 
	 * @param a
	 * @param file
	 * @return
	 */
	public static String dateiSpeichern(int a, File file) {
		try {
			if (a == JFileChooser.APPROVE_OPTION) {
				/* erstellt einen neuen Filewriter */
				FileWriter writer = new FileWriter(file);
				/*
				 * schreibt jedes Vokabel-Objekt in eine Separate Zeile;
				 * Englisch, Deutsch und Kategorie durch Kommas getrennt
				 */
				for (Vokabel temp : vokabeln) {
					writer.write(temp.getEnglisch() + "," + temp.getDeutsch() + "," + temp.getKategorie());
					writer.write("\r\n");
				}
				/* schlie�t den Filewriter */
				writer.close();
			} else {
				return "";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		/* aktualisiert die Listen */
		Start.list.removeAll();
		Start.list_1.removeAll();
		for (Vokabel temp : Verwaltung.vokabeln) {
			Start.list.add(temp.getEnglisch());
			Start.list_1.add(temp.getDeutsch());
		}
		return Start.getBundle().getString("gespeichert");
	}
}
