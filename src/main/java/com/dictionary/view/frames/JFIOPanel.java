package com.dictionary.view.frames;

import java.awt.*;
import java.util.Vector;

import javax.swing.*;

import com.dictionary.view.grid.MyGridBagConstraints;

public class JFIOPanel extends JPanel implements Block {
	private JTextField fio;
	private JComboBox className;

	public JFIOPanel() {
		super(new GridBagLayout());
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Наберите Фамилию и Имя и выберите");
		fio = new JTextField("Ф.И.О");
		className = new JComboBox(new Vector<String>() {
			{
				add("класс/курс");
				add("1 класс");
				add("2 класс");
				add("3 класс");
				add("4 класс");
				add("5 класс");
				add("6 класс");
				add("7 класс");
				add("8 класс");
				add("9 класс");
				add("10 класс");
				add("11 класс");
				add("I курс");
				add("II курс");
				add("III курс");
				add("IV курс");
				add("V курс");
				add("прочее");
			}});
		fio.setPreferredSize(new Dimension(130, 10));
		className.setPreferredSize(new Dimension(65, 10));

		panel.add(label);
		panel.add(fio);
		this.add(label, new MyGridBagConstraints(20, 20, 0, 0, 2, 1));
		this.add(fio, new MyGridBagConstraints(20, 20, 0, 1, 1, 1));
		this.add(className, new MyGridBagConstraints(20, 30, 1, 1, 1, 1));
	}

	public String getFIO() {
		return fio.getText();
	}

	public Object getClassName() {
		return className.getSelectedItem();
	}

	public void enableBlock() {
		fio.setEnabled(false);
		className.setEnabled(false);
	}

	public JComboBox getComboBox() {
		return className;
	}
}
