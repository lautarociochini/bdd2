/**
 * 
 */
package bd2.Muber.services;

import bd2.Muber.repositories.ConductorRepository;
import bd2.Muber.repositories.PasajeroRepository;

/**
 * @author Lautaro
 *
 */
public interface BaseService {

	PasajeroRepository getPasajerosRepository();

	ConductorRepository getConductoresRepository();
	
	

}
