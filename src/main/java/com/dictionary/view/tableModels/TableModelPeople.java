package com.dictionary.view.tableModels;

import java.util.List;

import com.dictionary.model.Info;

public class TableModelPeople extends TableModel {
	private List<Info> informations;

	public TableModelPeople(List<Info> informations) {
		super(informations);
		this.informations = informations;
	}

	@Override
	public String getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return informations.get(rowIndex).getFio();
		case 1:
			return informations.get(rowIndex).getNameOfClass();
		case 2:
			return informations.get(rowIndex).getSubject();
		case 3:
			return informations.get(rowIndex).getBook();
		case 4:
			return informations.get(rowIndex).getTopic();
		case 5:
			return informations.get(rowIndex).getMark().toString();
		case 6:
			return informations.get(rowIndex).getId().toString();
		default:
			return "";
		}
	}

	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "ФИО";
		case 1:
			return "Класс";
		case 2:
			return "Предмет";
		case 3:
			return "Тема";
		case 4:
			return "Вопросы";
		case 5:
			return "Оценка";
		default:
			return "";
		}
	}
}
