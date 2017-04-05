package misClases;

import java.sql.Date;
import java.util.Collection;


public class Usuario {
	
	private String nombre;
	
	private String contraseña;
	
	private Date fechaIngreso; 
	
	protected Collection<Viaje> viajes;
	
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
	
}
