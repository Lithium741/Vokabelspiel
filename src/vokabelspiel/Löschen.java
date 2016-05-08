package vokabelspiel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Löschen extends JFrame {

	private JPanel contentPane;
	private JTextField txtWortEingeben;

	/**
	 * Launch the application.
	 */
	public static void invoke() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Löschen frame = new Löschen();
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
	public Löschen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 186, 112);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtWortEingeben = new JTextField();
		txtWortEingeben.setText("Wort eingeben");
		txtWortEingeben.setBounds(10, 11, 139, 20);
		contentPane.add(txtWortEingeben);
		txtWortEingeben.setColumns(10);

		JButton btnLschen = new JButton("L\u00F6schen");
		btnLschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showOptionDialog(null, txtWortEingeben.getText() + " wirklich löschen?",
						"Löschen bestätigen", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
						new String[] { "Ja", "Nein" }, "Nein");
				JOptionPane.showMessageDialog(null, Verwaltung.loeschen(txtWortEingeben, a));
			}
		});
		btnLschen.setBounds(10, 42, 89, 23);
		contentPane.add(btnLschen);
	}
}
