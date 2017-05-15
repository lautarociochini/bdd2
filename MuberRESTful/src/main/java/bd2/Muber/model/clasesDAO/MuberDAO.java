package bd2.Muber.model.clasesDAO;

import java.util.List;

import org.hibernate.Session;

import bd2.Muber.model.Muber;

public interface MuberDAO {
	void update(Session session, Muber muber);
	List<Muber> obtenerMuber(Session session, long id);

}
