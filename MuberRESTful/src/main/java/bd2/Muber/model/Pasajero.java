package bd2.Muber.model;

public class Pasajero extends Usuario {

	protected float credito;

	public Pasajero() {

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

	public void calificar(Calificacion calificacion, Viaje viaje) {
		viaje.agregarCalificacion(calificacion);
		
	}

	public int okCalificar(Viaje unViaje, Pasajero pasajero) {
		if (unViaje.isFinalizado() && unViaje.pasajeros.contains(pasajero)) {
			return 0;
		} else {

			if (!unViaje.isFinalizado()) {
				return 1;
			} else {
				return 2;
			}
		}
	}

	public void registrarseA(Viaje unViaje) {
		unViaje.agregarPasajero(this);
	}

	public int okRegistrarseA(Viaje unViaje) {
		if (!unViaje.isFinalizado()) {
			boolean okAgregar = unViaje.okAgregar(this);
			if (okAgregar) {
				return 0;
			} else {
				return 1;
			}

		} else {
			return 2;
		}
	}

	public void descontarCredito(float costoIndividual) {
		this.credito = this.credito - costoIndividual;

	}

	public void cargarCredito(float f) {
		this.credito= this.credito + f;
		
	}

}
