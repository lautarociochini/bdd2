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
	
	
	
}
