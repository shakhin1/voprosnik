package com.dictionary.view.frames;

import javax.swing.*;

public class JComparePanel extends JPanel {
	private JButton button;

	public JComparePanel() {
		button = new JButton("Ответить");
		this.add(button);
	}

	public JButton getButton() {
		return button;
	}
}
