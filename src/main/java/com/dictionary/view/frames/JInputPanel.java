package com.dictionary.view.frames;

import java.awt.*;

import javax.swing.*;

import com.dictionary.view.grid.MyGridBagConstraints;

public class JInputPanel extends JPanel {
	private JTextField text;
	private JCheckBox jCheckBox;
	private JLabel jLabel;

	public JInputPanel() {
		super(new GridBagLayout());
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Введите ответ");
		JPanel tipPanel = new JPanel();
		jCheckBox = new JCheckBox("Показать ощибку для верного ответа");
		jCheckBox.setSelected(true);
		jLabel = new JLabel("");
		tipPanel.add(jCheckBox);
		tipPanel.add(jLabel);
		text = new JTextField("");
		label.setPreferredSize(new Dimension(400, 20));
		panel.add(label);
		panel.add(text);
		this.add(label, new MyGridBagConstraints(20, 20, 0, 0, 1, 1));
		this.add(tipPanel, new MyGridBagConstraints(20, 20, 0, 2, 1, 1));
		//this.add(jLabel, new MyGridBagConstraints(20, 20, 1, 2, 2, 1));
		this.add(text,      new MyGridBagConstraints(20, 20, 0, 1, 1, 1));
	}

	public JTextField getText() {
		return text;
	}

	public JCheckBox getjCheckBox() {
		return jCheckBox;
	}

	public void setRightWord(String s) {
		jLabel.setText(s);
	}

	public JLabel getjLabel() {
		return jLabel;
	}
}
