package misClases;



public class Usuario {
	
	protected String nombre;
	protected String contraseña;
	protected String fechaIngreso; 
	private long idUsuario;
	
	public Usuario(String nombre, String contrasena, String fechaIngreso) {
		this.setNombre(nombre);
		this.setContraseña(contrasena);
		this.setfechaIngreso(fechaIngreso);
	}

	public String getfechaIngreso() {
	return fechaIngreso; }
	
	public void setfechaIngreso(String fechaIngreso) {
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
	

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long id) {
		this.idUsuario = id;
	}
	
}
