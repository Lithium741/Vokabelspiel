package vokabelspiel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vokabelkasten extends JFrame {

	private JPanel contentPane;
	private JTextField txtUebersetzung;

	/**
	 * Launch the application.
	 */
	public static void invoke() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vokabelkasten frame = new Vokabelkasten();
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
	public Vokabelkasten() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 308, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblVokabel = new JLabel(Karteikasten.getRandomVokabel());
		lblVokabel.setBounds(23, 34, 253, 14);
		contentPane.add(lblVokabel);

		JLabel lblKategorie = new JLabel(Verwaltung.vokabeln.get(Karteikasten.getA()).getKategorie());
		lblKategorie.setBounds(23, 83, 229, 14);
		contentPane.add(lblKategorie);

		JLabel lblFach = new JLabel("Fach: " + Verwaltung.vokabeln.get(Karteikasten.getA()).getFach());
		lblFach.setBounds(23, 108, 86, 14);
		contentPane.add(lblFach);

		txtUebersetzung = new JTextField();
		txtUebersetzung.setText("Uebersetzung");
		txtUebersetzung.setBounds(10, 136, 161, 20);
		contentPane.add(txtUebersetzung);
		txtUebersetzung.setColumns(10);

		JButton btnUeberpruefungEingabe = new JButton("Ueberpruefung Eingabe");
		btnUeberpruefungEingabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, Karteikasten.pruefen(txtUebersetzung));
				Karteikasten.neuesWort();
				lblVokabel.setText(Karteikasten.getRandomVokabel());
				lblKategorie.setText(Verwaltung.vokabeln.get(Karteikasten.getA()).getKategorie());
				lblFach.setText("Fach: " + Verwaltung.vokabeln.get(Karteikasten.getA()).getFach());
			}
		});
		btnUeberpruefungEingabe.setBounds(10, 176, 168, 23);
		contentPane.add(btnUeberpruefungEingabe);
	}
}
