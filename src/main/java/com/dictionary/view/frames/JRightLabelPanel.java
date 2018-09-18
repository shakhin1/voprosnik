package com.dictionary.view.frames;

import javax.swing.*;

public class JRightLabelPanel extends JPanel {
	private JLabel jLabel;

	public JRightLabelPanel() {
		jLabel = new JLabel("");
		this.add(jLabel);
	}

	public JLabel getjLabel() {
		return jLabel;
	}

	public void setRightWord(String s) {
		jLabel.setText(s);
	}
}
