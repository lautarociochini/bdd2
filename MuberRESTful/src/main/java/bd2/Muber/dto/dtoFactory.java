package bd2.Muber.dto;

import java.util.ArrayList;
import java.util.List;

import bd2.Muber.model.Conductor;
import bd2.Muber.model.Pasajero;
import bd2.Muber.model.Viaje;

/**
 * Clase DTOFactory utilizada para convertir los objetos del dominio obtenidos desde los repositorios
 * a objetos DTO pasados al controlador
 * 
 */

public class DTOFactory {
	
	public DTOFactory() {
		super();
	}
	
	/**
	 * Método que recibe una lista de pasajeros, los convierte y retorna una lista de pasajeroDTO
	 * @param pasajeros
	 * 
	 */
	
	public List<PasajeroDTO> getAllPasajerosAsPasajeroDTO(List<Pasajero> pasajeros) {
		List<PasajeroDTO> pasajeroDTOs = new ArrayList<PasajeroDTO>();
		for (Pasajero pasajero : pasajeros ) {
			pasajeroDTOs.add(constructPasajeroDTO(pasajero));
		}

		return pasajeroDTOs;
	}
	
	/**
	 * Método que recibe un pasajero, lo convierte a un pasajeroDTO y lo retorna
	 * @param pasajero
	 * 
	 */
	
	public PasajeroDTO constructPasajeroDTO(Pasajero pasajero) {
		PasajeroDTO pasajeroDTO = new PasajeroDTO();
		pasajeroDTO.setNombre(pasajero.getNombre());
		pasajeroDTO.setFechaIngreso(pasajero.getfechaIngreso());
		pasajeroDTO.setCredito(pasajero.getCredito());
		return pasajeroDTO;
	}
	
	/**
	 * Método que recibe una lista de conductores, los convierte y retorna una lista de ConductorDTO
	 * @param conductores
	 * 
	 */
	public List<ConductorDTO> getAllConductoresAsConductorDTO(List<Conductor> conductores) {
		List<ConductorDTO> ConductorDTOs = new ArrayList<ConductorDTO>();
		for (Conductor conductor : conductores) {
			ConductorDTOs.add(constructConductorDTO(conductor));
		}

		return ConductorDTOs;
	}
	/**
	 * Método que recibe un conductor, lo convierte a un conductorDTO y lo retorna
	 * @param conductor
	 * 
	 */

	public ConductorDTO constructConductorDTO(Conductor conductor) {
		ConductorDTO ConductorDTO = new ConductorDTO();
		ConductorDTO.setNombre(conductor.getNombre());
		ConductorDTO.setFechaIngreso(conductor.getfechaIngreso());
		ConductorDTO.setLicencia(conductor.getLicencia());
		ConductorDTO.setPuntaje(conductor.getPuntaje());
		return ConductorDTO;
	}
	
	/**
	 * Método que recibe un viaje, lo convierte a un ViajeDTO y lo retorna
	 * @param viaje
	 * 
	 */
	public ViajeDTO constructViajeDTO(Viaje viaje) {
		ViajeDTO ViajeDTO = new ViajeDTO();
		ViajeDTO.setDestino(viaje.getDestino());
		ViajeDTO.setOrigen(viaje.getOrigen());
		ViajeDTO.setCostoTotal(viaje.getCostoTotal());
		ViajeDTO.setFecha(viaje.getFecha());
		ViajeDTO.setConductor(viaje.getConductor());
		return ViajeDTO;
	}
	
	/**
	 * Método que recibe una lista de viajes, los convierte y retorna una lista de ViajeDTO
	 * @param viajes
	 * 
	 */
	public List<ViajeDTO> getAllViajesAsViajeDTO(List<Viaje> viajes) {
		List<ViajeDTO> ViajeDTOs = new ArrayList<ViajeDTO>();
		for (Viaje viaje : viajes) {
			ViajeDTOs.add(constructViajeDTO(viaje));
		}
		return ViajeDTOs;
	}
}
