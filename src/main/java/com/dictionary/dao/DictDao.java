package com.dictionary.dao;

import java.util.List;

import com.dictionary.dao.filters.DictFilter;
import com.dictionary.model.Dict;


public interface DictDao {

	public List<Dict> findAll();

	public List<Dict> find(DictFilter filter);

	public Dict save(Dict dict);

	public void delete(Long id);

	public Dict findOne(Long id);

}
