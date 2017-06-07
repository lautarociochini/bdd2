package bd2.Muber.repositories;

import java.util.List;
import org.hibernate.Session;

import bd2.Muber.model.Pasajero;


public interface PasajeroRepository extends BaseRepository {
	
	 List<Pasajero> getAllPasajeros();

	List<Pasajero> getById(Session session, long idPasajero);

	void updatePasajero(Session session, Pasajero pasajero);



}
