package misClases;

import java.sql.Date;
import java.util.Collection;

public class Viaje {
	
	private String destino;
	private String origen;
	private float costoTotal;
	private Date fecha;
	private int maxPasajeros;
	private boolean finalizado;
	private Conductor conductor;
	private Collection<Pasajero> pasajeros;
	private Collection<Calificacion> calificaciones;	
	
	
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
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

	public void inicializar(float costoTotal, Date fecha, String destino, String origen, int maxPasajeros, Conductor conductor) {
		this.setConductor(conductor);
		this.setCostoTotal(costoTotal);
		this.setDestino(destino);
		this.setFinalizado(false);
		this.setFecha(fecha);
		this.setMaxPasajeros(maxPasajeros);
		this.setOrigen(origen);
	}
	public void finalizar() {
		this.setFinalizado(true);		
	}
	
	

}
