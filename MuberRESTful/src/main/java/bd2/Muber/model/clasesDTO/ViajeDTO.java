package bd2.Muber.model.clasesDTO;

import java.util.Collection;
import java.util.HashSet;

import bd2.Muber.model.Calificacion;
import bd2.Muber.model.Conductor;
import bd2.Muber.model.Pasajero;

public class ViajeDTO {

	protected String destino;
	protected String origen;
	protected float costoTotal;
	protected String fecha;
	protected int maxPasajeros;
	protected boolean finalizado;
	protected Conductor conductor;
	protected Collection<Pasajero> pasajeros = new HashSet<Pasajero>();
	protected Collection<Calificacion> calificaciones = new HashSet<Calificacion>();
	protected float puntaje;
	private long idViaje;
	
	public ViajeDTO() {
		super();
	}
	
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public float getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(float costoTotal) {
		this.costoTotal = costoTotal;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getMaxPasajeros() {
		return maxPasajeros;
	}
	public void setMaxPasajeros(int maxPasajeros) {
		this.maxPasajeros = maxPasajeros;
	}
	public boolean isFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	public Conductor getConductor() {
		return conductor;
	}
	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}
	public Collection<Pasajero> getPasajeros() {
		return pasajeros;
	}
	public void setPasajeros(Collection<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}
	public Collection<Calificacion> getCalificaciones() {
		return calificaciones;
	}
	public void setCalificaciones(Collection<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}
	public float getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(float puntaje) {
		this.puntaje = puntaje;
	}
	public long getIdViaje() {
		return idViaje;
	}
	public void setIdViaje(long idViaje) {
		this.idViaje = idViaje;
	}

	
}
