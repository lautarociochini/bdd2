/**
 * 
 */
package bd2.Muber.model.clasesDAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bd2.Muber.model.clasesDAO.ViajeDAO;

/**
 * @author GM
 *
 */
public class ViajeDAOImpl implements ViajeDAO {

	/* (non-Javadoc)
	 * @see bd2.Muber.model.clasesDAO.ViajeDAO#getAllViajesAbiertos(org.hibernate.Session)
	 */
	@Override
	public List<String> getAllViajesAbiertos(Session session) {
		Query query = session.createQuery("SELECT V.origen, V.destino, V.costoTotal, V.fecha FROM Viaje V WHERE V.finalizado = '0' ");
		@SuppressWarnings("unchecked")
		List<String> list = query.list();
		return list;
	}

}
