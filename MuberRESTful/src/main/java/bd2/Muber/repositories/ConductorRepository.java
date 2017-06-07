/**
 * 
 */
package bd2.Muber.repositories;

import java.util.Collection;
import java.util.List;
import org.hibernate.Session;
import bd2.Muber.model.Conductor;
import bd2.Muber.dto.ConductorDTO;

/**
 * @author GM
 *
 */
public interface ConductorRepository extends BaseRepository {
	List<Conductor> getAllConductores(Session session);
	List<Conductor> getById(Session session, long id);
	Collection<String> getViajesById(Session session, long id);
	Collection<String> getInfoById(Session session, long id);
	Collection<String> getTop10(Session session);
}
