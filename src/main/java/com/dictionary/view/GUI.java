package com.dictionary.view;

import java.awt.*;

import javax.swing.*;

/**
 * Created by 1 on 20.12.2014.
 */

public abstract class GUI {
	protected final int ID_NUMBER = 6;

	public void createAndShowGUI() {
		JFrame frame = new JFrame("ВОПРОСНИК");
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

	protected abstract void addComponentsToPane(Container contentPane);

}
