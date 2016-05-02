package vokabelspiel;

import java.util.ArrayList;

public class Verwaltung {

	public static ArrayList<Vokabel> vokabeln = new ArrayList<Vokabel>();
	static String a = "affe";

	public static String uebersetzen() {
		for (Vokabel temp : vokabeln) {
			if (temp.getEnglisch().equals("affe")) {
				return temp.getDeutsch();
			}
		}
		return "Wort nicht gefunden";
	}
}
