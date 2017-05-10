/**
 * 
 */
package bd2.Muber.model.clasesDAOImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import bd2.Muber.model.clasesDAO.PasajeroDAO;
import bd2.Muber.model.clasesDTO.PasajeroDTO;
import bd2.Muber.model.Pasajero;

/**
 * @author GM
 *
 */
public class PasajeroDAOImpl implements PasajeroDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see bd2.Muber.model.clasesDAO.PasajeroDAO#getAllPasajeros(org.hibernate.
	 * Session)
	 */

	public PasajeroDAOImpl() {
	}

	@Override
	@Transactional
	public List<Pasajero> getAllPasajeros(Session session) {
		Query query = session.createQuery("FROM Pasajero P");
		@SuppressWarnings("unchecked")
		List<Pasajero> list = query.list();
		return list;
	}

	public List<PasajeroDTO> getAllPasajerosAsPasajeroDTO(Session session) {
		List<PasajeroDTO> pasajeroDTOs = new ArrayList<PasajeroDTO>();
		for(Pasajero pasajero : getAllPasajeros(session)) {
	        pasajeroDTOs.add(constructPasajeroDTO(pasajero));
	    }

	    return pasajeroDTOs;
	}

	private PasajeroDTO constructPasajeroDTO(Pasajero pasajero) {
		 	PasajeroDTO pasajeroDTO = new PasajeroDTO();
		    pasajeroDTO.setNombre(pasajero.getNombre());
		    pasajeroDTO.setContrasena(pasajero.getContrasena());
		    pasajeroDTO.setFechaIngreso(pasajero.getfechaIngreso());
		    pasajeroDTO.setIdUsuario(pasajero.getIdUsuario());
		    pasajeroDTO.setCredito(pasajero.getCredito());
		    return pasajeroDTO;
	}
}
