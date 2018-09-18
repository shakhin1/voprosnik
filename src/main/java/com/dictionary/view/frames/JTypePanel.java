package com.dictionary.view.frames;

import com.dictionary.view.grid.MyGridBagConstraints;

import javax.swing.*;
import java.awt.*;

public class JTypePanel extends JPanel implements Block{
    private JRadioButton test;
    private JRadioButton question;

    public JTypePanel() {
        super(new GridBagLayout());
        JPanel panel = new JPanel();
        JLabel label = new JLabel("форма контроля знаний");
        test = new JRadioButton("варианты");
        question = new JRadioButton("вопросы");
        test.setPreferredSize(new Dimension(80, 10));
        test.setSelected(true);
        question.setPreferredSize(new Dimension(100, 10));
        ButtonGroup group = new ButtonGroup();
        group.add(test);
        group.add(question);

        panel.add(label);
        panel.add(test);
        this.add(label, new MyGridBagConstraints(20, 20, 0, 0, 2, 1));
        this.add(test, new MyGridBagConstraints(20, 20, 0, 1, 1, 1));
        this.add(question, new MyGridBagConstraints(20, 20, 1, 1, 1, 1));

    }

    public JRadioButton getTest() {
        return test;
    }

    public JRadioButton getQuestion() {
        return question;
    }

    public void enableBlock() {
        test.setEnabled(false);
        question.setEnabled(false);
    }
}
