package bd2.Muber.model;


import java.util.Collection;
import java.util.HashSet;

/**
 * Clase Muber
 */

public class Muber {
	protected Collection<Conductor> conductores = new HashSet<Conductor>();
	protected Collection<Pasajero> pasajeros = new HashSet<Pasajero>();
	private long idMuber;
	
	public long getIdMuber() {
		return idMuber;
	}

	public void setIdMuber(long idMuber) {
		this.idMuber = idMuber;
	}

	public Muber(){
		
	}
	/**
	 * Retorna la lista de pasajeros y su información
	 */
	public void listarPasajeros() {		
		for (Pasajero pasajero : pasajeros) {
			this.informacionDePasajero(pasajero);
		}
	}
	/**
	 * Retorna la lista de conductores y su información
	 */
	public void listarConductores() {		
		for (Conductor conductor : conductores) {
			this.informacionDeConductor(conductor);
		}
	}
	/**
	 * Itera sobre la colección de conductores y devuelve todos los viajes realizados de Muber
	 */
	public void listarViajes() {
		for (Conductor conductor : this.conductores) {
			conductor.viajesRealizados();
		}
	}

	/**
	 * Itera sobre la colección de conductores y devuelve todos los viajes abiertos de Muber
	 */
	public void listarViajesAbiertos() {
		for (Conductor conductor : this.conductores) {
			conductor.viajesAbiertos();
		}
	}
	/**
	 * Agrega un conductor a Muber
	 * @param conductor
	 */
	public void agregarConductor(Conductor conductor){
		this.conductores.add(conductor);
	}
	/**
	 * Agrega un pasajero a Muber
	 * @param pasajero
	 */
	public void agregarPasajero(Pasajero pasajero){
		this.pasajeros.add(pasajero);
	}
	/**
	 * Recibe un conductor como parámetro y retorna todos los datos asociados al mismo
	 * @param conductor
	 */
	public void informacionDeConductor(Conductor conductor){
		System.out.println("Nombre: "+conductor.getNombre());
		System.out.println("Puntaje: "+conductor.getPuntaje());
		System.out.println("Vto Licencia: "+conductor.getLicencia());
		conductor.viajesRealizados();
		conductor.viajesAbiertos();
		System.out.println("");
	}
	
	/**
	 * Recibe un pasajero como parámetro y retorna todos los datos asociados al mismo
	 * @param pasajero
	 */
	public void informacionDePasajero(Pasajero pasajero){
		System.out.println("Nombre: "+pasajero.getNombre());
		System.out.println("Credito: "+pasajero.getCredito());
		System.out.println("");
	}

	public Collection<Conductor> getConductores() {
		return conductores;
	}

	public void setConductores(Collection<Conductor> conductores) {
		this.conductores = conductores;
	}

	public Collection<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(Collection<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}

}

