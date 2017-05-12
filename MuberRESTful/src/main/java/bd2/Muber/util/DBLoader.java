package bd2.Muber.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import bd2.Muber.model.Calificacion;
import bd2.Muber.model.Conductor;
import bd2.Muber.model.Muber;
import bd2.Muber.model.Pasajero;
import bd2.Muber.model.Viaje;

public class DBLoader {

	private static SessionFactory sessions;
	private static ServiceRegistry serviceRegistry;

	public DBLoader() {
	}
	
	public static void main(String[] args) {

		try {
			System.out.println("Seteando Hibernate");
			Configuration cfg = new Configuration();
			cfg.configure("/hibernate.cfg.xml");

			System.out.println("Borrando schema...");
			new SchemaExport(cfg).drop(true, true);
			System.out.println("Hecho.");

			System.out.println("Generando schema...");
			new SchemaExport(cfg).create(true, true);
			System.out.println("Hecho.");

			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
			sessions = cfg.buildSessionFactory(serviceRegistry);

			Muber muber = persistirModelo();

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

			System.out.println("Modelo persistido.");

		} catch (Exception e) {
			System.out.println("Ha ocurrido un error");
			e.printStackTrace();
		}

	}

	private static Muber persistirModelo() throws Exception {
		Muber muber = new Muber();

		// Parte A.
		Conductor Roberto = new Conductor("Roberto", "012345", "15/03/2017", "10/03/2017");
		muber.agregarConductor(Roberto);
		Viaje viaje1 = new Viaje(900, "10/03/2017", "La Plata", "Tres Arroyos", 4, Roberto);

		// Parte B.
		Pasajero German = new Pasajero("German", "123456", "10/03/2017", 1500);
		Pasajero Alicia = new Pasajero("Alicia", "123456", "10/03/2017", 1500);
		Pasajero Margarita = new Pasajero("Margarita", "123456", "10/03/2017", 1500);

		muber.agregarPasajero(German);
		muber.agregarPasajero(Alicia);
		muber.agregarPasajero(Margarita);

		viaje1.agregarPasajero(Margarita);
		viaje1.agregarPasajero(Alicia);
//		viaje1.agregarPasajero(German);

		// Parte C y D

		Roberto.finalizarViaje(viaje1);

		Calificacion califGerman = new Calificacion(viaje1, 5, "Buen viaje, Roberto excelente conductor.", German);
		German.calificar(califGerman, viaje1);

		Calificacion califAlicia = new Calificacion(viaje1, 4, "Bien, lastima que Roberto es muy charlatan.", Alicia);
		Alicia.calificar(califAlicia, viaje1);

//		Calificacion califMargarita = new Calificacion(viaje1, 4,
//				"Me senti muy a gusto, ningun problema. Super recomendable.", Margarita);
//		Margarita.calificar(califMargarita, viaje1);

		return muber;
	}

}
