/**
 * 
 */
package bd2.Muber.model;

/**
 * @author GM
 * Clase que representa la relación entre un viaje y un pasajero
 * Fue creada sólo para respetar el método PUT que recibe dos valores tanto del idPasajero y IdUsuario
 */
public class ViajePasajero {

	private long idViaje;
	private long idUsuario;
	
	public void setIdViaje(long idViaje) {
		this.idViaje = idViaje;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public long getIdViaje() {
		// TODO Auto-generated method stub
		return idViaje;
	}

	public long getIdUsuario() {
		// TODO Auto-generated method stub
		return idUsuario;
	}

	

}
