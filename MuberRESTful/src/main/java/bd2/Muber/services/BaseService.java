/**
 * 
 */
package bd2.Muber.services;

import bd2.Muber.repositories.ConductorRepository;
import bd2.Muber.repositories.PasajeroRepository;
import bd2.Muber.repositories.ViajeRepository;

/**
 * @author Lautaro
 * Interface que representa a la clase base de Servicios
 * Declara  los métodos para recuperar los distintos repositorios de cada clase
 */
public interface BaseService {

	PasajeroRepository getPasajerosRepository();

	ConductorRepository getConductoresRepository();

	ViajeRepository getViajesRepository();
	
	

}
