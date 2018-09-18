package com.dictionary.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dictionary.dao.InfoDao;
import com.dictionary.dao.filters.InfoFilter;
import com.dictionary.model.Info;
import com.dictionary.utils.HibernateUtil;
import com.google.common.collect.Lists;


public class InfoDaoImpl implements InfoDao {

	@Override
	public List<Info> findAll() {
		List<Info> info = Lists.newArrayList();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			info = session.createCriteria(Info.class).list();
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
		return info;
	}

	@Override
	public List<Info> find(InfoFilter filter) {
		Session session = null;
		List<Info> infos = Lists.newArrayList();
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			String textQuery = filter.getQuery("Info", filter);
			Query query = session.createQuery(textQuery);
			infos = (List<Info>) query.list();
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
		return infos;
	}

	@Override
	public Info save(Info dict) {
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
		Info dict = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			dict = (Info) session.load(Info.class, id);
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
}
