package misClases;

import java.util.Collection;
import java.util.HashSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conductor extends Usuario {


	protected String licencia;
	protected float puntaje;
	protected Collection<Viaje> viajes = new HashSet<Viaje>();

	public Conductor(String nombre, String contrasena, String fechaIngreso, String licencia) {
		super(nombre, contrasena, fechaIngreso);
		this.setLicencia(licencia);
		this.puntaje = 0;
	}
	
	public Date ConvertirString(String fecha) {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		 try {
	            Date date = formatter.parse(fecha);
	            System.out.println(date);
	            System.out.println(formatter.format(date));
	            return date;

	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		return null;
	}

	public String getLicencia() {
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

	public float getPuntaje() {
		float puntajeTotal = 0;
		if (this.cantViajesFinalizados() > 0) {
			for (Viaje viaje : viajes) {
				if (viaje.calificaciones.size() > 0) {
					puntajeTotal = puntajeTotal + viaje.getPuntaje();
				}
			}
			puntaje = (puntajeTotal / this.cantViajesFinalizados());
		}	
		return puntaje;
	}
	
	public int cantViajesFinalizados(){
		int n = 0;
		for (Viaje viaje : viajes) {
			if (viaje.isFinalizado()) {
				n++;
			}
		}
		return n;
	}

	public void setPuntaje(float puntaje) {
		this.puntaje = puntaje;
	}

	public void agregarViaje(Viaje viaje) {
		this.viajes.add(viaje);
	}

	public void finalizarViaje(Viaje unViaje) {
		unViaje.finalizar();
	}

	public boolean licenciaVencidaPara(String fecha) {
		if (this.ConvertirString(this.getLicencia()).after(this.ConvertirString(fecha))) {
			return false;
		}
		return true;
	}
	
	public Collection<Viaje> getViajes() {
		return viajes;
	}

	public void viajesRealizados() {
		int n = 0;
		System.out.println("Viajes finalizados de: "+ this.getNombre());
		for (Viaje viaje : viajes) {
			if (viaje.isFinalizado()){
			n++;
			System.out.println("Viaje numero: "+ n);
			System.out.println(viaje.getOrigen());
			System.out.println(viaje.getDestino());
			System.out.println(viaje.getFecha());
			System.out.println("");
			}
		}
		System.out.println("");
	}
	
	public void viajesAbiertos() {
		int n = 0;
		System.out.println("Viajes abiertos de: "+ this.getNombre());
		for (Viaje viaje : viajes) {
			if (!viaje.isFinalizado()){
			n++;
			System.out.println("Viaje numero: "+ n);
			System.out.println(viaje.getOrigen());
			System.out.println(viaje.getDestino());
			System.out.println(viaje.getFecha());
			System.out.println("");
			}
		}
		System.out.println("");
	}

}
