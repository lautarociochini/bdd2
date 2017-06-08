/**
 * 
 */
package bd2.Muber.repositories;

import bd2.Muber.repositories.impl.HibernateConductoresRepository;
import bd2.Muber.repositories.impl.HibernatePasajerosRepository;

/**
 * @author Lautaro
 *
 */
public class RepositoryLocator {

		
		private static RepositoryLocator repositoryLocator;
		private PasajeroRepository pasajerosRepository;
		private ConductorRepository conductoresRepository;
		
		private RepositoryLocator() {
			
		}

		public static RepositoryLocator getInstance() {
				if (repositoryLocator == null) {
					repositoryLocator = new RepositoryLocator();
				}
				return repositoryLocator;
		}
		
		public PasajeroRepository getPasajerosRepository() {
				if (pasajerosRepository == null) {
					pasajerosRepository = new HibernatePasajerosRepository();
				}
				return pasajerosRepository;
		}

		public ConductorRepository getConductoresRepository() {
			if (conductoresRepository == null) {
				conductoresRepository = new HibernateConductoresRepository();
			}
			return conductoresRepository;
		}
	}

