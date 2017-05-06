/**
 * 
 */
package bd2.Muber.model.clasesDAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

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
	public List<String> getAllConductores(Session session) {
		Query query = session.createQuery("SELECT C.nombre FROM Conductor C");
		@SuppressWarnings("unchecked")
		List<String> list = query.list();
		return list;
	}

}
