package bd2.Muber.dto;

import java.util.ArrayList;
import java.util.List;

import bd2.Muber.model.Conductor;
import bd2.Muber.model.Pasajero;

public class dtoFactory {
	
	public dtoFactory() {
		super();
	}

	
	public List<PasajeroDTO> getAllPasajerosAsPasajeroDTO(List<Pasajero> pasajeros) {
		List<PasajeroDTO> pasajeroDTOs = new ArrayList<PasajeroDTO>();
		for (Pasajero pasajero : pasajeros ) {
			pasajeroDTOs.add(constructPasajeroDTO(pasajero));
		}

		return pasajeroDTOs;
	}
	
	private PasajeroDTO constructPasajeroDTO(Pasajero pasajero) {
		PasajeroDTO pasajeroDTO = new PasajeroDTO();
		pasajeroDTO.setNombre(pasajero.getNombre());
		pasajeroDTO.setFechaIngreso(pasajero.getfechaIngreso());
		pasajeroDTO.setCredito(pasajero.getCredito());
		return pasajeroDTO;
	}
	
	
	public List<ConductorDTO> getAllConductoresAsConductorDTO(List<Conductor> conductores) {
		List<ConductorDTO> ConductorDTOs = new ArrayList<ConductorDTO>();
		for (Conductor conductor : conductores) {
			ConductorDTOs.add(constructConductorDTO(conductor));
		}

		return ConductorDTOs;
	}

	private ConductorDTO constructConductorDTO(Conductor conductor) {
		ConductorDTO ConductorDTO = new ConductorDTO();
		ConductorDTO.setNombre(conductor.getNombre());
		ConductorDTO.setFechaIngreso(conductor.getfechaIngreso());
		ConductorDTO.setLicencia(conductor.getLicencia());
		ConductorDTO.setPuntaje(conductor.getPuntaje());
		return ConductorDTO;
	}
}
