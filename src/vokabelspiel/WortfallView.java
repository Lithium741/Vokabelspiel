package vokabelspiel;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.UIManager;


@SuppressWarnings("serial")
public class WortfallView extends JFrame {

	private JPanel contentPane;
	private Wort wort1;
	private Wort wort2;
	private Wort wort3;
	private Wort wort4;
	private Balken balken;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WortfallView frame = new WortfallView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		wort1.paint(g2d);
		wort2.paint(g2d);
		wort3.paint(g2d);
		wort4.paint(g2d);
		balken.paint(g2d);
	}

	/**
	 * Create the frame.
	 */
	public WortfallView() {
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
		wort1.setWort("wort1");
		contentPane.add(wort1);

		wort2 = new Wort();
		wort2.setWort("wort2");
		contentPane.add(wort2);

		wort3 = new Wort();
		wort3.setWort("wort3");
		contentPane.add(wort3);

		wort4 = new Wort();
		wort4.setWort("wort4");
		contentPane.add(wort4);

		balken = new Balken();
		contentPane.add(balken);
	}

	public Wort getWort1() {
		return wort1;
	}

	public void setWort1(Wort wort1) {
		this.wort1 = wort1;
	}

	public Wort getWort2() {
		return wort2;
	}

	public void setWort2(Wort wort2) {
		this.wort2 = wort2;
	}

	public Wort getWort3() {
		return wort3;
	}

	public void setWort3(Wort wort3) {
		this.wort3 = wort3;
	}

	public Wort getWort4() {
		return wort4;
	}

	public void setWort4(Wort wort4) {
		this.wort4 = wort4;
	}

	public Balken getBalken() {
		return balken;
	}

	public void setBalken(Balken balken) {
		this.balken = balken;
	}
}
