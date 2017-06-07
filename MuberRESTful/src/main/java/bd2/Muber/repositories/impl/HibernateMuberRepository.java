package bd2.Muber.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import bd2.Muber.model.Muber;
import bd2.Muber.repositories.MuberRepository;

public class HibernateMuberRepository extends BaseHibernateRepository implements MuberRepository {
	
	@Override
	public void update(Session session, Muber muber) {
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.update(muber);
			session.flush();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		
	}

	@Override
	public List<Muber> obtenerMuber(Session session, long id) {
		Query query = session.createQuery("FROM Muber C WHERE C.idMuber = :id ");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Muber> list = query.list();
		return list;
	}

	@Override
	public boolean existeMuber(Session session) {
		Query query = session.createQuery("FROM Muber M ");
		@SuppressWarnings("unchecked")
		List<Muber> list = query.list();
		if (list.isEmpty()){
			return false;
		}else{
			return true;
		}
		
	}

	@Override
	public void saveMuber(Session session, Muber muber) {
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.save(muber);
			session.flush();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
	}

}
