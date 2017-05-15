/**
 * 
 */
package bd2.Muber.model.clasesDAO;

import java.util.Collection;
import java.util.List;
import org.hibernate.Session;
import bd2.Muber.model.Conductor;
import bd2.Muber.model.clasesDTO.ConductorDTO;

/**
 * @author GM
 *
 */
public interface ConductorDAO {
	List<Conductor> getAllConductores(Session session);
	List<Conductor> getById(Session session, long id);
	Collection<String> getViajesById(Session session, long id);
	Collection<String> getInfoById(Session session, long id);
	public List<ConductorDTO> getAllConductoresAsConductorDTO(Session session);
}
