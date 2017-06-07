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
	
	private Session session;
	
	@Override
	public Session getSession() {
		if (session == null) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		@SuppressWarnings("deprecation")
		SessionFactory factory = cfg.buildSessionFactory();
		session = factory.openSession();
		}
		return session;
	}

}
