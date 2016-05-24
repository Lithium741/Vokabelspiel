package vokabelspiel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class WortfallController {

	WortfallView wView;
	Timer timer;

	public void move() {
		WortfallModel.move(wView.getWort1());
		WortfallModel.move(wView.getWort2());
		WortfallModel.move(wView.getWort3());
		WortfallModel.move(wView.getWort4());
		WortfallModel.move(wView.getWidth(), wView.getBalken());
	}

	public WortfallController(WortfallView wView) {
		this.wView = wView;
		wView.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				WortfallModel.balkenKeyReleased(e, wView.getBalken());
			}

			@Override
			public void keyPressed(KeyEvent e) {
				WortfallModel.balkenKeyPressed(e, wView.getBalken());
			}
		});

		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					move();
					wView.repaint();
				} catch (Exception e) {
					System.out.println("Thread");
				}
			}
		};

		timer = new Timer(3, taskPerformer);
		timer.setInitialDelay(10);

		timer.start();
	}
}
