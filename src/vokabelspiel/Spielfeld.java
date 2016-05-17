package vokabelspiel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.UIManager;

public class Spielfeld extends JPanel {

	private JPanel contentPane;
	private Wort wort1;
	private Wort wort2;
	private Wort wort3;
	private Wort wort4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Spielfeld frame = new Spielfeld();
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
	public Spielfeld() {
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JTextArea txtrWort = new JTextArea();
		txtrWort.setFont(new Font("Impact", Font.PLAIN, 13));
		txtrWort.setBackground(UIManager.getColor("Button.background"));
		txtrWort.setText("Wort");
		txtrWort.setBounds(10, 11, 178, 22);
		contentPane.add(txtrWort);
		
		JTextArea txtrScore = new JTextArea();
		txtrScore.setFont(new Font("Impact", Font.PLAIN, 13));
		txtrScore.setBackground(UIManager.getColor("Button.background"));
		txtrScore.setText("Score");
		txtrScore.setBounds(198, 11, 143, 22);
		contentPane.add(txtrScore);
		
	}
	
}
