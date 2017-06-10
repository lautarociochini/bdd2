package bd2.Muber.dto;

import java.util.ArrayList;
import java.util.List;

import bd2.Muber.model.Conductor;
import bd2.Muber.model.Pasajero;

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
	
	private PasajeroDTO constructPasajeroDTO(Pasajero pasajero) {
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
	 * Método que recibe una lista de conductores, los convierte y retorna una lista de ConductoresDTO
	 * @param pasajeros
	 * 
	 */

	private ConductorDTO constructConductorDTO(Conductor conductor) {
		ConductorDTO ConductorDTO = new ConductorDTO();
		ConductorDTO.setNombre(conductor.getNombre());
		ConductorDTO.setFechaIngreso(conductor.getfechaIngreso());
		ConductorDTO.setLicencia(conductor.getLicencia());
		ConductorDTO.setPuntaje(conductor.getPuntaje());
		return ConductorDTO;
	}
}
