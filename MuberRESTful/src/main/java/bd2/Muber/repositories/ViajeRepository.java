/**
 * 
 */
package bd2.Muber.repositories;

import java.util.List;

import org.hibernate.Session;
import bd2.Muber.model.Viaje;

/**
 * @author GM
 *
 */
public interface ViajeRepository extends BaseRepository {
	List<String> getAllViajesAbiertos(Session session);
	List<Viaje> getById(Session session, long idViaje);
	void updateViaje(Session session, Viaje viaje);

}
