/**
 * 
 */
package bd2.Muber.services.impl;

import bd2.Muber.dto.DTOFactory;
import bd2.Muber.repositories.ConductorRepository;
import bd2.Muber.repositories.PasajeroRepository;
import bd2.Muber.repositories.RepositoryLocator;
import bd2.Muber.repositories.ViajeRepository;
import bd2.Muber.services.BaseService;

/**
 * @author Lautaro
 * Implementación de la clase base de servicios
 */
public class BaseServiceImpl implements BaseService {
	
	protected DTOFactory dtoFactory;
	protected RepositoryLocator repositoryLocator;
	
	/**
	 *Método que pide al localizador de repositorios una instancia
	 *del repositorio de pasajeros y lo retorna
	 */

	@Override
	public PasajeroRepository getPasajerosRepository() {
		return repositoryLocator.getInstance().getPasajerosRepository();
	}
	
	/**
	 *Método que pide al localizador de repositorios una instancia
	 *del repositorio de conductores y lo retorna
	 */
	
	@Override
	public ConductorRepository getConductoresRepository() {
		return repositoryLocator.getInstance().getConductoresRepository();
	
	}

	@Override
	public ViajeRepository getViajesRepository() {
		return repositoryLocator.getInstance().getViajesRepository();
	}
	
}
