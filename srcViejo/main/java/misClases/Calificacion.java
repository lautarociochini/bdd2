package misClases;

public class Calificacion {

	protected String comentario;
	protected int puntaje;
	protected Pasajero pasajero;
	protected Viaje viaje;
	private long idCalificacion;
	
	public Calificacion(){
		
	}
	
	public Calificacion(Viaje unViaje, int puntaje, String comentario, Pasajero pasajero) {
		this.setViaje(unViaje);
		this.setPasajero(pasajero);
		this.setPuntaje(puntaje);
		this.setComentario(comentario);	
}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	public long getIdCalificacion() {
		return idCalificacion;
	}

	public void setIdCalificacion(long id) {
		this.idCalificacion = id;
	}

}
