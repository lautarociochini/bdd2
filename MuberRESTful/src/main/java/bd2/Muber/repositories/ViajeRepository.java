/**
 * 
 */
package bd2.Muber.repositories;

import java.util.List;

import org.hibernate.Session;
import bd2.Muber.model.Viaje;

/**
 * @author GM
 * Interface que representa a la clase del Repositorio de Viajes
 * Define métodos para devolver los viajes abiertos y para obtener uno a través de su Id
 */
public interface ViajeRepository extends BaseRepository {
	List<Viaje> getAllViajesAbiertos();
	List<Viaje> getById(long idViaje);
	void updateViaje(Session session, Viaje viaje);

}
