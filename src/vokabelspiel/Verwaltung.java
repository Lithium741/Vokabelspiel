package vokabelspiel;

import java.util.ArrayList;

import javax.swing.JTextField;

public class Verwaltung {

	public static ArrayList<Vokabel> vokabeln = new ArrayList<Vokabel>();
//speichern/hinzufügen einer neuer Vokabel
	public static  String speichern(JTextField wortA, JTextField wortB, int a, int b) {
		if(b ==0){
			vokabeln.add(new Vokabel(wortA.getText(),wortB.getText(),a));
			return "Gespeichert";
		}else {
			return "Nicht gespeichert";
		}
	}
}
