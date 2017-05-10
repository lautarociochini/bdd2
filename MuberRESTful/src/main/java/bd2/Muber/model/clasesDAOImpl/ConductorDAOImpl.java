/**
 * 
 */
package bd2.Muber.model.clasesDAOImpl;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;

import bd2.Muber.model.Conductor;
import bd2.Muber.model.clasesDAO.ConductorDAO;

/**
 * @author GM
 *
 */
public class ConductorDAOImpl implements ConductorDAO {

	/* (non-Javadoc)
	 * @see bd2.Muber.model.clasesDAO.ConductorDAO#getAllConductores(org.hibernate.Session)
	 */
	@Override
	@Transactional
	public List<String> getAllConductores(Session session) {
		Query query = session.createQuery("SELECT C.nombre FROM Conductor C");
		@SuppressWarnings("unchecked")
		List<String> list = query.list();
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
	@Transactional
	public List<Conductor> getById(Session session, long id) {
		Query query = session.createQuery("FROM Conductor C WHERE C.idUsuario = :id ");
		query.setParameter("id", id);
//		return (Conductor) query;
		@SuppressWarnings("unchecked")
		List<Conductor> list = query.list();
		session.close();
		return list;
		
		
	}

	

}
