package bd2.Muber.repositories;

import java.util.List;

import org.hibernate.Session;

import bd2.Muber.model.Muber;

public interface MuberRepository extends BaseRepository {
	void update(Session session, Muber muber);
	List<Muber> obtenerMuber(Session session, long id);
	boolean existeMuber(Session session);
	void saveMuber(Session session, Muber muber);

}
