/**
 * 
 */
package bd2.Muber.services;

import java.util.List;

import bd2.Muber.dto.ViajeDTO;

/**
 * @author Lautaro
 *
 */
public interface ViajesService extends BaseService {

	public List<ViajeDTO> getViajesAbiertos();
}
