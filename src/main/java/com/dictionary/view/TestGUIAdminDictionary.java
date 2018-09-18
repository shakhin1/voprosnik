package com.dictionary.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import com.dictionary.dao.DictDao;
import com.dictionary.dao.filters.DictFilter;
import com.dictionary.model.Dict;
import com.dictionary.utils.Factory;
import com.dictionary.view.frames.TableInfoDictionary;
import com.dictionary.view.grid.MyGridBagConstraints;
import com.dictionary.view.tableModels.TableModelDictionary;

public class TestGUIAdminDictionary extends GUI {
	private String classNameBD;
	private String wordBD;
	private String subjectBD;
	private String bookBD;
	private String topicBD;
	private String linkBD;
	private String typeBD;
	private Long idSelectedItem;
	private Integer markBD;
	private DictDao dictionaryRepository;

	protected void addComponentsToPane(Container pane) {
		pane.setLayout(new GridBagLayout());
		dictionaryRepository = Factory.getInstance().getDictDao();

		JPanel vocabPanel = new JPanel();
		final JButton addVocab = new JButton("Добавить слова");
		final JTextField vocabWord = new JTextField(15);
		final JTextField vocabMark = new JTextField(2);
		final JButton delete = new JButton("Удалить");
		final JButton edit = new JButton("Редактировать");
		vocabPanel.add(vocabWord);
		vocabPanel.add(vocabMark);
		vocabPanel.add(addVocab);
		vocabPanel.add(delete);
		vocabPanel.add(edit);
		pane.add(vocabPanel, new MyGridBagConstraints(10, 20, 0, 0, 2, 1));

		final JPanel infoPanel = new JPanel();
		final JTextField className = new JTextField(2);
		className.setText("Класс");
		final JTextField subject = new JTextField(7);
		subject.setText("Предмет");
		final JTextField book = new JTextField(15);
		book.setText("Тема");
		final JTextField topic = new JTextField(35);
		topic.setText("Вопрос");


		infoPanel.add(className);
		infoPanel.add(subject);
		infoPanel.add(book);
		infoPanel.add(topic);

		pane.add(infoPanel, new MyGridBagConstraints(10, 100, 0, 1, 2, 1));
		final JPanel linkPanel = new JPanel();
		final JTextField link = new JTextField(20);
		link.setText("Сcылка");
		linkPanel.add(link);
		pane.add(linkPanel, new MyGridBagConstraints(10, 100, 0, 2, 1, 1));

		final JPanel typePanel = new JPanel();
		final JTextField type = new JTextField(20);
		type.setText("Тип(Q/T)");
		typePanel.add(type);
		pane.add(typePanel, new MyGridBagConstraints(10, 100, 1, 2, 1, 1));


		final TableInfoDictionary tableInfoDictionary = new TableInfoDictionary();
		pane.add(tableInfoDictionary, new MyGridBagConstraints(10, 100, 0, 3, 2, 1));

		tableInfoDictionary.getTbl().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				String id = tableInfoDictionary.getTbl().getModel().getValueAt(tableInfoDictionary.getTbl().getSelectedRow(), 8).toString();
				Dict dictionary = dictionaryRepository.find(new DictFilter.Builder().id(Long.valueOf(id)).build()).get(0);
				className.setText(dictionary.getClassName());
				subject.setText(dictionary.getSubject());
				book.setText(dictionary.getBook());
				topic.setText(dictionary.getTopic());
				link.setText(dictionary.getLink());
				type.setText(dictionary.getType());
				vocabWord.setText(dictionary.getWord());
				vocabMark.setText(dictionary.getMark().toString());
				idSelectedItem = dictionary.getId();
			}
		});

		addVocab.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				classNameBD = className.getText();
				subjectBD = subject.getText();
				bookBD = book.getText();
				topicBD = topic.getText();
				wordBD = vocabWord.getText();
				markBD = Integer.parseInt(vocabMark.getText());
				linkBD = link.getText();
				typeBD = type.getText();
				dictionaryRepository.save(new Dict(classNameBD, wordBD,linkBD, subjectBD, bookBD, topicBD, markBD,typeBD));
				TableModelDictionary tModel = new TableModelDictionary(dictionaryRepository.findAll());
				tableInfoDictionary.getTbl().setModel(tModel);
			}
		});

		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id =
						tableInfoDictionary.getTbl().getModel().getValueAt(tableInfoDictionary.getTbl().getSelectedRow(), 8).toString();
				dictionaryRepository.delete(Long.valueOf(id));
				TableModelDictionary tModel = new TableModelDictionary(dictionaryRepository.findAll());
				tableInfoDictionary.getTbl().setModel(tModel);
			}
		});

		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (idSelectedItem != null) {
					dictionaryRepository.delete(idSelectedItem);
					idSelectedItem =
							dictionaryRepository.save(
									new Dict(className.getText(), vocabWord.getText(),link.getText(), subject.getText(), book.getText(), topic.getText(),
											Integer.parseInt(vocabMark.getText()),type.getText())).getId();
					TableModelDictionary tModel = new TableModelDictionary(dictionaryRepository.findAll());
					tableInfoDictionary.getTbl().setModel(tModel);
				}
			}
		});
	}
}
