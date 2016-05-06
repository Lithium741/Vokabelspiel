package vokabelspiel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;

public class Start extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
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
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel Spiele = new JPanel();
		tabbedPane.addTab("Spiele", null, Spiele, null);
		Spiele.setLayout(null);
		
		JButton btnSpiel = new JButton("Spiel 1");
		btnSpiel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Spiele1GUI.invoke();
				
			}
		});
		btnSpiel.setBounds(6, 39, 117, 29);
		Spiele.add(btnSpiel);
		
		JPanel Verwaltung = new JPanel();
		tabbedPane.addTab("Verwaltung", null, Verwaltung, null);
		Verwaltung.setLayout(null);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				VerwaltungGUI.invoke();
			}
		});
		btnSpeichern.setBounds(6, 6, 117, 29);
		Verwaltung.add(btnSpeichern);	
	}
}
