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
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class DateiLaden extends JFrame {

	private JPanel contentPane;
	private JFileChooser fc;
	private int a;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAnzeige = new JLabel("Anzeige");
		lblAnzeige.setBounds(216, 39, 208, 19);
		contentPane.add(lblAnzeige);
		
		JButton btnDateiAuswhlen = new JButton("Datei Ausw\u00E4hlen");
		btnDateiAuswhlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//AUswählen einer Datei
				fc = new JFileChooser();
				a = fc.showOpenDialog(null);
				try {
					lblAnzeige.setText(fc.getSelectedFile().getName());
					JOptionPane.showMessageDialog(null, fc.getSelectedFile().getName());
				}catch (NullPointerException e){
					
				}
			}
		});
		btnDateiAuswhlen.setBounds(10, 35, 150, 23);
		contentPane.add(btnDateiAuswhlen);
		
		JButton btnDateiLaden = new JButton("Datei Laden");
		btnDateiLaden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, Verwaltung.dateiLaden(a, fc.getSelectedFile()));
			}
		});
		btnDateiLaden.setBounds(10, 82, 150, 23);
		contentPane.add(btnDateiLaden);
	}
}
