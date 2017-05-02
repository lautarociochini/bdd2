package misClases;


public class Pasajero extends Usuario {

	protected float credito;
	
	public Pasajero(){
		
	}
	
	public Pasajero(String nombre, String contrasena, String fecha, float credito) {
		super(nombre, contrasena, fecha);
		this.setCredito(credito);
	}

	public float getCredito() {
		return credito;
	}

	public void setCredito(float credito) {
		this.credito = credito;
	}
	
	public void calificar(Calificacion calificacion, Viaje unViaje) {
			if (unViaje.isFinalizado() && unViaje.pasajeros.contains(this)) {
			unViaje.agregarCalificacion(calificacion);
			} else {
				if (!unViaje.isFinalizado()) {
				System.out.println("No se puede calificar un viaje abierto");
				} else {
					System.out.println("No estas incluido en este viaje");
				}
			}
				
	}
	
	public void registrarseA(Viaje unViaje) {
		if (!unViaje.isFinalizado()) {
		unViaje.agregarPasajero(this);
		}
	}

	public void descontarCredito(float costoIndividual) {
		this.credito = this.credito - costoIndividual;
		
	}
	
}
	

