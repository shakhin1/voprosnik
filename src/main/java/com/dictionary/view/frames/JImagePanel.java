package com.dictionary.view.frames;

import java.awt.*;

import javax.swing.*;

public class JImagePanel extends JPanel {
	public JImagePanel() {
		super(new BorderLayout());
		ImageIcon image = new ImageIcon(JImagePanel.class.getClassLoader().getResource("img/image2.png"));
		JLabel label = new JLabel("", image, JLabel.CENTER);
		this.add(label, BorderLayout.CENTER);
	}
}
