package bd2.Muber.model;

/**
 * Clase Pasajero subclase de Usuario que representa un pasajero de Muber
 */

public class Pasajero extends Usuario {

	protected float credito;

	public Pasajero() {

	}
	/**
	 * Crea un pasajero de Muber
	 * @param nombre
	 * @param contrasena
	 * @param fecha
	 * @param credito
	 */
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
	
	/**
	 * Recibe un viaje y una calificación y la última al viaje
	 * @param calificacion
	 * @param viaje
	 */
	public void calificar(Calificacion calificacion, Viaje viaje) {
		viaje.agregarCalificacion(calificacion);
		
	}

	/**
	 * Verifica que un viaje pueda ser calificado por un pasajero
	 * @param unViaje
	 * @param pasajero
	 */
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
	
	/**
	 * Recibe un viaje como parámetro y registra al pasajero al mismo
	 * @param unViaje
	 */
	public void registrarseA(Viaje unViaje) {
		unViaje.agregarPasajero(this);
	}
	
	/**
	 * Verifica que un pasajero pueda registrarse a un viaje pasado por parámetro
	 * @param unViaje
	 */
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

	/**
	 * Descuenta el crédito de un pasajero
	 * @param costoIndividual
	 */
	public void descontarCredito(float costoIndividual) {
		this.credito = this.credito - costoIndividual;

	}

	/**
	 * Cargar crédito a un pasajero
	 * @param f
	 */
	public void cargarCredito(float f) {
		this.credito= this.credito + f;
		
	}

}
