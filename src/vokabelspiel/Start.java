package vokabelspiel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import java.awt.Color;

/**
 * Start-Klasse 
 * startet das Programm und regelt die GUI zum gro�teil
 * 
 * @author Manuel S., Mareen B., Alex B., Kevin K.
 *
 */
@SuppressWarnings("serial")
public class Start extends JFrame {

	private JPanel contentPane;
	private JFileChooser fc;
	private int a;
	public static List list;
	public static List list_1;
	private JTextField suchen;

	/**
	 * Startet das Programm
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
	 * Kreiert das Fenster
	 */
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 486);
		// erstellen Panel,auf den sp�ter die Elemente gezogen werden (Fenster
		// im Fenster)
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);

		JPanel Verwaltung = new JPanel();
		tabbedPane.addTab("Verwaltung", null, Verwaltung, null);
		Verwaltung.setLayout(null);

		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* �ffnet das Speichern-Fenster */
				Speichern.invoke();
			}
		});
		btnSpeichern.setBounds(10, 26, 133, 29);
		Verwaltung.add(btnSpeichern);

		JButton btnLschen = new JButton("L\u00F6schen");
		btnLschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * fragt ab, ob die aktion ausgef�hrt werden soll und ruft dann
				 * die loeschen-Methode aus der Verwaltung-Klasse auf
				 */
				int a = JOptionPane.showOptionDialog(null, Start.list.getSelectedItem() + " wirklich l�schen?",
						"L�schen best�tigen", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
						new String[] { "Ja", "Nein" }, "Nein");
				JOptionPane.showMessageDialog(null, vokabelspiel.Verwaltung.loeschen(Start.list.getSelectedItem(), a));
			}
		});
		btnLschen.setBounds(10, 81, 133, 29);
		Verwaltung.add(btnLschen);

		JButton btnDateiSpeichern = new JButton("Datei Speichern");
		btnDateiSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* �ffnet einen Filechooser */
				fc = new JFileChooser();
				a = fc.showOpenDialog(null);
				try {
					/* F f�hrt dateiSpeichern aus */
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
				/* �ffnet einen Filechooser */
				fc = new JFileChooser();
				a = fc.showOpenDialog(null);
				/* Auswahldialog */
				int b = JOptionPane.showOptionDialog(null, "Alte Liste �berschreiben?", "Datei laden",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[] { "Ja", "Nein" },
						"Nein");
				try {
					/*
					 * wenn ja, l�d die Vokabeln aus der Datei und �berschreibt
					 * die alten Eintr�ge
					 */
					if (b == 0) {
						vokabelspiel.Verwaltung.vokabeln.clear();
						JOptionPane.showMessageDialog(null,
								vokabelspiel.Verwaltung.dateiLaden(a, fc.getSelectedFile()));
						/*
						 * wenn nein, l�dt die Vokabeln aus der Datei ohne die
						 * alten Eintrge zu �berschreiben
						 */
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

		list = new List();
		/*
		 * w�hlt das Gegenst�ck des Ausgew�hlten Eintrages in der anderen Liste
		 * aus
		 */
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					list_1.select(list.getSelectedIndex());
				}
			}
		});
		list.setBounds(149, 81, 225, 318);
		Verwaltung.add(list);

		list_1 = new List();
		/*
		 * w�hlt das Gegenst�ck des Ausgew�hlten Eintrages in der anderen Liste
		 * aus
		 */
		list_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					list.select(list_1.getSelectedIndex());
				}
			}
		});
		list_1.setBounds(380, 81, 225, 318);
		Verwaltung.add(list_1);

		suchen = new JTextField();
		suchen.setBounds(389, 11, 208, 20);
		Verwaltung.add(suchen);
		suchen.setColumns(10);

		JButton btnSuchen = new JButton("Suchen");
		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * w�hlt das Eingegebene Wort und dessen �bersetzung in den
				 * Listen aus, sofern vorhanden
				 */
				for (int i = 0; i < list.getItemCount() - 1; i++) {
					if (suchen.getText().equals(list.getItem(i))) {
						list.select(i);
						list_1.select(i);
					} else if (suchen.getText().equals(list_1.getItem(i))) {
						list.select(i);
						list_1.select(i);
					}
				}
			}
		});
		btnSuchen.setBounds(285, 10, 89, 23);
		Verwaltung.add(btnSuchen);

		JTextArea txtrEnglisch = new JTextArea();
		txtrEnglisch.setBackground(new Color(240, 240, 240));
		txtrEnglisch.setText("Englisch");
		txtrEnglisch.setBounds(153, 53, 221, 22);
		Verwaltung.add(txtrEnglisch);

		JTextArea txtrDeutsch = new JTextArea();
		txtrDeutsch.setBackground(new Color(240, 240, 240));
		txtrDeutsch.setText("Deutsch");
		txtrDeutsch.setBounds(380, 53, 225, 22);
		Verwaltung.add(txtrDeutsch);

		JPanel Spiele = new JPanel();
		tabbedPane.addTab("Spiele", null, Spiele, null);
		Spiele.setLayout(null);

		JButton btnSpiel = new JButton("Karteikasten");
		btnSpiel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* startet den Karteikasten */

				Vokabelkasten.invoke();
			}
		});
		btnSpiel.setBounds(10, 11, 117, 29);
		Spiele.add(btnSpiel);

		JButton btnSpiel2 = new JButton("Wortfall");
		btnSpiel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/* startet Wortfall */
				Spielfeld.newRnd();
				Wortfall.invoke();
			}
		});
		btnSpiel2.setBounds(10, 71, 117, 29);
		Spiele.add(btnSpiel2);
	}
}
