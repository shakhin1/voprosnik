package com.dictionary.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dictionary.dao.DictDao;
import com.dictionary.dao.filters.DictFilter;
import com.dictionary.model.Dict;
import com.dictionary.utils.HibernateUtil;
import com.google.common.collect.Lists;


public class DictDaoImpl implements DictDao {

	public List<Dict> findAll() {
		List<Dict> dicts = Lists.newArrayList();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			dicts = session.createCriteria(Dict.class).list();
			session.getTransaction().commit();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error findAll", JOptionPane.OK_OPTION);
		}
		finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return dicts;
	}

	public List<Dict> find(DictFilter filter) {
		Session session = null;
		List<Dict> dicts = Lists.newArrayList();
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			String textQuery = filter.getQuery("Dict", filter);
			Query query = session.createQuery(textQuery);
			dicts = (List<Dict>) query.list();
			session.getTransaction().commit();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error find", JOptionPane.OK_OPTION);
		}
		finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return dicts;
	}

	public Dict save(Dict dict) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(dict);
			session.getTransaction().commit();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error save", JOptionPane.OK_OPTION);
		}
		finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return dict;
	}

	@Override
	public void delete(Long id) {
		Session session = null;
		Dict dict = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			dict = (Dict) session.load(Dict.class, id);
			session.delete(dict);
			session.getTransaction().commit();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error delete", JOptionPane.OK_OPTION);
		}
		finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public Dict findOne(Long id) {
		Session session = null;
		Dict dict = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			dict = (Dict) session.load(Dict.class, id);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error findOne", JOptionPane.OK_OPTION);
		}
		finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return dict;
	}

}
