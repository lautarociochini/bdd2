package bd2.Muber.model.clasesDAO;

import java.util.List;
import org.hibernate.Session;

import bd2.Muber.model.Pasajero;
import bd2.Muber.model.clasesDTO.PasajeroDTO;

public interface PasajeroDAO {
	List<Pasajero> getAllPasajeros(Session session);

	public List<PasajeroDTO> getAllPasajerosAsPasajeroDTO(Session session);

	List<Pasajero> getById(Session session, long idPasajero);

	void updatePasajero(Session session, Pasajero pasajero);

}
