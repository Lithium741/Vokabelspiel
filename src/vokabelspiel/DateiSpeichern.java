package vokabelspiel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DateiSpeichern extends JFrame {

	private JPanel contentPane;
	JFileChooser fc;
	int a;

	/**
	 * Launch the application.
	 */
	public static void invoke() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateiSpeichern frame = new DateiSpeichern();
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
	public DateiSpeichern() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 145);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAnzeige = new JLabel("Anzeige");
		lblAnzeige.setBounds(210, 29, 214, 19);
		contentPane.add(lblAnzeige);

		JButton btnDateiAuswhlen = new JButton("Datei ausw\u00E4hlen");
		btnDateiAuswhlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// AUswählen einer Datei
				fc = new JFileChooser();
				a = fc.showOpenDialog(null);
				try {
					lblAnzeige.setText(fc.getSelectedFile().getName());
					JOptionPane.showMessageDialog(null, fc.getSelectedFile().getName());
				} catch (NullPointerException f) {

				}
			}
		});
		btnDateiAuswhlen.setBounds(10, 25, 150, 23);
		contentPane.add(btnDateiAuswhlen);

		JButton btnDateiSpeichern = new JButton("Datei speichern");
		btnDateiSpeichern.setBounds(10, 71, 150, 23);
		btnDateiSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, Verwaltung.dateiSpeichern(a, fc.getSelectedFile()));
			}
		});
		contentPane.add(btnDateiSpeichern);
	}
}
