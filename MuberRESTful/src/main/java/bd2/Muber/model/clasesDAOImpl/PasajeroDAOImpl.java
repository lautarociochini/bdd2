/**
 * 
 */
package bd2.Muber.model.clasesDAOImpl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import bd2.Muber.model.clasesDAO.PasajeroDAO;

/**
 * @author GM
 *
 */
public class PasajeroDAOImpl implements PasajeroDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see bd2.Muber.model.clasesDAO.PasajeroDAO#getAllPasajeros(org.hibernate.
	 * Session)
	 */

	public PasajeroDAOImpl() {
	}

	@Override

	public List<String> getAllPasajeros(Session session) {
		Query query = session.createQuery("SELECT P.nombre FROM Pasajero P");
		@SuppressWarnings("unchecked")
		List<String> list = query.list();
		return list;
	}

}
