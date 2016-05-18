package vokabelspiel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Gameplay {

	Spielfeld feld = new Spielfeld();
	
	/**
	 * Launch the application.
	 */
	
	public void main(String[] args) {
		feld.invoke();
	}
}