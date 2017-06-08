/**
 * 
 */
package bd2.Muber.services.impl;

import java.util.List;


import bd2.Muber.dto.PasajeroDTO;
import bd2.Muber.model.Pasajero;
import bd2.Muber.repositories.PasajeroRepository;
import bd2.Muber.services.PasajerosService;
import bd2.Muber.services.ServiceLocator;
import bd2.Muber.dto.DTOFactory;

/**
 * @author Lautaro
 *
 */
public class PasajerosServiceImpl extends BaseServiceImpl implements PasajerosService {

	/* (non-Javadoc)
	 * @see bd2.Muber.services.PasajerosService#getPasajeros()
	 */
	
	
	private DTOFactory dtoFactory;
	
	@Override
	public List<PasajeroDTO> getPasajeros() {
		 List<Pasajero> pasajeros =  getPasajerosRepository().getAllPasajeros();
		 List<PasajeroDTO> pasajerosDTO = dtoFactory.getAllPasajerosAsPasajeroDTO(pasajeros);
		 return pasajerosDTO;
	}


}
