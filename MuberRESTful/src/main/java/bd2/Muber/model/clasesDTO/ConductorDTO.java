package bd2.Muber.model.clasesDTO;

import java.util.Collection;
import java.util.HashSet;

import bd2.Muber.model.Viaje;

public class ConductorDTO extends UsuarioDTO {
	
	protected String licencia;
	protected float puntaje;
	protected Collection<Viaje> viajes = new HashSet<Viaje>();
	
	public ConductorDTO() {
		super();
	}
	
	 public String getLicencia() {
		return licencia;
	}
	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}
	public float getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(float puntaje) {
		this.puntaje = puntaje;
	}
	public Collection<Viaje> getViajes() {
		return viajes;
	}
	public void setViajes(Collection<Viaje> viajes) {
		this.viajes = viajes;
	}

}
