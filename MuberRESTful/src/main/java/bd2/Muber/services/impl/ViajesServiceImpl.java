package bd2.Muber.services.impl;

import java.util.List;
import bd2.Muber.dto.ViajeDTO;
import bd2.Muber.model.Viaje;
import bd2.Muber.services.ViajesService;

public class ViajesServiceImpl extends BaseServiceImpl implements ViajesService {

	@Override
	public List<ViajeDTO> getViajesAbiertos() {
		 List<Viaje> viajes =  getViajesRepository().getAllViajesAbiertos();
		 List<ViajeDTO> viajesDTO = dtoFactory.getAllViajesAsViajeDTO(viajes);
		 return viajesDTO;
	}

	

}
