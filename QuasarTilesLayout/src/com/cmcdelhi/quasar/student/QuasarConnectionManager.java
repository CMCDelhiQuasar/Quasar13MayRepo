package com.cmcdelhi.quasar.student;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cmcdelhi.quasar.util.log.Log;

/**
 * @author Gufran Khurshid
 * 
 */

public class QuasarConnectionManager {

	private static volatile QuasarConnectionManager quasarConnectionManager;
	private SessionFactory sessionFactory;
	private Session session;

	private QuasarConnectionManager() throws HibernateException {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Log.i("Session Factory Created");

	}

	public static QuasarConnectionManager getInstance() {
		if (quasarConnectionManager == null) {
			synchronized (QuasarConnectionManager.class) {
				if (quasarConnectionManager == null) {
					quasarConnectionManager = new QuasarConnectionManager();
					Log.i("new QUASAR ConnectionManger Object created ");
				}
			}
		} else {
			Log.i("Old QUASAR ConnectionManger object returned ");
		}
		return quasarConnectionManager;

	}

	public Session getSession() {
		session = sessionFactory.openSession();
		Log.i("Session Opened");
		return session;
	}

	// public boolean save(Object ob) throws HibernateException {
	//
	// if (session != null) {
	// session.save(ob);
	// Log.i("Object Svaed  ");
	// return true;
	// } else {
	// getSession();
	// return false;
	// }
	//
	// }
	//
	// public boolean commitSession() throws HibernateException {
	// if (session != null) {
	// session.getTransaction().commit();
	// Log.i("Tranasction Coomited ");
	// return true;
	// } else {
	// return false;
	// }
	//
	// }
	//
	// public boolean closeSession() throws HibernateException {
	// if (session != null) {
	// session.close();
	// Log.i("Session Closed ");
	// return true;
	// } else {
	// return false;
	// }
	//
	// }

}
