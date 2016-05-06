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

public class Speichern extends JFrame {

	private JPanel contentPane;
	private JTextField txtDeutschesWort;
	private JTextField txtEnglischesWort;
	private String a;
	private int b = 0;

	/**
	 * Launch the application.
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
	 * Create the frame.
	 */
	public Speichern() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtDeutschesWort = new JTextField();
		txtDeutschesWort.setText("deutsches Wort");
		txtDeutschesWort.setBounds(10, 23, 86, 20);
		contentPane.add(txtDeutschesWort);
		txtDeutschesWort.setColumns(10);

		txtEnglischesWort = new JTextField();
		txtEnglischesWort.setText("englisches Wort");
		txtEnglischesWort.setBounds(10, 59, 86, 20);
		contentPane.add(txtEnglischesWort);
		txtEnglischesWort.setColumns(10);

		JRadioButton rdbtnAlltag = new JRadioButton("Alltag");
		rdbtnAlltag.setBounds(150, 22, 109, 23);
		contentPane.add(rdbtnAlltag);

		JRadioButton rdbtnNatur = new JRadioButton("Natur");
		rdbtnNatur.setBounds(150, 48, 109, 23);
		contentPane.add(rdbtnNatur);

		JRadioButton rdbtnFahrzeuge = new JRadioButton("Fahrzeuge");
		rdbtnFahrzeuge.setBounds(150, 74, 109, 23);
		contentPane.add(rdbtnFahrzeuge);

		JRadioButton rdbtnLebensmittel = new JRadioButton("Lebensmittel");
		rdbtnLebensmittel.setBounds(150, 104, 109, 23);
		contentPane.add(rdbtnLebensmittel);

		JRadioButton rdbtnFachbegriffe = new JRadioButton("Fachbegriffe");
		rdbtnFachbegriffe.setBounds(150, 130, 109, 23);
		contentPane.add(rdbtnFachbegriffe);

		ButtonGroup group = new ButtonGroup(); // Auswählen nur einer Kategorie
												// möglich
		group.add(rdbtnAlltag);
		group.add(rdbtnNatur);
		group.add(rdbtnFahrzeuge);
		group.add(rdbtnLebensmittel);
		group.add(rdbtnFachbegriffe);

		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnAlltag.isSelected()) {
					a = "Alltag";
				} else if (rdbtnNatur.isSelected()) {
					a = "Natur";
				} else if (rdbtnFahrzeuge.isSelected()) {
					a = "Fahrzeuge";
				} else if (rdbtnLebensmittel.isSelected()) {
					a = "Lebensmittel";
				} else if (rdbtnFachbegriffe.isSelected()) {
					a = "Fachbegriffe";
					// wenn einer der Knöpfe ausgewählt wurde --> normal im
					// Programm weitergehen
				}
				if (rdbtnAlltag.isSelected() == true || rdbtnNatur.isSelected() == true
						|| rdbtnFahrzeuge.isSelected() == true || rdbtnLebensmittel.isSelected() == true
						|| rdbtnFachbegriffe.isSelected() == true) {
					b = JOptionPane.showOptionDialog(null,
							txtEnglischesWort.getText() + " = " + txtDeutschesWort.getText() + " speichern?",
							"Speichern", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
							new String[] { "Ja", "Nein" }, "Nein");
					JOptionPane.showMessageDialog(null,
							Verwaltung.speichern(txtEnglischesWort, txtDeutschesWort, a, b));
					// wenn kein Knopf ausgewählt wurde PopUp Femster mit
					// Fehlermeldung
				} else if (rdbtnAlltag.isSelected() == false && rdbtnNatur.isSelected() == false
						&& rdbtnFahrzeuge.isSelected() == false && rdbtnLebensmittel.isSelected() == false
						&& rdbtnFachbegriffe.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Wählen Sie eine Kategorie aus!");
				}
			}
		});
		btnSpeichern.setBounds(7, 104, 89, 23);
		contentPane.add(btnSpeichern);
	}

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
