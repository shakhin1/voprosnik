package com.dictionary.view.frames;

import java.awt.*;
import java.util.Vector;

import javax.swing.*;

import com.dictionary.view.grid.MyGridBagConstraints;

public class JComboBoxSubjectPanel extends JPanel implements Block,DialogFont {
	private JComboBox text;

	public JComboBoxSubjectPanel(Vector<String> v) {
		super(new GridBagLayout());
		//super.setBackground(new Color(255, 0, 185));
		JPanel panel = new JPanel();
		final JLabel label = new JLabel("предмет");
		text = new JComboBox(v);
		text.setPreferredSize(new Dimension(200, 10));
		text.setFont(font);
		panel.add(label);
		panel.add(text);
		this.add(label, new MyGridBagConstraints(20, 0, 0, 0, 1, 1));
		this.add(text, new MyGridBagConstraints(20, 0, 0, 1, 0, 0));
	}

	public void enableBlock() {
		text.setEnabled(false);
	}

	public JComboBox getComboBox() {
		return text;
	}
}
