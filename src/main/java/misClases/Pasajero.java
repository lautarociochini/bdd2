package misClases;

public class Pasajero extends Usuario {

	private float credito;	

	public float getCredito() {
		return credito;
	}

	public void setCredito(float credito) {
		this.credito = credito;
	}
	
	public void calificar(Viaje unViaje, int puntaje, String comentario) {
			Calificacion calificacion = new Calificacion();
			calificacion.inicializar(unViaje, puntaje, comentario, this);		
	}
	
	public void registrarseA(Viaje unViaje) {
		unViaje.agregarPasajero(this);
	}
	
}
	

