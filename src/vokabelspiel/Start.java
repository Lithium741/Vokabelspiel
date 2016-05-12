package vokabelspiel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;

public class Start extends JFrame {

	private JPanel contentPane;
	private JFileChooser fc;
	private int a;

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
					// f�ngt Fehlermeldung ab damit das Programm weiterl�uft
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
		// erstellen Panel,auf den sp�ter die Elemente gezogen werden (Fenster
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

		JButton btnSpiel = new JButton("Karteikasten");// Erster Button
		btnSpiel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vokabelkasten.invoke();
			}
		});
		btnSpiel.setBounds(10, 11, 117, 29);
		Spiele.add(btnSpiel);// Gelegt in den Panel "Spiele"

		JButton btnSpiel2 = new JButton("Wortfall");
		btnSpiel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Spielfeld.newRnd();
				Wortfall.invoke();
			}
		});
		btnSpiel2.setBounds(10, 71, 117, 29);
		Spiele.add(btnSpiel2);

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
				fc = new JFileChooser();
				a = fc.showOpenDialog(null);
				try {
					JOptionPane.showMessageDialog(null,
							vokabelspiel.Verwaltung.dateiSpeichern(a, fc.getSelectedFile()));
				} catch (NullPointerException f) {

				}
			}
		});
		btnDateiSpeichern.setBounds(10, 134, 133, 29);
		Verwaltung.add(btnDateiSpeichern);

		JButton btnDateiLaden = new JButton("Datei Laden");
		btnDateiLaden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fc = new JFileChooser();
				a = fc.showOpenDialog(null);
				int b = JOptionPane.showOptionDialog(null, "Alte Liste �berschreiben?", "Datei laden",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[] { "Ja", "Nein" },
						"Nein");
				try {
					if (b == 0) {
						vokabelspiel.Verwaltung.vokabeln.clear();
						JOptionPane.showMessageDialog(null,
								vokabelspiel.Verwaltung.dateiLaden(a, fc.getSelectedFile()));
					} else {
						JOptionPane.showMessageDialog(null,
								vokabelspiel.Verwaltung.dateiLaden(a, fc.getSelectedFile()));
					}
				} catch (NullPointerException e) {

				}
			}
		});
		btnDateiLaden.setBounds(10, 188, 133, 29);
		Verwaltung.add(btnDateiLaden);
	}
}
