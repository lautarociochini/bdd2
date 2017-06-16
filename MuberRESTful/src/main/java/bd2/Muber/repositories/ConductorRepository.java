/**
 * 
 */
package bd2.Muber.repositories;

import java.util.Collection;
import java.util.List;
import org.hibernate.Session;
import bd2.Muber.model.Conductor;
import bd2.Muber.model.Viaje;
import bd2.Muber.dto.ConductorDTO;

/**
 * @author GM
 * Interface para representar a la clase de repositorios de Conductor
 * Define métodos para obtener todos los conductores, obtener uno a través de su id
 * y el top10 de conductores 
 */
public interface ConductorRepository extends BaseRepository {
	List<Conductor> getAllConductores();
	List<Conductor> getById(long id);
	List<Viaje> getViajesById(long id);
	List<Conductor> getInfoById(long id);
	List<Conductor> getTop10();
}
