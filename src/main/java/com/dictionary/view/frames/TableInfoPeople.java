package com.dictionary.view.frames;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import com.dictionary.dao.InfoDao;
import com.dictionary.model.Info;
import com.dictionary.utils.Factory;
import com.dictionary.view.tableModels.TableModelPeople;

public class TableInfoPeople extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tbl;

	public TableInfoPeople() {
		InfoDao informationRepository = Factory.getInstance().getInfoDao();
		List<Info> informations = informationRepository.findAll();
		TableModelPeople tModel = new TableModelPeople(informations);
		tbl = new JTable(tModel);
		tbl.setGridColor(Color.black);
		//tbl.setAutoCreateRowSorter(true);
		add(new JScrollPane(tbl));
	}

	public JTable getTbl() {
		return tbl;
	}
}
