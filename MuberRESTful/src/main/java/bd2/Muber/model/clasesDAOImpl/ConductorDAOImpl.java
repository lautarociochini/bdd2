/**
 * 
 */
package bd2.Muber.model.clasesDAOImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import bd2.Muber.model.Conductor;
import bd2.Muber.model.clasesDAO.ConductorDAO;
import bd2.Muber.model.clasesDTO.ConductorDTO;

/**
 * @author GM
 *
 */
public class ConductorDAOImpl implements ConductorDAO {

	/* (non-Javadoc)
	 * @see bd2.Muber.model.clasesDAO.ConductorDAO#getAllConductores(org.hibernate.Session)
	 */
	@Override
	@Transactional
	public List<Conductor> getAllConductores(Session session) {
		Query query = session.createQuery("FROM Conductor C");
		@SuppressWarnings("unchecked")
		List<Conductor> list = query.list();
		return list;
	}

	@Override
	@Transactional
	public List<String> getInfoById(Session session, long id) {
		Query query = session.createQuery("SELECT C.nombre, C.puntaje, C.licencia FROM Conductor C WHERE C.idUsuario = :id ");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<String> list = query.list();
		return list;
	}

	@Override
	@Transactional
	public Collection<String> getViajesById(Session session, long id) {
		Query query = session.createQuery("SELECT V.origen, V.destino, V.costoTotal, V.fecha FROM Viaje V WHERE V.conductor.idUsuario = :id ");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<String> list = query.list();
		return list;
	}

	@Override
	public List<Conductor> getById(Session session, long id) {
		Query query = session.createQuery("FROM Conductor C WHERE C.idUsuario = :id ");
		query.setParameter("id", id);
		// return (Conductor) query;
		@SuppressWarnings("unchecked")
		List<Conductor> list = query.list();
		return list;		
	}

	@Override
	public List<ConductorDTO> getAllConductoresAsConductorDTO(Session session) {
		List<ConductorDTO> ConductorDTOs = new ArrayList<ConductorDTO>();
		for (Conductor conductor : getAllConductores(session)) {
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
