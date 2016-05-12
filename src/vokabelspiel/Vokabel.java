package vokabelspiel;

public class Vokabel {

	private String englisch;
	private String deutsch;
	private String kategorie;
	private int fach = 0;
	private int zaehler = 0;

	public Vokabel(String englisch, String deutsch, String kategorie) {
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
	
	public String rndLang(int a) {
		if ((a % 2) == 0) {
			return englisch;
		}else if ((a % 2) != 0){
			return deutsch;
		} else {
			return "";
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

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
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
