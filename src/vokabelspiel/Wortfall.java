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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JProgressBar;

/**
 * Wortfall-Klasse 
 * regelt die GUI-Anteile des Spiels
 * 
 * @author Manuel S., Mareen B., Alex B., Kevin K.
 *
 */
public class Wortfall extends JFrame {
	private JPanel contentPane;
	private static Timer timer;
	private Spielfeld feld;
	private static JTextArea txtrScore;
	private static JTextArea txtrWort;
	private static JProgressBar progressBar;
	private static int column;

	/**
	 * startet das Fenster
	 */
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

	/**
	 * Konstruktor, in dem das Fenster gezeichnet und gefüllt wird
	 */
	public Wortfall() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		int delay = 10;
		/*
		 * taskPerformer, der zum eigentlichen Ablauf des Spiels aufgerufen wird
		 */
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					feld.move();
					txtrWort.setText(Spielfeld.getWort(Spielfeld.getRand()));
					feld.repaint();
					/* beendet das Spiel bei Verlust des ganzen Lebens */
					if (feld.getLife() == 0) {
						JOptionPane.showMessageDialog(null, "Verloren");
						dispose();
						feld.setLife(20);
					}
				} catch (Exception e) {
					timer.stop();
				}
			}
		};
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 774, 522);
		contentPane.add(panel);
		panel.setLayout(null);
		feld = new Spielfeld(this);
		feld.setBackground(new Color(240, 240, 240));
		feld.setBounds(0, 0, 774, 522);
		panel.add(feld);
		feld.setLayout(null);

		txtrWort = new JTextArea();
		txtrWort.setBackground(new Color(240, 240, 240));
		txtrWort.setBounds(10, 11, 232, 30);
		feld.add(txtrWort);
		txtrWort.setForeground(Color.BLACK);
		txtrWort.setFont(new Font("Impact", Font.PLAIN, 18));
		txtrWort.setText(Spielfeld.getWort(Spielfeld.getRand()));

		txtrScore = new JTextArea();
		txtrScore.setBackground(new Color(240, 240, 240));
		txtrScore.setBounds(257, 11, 216, 38);
		feld.add(txtrScore);
		txtrScore.setForeground(Color.BLACK);
		txtrScore.setFont(new Font("Impact", Font.PLAIN, 18));
		txtrScore.setText("Score: " + feld.getScore());

		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 4, 22);
		feld.add(textArea);

		progressBar = new JProgressBar(0, 20);
		progressBar.setValue(feld.getLife());
		progressBar.setForeground(Color.GREEN);
		progressBar.setBackground(Color.RED);
		progressBar.setBounds(543, 11, 221, 22);
		feld.add(progressBar);

		/* Timer, der in periodischen Abständen den taskPerformer aufruft */
		timer = new Timer(delay, taskPerformer);
		timer.setInitialDelay(delay);
		timer.start();

	}

	/**
	 * getter und setter
	 */
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

	public static JProgressBar getProgressBar() {
		return progressBar;
	}

	public static void setProgressBar(JProgressBar progressBar) {
		Wortfall.progressBar = progressBar;
	}

	public static int getColumn() {
		return column;
	}

	public static void setColumn(int column) {
		Wortfall.column = column;
	}
}
