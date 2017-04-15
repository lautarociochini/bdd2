package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import misClases.Muber;

public class DBLoader {

	private static SessionFactory sessions;

	public DBLoader() {
	}

	
	public static void main(String[] args) {
		
		try {
			System.out.println("----------------------- Setting up Hibernate -----------------------");
			Configuration cfg = new Configuration();
			cfg.configure("/hibernate/hibernate.cfg.xml");

			System.out.println("Droping schema.........");
			new SchemaExport(cfg).drop(true, true);
			System.out.println("DONE.");

			System.out.println("Generating schema.........");
			new SchemaExport(cfg).create(true, true);
			System.out.println("DONE.");

			System.out.println("Building sessions.........");
			sessions = cfg.buildSessionFactory();
			Muber muber = cargarBase();

			Session session = sessions.openSession();
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
				session.close();
			}
			session.disconnect();

			System.out.println("DONE.");
		} catch (Exception e) {
			System.out.println("------------------------FAIL.------------------------");
			e.printStackTrace();
		}
		
		
		
	}
	private static Muber cargarBase() throws Exception {
		Muber muber = new Muber();
		return muber;
	}

}
