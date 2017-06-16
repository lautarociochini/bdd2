package bd2.Muber.services.impl;

import java.util.List;

import bd2.Muber.dto.ConductorDTO;
import bd2.Muber.dto.DTOFactory;
import bd2.Muber.dto.ViajeDTO;
import bd2.Muber.model.Conductor;
import bd2.Muber.model.Viaje;
import bd2.Muber.services.ConductoresService;

/**
 *Clase que implementa el servicio de conductores
 */

public class ConductoresServiceImpl extends BaseServiceImpl implements ConductoresService {
	
	/**
	 *Método que recupera los conductores de Muber, los convierte a objetos DTO
	 *y los retorna
	 */
	@Override
	public List<ConductorDTO> getConductores() {
		 List<Conductor> conductores =  getConductoresRepository().getAllConductores();
		 List<ConductorDTO> conductoresDTO = dtoFactory.getAllConductoresAsConductorDTO(conductores);
		 return conductoresDTO;
	}

	/**
	 *Método que recupera el top 10 de los conductores de Muber, los convierte a objetos DTO
	 *y los retorna
	 */
	@Override
	public List<ConductorDTO> getConductoresTopTen() {
		 List<Conductor> conductores =  getConductoresRepository().getTop10();
		 List<ConductorDTO> conductoresDTO = dtoFactory.getAllConductoresAsConductorDTO(conductores);
		 return conductoresDTO;
	}

	/**
	 *Método que recupera un conductor de Muber a través de su id, lo convierte a objeto DTO
	 *y lo retorna
	 */
	@Override
	public List<ConductorDTO> getInfoById(long id) {
		 List<Conductor> conductores =  getConductoresRepository().getInfoById(id);
		 List<ConductorDTO> conductoresDTO = dtoFactory.getAllConductoresAsConductorDTO(conductores);
		 return conductoresDTO;
	}

	@Override
	public List<ViajeDTO> getViajesById(long id) {
		List<Viaje> viajes =  getConductoresRepository().getViajesById(id);
		List<ViajeDTO> viajesDTO = dtoFactory.getAllViajesAsViajeDTO(viajes);
		return viajesDTO;
	}

}
