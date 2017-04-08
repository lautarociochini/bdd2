package misClases;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;


public class Usuario {
	
	protected String nombre;
	protected String contraseña;
	protected Date fechaIngreso; 
	protected Collection<Viaje> viajes = new HashSet<Viaje>();
	private long idUsuario;
	
	public Date getfechaIngreso() {
	return fechaIngreso; }
	
	public void setfechaIngreso(Date fechaIngreso) {
	this.fechaIngreso = fechaIngreso;
	}
	
	public String getContraseña() {
	return contraseña; }
	
	public void setContraseña(String contraseña) {
	this.contraseña = contraseña; }
	
	public String getNombre() { return nombre;
	}
	
	public void setNombre(String nombre) {
	this.nombre = nombre; }
	
	public Collection<Viaje> viajesRealizados() {
		return viajes;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long id) {
		this.idUsuario = id;
	}
	
}
