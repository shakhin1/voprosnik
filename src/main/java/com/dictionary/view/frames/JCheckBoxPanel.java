package com.dictionary.view.frames;

import javax.swing.*;

public class JCheckBoxPanel extends JPanel {
	private JCheckBox jCheckBox;

	public JCheckBoxPanel() {
		jCheckBox = new JCheckBox("Подсказка");
		jCheckBox.setSelected(true);
		this.add(jCheckBox);
	}

	public JCheckBox getjCheckBox() {
		return jCheckBox;
	}
}
