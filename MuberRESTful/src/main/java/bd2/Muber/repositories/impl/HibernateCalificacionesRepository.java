/**
 * 
 */
package bd2.Muber.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bd2.Muber.model.Calificacion;
import bd2.Muber.repositories.CalificacionRepository;;

/**
 * @author GM
 *
 */
public class HibernateCalificacionesRepository extends BaseHibernateRepository implements CalificacionRepository {

	public HibernateCalificacionesRepository() {
	}
	@Override
	public List<Calificacion> existeCalificacion(Session session, long idPasajero, long idViaje) {
		Query query = session.createQuery(
				"FROM Calificacion C WHERE C.pasajero.idUsuario = :idPasajero and C.viaje.idViaje = :idViaje ");
		query.setParameter("idPasajero", idPasajero);
		query.setParameter("idViaje", idViaje);
		@SuppressWarnings("unchecked")
		List<Calificacion> list = query.list();
		return list;

	}


}
