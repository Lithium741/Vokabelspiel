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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;

/**
 * Start-Klasse startet das Programm und regelt die GUI zum großteil
 * 
 * @author Manuel S., Mareen B., Alex B., Kevin K.
 *
 */
@SuppressWarnings("serial")
public class Start extends JFrame {

	private JPanel contentPane;
	private JFileChooser fc;
	private int a;
	private static int b;
	private static int c;
	public static List list;
	public static List list_1;
	private JTextField suchen;
	private static ResourceBundle bundle;
	private static String baseName;

	/**
	 * Startet das Programm
	 */
	public static void main(String[] args) {
		/* ruft die lokalisierungdateien ab */
		baseName = "resources.Vokabelspiel";
		/* Abfrage der gewünschten Sprache*/
		b = JOptionPane.showOptionDialog(null, "Select language", "Select language", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, new String[] { "German", "English" }, "English");
		if (b == 0) {
			c = 0;
			/* ruft die deutsche lokalisierungsdatei auf */
			Locale.setDefault(new Locale("de", "DE"));
			try {
				bundle = ResourceBundle.getBundle(baseName);
			} catch (MissingResourceException e) {
				System.err.println(e);
			}
		}
		else if (b == 1) {
			c = 1;
			/* ruft die englische lokalisierungsdatei auf */
			Locale.setDefault(new Locale("en", "EN"));
			try {
				bundle = ResourceBundle.getBundle(baseName);
			} catch (MissingResourceException e) {
				System.err.println(e);
			}
		} else if (b != 1 && b != 0) {
			c = 1;
			/* ruft die englische lokalisierungsdatei auf */
			Locale.setDefault(new Locale("en", "EN"));
			try {
				bundle = ResourceBundle.getBundle(baseName);
			} catch (MissingResourceException e) {
				System.err.println(e);
			}
		}
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
	 * Kreiert das Fenster
	 */
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 486);
		// erstellen Panel,auf den später die Elemente gezogen werden (Fenster
		// im Fenster)
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);

		JPanel Verwaltung = new JPanel();
		tabbedPane.addTab(getBundle().getString("verwaltung"), null, Verwaltung, null);
		Verwaltung.setLayout(null);

		JButton btnSpeichern = new JButton(getBundle().getString("speichern"));
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* öffnet das Speichern-Fenster */
				Speichern.invoke();
			}
		});
		btnSpeichern.setBounds(10, 26, 133, 29);
		Verwaltung.add(btnSpeichern);

		JButton btnLschen = new JButton(getBundle().getString("löschen"));
		btnLschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * fragt ab, ob die aktion ausgeführt werden soll und ruft dann
				 * die loeschen-Methode aus der Verwaltung-Klasse auf
				 */
				int a = JOptionPane.showOptionDialog(null,
						getBundle().getString("löschen") + "?" + Start.list.getSelectedItem(), "Löschen bestätigen",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
						new String[] { getBundle().getString("ja"), getBundle().getString("nein") },
						getBundle().getString("nein"));
				JOptionPane.showMessageDialog(null, vokabelspiel.Verwaltung.loeschen(Start.list.getSelectedItem(), a));
			}
		});
		btnLschen.setBounds(10, 81, 133, 29);
		Verwaltung.add(btnLschen);

		JButton btnDateiSpeichern = new JButton(getBundle().getString("datSpeichern"));
		btnDateiSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* öffnet einen Filechooser */
				fc = new JFileChooser();
				a = fc.showOpenDialog(null);
				try {
					/* F führt dateiSpeichern aus */
					JOptionPane.showMessageDialog(null,
							vokabelspiel.Verwaltung.dateiSpeichern(a, fc.getSelectedFile()));
				} catch (NullPointerException f) {

				}
			}
		});
		btnDateiSpeichern.setBounds(10, 134, 133, 29);
		Verwaltung.add(btnDateiSpeichern);

		JButton btnDateiLaden = new JButton(getBundle().getString("datLaden"));
		btnDateiLaden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/* öffnet einen Filechooser */
				fc = new JFileChooser();
				a = fc.showOpenDialog(null);
				/* Auswahldialog */
				int b = JOptionPane.showOptionDialog(null, getBundle().getString("listeÜberschr"),
						getBundle().getString("datLaden"), JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
						new String[] { getBundle().getString("ja"), getBundle().getString("nein") },
						getBundle().getString("nein"));
				try {
					/*
					 * wenn ja, läd die Vokabeln aus der Datei und überschreibt
					 * die alten Einträge
					 */
					if (b == 0) {
						vokabelspiel.Verwaltung.vokabeln.clear();
						JOptionPane.showMessageDialog(null,
								vokabelspiel.Verwaltung.dateiLaden(a, fc.getSelectedFile()));
						/*
						 * wenn nein, lädt die Vokabeln aus der Datei ohne die
						 * alten Eintrge zu Überschreiben
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
		 * wählt das Gegenstück des Ausgewählten Eintrages in der anderen Liste
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
		 * wählt das Gegenstück des Ausgewählten Eintrages in der anderen Liste
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

		JButton btnSuchen = new JButton(getBundle().getString("suchen"));
		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * wählt das Eingegebene Wort und dessen Übersetzung in den
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
		txtrEnglisch.setText(getBundle().getString("eWort"));
		txtrEnglisch.setBounds(153, 53, 221, 22);
		Verwaltung.add(txtrEnglisch);

		JTextArea txtrDeutsch = new JTextArea();
		txtrDeutsch.setBackground(new Color(240, 240, 240));
		txtrDeutsch.setText(getBundle().getString("dWort"));
		txtrDeutsch.setBounds(380, 53, 225, 22);
		Verwaltung.add(txtrDeutsch);
		
		Icon icon1 = new ImageIcon(getClass().getResource("/britmerican.png"));
		Icon icon2 = new ImageIcon(getClass().getResource("/german.png"));

		/* Flaggen-Icon in der linken unteren Ecke*/
		JLabel lblNewLabel;
		if (c == 0) {
			lblNewLabel = new JLabel(icon2);
		} else if (c == 1) {
			lblNewLabel = new JLabel(icon1);
		} else {
			lblNewLabel = new JLabel("Error");
		}
		lblNewLabel.setBounds(10, 370, 38, 28);
		Verwaltung.add(lblNewLabel);
		
		JPanel Spiele = new JPanel();
		tabbedPane.addTab(getBundle().getString("spiele"), null, Spiele, null);
		Spiele.setLayout(null);

		JButton btnSpiel = new JButton(getBundle().getString("karteikasten"));
		btnSpiel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* startet den Karteikasten */

				Vokabelkasten.invoke();
			}
		});
		btnSpiel.setBounds(10, 11, 156, 81);
		Spiele.add(btnSpiel);

		JButton btnSpiel2 = new JButton(getBundle().getString("wortfall"));
		btnSpiel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/* startet Wortfall */
				Spielfeld.newRnd();
				Wortfall.invoke();
			}
		});
		btnSpiel2.setBounds(176, 11, 156, 81);
		Spiele.add(btnSpiel2);
	}

	/**
	 * getter und setter
	 */
	public static ResourceBundle getBundle() {
		return bundle;
	}

	public static void setBundle(ResourceBundle bundle) {
		Start.bundle = bundle;
	}

	public JFileChooser getFc() {
		return fc;
	}

	public void setFc(JFileChooser fc) {
		this.fc = fc;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public static int getB() {
		return b;
	}

	public static void setB(int b) {
		Start.b = b;
	}

	public static int getC() {
		return c;
	}

	public static void setC(int c) {
		Start.c = c;
	}

	public static List getList() {
		return list;
	}

	public static void setList(List list) {
		Start.list = list;
	}

	public static List getList_1() {
		return list_1;
	}

	public static void setList_1(List list_1) {
		Start.list_1 = list_1;
	}

	public JTextField getSuchen() {
		return suchen;
	}

	public void setSuchen(JTextField suchen) {
		this.suchen = suchen;
	}

	public static String getBaseName() {
		return baseName;
	}

	public static void setBaseName(String baseName) {
		Start.baseName = baseName;
	}
}