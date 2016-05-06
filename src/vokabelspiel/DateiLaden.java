package vokabelspiel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DateiLaden extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void invoke () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateiLaden frame = new DateiLaden();
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
	public DateiLaden() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDateiLaden = new JButton("Datei Laden");
		btnDateiLaden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDateiLaden.setBounds(10, 82, 150, 23);
		contentPane.add(btnDateiLaden);
		
		JButton btnDateiAuswhlen = new JButton("Datei Ausw\u00E4hlen");
		btnDateiAuswhlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDateiAuswhlen.setBounds(10, 35, 150, 23);
		contentPane.add(btnDateiAuswhlen);
		
		JLabel lblAnzeige = new JLabel("Anzeige");
		lblAnzeige.setBounds(216, 39, 208, 19);
		contentPane.add(lblAnzeige);
	}
}
