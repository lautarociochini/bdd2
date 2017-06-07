package bd2.Muber.dto;

import bd2.Muber.model.Pasajero;
import bd2.Muber.model.Viaje;

public class CalificacionDTO {
	
	protected String comentario;
	protected int puntaje;
	protected Pasajero pasajero;
	protected Viaje viaje;
	private long idCalificacion;
	
	public CalificacionDTO() {
		super();
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
	public void setIdCalificacion(long idCalificacion) {
		this.idCalificacion = idCalificacion;
	}


}
