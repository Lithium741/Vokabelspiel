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
		wView.getWort1().setY(WortfallModel.moveWort(wView.getWort1().getY()));
		wView.getWort2().setY(WortfallModel.moveWort(wView.getWort2().getY()));
		wView.getWort3().setY(WortfallModel.moveWort(wView.getWort3().getY()));
		wView.getWort4().setY(WortfallModel.moveWort(wView.getWort4().getY()));
		wView.getBalken()
				.setX(WortfallModel.moveBalken(wView.getWidth(), wView.getBalken().getX(), wView.getBalken().getXa()));
	}

	public WortfallController() {

		wView = new WortfallView();

		wView.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				wView.getBalken().setXa(WortfallModel.balkenKeyReleased(e));
			}

			@Override
			public void keyPressed(KeyEvent e) {
				wView.getBalken().setXa(WortfallModel.balkenKeyPressed(e));
			}
		});

		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// ...Perform a task...
				// System.out.println("timer");
				try {
					wView.repaint();
					move();
				} catch (Exception e) {
					System.out.println("Thread");
				}
			}
		};

		timer = new Timer(10, taskPerformer);
		timer.setInitialDelay(10);

		timer.start();
	}
}
