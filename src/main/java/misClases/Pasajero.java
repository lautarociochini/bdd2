package misClases;

import java.sql.Date;

public class Pasajero extends Usuario {

	protected float credito;

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

	public void inicializar(String nombre, String contrasena, Date fechaIngreso, float credito) {
		this.setNombre(nombre);
		this.setContraseña(contrasena);
		this.setfechaIngreso(fechaIngreso);
		this.setCredito(credito);
	}

	public void descontarCredito(float costoIndividual) {
		this.credito = this.credito - costoIndividual;
		
	}
	
}
	

