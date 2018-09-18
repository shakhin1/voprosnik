package com.dictionary;

import com.dictionary.view.TestGUIAdminDictionary;

public class TestAdminDictionary {
	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TestGUIAdminDictionary().createAndShowGUI();
			}
		});
	}
}
