package com.dictionary.dao;

import java.util.List;

import com.dictionary.dao.filters.InfoFilter;
import com.dictionary.model.Info;


public interface InfoDao {

	public List<Info> findAll();

	public List<Info> find(InfoFilter filter);

	public Info save(Info dict);

	public void delete(Long id);

}
