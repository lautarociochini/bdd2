/**
 * 
 */
package bd2.Muber.model.clasesDAO;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import bd2.Muber.model.Conductor;

/**
 * @author GM
 *
 */
public interface ConductorDAO {
	List<String> getAllConductores(Session session);
	List<Conductor> getById(Session session, long id);
	Collection<String> getViajesById(Session session, long id);
	Collection<String> getInfoById(Session session, long id);
}
