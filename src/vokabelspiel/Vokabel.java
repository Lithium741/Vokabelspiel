package vokabelspiel;

public class Vokabel {

	private String englisch;
	private String deutsch;
	private int kategorie;
	private int fach = 0;
	private int zaehler = 0;

	public Vokabel(String englisch, String deutsch, int kategorie) {
		this.englisch = englisch;
		this.deutsch = deutsch;
		this.kategorie = kategorie;
	}

	public void sprung() {
		if (zaehler == 3) {
			fach = 4;
		} else if (fach == 3) {
			zaehler += 1;
		} else if (fach < 3) {
			fach += 1;
		}

	}

	public String getEnglisch() {
		return englisch;
	}

	public void setEnglisch(String englisch) {
		this.englisch = englisch;
	}

	public String getDeutsch() {
		return deutsch;
	}

	public void setDeutsch(String deutsch) {
		this.deutsch = deutsch;
	}

	public int getKategorie() {
		return kategorie;
	}

	public void setKategorie(int kategorie) {
		this.kategorie = kategorie;
	}

	public int getFach() {
		return fach;
	}

	public void setFach(int fach) {
		this.fach = fach;
	}

	public int getZaehler() {
		return zaehler;
	}

	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
	}
}
