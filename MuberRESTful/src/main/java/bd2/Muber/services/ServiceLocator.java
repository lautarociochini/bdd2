package bd2.Muber.services;

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
		return this.pasajerosService ;
	}
	
}
