/**
 * 
 */
package bd2.Muber.model.clasesDAO;

import java.util.List;

import org.hibernate.Session;

/**
 * @author GM
 *
 */
public interface ConductorDAO {
	List<String> getAllConductores(Session session);
}
