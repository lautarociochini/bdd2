/**
 * 
 */
package bd2.Muber.repositories;

import java.util.List;

import org.hibernate.Session;

import bd2.Muber.model.Calificacion;

/**
 * @author GM
 *
 */
public interface CalificacionRepository extends BaseRepository {
	public List<Calificacion> existeCalificacion(Session session, long idPasajero, long idViaje);

}
