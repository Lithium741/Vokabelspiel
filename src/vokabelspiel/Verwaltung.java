package vokabelspiel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class Verwaltung {

	public static ArrayList<Vokabel> vokabeln = new ArrayList<Vokabel>();
	
	public static String setEnglisch() {
		for (Vokabel temp : vokabeln) {
			return temp.getEnglisch() + "\n";
		}
		return "";
	}

	// speichern/hinzufügen einer neuen Vokabel
	public static String speichern(JTextField wortA, JTextField wortB, String a, int b) {
		if (b == 0) {
			vokabeln.add(new Vokabel(wortA.getText(), wortB.getText(), a));
			return "Gespeichert";
		} else {
			return "Nicht gespeichert";
		}
	}

	public static String loeschen(JTextField wort, int b) {
		for (Vokabel temp : vokabeln) {
			if (temp.getDeutsch().equals(wort.getText())) {
				if (b == 0) {
					vokabeln.remove(temp);
					return temp.getDeutsch() + " = " + temp.getEnglisch() + " gelöscht!";
				} else {

				}
			} else if (temp.getEnglisch().equals(wort.getText())) {
				if (b == 0) {
					vokabeln.remove(temp);
					return temp.getDeutsch() + " = " + temp.getEnglisch() + " gelöscht!";
				} else {

				}
			} else {
			}
		}
		return "Wort nicht gefunden";
	}

	public static String dateiLaden(int a, File file) {
		Scanner s = null;
		if (a == JFileChooser.APPROVE_OPTION) {
			try {
				s = new Scanner(file);
				s.useDelimiter("\n");
			} catch (FileNotFoundException e) {
				return "NoSuchElementException: " + e.getCause();
			}
		} else {
			return "";

		}
		while (s.hasNext()) {
			try {
				String[] x = s.next().split(",");
				Vokabel temp = new Vokabel(x[0], x[1], x[2]);
				vokabeln.add(temp);
			} catch (NoSuchElementException e) {

			}
		}
		s.close();
		return file.getName() + " geladen";
	}

	public static String dateiSpeichern(int a, File file) {
		try {
			if (a == JFileChooser.APPROVE_OPTION) {
				FileWriter writer = new FileWriter(file);
				for (Vokabel temp : vokabeln) {
					writer.write(temp.getEnglisch() + "," + temp.getDeutsch() + "," + temp.getKategorie());
					writer.write("\r\n");
				}
				writer.close();
			} else {
				return "";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Gespeichert";
	}
}
