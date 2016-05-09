package vokabelspiel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;

public class Start extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					// erstellen Fenster
					frame.setVisible(true);
					// fängt Fehlermeldung ab damit das Programm weiterläuft
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 324);
		// erstellen Panel,auf den später die Elemente gezogen werden (Fenster
		// im Fenster)
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP); // Erstellen
																	// Tabbed
																	// Pane
																	// (versch.
																	// Tabs zB
																	// Spiel/Verwaltung)
		contentPane.add(tabbedPane);

		JPanel Spiele = new JPanel();// Neues Panel "Spiel"
		tabbedPane.addTab("Spiele", null, Spiele, null);
		Spiele.setLayout(null);

		JButton btnSpiel = new JButton("Spiel 1");// Erster Button
		btnSpiel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Spiele1GUI.invoke();
				for (Vokabel temp : Verwaltung.vokabeln) {
					System.out.println(temp.getDeutsch());
				}

			}
		});
		btnSpiel.setBounds(10, 11, 117, 29);
		Spiele.add(btnSpiel);// Gelegt in den Panel "Spiele"

		JPanel Verwaltung = new JPanel();
		tabbedPane.addTab("Verwaltung", null, Verwaltung, null);
		Verwaltung.setLayout(null);

		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Speichern.invoke();
			}
		});
		btnSpeichern.setBounds(10, 26, 133, 29);
		Verwaltung.add(btnSpeichern);

		JButton btnLschen = new JButton("L\u00F6schen");
		btnLschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Loeschen.invoke();
			}
		});
		btnLschen.setBounds(10, 80, 133, 29);
		Verwaltung.add(btnLschen);

		JButton btnDateiSpeichern = new JButton("Datei Speichern");
		btnDateiSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateiSpeichern.invoke();
			}
		});
		btnDateiSpeichern.setBounds(10, 134, 133, 29);
		Verwaltung.add(btnDateiSpeichern);

		JButton btnDateiLaden = new JButton("Datei Laden");
		btnDateiLaden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateiLaden.invoke();
			}
		});
		btnDateiLaden.setBounds(10, 188, 133, 29);
		Verwaltung.add(btnDateiLaden);
	}
}
