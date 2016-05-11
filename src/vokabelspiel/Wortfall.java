package vokabelspiel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Wortfall extends JFrame {
	private JPanel contentPane;
	private Timer timer;
	Spielfeld feld;

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
		setBounds(100, 100, 600, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		int delay = 10;
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					feld.move();
					feld.repaint();
				} catch (Exception e) {
					System.out.println("Thread");
				}
			}
		};
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		feld = new Spielfeld();
		panel.add(feld);
		timer = new Timer(delay, taskPerformer);
		timer.setInitialDelay(delay);
		timer.start();
		
	}
}
