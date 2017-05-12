/**
 * 
 */
package bd2.Muber.model.clasesDAO;

import org.hibernate.Session;

import bd2.Muber.model.Calificacion;

/**
 * @author GM
 *
 */
public interface CalificacionDAO {

	public void createCalificacion(Session session, Calificacion calificacion);
}
