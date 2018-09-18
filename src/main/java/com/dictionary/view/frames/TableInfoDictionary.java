package com.dictionary.view.frames;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import com.dictionary.dao.DictDao;
import com.dictionary.model.Dict;
import com.dictionary.utils.Factory;
import com.dictionary.view.tableModels.TableModelDictionary;

public class TableInfoDictionary extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tbl;

	public TableInfoDictionary() {
		DictDao dictionaryRepository = Factory.getInstance().getDictDao();
		List<Dict> dictionary = dictionaryRepository.findAll();
		TableModelDictionary tModel = new TableModelDictionary(dictionary);
		tbl = new JTable(tModel);
		tbl.setGridColor(Color.black);
		//tbl.setAutoCreateRowSorter(true);
		add(new JScrollPane(tbl));
	}

	public JTable getTbl() {
		return tbl;
	}
}
