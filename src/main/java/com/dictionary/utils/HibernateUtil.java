package com.dictionary.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public final class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		catch (Throwable ex) {

			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
