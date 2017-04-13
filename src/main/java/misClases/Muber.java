package misClases;


import java.util.Collection;
import java.util.HashSet;

public class Muber {
	protected Collection<Conductor> conductores = new HashSet<Conductor>();
	protected Collection<Pasajero> pasajeros = new HashSet<Pasajero>();
	
	public Muber(){
		
	}
	
	public void listarPasajeros() {		
		for (Pasajero pasajero : pasajeros) {
			this.informacionDePasajero(pasajero);
		}
	}
	
	public void listarConductores() {		
		for (Conductor conductor : conductores) {
			this.informacionDeConductor(conductor);
		}
	}
	
	public void listarViajes() {
		for (Conductor conductor : this.conductores) {
			conductor.viajesRealizados();
		}
	}

	public void listarViajesAbiertos() {
		for (Conductor conductor : this.conductores) {
			conductor.viajesAbiertos();
		}
	}
	
	public void agregarConductor(Conductor conductor){
		this.conductores.add(conductor);
	}
	
	public void agregarPasajero(Pasajero pasajero){
		this.pasajeros.add(pasajero);
	}
	
	public void informacionDeConductor(Conductor conductor){
		System.out.println("Nombre: "+conductor.getNombre());
		System.out.println("Puntaje: "+conductor.getPuntaje());
		System.out.println("Vto Licencia: "+conductor.getLicencia());
		conductor.viajesRealizados();
		conductor.viajesAbiertos();
		System.out.println("");
	}
	
	public void informacionDePasajero(Pasajero pasajero){
		System.out.println("Nombre: "+pasajero.getNombre());
		System.out.println("Credito: "+pasajero.getCredito());
		System.out.println("");
	}

}

