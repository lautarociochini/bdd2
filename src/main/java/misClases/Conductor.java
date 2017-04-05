package misClases;

import java.sql.Date;

public class Conductor extends Usuario {

	private Date licencia;
	private float puntaje;

	public Date getLicencia() {
		return licencia;
	}
	public void setLicencia(Date licencia) {
		this.licencia = licencia;
	}
	public float getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(float puntaje) {
		this.puntaje = puntaje;
	}

	public void crearViaje(float costoTotal, Date fecha, String destino, String origen, int maxPasajeros){
		Viaje viaje = new Viaje();
		viaje.inicializar(costoTotal, fecha, destino, origen, maxPasajeros, this);
		this.viajes.add(viaje);
	}

	public void finalizarViaje(Viaje unViaje){
		unViaje.finalizar();
	}

}
