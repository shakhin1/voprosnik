package com.dictionary.view.tableModels;

import java.util.List;

import com.dictionary.model.Dict;

public class TableModelDictionary extends TableModel {
    private List<Dict> dictionary;

    public TableModelDictionary(List<Dict> dictionary) {
        super(dictionary);
        this.dictionary = dictionary;
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return dictionary.get(rowIndex).getWord();
            case 1:
                return dictionary.get(rowIndex).getType();
            case 2:
                return dictionary.get(rowIndex).getClassName();
            case 3:
                return dictionary.get(rowIndex).getSubject();
            case 4:
                return dictionary.get(rowIndex).getBook();
            case 5:
                return dictionary.get(rowIndex).getTopic();
            case 6:
                return dictionary.get(rowIndex).getMark().toString();
            case 7:
                return dictionary.get(rowIndex).getLink();
            case 8:
                return dictionary.get(rowIndex).getId().toString();
            default:
                return "";
        }
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Слово";
            case 1:
                return "Тип";
            case 2:
                return "Класс";
            case 3:
                return "Предмет";
            case 4:
                return "Тема";
            case 5:
                return "Вопросы";
            case 6:
                return "Оценка";
            case 7:
                return "Ссылка";
            default:
                return "";
        }
    }

    @Override
    public int getColumnCount() {
        return 8;
    }
}
