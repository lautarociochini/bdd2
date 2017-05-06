package bd2.Muber.model.clasesDAO;

import java.util.List;
import org.hibernate.Session;

public interface PasajeroDAO {
	List<String> getAllPasajeros(Session session);
}
