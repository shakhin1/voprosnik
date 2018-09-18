package com.dictionary;

import com.dictionary.view.TestGUIClient;

public class TestClient {
	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TestGUIClient().createAndShowGUI();
			}
		});
	}
}
