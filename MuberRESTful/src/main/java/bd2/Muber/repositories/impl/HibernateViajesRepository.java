/**
 * 
 */
package bd2.Muber.repositories.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import bd2.Muber.model.Viaje;
import bd2.Muber.repositories.ViajeRepository;

/**
 * @author GM
 * Clase que implementa al repositorio de Viajes
 */
public class HibernateViajesRepository extends BaseHibernateRepository implements ViajeRepository {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * bd2.Muber.model.clasesDAO.ViajeDAO#getAllViajesAbiertos(org.hibernate.
	 * Session)
	 */
	
	public HibernateViajesRepository() {
	}
	
	/**
	 * Método que recupera todos los Viajes abiertos de Muber
	 **/
	@Override
	@Transactional
	public List<Viaje> getAllViajesAbiertos() {
		Query query = getSession().createQuery(
				"SELECT V.origen, V.destino, V.costoTotal, V.fecha FROM Viaje V WHERE V.finalizado = '0' ");
		@SuppressWarnings("unchecked")
		List<Viaje> list = query.list();
		return list;
	}

	/**
	 * Método que recupera un Viaje de Muber a través de su id
	 * @param idViaje
	 **/
	@Override
	public List<Viaje> getById(long idViaje) {
		Query query = getSession().createQuery("FROM Viaje V WHERE V.idViaje = :id ");
		query.setParameter("id", idViaje);
		@SuppressWarnings("unchecked")
		List<Viaje> list = query.list();
		return list;
	}

	@Override
	public void updateViaje(Session session, Viaje viaje) {
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.update(viaje);
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
