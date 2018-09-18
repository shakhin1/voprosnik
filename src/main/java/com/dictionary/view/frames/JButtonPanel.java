package com.dictionary.view.frames;

import javax.swing.*;

public class JButtonPanel extends JPanel {
	private JButton button;

	public JButtonPanel(String text) {
		button = new JButton(text);
		this.add(button);
	}

	public JButton getButton() {
		return button;
	}
}
