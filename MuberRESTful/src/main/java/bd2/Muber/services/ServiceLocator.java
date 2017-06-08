package bd2.Muber.services;

import bd2.Muber.services.impl.PasajerosServiceImpl;

public class ServiceLocator {
	
	private static ServiceLocator serviceLocator;
	private PasajerosService pasajerosService;
	
	private ServiceLocator() {
		
	}

	public static ServiceLocator getInstance() {
			if (serviceLocator == null) {
				serviceLocator = new ServiceLocator();
			}
			return serviceLocator;
	}
	
	public PasajerosService getPasajerosService() {
			if (pasajerosService == null) {
				pasajerosService = new PasajerosServiceImpl();
			}
			return pasajerosService;
	}
	
}
