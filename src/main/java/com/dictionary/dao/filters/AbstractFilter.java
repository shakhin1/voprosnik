package com.dictionary.dao.filters;

import java.lang.reflect.Field;


public class AbstractFilter {
	private final String AND = " AND ";
	private final String FROM = "FROM ";
	private final String WHERE = " WHERE ";

	public <T extends AbstractFilter> String getQuery(String tableName, T entity) throws IllegalAccessException {
		StringBuilder sb = new StringBuilder();
		boolean useWhere = false;
		sb.append(FROM + tableName);
		for (Field field : entity.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			if (field.get(entity) != null) {
				if (!useWhere) {
					sb.append(WHERE);
				}
				Object nameValue = field.get(entity);
				sb.append(field.getName() + " = '" + nameValue + "'" + AND);
				useWhere = true;
			}
		}
		return useWhere ? sb.substring(0, sb.length() - AND.length()) : sb.toString();
	}

}
