/**
 * 
 */
package bd2.Muber.model.clasesDAOImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bd2.Muber.model.Calificacion;
import bd2.Muber.model.clasesDAO.CalificacionDAO;

/**
 * @author GM
 *
 */
public class CalificacionDAOImpl implements CalificacionDAO {

	

	@Override
	public void createCalificacion(Session session, Calificacion calificacion) {
		session.save(calificacion);
		session.flush();
		
	}

}
