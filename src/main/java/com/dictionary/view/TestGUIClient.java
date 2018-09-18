package com.dictionary.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.dictionary.utils.InvokeFunctions;
import com.dictionary.view.dto.Vocabulary;
import com.dictionary.view.frames.*;
import javafx.util.Pair;

import javax.swing.*;


import com.dictionary.dao.DictDao;
import com.dictionary.dao.filters.DictFilter;
import com.dictionary.dao.InfoDao;
import com.dictionary.model.Dict;
import com.dictionary.model.Info;
import com.dictionary.service.FileService;
import com.dictionary.utils.Factory;
import com.dictionary.utils.Utils;
import com.dictionary.view.grid.MyGridBagConstraints;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class TestGUIClient extends GUI {
    private static final String FIRST_CLASS = "1";
    private static boolean ALREADY_DONE = false;
    private static final String TYPE_OF_QUESTIONS = "Q";
    private static final String TYPE_OF_TEST = "T";
    private String subject;
    private String book;
    private String topic;
    private String fio;
    private String nameOfClass;
    private String selectRadioButton= TYPE_OF_TEST;
    private Vocabulary currentVoc;
    private Map<String, Integer> answers100 = Maps.newHashMap();
    private Map<String, Integer> answers50 = Maps.newHashMap();
    private Map<String, Integer> answers30 = Maps.newHashMap();
    private Map<String, Vocabulary> vocab;
    private Map<String, String> answers = Maps.newHashMap();
    private InfoDao informationRepository;
    private DictDao dictionaryRepository;
    private FileService fileService;
    private JComboBoxTopicPanel comboBoxTopicPanel;


    public void createAndShowGUI() {
        informationRepository = Factory.getInstance().getInfoDao();
        dictionaryRepository = Factory.getInstance().getDictDao();
        fileService = Factory.getInstance().getFileService();
        JFrame frame = new JFrame("www.voprosnik.su");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setBounds(100, 100, 1280, 720);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public void addComponentsToPane(final Container pane) {
        pane.setLayout(new GridBagLayout());
        final Color color = pane.getBackground();

        final JFIOPanel FIOPanel = new JFIOPanel();
        pane.add(FIOPanel, new MyGridBagConstraints(10, 0, 1, 0, 1, 1));

        final JComboBoxSubjectPanel comboBoxSubjectPanel =
                new JComboBoxSubjectPanel(extractSubjects(dictionaryRepository.find(new DictFilter.Builder().className(FIRST_CLASS).type(selectRadioButton).build())));
        subject = (String) comboBoxSubjectPanel.getComboBox().getSelectedItem();
        pane.add(comboBoxSubjectPanel, new MyGridBagConstraints(0, 0, 2, 0, 1, 1));

        final JComboBoxBookPanel comboBoxBookPanel =
                new JComboBoxBookPanel(extractBooks(dictionaryRepository.find(new DictFilter.Builder().className(FIRST_CLASS).subject(subject).type(selectRadioButton).build())));
        book = (String) comboBoxBookPanel.getComboBox().getSelectedItem();
        pane.add(comboBoxBookPanel, new MyGridBagConstraints(0, 0, 3, 0, 1, 1));

        comboBoxTopicPanel =
                new JComboBoxTopicPanel(extractTopics(dictionaryRepository.find(new DictFilter.Builder().className(FIRST_CLASS).subject(subject).book(book).type(selectRadioButton).build())));
        topic = (String) comboBoxTopicPanel.getComboBox().getSelectedItem();
        currentVoc = (Vocabulary)comboBoxTopicPanel.getComboBox().getSelectedItem();

        vocab = extractWords(dictionaryRepository.find(new DictFilter.Builder().className(FIRST_CLASS).subject(subject).book(book).topic(topic).type(selectRadioButton).build()));

        JTypePanel typePanel = new JTypePanel();
        typePanel.getTest().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectRadioButton =TYPE_OF_TEST;
            }
        });
        typePanel.getQuestion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectRadioButton = TYPE_OF_QUESTIONS;
            }
        });
        pane.add(typePanel, new MyGridBagConstraints(0, 0, 0, 0, 1, 1));

        pane.add(comboBoxTopicPanel, new MyGridBagConstraints(10, 20, 0, 1, 3, 1));

        FIOPanel.getComboBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String className = (String) FIOPanel.getClassName();
                comboBoxSubjectPanel.getComboBox().removeAllItems();
                List<String> l = extractSubjects(dictionaryRepository.find(new DictFilter.Builder().className(className).type(selectRadioButton).build()));

                for (String s : l) {
                    comboBoxSubjectPanel.getComboBox().addItem(s);
                }
            }
        });

        comboBoxSubjectPanel.getComboBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String className = (String) FIOPanel.getClassName();
                final String subject = (String) comboBoxSubjectPanel.getComboBox().getSelectedItem();
                comboBoxBookPanel.getComboBox().removeAllItems();
                List<String> l = extractBooks(dictionaryRepository.find(new DictFilter.Builder().className(className).subject(subject).type(selectRadioButton).build()));
                for (String s : l) {
                    comboBoxBookPanel.getComboBox().addItem(s);
                }
            }
        });

        comboBoxBookPanel.getComboBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String className = (String) FIOPanel.getClassName();
                final String subject = (String) comboBoxSubjectPanel.getComboBox().getSelectedItem();
                final String book = (String) comboBoxBookPanel.getComboBox().getSelectedItem();
                comboBoxTopicPanel.getComboBox().removeAllItems();
                List<Vocabulary> allTopics =
                        extractTopics(dictionaryRepository.find(new DictFilter.Builder().className(className).subject(subject).book(book).type(selectRadioButton).build()));
                for (Vocabulary s : allTopics) {
                    comboBoxTopicPanel.getComboBox().addItem(s);
                }
            }
        });

        comboBoxTopicPanel.getComboBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String className = (String) FIOPanel.getClassName();
                final String subject = (String) comboBoxSubjectPanel.getComboBox().getSelectedItem();
                final String book = (String) comboBoxBookPanel.getComboBox().getSelectedItem();
                topic = ((Vocabulary) comboBoxTopicPanel.getComboBox().getSelectedItem()).toString();
                currentVoc = ((Vocabulary) comboBoxTopicPanel.getComboBox().getSelectedItem());
                vocab =
                        extractWords(dictionaryRepository
                                .find(new DictFilter.Builder().className(className).subject(subject).book(book).type(selectRadioButton).build()));
            }
        });

        final JInputPanel inputPanel = new JInputPanel();
        pane.add(inputPanel, new MyGridBagConstraints(10, 20, 0, 3, 3, 1));


        JImagePanel imagePanel = new JImagePanel();
        pane.add(imagePanel, new MyGridBagConstraints(10, 50, 3, 1, 1, 3));

        final J100pPanel j100pPanel = new J100pPanel("верных", String.valueOf(answers100.size()));
        pane.add(j100pPanel, new MyGridBagConstraints(10, 20, 1, 6, 1, 1));

        final J100pPanel j80pPanel = new J100pPanel("с ошибками", String.valueOf(answers50.size()));
        pane.add(j80pPanel, new MyGridBagConstraints(10, 20, 2, 6, 1, 1));

        final J100pPanel j60pPanel = new J100pPanel("неверных", String.valueOf(answers30.size()));
        pane.add(j60pPanel, new MyGridBagConstraints(10, 20, 3, 6, 1, 1));

        /*final JRightLabelPanel rightLabelPanel = new JRightLabelPanel();
        pane.add(rightLabelPanel, new MyGridBagConstraints(10, 20, 2, 4, 1, 1));*/

        JButtonPanel comparePanel = new JButtonPanel("Ответить");
        comparePanel.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputPanel.getText().getText().isEmpty())
                    return;

                if (!ALREADY_DONE) {
                    saveParams(FIOPanel, comboBoxSubjectPanel, comboBoxBookPanel, comboBoxTopicPanel,typePanel);
                }

                final Pair<Integer, String> p = findWords(inputPanel);

                if (p.getKey() >= 50) {
                    inputPanel.setRightWord(p.getValue());
                } else {
                    inputPanel.setRightWord("");
                }

                if (p.getKey() == 100) {
                    answers100.put(inputPanel.getText().getText(), vocab.get(p.getValue()).getMark());
                    j100pPanel.setCount(String.valueOf(answers100.size()));
                    answers.put(p.getValue(), p.getValue());
                } else if (p.getKey() >= 50) {
                    answers50.put(inputPanel.getText().getText(), vocab.get(p.getValue()).getMark());
                    j80pPanel.setCount(String.valueOf(answers50.size()));
                    answers.put(inputPanel.getText().getText(), p.getValue());
                } else {
                    answers30.put(inputPanel.getText().getText(), vocab.get(p.getValue()).getMark());
                    j60pPanel.setCount(String.valueOf(answers30.size()));
                    answers.put(inputPanel.getText().getText(), "неверный ответ");
                }
            }
        });
        pane.add(comparePanel, new MyGridBagConstraints(10, 20, 0, 4, 1, 1));

        JCheckBoxPanel checkBoxPanel = new JCheckBoxPanel();
        /*checkBoxPanel.getjCheckBox().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					rightLabelPanel.getjLabel().setForeground(Color.black);
				} else {
					rightLabelPanel.getjLabel().setForeground(color);
				}
			}
		});*/
        inputPanel.getjCheckBox().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    inputPanel.getjLabel().setForeground(Color.black);
                } else {
                    inputPanel.getjLabel().setForeground(color);
                }
            }
        });
        //pane.add(checkBoxPanel, new MyGridBagConstraints(10, 20, 1, 2, 1, 1));

        JButtonPanel linkPanel = new JButtonPanel("Показать задание на сайте");
        linkPanel.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentVoc = (Vocabulary)comboBoxTopicPanel.getComboBox().getSelectedItem();
                String link = currentVoc.getLink();
                if (link != null) {
                    try {
                        openLink(link);
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage(), "Wrong link", JOptionPane.OK_OPTION);
                    }
                }
            }
        });
        pane.add(linkPanel, new MyGridBagConstraints(10, 20, 1, 4, 1, 1));

        JStatisticPanel statisticPanel = new JStatisticPanel();
        pane.add(statisticPanel, new MyGridBagConstraints(10, 20, 0, 6, 1, 1));

        JButtonPanel buttonPanel = new JButtonPanel("Ваша оценка");
        buttonPanel.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final Double mark = Utils.calculateMark(vocab, answers100, answers50.size(), answers30.size());
                informationRepository.save(new Info(fio, nameOfClass, subject, book, topic, mark.toString()));
                JOptionPane.showMessageDialog(pane, "Ваша оценка - " + mark.toString(), "Результат", JOptionPane.INFORMATION_MESSAGE);
                saveResult(fio + "_" + nameOfClass + "." + subject + "." + book + ".doc", mark);
                System.exit(0);
            }
        });
        pane.add(buttonPanel, new MyGridBagConstraints(10, 220, 0, 9, 4, 1));
    }


    private void saveResult(String path, Double mark) {
        StringBuilder sb = new StringBuilder();
        sb.append("Ваши ответы по теме:\n");
        sb.append(book + "." + "  \n");
        sb.append("------------------------------------\n");
        for (String key : answers.keySet()) {
            sb.append(key + "  правильный ответ  " + answers.get(key) + "\n");
        }
        sb.append("------------------------------------\n");
        sb.append("Ваша оценка " + mark);
        fileService.write(path, sb.toString());
    }

    private Pair<Integer, String> findWords(JInputPanel inputPanel) {
        Integer max = 0;
        Pair<Integer, String> p = new Pair(0, "");
        Iterator<String> i = vocab.keySet().iterator();
        while (i.hasNext()) {
            String stringFromDB = i.next();
            Integer f = Utils.indistinctMatching(7, inputPanel.getText().getText(), stringFromDB);
            if (f > max) {
                max = f;
                p = new Pair(f, stringFromDB);
            }
        }

        return p;
    }

    private void saveParams(JFIOPanel FIOPanel, JComboBoxSubjectPanel comboBoxSubjectPanel, JComboBoxBookPanel comboBoxBookPanel,
                            JComboBoxTopicPanel comboBoxTopicPanel, JTypePanel typePanel) {
        block(FIOPanel, comboBoxSubjectPanel, comboBoxBookPanel, comboBoxTopicPanel,typePanel);
        fio = FIOPanel.getFIO();
        nameOfClass = (String) FIOPanel.getClassName();
        topic =( (Vocabulary) comboBoxTopicPanel.getComboBox().getSelectedItem()).toString();
        subject = (String) comboBoxSubjectPanel.getComboBox().getSelectedItem();
        book = (String) comboBoxBookPanel.getComboBox().getSelectedItem();
        ALREADY_DONE = true;
    }

    private Map<String, Vocabulary> extractWords(List<Dict> dictionaryList) {
        Map<String, Vocabulary> vocabulary = Maps.newHashMap();
        for (Dict d : dictionaryList) {
            String type = d.getType()!=null?d.getType():TYPE_OF_QUESTIONS;
            if (type.equals(selectRadioButton)) {
                vocabulary.put(d.getWord(), new Vocabulary(d.getTopic(), d.getWord(), d.getMark(), d.getLink()));
            }
            }
        return vocabulary;
    }

    private void openLink(String link) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI(link));
    }

    private Vector<Vocabulary> extractTopics(List<Dict> dictionaryList) {

        return new Vector(Sets.newHashSet(Collections2.transform(dictionaryList, InvokeFunctions.INVOKE_GET_TOPIC)));
    }



    private Vector<String> extractBooks(List<Dict> dictionaryList) {
        return new Vector(Sets.newHashSet(Collections2.transform(dictionaryList, InvokeFunctions.INVOKE_GET_BOOK)));
    }

    private Vector<String> extractSubjects(List<Dict> dictionaryList) {
        return new Vector(Sets.newHashSet(Collections2.transform(dictionaryList, InvokeFunctions.INVOKE_GET_SUBJECT)));
    }



    private void block(Block... panels) {
        for (Block b : panels) {
            b.enableBlock();
        }
    }


}