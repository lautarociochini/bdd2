package misClases;



public class Usuario {
	
	protected String nombre;
	protected String contrasena;
	protected String fechaIngreso; 
	private long idUsuario;
	
	public Usuario(){
		
	}
	
	public Usuario(String nombre, String contrasena, String fechaIngreso) {
		this.setNombre(nombre);
		this.setContrasena(contrasena);
		this.setfechaIngreso(fechaIngreso);
	}

	public String getfechaIngreso() {
	return fechaIngreso; }
	
	public void setfechaIngreso(String fechaIngreso) {
	this.fechaIngreso = fechaIngreso;
	}
	
	public String getContrasena() {
	return contrasena; }
	
	public void setContrasena(String contrasena) {
	this.contrasena = contrasena; }
	
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
