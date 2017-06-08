package bd2.Muber.services.impl;

import java.util.List;

import bd2.Muber.dto.ConductorDTO;
import bd2.Muber.dto.DTOFactory;
import bd2.Muber.model.Conductor;
import bd2.Muber.services.ConductoresService;

public class ConductoresServiceImpl extends BaseServiceImpl implements ConductoresService {
	
	private DTOFactory dtoFactory;

	@Override
	public List<ConductorDTO> getConductores() {
		 List<Conductor> conductores =  getConductoresRepository().getAllConductores();
		 List<ConductorDTO> conductoresDTO = dtoFactory.getAllConductoresAsConductorDTO(conductores);
		 return conductoresDTO;
	}

}
