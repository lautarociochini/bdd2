package bd2.Muber.services;

import bd2.Muber.services.impl.ConductoresServiceImpl;
import bd2.Muber.services.impl.PasajerosServiceImpl;
import bd2.Muber.services.impl.ViajesServiceImpl;
/**
* Clase que representa al localizador de servicios
* Su trabajo es retornar una instancia del servicio que se le solicite
*/

public class ServiceLocator {
	
	protected static ServiceLocator serviceLocator;
	protected PasajerosService pasajerosService;
	protected ConductoresService conductoresService;
	protected ViajesService viajesService;
	public ServiceLocator() {
		
	}

	/**
	 *Método que crea una instancia del localizador de servicios, en caso que no exista
	 *Y la retorna
	 */
	
	public static ServiceLocator getInstance() {
			if (serviceLocator == null) {
				serviceLocator = new ServiceLocator();
			}
			return serviceLocator;
	}
	
	/**
	 *Método que crea una instancia del servicio de pasajeros, en caso que no exista
	 *Y la retorna
	 */
	
	public PasajerosService getPasajerosService() {
			if (pasajerosService == null) {
				pasajerosService = new PasajerosServiceImpl();
			}
			return pasajerosService;
	}
	
	public ConductoresService getConductoresService() {
		if (conductoresService == null) {
			conductoresService = new ConductoresServiceImpl();
		}
		return conductoresService;
	}
	
	public ViajesService getViajesService() {
		if (viajesService == null) {
			viajesService = new ViajesServiceImpl();
		}
		return viajesService;
}
	
}
