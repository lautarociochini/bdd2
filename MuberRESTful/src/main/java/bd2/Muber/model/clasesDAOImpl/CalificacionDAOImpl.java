/**
 * 
 */
package bd2.Muber.model.clasesDAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bd2.Muber.model.Calificacion;
import bd2.Muber.model.Viaje;
import bd2.Muber.model.clasesDAO.CalificacionDAO;

/**
 * @author GM
 *
 */
public class CalificacionDAOImpl implements CalificacionDAO {

	

	@Override
	public void createCalificacion(Session session, Calificacion calificacion) {
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.save(calificacion);
			session.flush();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		
	}

	@Override
	public List<Calificacion> existeCalificacion(Session session, long idPasajero, long idViaje) {
		Query query = session.createQuery("FROM Calificacion C WHERE C.pasajero.idUsuario = :idPasajero and C.viaje.idViaje = :idViaje ");
		query.setParameter("idPasajero", idPasajero);
		query.setParameter("idViaje", idViaje);
		@SuppressWarnings("unchecked")
		List<Calificacion> list = query.list();
		return list;
		
	}

}
