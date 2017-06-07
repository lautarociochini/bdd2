package bd2.Muber.dto;

public class UsuarioDTO {
	
	protected String nombre;
	protected String contrasena;
	protected String fechaIngreso; 

	 
	 public UsuarioDTO() {
		 super();
	 }
	 
	 public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

}
