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
 * Implementación de la clase de Repositorio Base
 * Contiene una variable de SessionFactory
 */
public class BaseHibernateRepository implements BaseRepository {

	/* (non-Javadoc)
	 * @see bd2.Muber.repositories.BaseRepository#getSession()
	 */
	protected SessionFactory sessionFactory;
	
	/**
	 * Método que le pide la sesión actual al sessionFactory y la retorna
	 **/
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
