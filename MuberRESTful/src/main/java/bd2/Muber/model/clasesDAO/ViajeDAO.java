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
public interface ViajeDAO {
	List<String> getAllViajesAbiertos(Session session);
}
