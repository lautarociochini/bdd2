package bd2.Muber.repositories;

import java.util.List;

import org.hibernate.Session;

import bd2.Muber.model.Muber;
/**
 * Interface para representar al repositorio de Muber
 * define mensajes para obtener a muber y saber si está definido
 * 
 */
public interface MuberRepository extends BaseRepository {
	void update(Session session, Muber muber);
	List<Muber> obtenerMuber(Session session, long id);
	boolean existeMuber(Session session);
	void saveMuber(Session session, Muber muber);

}
