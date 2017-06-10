package bd2.Muber.dto;

/**
 * Clase PasajeroDTO utilizada para representar a un pasajero en el controlador
 * 
 */
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
