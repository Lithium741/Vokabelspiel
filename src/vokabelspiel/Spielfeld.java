package vokabelspiel;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.UIManager;

@SuppressWarnings("serial")
public class Spielfeld extends JFrame {

	private JPanel contentPane;
	private Wort wort1;
	private Wort wort2;
	private Wort wort3;
	private Wort wort4;
	private Balken balken;

	/**
	 * Launch the application.
	 */
	public void invoke() {
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
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
		setFocusable(true);
		setBounds(100, 100, 836, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		getContentPane().add(contentPane);

		JTextArea txtrWort = new JTextArea();
		txtrWort.setEditable(false);
		txtrWort.setFont(new Font("Impact", Font.PLAIN, 13));
		txtrWort.setBackground(UIManager.getColor("Button.background"));
		txtrWort.setText("Wort");
		txtrWort.setBounds(10, 11, 178, 22);
		contentPane.add(txtrWort);

		JTextArea txtrScore = new JTextArea();
		txtrScore.setEditable(false);
		txtrScore.setFont(new Font("Impact", Font.PLAIN, 13));
		txtrScore.setBackground(UIManager.getColor("Button.background"));
		txtrScore.setText("Score");
		txtrScore.setBounds(198, 11, 143, 22);
		contentPane.add(txtrScore);

		wort1 = new Wort();
		wort1.setLocation(10, 33);
		wort1.setWort("wort1");
		contentPane.add(wort1);

		wort2 = new Wort();
		wort2.setLocation(211, 33);
		wort2.setWort("wort2");
		contentPane.add(wort2);

		wort3 = new Wort();
		wort3.setLocation(412, 33);
		wort3.setWort("wort3");
		contentPane.add(wort3);

		wort4 = new Wort();
		wort4.setLocation(613, 33);
		wort4.setWort("wort4");
		contentPane.add(wort4);

	}

}
