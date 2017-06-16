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
 * Clase que implementa al repositorio de Calificaciones
 */
public class HibernateCalificacionesRepository extends BaseHibernateRepository implements CalificacionRepository {

	public HibernateCalificacionesRepository() {
	}
	@Override
	
	/**
	 * Método que devuelve una lista(1) de calificaciones
	 * @param session
	 * @param idPasajero
	 * @param idViaje
	 **/
	public List<Calificacion> existeCalificacion(long idPasajero, long idViaje) {
		Query query = getSession().createQuery(
				"FROM Calificacion C WHERE C.pasajero.idUsuario = :idPasajero and C.viaje.idViaje = :idViaje ");
		query.setParameter("idPasajero", idPasajero);
		query.setParameter("idViaje", idViaje);
		@SuppressWarnings("unchecked")
		List<Calificacion> list = query.list();
		return list;

	}


}
