package vokabelspiel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Wortfall extends JFrame {
	private JPanel contentPane;
	private static Timer timer;
	private Spielfeld feld;
	private static JTextArea txtrScore;
	private static JTextArea txtrWort;
	
	

	public static void invoke() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wortfall frame = new Wortfall();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Wortfall() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		int delay = 10;
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					feld.move();
					txtrWort.setText(getWort(feld.getRand()));
					feld.repaint();
				} catch (Exception e) {
					System.out.println("Thread");
				}
			}
		};
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 774, 522);
		contentPane.add(panel);
		panel.setLayout(null);
		feld = new Spielfeld();
		feld.setBackground(Color.LIGHT_GRAY);
		feld.setBounds(0, 0, 774, 522);
		panel.add(feld);
		feld.setLayout(null);

		txtrWort = new JTextArea();
		txtrWort.setBackground(Color.LIGHT_GRAY);
		txtrWort.setBounds(10, 11, 232, 30);
		feld.add(txtrWort);
		txtrWort.setForeground(Color.BLACK);
		txtrWort.setFont(new Font("Impact", Font.PLAIN, 18));
		txtrWort.setText(getWort(feld.getRand()));

		txtrScore = new JTextArea();
		txtrScore.setBackground(Color.LIGHT_GRAY);
		txtrScore.setBounds(257, 11, 216, 38);
		feld.add(txtrScore);
		txtrScore.setForeground(Color.BLACK);
		txtrScore.setFont(new Font("Impact", Font.PLAIN, 18));
		txtrScore.setText("Score: " + feld.getScore());

		timer = new Timer(delay, taskPerformer);
		timer.setInitialDelay(delay);
		timer.start();

	}

	public String getWort(int a) {
		switch (a) {
		case 1:
			return Verwaltung.vokabeln.get(feld.getA()).rndLang(feld.getZ() - 1);
		case 2:
			return Verwaltung.vokabeln.get(feld.getB()).rndLang(feld.getZ() - 1);
		case 3:
			return Verwaltung.vokabeln.get(feld.getC()).rndLang(feld.getZ() - 1);
		case 4:
			return Verwaltung.vokabeln.get(feld.getD()).rndLang(feld.getZ() - 1);
		}
		return "";
	}

	public static Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public static JTextArea getTxtrScore() {
		return txtrScore;
	}

	public void setTxtrScore(JTextArea txtrScore) {
		this.txtrScore = txtrScore;
	}

	public static JTextArea getTxtrWort() {
		return txtrWort;
	}

	public void setTxtrWort(JTextArea txtrWort) {
		this.txtrWort = txtrWort;
	}
}
