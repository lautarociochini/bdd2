/**
 * 
 */
package bd2.Muber.repositories;

import bd2.Muber.repositories.impl.HibernateConductoresRepository;
import bd2.Muber.repositories.impl.HibernatePasajerosRepository;
import bd2.Muber.repositories.impl.HibernateViajesRepository;

/**
 * @author Lautaro
 * Clase utilizada como localizador de repositorios, implementa un singleton que se encarga de 
 * crear el localizador o retornarlo en caso que ya exista
 */
public class RepositoryLocator {

		
		private static RepositoryLocator repositoryLocator;
		private PasajeroRepository pasajerosRepository;
		private ConductorRepository conductoresRepository;
		private ViajeRepository viajesRepository;
		
		private RepositoryLocator() {
			
		}
		/**
		 * Método que crea una instancia del localizador en caso que no exista
		  y luego lo retorna
		*/
		public static RepositoryLocator getInstance() {
				if (repositoryLocator == null) {
					repositoryLocator = new RepositoryLocator();
				}
				return repositoryLocator;
		}
		/**
		 * Método que crea una instancia del Repositorio de pasajeros en caso que no exista
		 * y luego lo retorna
		*/
		public PasajeroRepository getPasajerosRepository() {
				if (pasajerosRepository == null) {
					pasajerosRepository = new HibernatePasajerosRepository();
				}
				return pasajerosRepository;
		}
		/**
		 * Método que crea una instancia del Repositorio de conductores en caso que no exista
		 * y luego lo retorna
		*/

		public ConductorRepository getConductoresRepository() {
			if (conductoresRepository == null) {
				conductoresRepository = new HibernateConductoresRepository();
			}
			return conductoresRepository;
		}
		
		public ViajeRepository getViajesRepository() {
			if (viajesRepository == null) {
				viajesRepository = new HibernateViajesRepository();
			}
			return viajesRepository;
		}
	}

