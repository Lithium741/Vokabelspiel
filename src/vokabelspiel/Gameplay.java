package vokabelspiel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Gameplay extends JFrame {

	private JPanel contentPane;
	private Wort wort1;
	private Wort wort2;
	private Wort wort3;
	private Wort wort4;
	Timer timer;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gameplay frame = new Gameplay();
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
	public Gameplay() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 420);
		contentPane = new Spielfeld();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add(wort1 = new Wort(5, "wort1"));
		wort1.setBounds(0, 30, 200, 15);
		contentPane.add(wort2 = new Wort(206, "wort2"));
		wort2.setBounds(201, 30, 200, 15);
		contentPane.add(wort3 = new Wort(407, "wort3"));
		wort3.setBounds(402, 30, 200, 15);
		contentPane.add(wort4 = new Wort(608, "wort4"));
		wort4.setBounds(603, 30, 200, 15);
	}

	ActionListener taskPerformer = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			try {
				
					wort1.repaint();
					wort2.repaint();
					wort3.repaint();
					wort4.repaint();
			
				
			} catch (Exception e) {
				System.out.println("Thread");
			}
		}
	};
	
	timer = new Timer(10, taskPerformer);
	timer.setInitialDelay(10);
	
	timer.start();
}