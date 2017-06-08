/**
 * 
 */
package bd2.Muber.repositories.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bd2.Muber.repositories.BaseRepository;

/**
 * @author Lautaro
 *
 */
public class BaseHibernateRepository implements BaseRepository {

	/* (non-Javadoc)
	 * @see bd2.Muber.repositories.BaseRepository#getSession()
	 */
	protected SessionFactory sessionFactory;
	
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
