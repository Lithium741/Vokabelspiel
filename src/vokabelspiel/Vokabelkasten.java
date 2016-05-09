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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVokabel = new JLabel("Vokabel");
		lblVokabel.setBounds(23, 34, 73, 14);
		contentPane.add(lblVokabel);
		
		JLabel lblKategorie = new JLabel("Kategorie");
		lblKategorie.setBounds(125, 34, 70, 14);
		contentPane.add(lblKategorie);
		
		JLabel lblFach = new JLabel("Fach");
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
	}
}
