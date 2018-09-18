package com.dictionary.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.dictionary.dao.InfoDao;
import com.dictionary.utils.Factory;
import com.dictionary.view.frames.TableInfoPeople;
import com.dictionary.view.grid.MyGridBagConstraints;
import com.dictionary.view.tableModels.TableModelPeople;

public class TestGUIAdminPeople extends GUI {
	private InfoDao informationRepository;

	protected void addComponentsToPane(final Container pane) {
		pane.setLayout(new GridBagLayout());
		informationRepository = Factory.getInstance().getInfoDao();

		JPanel vocabPanel = new JPanel();
		final JButton delete = new JButton("Удалить");
		vocabPanel.add(delete);
		pane.add(vocabPanel, new MyGridBagConstraints(10, 20, 0, 0, 2, 1));

		final TableInfoPeople tableInfoPeople = new TableInfoPeople();
		pane.add(tableInfoPeople, new MyGridBagConstraints(10, 200, 0, 2, 2, 1));

		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = tableInfoPeople.getTbl().getModel().getValueAt(tableInfoPeople.getTbl().getSelectedRow(), ID_NUMBER).toString();
				informationRepository.delete(Long.valueOf(id));
				final TableModelPeople tModel = new TableModelPeople(informationRepository.findAll());
				tableInfoPeople.getTbl().setModel(tModel);
			}
		});
	}
}
