/**
 * 
 */
package bd2.Muber.services;

import java.util.List;

import bd2.Muber.dto.ConductorDTO;
import bd2.Muber.dto.ViajeDTO;

/**
 * @author Lautaro
 * Interface que representa al servicio de conductores
 * Declara un método que recupera los Conductores de Muber como DTOs.
 */
public interface ConductoresService extends BaseService {
	
	public List<ConductorDTO> getConductores();

	public List<ConductorDTO> getConductoresTopTen();
	
	public List<ConductorDTO> getInfoById(long id);

	public List<ViajeDTO> getViajesById(long id);
}
