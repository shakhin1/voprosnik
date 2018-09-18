package com.dictionary.view.tableModels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public abstract class TableModel extends AbstractTableModel {
	private List<?> data;

	public TableModel(List<?> data) {
		super();
		this.data = data;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return 6;
	}
}
