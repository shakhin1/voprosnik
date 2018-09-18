package com.dictionary;

import com.dictionary.view.TestGUIAdminPeople;

public class TestAdminPeople {
	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TestGUIAdminPeople().createAndShowGUI();
			}
		});
	}
}
