package vokabelspiel;

import java.awt.EventQueue;

public class WortfallStart {


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WortfallView wView = new WortfallView();
					wView.setVisible(true);
					WortfallController wCont = new WortfallController(wView);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
