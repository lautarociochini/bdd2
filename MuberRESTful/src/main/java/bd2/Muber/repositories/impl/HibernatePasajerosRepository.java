/**
 * 
 */
package bd2.Muber.repositories.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import bd2.Muber.repositories.PasajeroRepository;
import bd2.Muber.model.Pasajero;

/**
 * @author GM
 * Clase que implementa al repositorio de Pasajeros
 */
public class HibernatePasajerosRepository extends BaseHibernateRepository implements PasajeroRepository {

	/*
	 * (non-Javadoc)
	 * 
	 * @see bd2.Muber.model.clasesDAO.PasajeroDAO#getAllPasajeros(org.hibernate.
	 * Session)
	 */

	public HibernatePasajerosRepository() {
	}

	/**
	 * Método que recupera todos los pasajeros de Muber
	 **/
	@Override
	@Transactional
	public List<Pasajero> getAllPasajeros() {
		Query query = this.getSession().createQuery("FROM Pasajero P");
		@SuppressWarnings("unchecked")
		List<Pasajero> list = query.list();
		return list;
	}
	/**
	 * Método que recupera un pasajero de Muber a través de su id
	 * @param idPasajero
	 **/

	@Override
	public List<Pasajero> getById(long idPasajero) {
		Query query = getSession().createQuery("FROM Pasajero P WHERE P.idUsuario = :id ");
		query.setParameter("id", idPasajero);
		@SuppressWarnings("unchecked")
		List<Pasajero> list = query.list();
		return list;

	}

	@Override
	public void updatePasajero(Session session, Pasajero pasajero) {
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.update(pasajero);
			session.flush();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		
	}

}
