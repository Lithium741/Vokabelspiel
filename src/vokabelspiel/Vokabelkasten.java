package vokabelspiel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vokabelkasten extends JFrame {

	private JPanel contentPane;
	private JTextField txtUebersetzung;
	private int a = (int) (Math.random() * (Verwaltung.vokabeln.size()-1));
	private int b = (int) (Math.random() * 11);

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

	private String getRandomVokabel() {
		if ((b % 2) == 1) {
			return Verwaltung.vokabeln.get(a).getDeutsch();
		} else if ((b % 2) != 1) {
			return Verwaltung.vokabeln.get(a).getEnglisch();
		} else {
			return "";
		}
	}

	/**
	 * Create the frame.
	 */
	public Vokabelkasten() {
		try {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 321, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblVokabel = new JLabel(getRandomVokabel());
		lblVokabel.setBounds(23, 34, 73, 14);
		contentPane.add(lblVokabel);

		JLabel lblKategorie = new JLabel(Verwaltung.vokabeln.get(a).getKategorie());
		lblKategorie.setBounds(125, 34, 70, 14);
		contentPane.add(lblKategorie);

		JLabel lblFach = new JLabel("Fach: " + Verwaltung.vokabeln.get(a).getFach());
		lblFach.setBounds(211, 34, 86, 14);
		contentPane.add(lblFach);

		txtUebersetzung = new JTextField();
		txtUebersetzung.setText("Uebersetzung");
		txtUebersetzung.setBounds(10, 81, 86, 20);
		contentPane.add(txtUebersetzung);
		txtUebersetzung.setColumns(10);

		JButton btnUeberpruefungEingabe = new JButton("Ueberpruefung Eingabe");
		btnUeberpruefungEingabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUeberpruefungEingabe.setBounds(106, 80, 168, 23);
		contentPane.add(btnUeberpruefungEingabe);
		}catch (IndexOutOfBoundsException e) {
			
		}
		}
}
