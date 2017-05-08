/**
 * 
 */
package bd2.Muber.model.clasesDAO;

import java.util.List;

import org.hibernate.Session;

import bd2.Muber.model.Viaje;

/**
 * @author GM
 *
 */
public interface ViajeDAO {
	List<String> getAllViajesAbiertos(Session session);
	public void createViaje(Session session, Viaje viaje);
}
