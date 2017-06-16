package bd2.Muber.repositories;

import java.util.List;

import org.hibernate.Session;

import bd2.Muber.model.Pasajero;

/**
 * @author GM
 * Interface para representar a la clase de repositorio de Pasajero
 * Define métodos para obtener los pasajeros y obtener uno a través de su id
 */


public interface PasajeroRepository extends BaseRepository {
	
	 List<Pasajero> getAllPasajeros();

	List<Pasajero> getById(long idPasajero);

	void updatePasajero(Session session, Pasajero pasajero);



}
