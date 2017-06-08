/**
 * 
 */
package bd2.Muber.services;

import java.util.List;

import bd2.Muber.dto.ConductorDTO;

/**
 * @author Lautaro
 *
 */
public interface ConductoresService extends BaseService {
	
	public List<ConductorDTO> getConductores();


}
