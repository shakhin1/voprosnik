package com.dictionary.view.frames;

import java.awt.*;
import java.util.Vector;

import javax.swing.*;

import com.dictionary.view.grid.MyGridBagConstraints;

public class JComboBoxBookPanel extends JPanel implements Block,DialogFont {
	private JComboBox<String> text;

	public JComboBoxBookPanel(Vector<String> v) {
		super(new GridBagLayout());
		//super.setBackground(new Color(58, 93, 255));
		JPanel panel = new JPanel();
		final JLabel label = new JLabel("тема");
		text = new JComboBox<String>(v);
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

	public JComboBox<String> getComboBox() {
		return text;
	}
}
