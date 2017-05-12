package bd2.web;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.google.gson.Gson;
import bd2.Muber.model.clasesDAO.PasajeroDAO;
import bd2.Muber.model.Calificacion;
import bd2.Muber.model.Conductor;
import bd2.Muber.model.Pasajero;
import bd2.Muber.model.Viaje;
import bd2.Muber.model.clasesDAO.ConductorDAO;
import bd2.Muber.model.clasesDAO.ViajeDAO;
import bd2.Muber.model.clasesDAO.CalificacionDAO;
import bd2.Muber.model.clasesDTO.PasajeroDTO;

@ControllerAdvice
@RequestMapping("/services")
@ResponseBody
@EnableWebMvc
public class MuberRestController {

	@Resource(name = "PasajeroDAO")
	private PasajeroDAO PasajeroDAO;

	@Resource(name = "ConductorDAO")
	private ConductorDAO ConductorDAO;

	@Resource(name = "ViajeDAO")
	private ViajeDAO ViajeDAO;
	
	@Resource(name = "CalificacionDAO")
	private CalificacionDAO CalificacionDAO;

	protected Session getSession() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		@SuppressWarnings("deprecation")
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}

	@RequestMapping(value = "/example", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String pasajeros() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}

	@RequestMapping(value = "/pasajeros", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String devolverPasajeros() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		Collection<PasajeroDTO> pasajeros = PasajeroDAO.getAllPasajerosAsPasajeroDTO(getSession());
		aMap.put("result", "OK");
		aMap.put("Pasajeros", pasajeros);
		return new Gson().toJson(aMap);
	}

	@RequestMapping(value = "/conductores", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String devolverConductores() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		Collection<String> conductores = ConductorDAO.getAllConductores(getSession());
		aMap.put("result", "OK");
		aMap.put("Conductores", conductores);
		return new Gson().toJson(aMap);
	}

	@RequestMapping(value = "/viajes/abiertos", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String devolverViajesAbiertos() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		Collection<String> viajesAbiertos = ViajeDAO.getAllViajesAbiertos(getSession());
		aMap.put("result", "OK");
		aMap.put("Viajes Abiertos", viajesAbiertos);
		return new Gson().toJson(aMap);
	}

	@RequestMapping(value = "/conductores/detalle", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String devolverDetalleConductor(@RequestParam("id") long id) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		Collection<String> detallesConductor = ConductorDAO.getInfoById(getSession(), id);
		Collection<String> viajesConductor = ConductorDAO.getViajesById(getSession(), id);
		aMap.put("result", "OK");
		aMap.put("Detalles Conductor", detallesConductor);
		aMap.put("Viajes", viajesConductor);
		return new Gson().toJson(aMap);
	}

	@RequestMapping(value = "/viajes/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String nuevoViaje(@RequestParam String origen, @RequestParam String destino, @RequestParam long idConductor,
			@RequestParam float costoTotal, @RequestParam int maxPasajeros) {
		Map<String, Object> aMap = new HashMap<String, Object>();

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String fecha = dateFormat.format(date).toString();

		Session session = getSession();
		List<Conductor> conductor = ConductorDAO.getById(session, idConductor);
		Viaje viaje = new Viaje(costoTotal, fecha, origen, destino, maxPasajeros, conductor.get(0));
		ViajeDAO.createViaje(session, viaje);
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}

	@RequestMapping(value = "/viajes/agregarPasajero", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String agregarPasajero(@RequestParam long idViaje, @RequestParam long idPasajero) {
		Map<String, Object> aMap = new HashMap<String, Object>();

		Session session = getSession();

		List<Viaje> viajes = ViajeDAO.getById(session, idViaje);
		Viaje viaje = viajes.get(0);

		List<Pasajero> pasajeros = PasajeroDAO.getById(session, idPasajero);
		Pasajero pasajero = pasajeros.get(0);

		int registrarse = pasajero.okRegistrarseA(viaje);

		if (registrarse == 0) {
			pasajero.registrarseA(viaje);
			ViajeDAO.updateViaje(session, viaje);
			aMap.put("result", "OK");
		} else {
			if (registrarse == 1) {
				aMap.put("result", "La capacidad esta llena");
			} else {
				aMap.put("result", "El viaje esta finalizado");
			}
		}

		return new Gson().toJson(aMap);
	}
	
	@RequestMapping(value = "/viajes/calificar", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String calificarViaje(@RequestParam long idViaje, @RequestParam long idPasajero, @RequestParam int puntaje, @RequestParam String comentario) {
		Map<String, Object> aMap = new HashMap<String, Object>();

		Session session = getSession();

		List<Viaje> viajes = ViajeDAO.getById(session, idViaje);
		Viaje viaje = viajes.get(0);

		List<Pasajero> pasajeros = PasajeroDAO.getById(session, idPasajero);
		Pasajero pasajero = pasajeros.get(0);

		int calificar = pasajero.okCalificar(viaje, pasajero);

		if (calificar == 0) {
			Calificacion calificacion = new Calificacion(viaje, puntaje, comentario, pasajero);
			pasajero.calificar(calificacion, viaje);
			
			Transaction tx = null;
			try {

				tx = session.beginTransaction();
				CalificacionDAO.createCalificacion(session, calificacion);
				ViajeDAO.updateViajeCalif(session, viaje);
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) {
					tx.rollback();
				}
			}
			
			
			aMap.put("result", "La calificacion fue agregada");
		} else {
			if (calificar == 1) {
				aMap.put("result", "El viaje no esta finalizado aun");
			} else {
				aMap.put("result", "El pasajero no se encuentra registrado en este viaje");
			}
		}

		return new Gson().toJson(aMap);
	}

}
