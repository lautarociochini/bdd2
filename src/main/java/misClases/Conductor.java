package misClases;

import java.sql.Date;

public class Conductor extends Usuario {

	protected Date licencia;
	protected float puntaje;

	public Date getLicencia() {
		return licencia;
	}
	public void setLicencia(Date licencia) {
		this.licencia = licencia;
	}
	public float getPuntaje() {
		float puntajeTotal = 0;
		for (Viaje viaje : viajes) {
			puntajeTotal = puntajeTotal + viaje.getPuntaje();
		}
		puntaje = (puntajeTotal / viajes.size());
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

	public boolean licenciaVencidaPara(Date fecha) {
		if (this.getLicencia().after(fecha)) {
			return false;
		}
			return true;
	}
	public void inicializar(String nombre, String contrasena, Date fechaIngreso, Date licencia) {
		this.setNombre(nombre);
		this.setContraseña(contrasena);
		this.setfechaIngreso(fechaIngreso);
		this.setLicencia(licencia);
		this.puntaje = 0;
	}
	
}
