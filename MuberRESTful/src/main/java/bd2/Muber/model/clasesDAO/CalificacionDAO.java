/**
 * 
 */
package bd2.Muber.model.clasesDAO;

import java.util.List;

import org.hibernate.Session;

import bd2.Muber.model.Calificacion;
import bd2.Muber.model.Viaje;

/**
 * @author GM
 *
 */
public interface CalificacionDAO {
	public List<Calificacion> existeCalificacion(Session session, long idPasajero, long idViaje);

}
