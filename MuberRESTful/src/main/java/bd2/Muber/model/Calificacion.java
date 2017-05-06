package bd2.Muber.model;

/**
 * Clase calificacion representa la calificacion de un usuario para un viaje
 *
 */
/**
 * @author GM
 *
 */
public class Calificacion {

	protected String comentario;
	protected int puntaje;
	protected Pasajero pasajero;
	protected Viaje viaje;
	private long idCalificacion;
	
	/**
	 * 
	 */
	public Calificacion(){
		
	}
	
	/**
	 * Asigna una calificacion y un comentario por parte de un pasajero para un viaje determinado. 
	 *
	 * @param unViaje
	 * @param puntaje
	 * @param comentario
	 * @param pasajero
	 */
	public Calificacion(Viaje unViaje, int puntaje, String comentario, Pasajero pasajero) {
		this.setViaje(unViaje);
		this.setPasajero(pasajero);
		this.setPuntaje(puntaje);
		this.setComentario(comentario);	
}
	
	/**Retorna el comentario 
	 * 
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}
	
	/**
	 * Setea el comentario
	 * 
	 * @param comentario / the new comentario
	 * 
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	/**
	 * Retorna el puntaje 
	 * 
	 * @return puntaje
	 */
	public int getPuntaje() {
		return puntaje;
	}
	/**
	 * Setea el puntaje
	 * 
	 * @param puntaje / the new puntaje
	 */
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	/**
	 * Retorna el pasajero
	 * 
	 * @return pasajero
	 */
	public Pasajero getPasajero() {
		return pasajero;
	}

	/**
	 * Setea el pasajero
	 * 
	 * @param pasajero / the new pasajero
	 */
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	/**
	 * Retorna el viaje
	 * 
	 * @return viaje
	 */
	public Viaje getViaje() {
		return viaje;
	}

	/**
	 * Setea el viaje
	 * 
	 * @param viaje / Set the new viaje
	 */
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
