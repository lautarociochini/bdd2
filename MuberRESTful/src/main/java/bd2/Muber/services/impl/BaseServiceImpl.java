/**
 * 
 */
package bd2.Muber.services.impl;

import bd2.Muber.repositories.ConductorRepository;
import bd2.Muber.repositories.PasajeroRepository;
import bd2.Muber.repositories.RepositoryLocator;
import bd2.Muber.services.BaseService;

/**
 * @author Lautaro
 *
 */
public class BaseServiceImpl implements BaseService {
	
	protected RepositoryLocator repositoryLocator;

	@Override
	public PasajeroRepository getPasajerosRepository() {
		return repositoryLocator.getInstance().getPasajerosRepository();
	}
	
	@Override
	public ConductorRepository getConductoresRepository() {
		return repositoryLocator.getInstance().getConductoresRepository();
	
	}
	
}
