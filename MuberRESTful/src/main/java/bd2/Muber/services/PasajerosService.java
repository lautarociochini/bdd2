package bd2.Muber.services;

import java.util.List;

import bd2.Muber.dto.PasajeroDTO;
/**
* Interface que representa al servicio de pasajeros
* Declara un método que recupera los Pasajeros de Muber como DTOs.
*/
public interface PasajerosService extends BaseService {
	
	public List<PasajeroDTO> getPasajeros();

}
