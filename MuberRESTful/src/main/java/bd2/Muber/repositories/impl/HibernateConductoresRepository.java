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
import bd2.Muber.model.Viaje;
import bd2.Muber.repositories.ConductorRepository;
import bd2.Muber.dto.ConductorDTO;

/**
 * @author GM
 * Clase que implementa al repositorio de Conductores
 */
public class HibernateConductoresRepository extends BaseHibernateRepository implements ConductorRepository {

	/* (non-Javadoc)
	 * @see bd2.Muber.model.clasesDAO.ConductorDAO#getAllConductores(org.hibernate.Session)
	 */
	
	public HibernateConductoresRepository() {
	}
	
	/**
	 * Método que recupera todos los conductores de Muber
	 **/
	@Override
	@Transactional
	public List<Conductor> getAllConductores() {
		Query query = getSession().createQuery("FROM Conductor C");
		@SuppressWarnings("unchecked")
		List<Conductor> list = query.list();
		return list;
	}
	/**
	 * Método que recupera un conductor de Muber a través de su id
	 * @param id
	 **/
	@Override
	@Transactional
	public List<Conductor> getInfoById(long id) {
		Query query = getSession().createQuery("SELECT C.nombre, C.puntaje, C.licencia FROM Conductor C WHERE C.idUsuario = :id ");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Conductor> list = query.list();
		return list;
	}

	/**
	 * Método que recupera un Viaje de Muber a través de su id
	 * @param id
	 **/
	@Override
	@Transactional
	public List<Viaje> getViajesById(long id) {
		Query query = getSession().createQuery("SELECT V.origen, V.destino, V.costoTotal, V.fecha FROM Viaje V WHERE V.conductor.idUsuario = :id ");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Viaje> list = query.list();
		return list;
	}
	
	/**
	 * Método que recupera un Conductor de Muber a través de su id
	 * @param id
	 **/

	@Override
	public List<Conductor> getById(long id) {
		Query query = getSession().createQuery("FROM Conductor C WHERE C.idUsuario = :id ");
		query.setParameter("id", id);
		// return (Conductor) query;
		@SuppressWarnings("unchecked")
		List<Conductor> list = query.list();
		return list;		
	}

	/**
	 * Método que recupera el nombre del Top 10 de los Conductores de Muber
	 **/
	@Override
	public List<Conductor> getTop10() {
		Query query = getSession().createQuery("SELECT C.nombre, C.puntaje "
				+ "FROM Conductor C "
				+ "WHERE C.idUsuario not in ( Select distinct C.idUsuario From Conductor C join C.viajes V where V.finalizado = false)"
				+ "ORDER BY C.puntaje desc");
		query.setMaxResults(10);		
		@SuppressWarnings("unchecked")
		List<Conductor> list = query.list();
		return list;
	}

}
