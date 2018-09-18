package com.dictionary.view.frames;

import java.awt.*;

import javax.swing.*;

import com.dictionary.view.grid.MyGridBagConstraints;

public class J100pPanel extends JPanel {
	private JLabel text;

	public J100pPanel(String s, String s1) {
		super(new GridBagLayout());
		JPanel panel = new JPanel();
		JLabel label = new JLabel(s);
		text = new JLabel(s1);
		panel.add(text);
		panel.add(label);
		this.add(label, new MyGridBagConstraints(10, 20, 0, 0, 1, 1));
		this.add(text, new MyGridBagConstraints(10, 20, 0, 1, 1, 1));
	}

	public void setCount(String i) {
		text.setText(i);
	}
}
