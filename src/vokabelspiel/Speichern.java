package vokabelspiel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Speichern-Klasse 
 * Erstellt das Fenster und regelt den Ablauf der
 * Speichern-Funktion des Programms
 * 
 * @author Manuel S., Mareen B., Alex B., Kevin K.
 *
 */
public class Speichern extends JFrame {

	private JPanel contentPane;
	private JTextField txtDeutschesWort;
	private JTextField txtEnglischesWort;
	private String a;
	private int b = 0;

	/**
	 * startet das Fenster
	 */
	public static void invoke() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Speichern frame = new Speichern();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Kreiert das Fenster
	 */
	public Speichern() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtDeutschesWort = new JTextField();
		txtDeutschesWort.setText(Start.getBundle().getString("dWort"));
		txtDeutschesWort.setBounds(10, 23, 86, 20);
		contentPane.add(txtDeutschesWort);
		txtDeutschesWort.setColumns(10);

		txtEnglischesWort = new JTextField();
		txtEnglischesWort.setText(Start.getBundle().getString("eWort"));
		txtEnglischesWort.setBounds(10, 59, 86, 20);
		contentPane.add(txtEnglischesWort);
		txtEnglischesWort.setColumns(10);

		JRadioButton rdbtnAlltag = new JRadioButton(Start.getBundle().getString("alltag"));
		rdbtnAlltag.setBounds(150, 22, 109, 23);
		contentPane.add(rdbtnAlltag);

		JRadioButton rdbtnNatur = new JRadioButton(Start.getBundle().getString("natur"));
		rdbtnNatur.setBounds(150, 48, 109, 23);
		contentPane.add(rdbtnNatur);

		JRadioButton rdbtnFahrzeuge = new JRadioButton(Start.getBundle().getString("fahrzeuge"));
		rdbtnFahrzeuge.setBounds(150, 74, 109, 23);
		contentPane.add(rdbtnFahrzeuge);

		JRadioButton rdbtnLebensmittel = new JRadioButton(Start.getBundle().getString("lebensmittel"));
		rdbtnLebensmittel.setBounds(150, 104, 109, 23);
		contentPane.add(rdbtnLebensmittel);

		JRadioButton rdbtnFachbegriffe = new JRadioButton(Start.getBundle().getString("fachbegriffe"));
		rdbtnFachbegriffe.setBounds(150, 130, 109, 23);
		contentPane.add(rdbtnFachbegriffe);

		/* Gruppiert die radiobuttnos, damit nur einer ausgewählt werden kann */
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnAlltag);
		group.add(rdbtnNatur);
		group.add(rdbtnFahrzeuge);
		group.add(rdbtnLebensmittel);
		group.add(rdbtnFachbegriffe);

		/*
		 * Speichert die Eingaben in einer neuen Vokabel (neues Vokabel-Objekt
		 * in der Arraylist)
		 */
		JButton btnSpeichern = new JButton(Start.getBundle().getString("speichern"));
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnAlltag.isSelected()) {
					a = "alltag";
				} else if (rdbtnNatur.isSelected()) {
					a = "natur";
				} else if (rdbtnFahrzeuge.isSelected()) {
					a = "fahrzeuge";
				} else if (rdbtnLebensmittel.isSelected()) {
					a = "lebensmittel";
				} else if (rdbtnFachbegriffe.isSelected()) {
					a = "fachbegriffe";
				}

				/*
				 * Prüft, ob ein radiobutton ausgewählt wurde
				 */
				if (rdbtnAlltag.isSelected() == true || rdbtnNatur.isSelected() == true
						|| rdbtnFahrzeuge.isSelected() == true || rdbtnLebensmittel.isSelected() == true
						|| rdbtnFachbegriffe.isSelected() == true) {
					b = JOptionPane.showOptionDialog(null,
							Start.getBundle().getString("speichern") + "?" + "\n" + txtEnglischesWort.getText() + " = "
									+ txtDeutschesWort.getText(),
							"Speichern", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
							new String[] { Start.getBundle().getString("ja"), Start.getBundle().getString("nein") },
							Start.getBundle().getString("nein"));
					JOptionPane.showMessageDialog(null,
							Verwaltung.speichern(txtEnglischesWort, txtDeutschesWort, a, b));

					/* Fehlermeldung, wenn kein Radiobutton ausgewählt wurde */
				} else if (rdbtnAlltag.isSelected() == false && rdbtnNatur.isSelected() == false
						&& rdbtnFahrzeuge.isSelected() == false && rdbtnLebensmittel.isSelected() == false
						&& rdbtnFachbegriffe.isSelected() == false) {
					JOptionPane.showMessageDialog(null, Start.getBundle().getString("wählKat"));
				}

				/* aktualisiert die Listen */
				Start.list.removeAll();
				Start.list_1.removeAll();
				for (Vokabel temp : Verwaltung.vokabeln) {
					Start.list.add(temp.getEnglisch());
					Start.list_1.add(temp.getDeutsch());
				}
			}
		});
		btnSpeichern.setBounds(7, 104, 89, 23);
		contentPane.add(btnSpeichern);
	}

	/**
	 * getter und setter
	 */
	public JTextField getTxtDeutschesWort() {
		return txtDeutschesWort;
	}

	public void setTxtDeutschesWort(JTextField txtDeutschesWort) {
		this.txtDeutschesWort = txtDeutschesWort;
	}

	public JTextField getTxtEnglischesWort() {
		return txtEnglischesWort;
	}

	public void setTxtEnglischesWort(JTextField txtEnglischesWort) {
		this.txtEnglischesWort = txtEnglischesWort;
	}
}
