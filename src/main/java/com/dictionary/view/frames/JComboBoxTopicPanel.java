package com.dictionary.view.frames;

import java.awt.*;
import java.util.Vector;

import javax.swing.*;

import com.dictionary.view.dto.Vocabulary;
import com.dictionary.view.grid.MyGridBagConstraints;

public class JComboBoxTopicPanel extends JPanel implements Block,DialogFont {
	private JComboBox<Vocabulary> text;

	public JComboBoxTopicPanel(Vector<Vocabulary> vocabulary) {
		super(new GridBagLayout());
		//super.setBackground(new Color(45, 255, 38));
		JPanel panel = new JPanel();
		final JLabel label = new JLabel("вопросы / варианты ");
		Vector topicNames = new Vector();
		for (Vocabulary v:vocabulary){
			topicNames.add(v.getTopic());
		}
		text = new JComboBox(vocabulary);
		text.setPreferredSize(new Dimension(400, 10));
		text.setFont(font);
		panel.add(label);
		panel.add(text);
		this.add(label, new MyGridBagConstraints(20, 0, 0, 0, 1, 1));
		this.add(text, new MyGridBagConstraints(20, 0, 0, 1, 0, 0));
	}

	public void enableBlock() {
		text.setEnabled(true);
	}

	public JComboBox<Vocabulary> getComboBox() {
		return text;
	}
}
