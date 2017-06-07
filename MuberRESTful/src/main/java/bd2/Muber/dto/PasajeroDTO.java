package bd2.Muber.dto;

public class PasajeroDTO extends UsuarioDTO {

	protected float credito;
	
	public PasajeroDTO() {
		super();
	}

	public float getCredito() {
		return credito;
	}

	public void setCredito(float credito) {
		this.credito = credito;
	}
	
}
