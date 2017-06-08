/**
 * 
 */
package bd2.Muber.repositories.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
import bd2.Muber.model.Conductor;
import bd2.Muber.repositories.ConductorRepository;
import bd2.Muber.dto.ConductorDTO;

/**
 * @author GM
 *
 */
public class HibernateConductoresRepository extends BaseHibernateRepository implements ConductorRepository {

	/* (non-Javadoc)
	 * @see bd2.Muber.model.clasesDAO.ConductorDAO#getAllConductores(org.hibernate.Session)
	 */
	
	public HibernateConductoresRepository() {
	}
	@Override
	@Transactional
	public List<Conductor> getAllConductores() {
		Query query = getSession().createQuery("FROM Conductor C");
		@SuppressWarnings("unchecked")
		List<Conductor> list = query.list();
		return list;
	}

	@Override
	@Transactional
	public List<String> getInfoById(Session session, long id) {
		Query query = session.createQuery("SELECT C.nombre, C.puntaje, C.licencia FROM Conductor C WHERE C.idUsuario = :id ");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<String> list = query.list();
		return list;
	}

	@Override
	@Transactional
	public Collection<String> getViajesById(Session session, long id) {
		Query query = session.createQuery("SELECT V.origen, V.destino, V.costoTotal, V.fecha FROM Viaje V WHERE V.conductor.idUsuario = :id ");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<String> list = query.list();
		return list;
	}

	@Override
	public List<Conductor> getById(Session session, long id) {
		Query query = session.createQuery("FROM Conductor C WHERE C.idUsuario = :id ");
		query.setParameter("id", id);
		// return (Conductor) query;
		@SuppressWarnings("unchecked")
		List<Conductor> list = query.list();
		return list;		
	}

	@Override
	public Collection<String> getTop10(Session session) {
		Query query = session.createQuery("SELECT C.nombre, C.puntaje "
				+ "FROM Conductor C "
				+ "WHERE C.idUsuario not in ( Select distinct C.idUsuario From Conductor C join C.viajes V where V.finalizado = false)"
				+ "ORDER BY C.puntaje desc");
		query.setMaxResults(10);		
		@SuppressWarnings("unchecked")
		List<String> list = query.list();
		return list;
	}

}
