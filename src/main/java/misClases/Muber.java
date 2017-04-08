package misClases;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;

public class Muber {
	protected Collection<Usuario> usuarios = new HashSet<Usuario>();
	
	
	public Collection<Usuario> listarPasajeros() {
		Collection<Usuario> coleccionPasajeros = new HashSet<Usuario>();
		for (Usuario usuario : usuarios) {
			if (usuario.getClass().getSimpleName().equals("Pasajero")) {
				coleccionPasajeros.add(usuario);
			}
		}
		return coleccionPasajeros;
	}
	
	public Collection<Usuario> listarConductores() {
		Collection<Usuario> coleccionConductores = new HashSet<Usuario>();
		for (Usuario usuario : usuarios) {
			if (usuario.getClass().getSimpleName().equals("Conductor")) {
				coleccionConductores.add(usuario);
			}
		}
		return coleccionConductores;
	}
	
	public Collection<Viaje> listarViajes() {
		Collection<Usuario> coleccionConductores = this.listarConductores();
		Collection<Viaje> coleccionViajes = new HashSet<Viaje>();
		for (Usuario usuario : coleccionConductores) {
			for (Viaje viaje : usuario.viajesRealizados()) {
				coleccionViajes.add(viaje);
			}
		}
		return coleccionViajes;
	}

	public Collection<Viaje> listarViajesAbiertos() {
		Collection<Viaje> viajesAbiertos = new HashSet<Viaje>();
		for (Viaje viaje : this.listarViajes()) {
			if (!viaje.isFinalizado()) {
				viajesAbiertos.add(viaje);
			}
		}
		return viajesAbiertos;
	}
	
	public void crearConductor(String nombre, String contrasena, Date fechaIngreso, Date licencia){
		Conductor conductor = new Conductor();
		conductor.inicializar(nombre, contrasena, fechaIngreso, licencia);
		this.usuarios.add(conductor);
	}
	
	public void crearPasajero(String nombre, String contrasena, Date fechaIngreso, float credito){
		Pasajero pasajero = new Pasajero();
		pasajero.inicializar(nombre, contrasena, fechaIngreso, credito);
		this.usuarios.add(pasajero);
	}
}

