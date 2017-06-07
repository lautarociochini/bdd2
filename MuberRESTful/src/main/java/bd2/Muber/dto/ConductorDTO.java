package bd2.Muber.dto;


public class ConductorDTO extends UsuarioDTO {
	
	protected String licencia;
	protected float puntaje;
	
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


}
