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
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.google.gson.Gson;

import bd2.Muber.dto.ConductorDTO;
import bd2.Muber.dto.PasajeroDTO;
import bd2.Muber.model.Calificacion;
import bd2.Muber.model.Conductor;
import bd2.Muber.model.Muber;
import bd2.Muber.model.Pasajero;
import bd2.Muber.model.Viaje;
import bd2.Muber.model.ViajePasajero;
import bd2.Muber.repositories.ConductorRepository;
import bd2.Muber.repositories.ViajeRepository;
import bd2.Muber.services.ServiceLocator;
import bd2.Muber.repositories.MuberRepository;
import bd2.Muber.repositories.CalificacionRepository;
import bd2.Muber.repositories.ConductorRepository;
import bd2.Muber.repositories.PasajeroRepository;

/**
 * @author GM
 *
 */
@ControllerAdvice
@RequestMapping("/services")
@ResponseBody
@EnableWebMvc
public class MuberRestController {

	@Resource(name = "PasajeroRepository")
	private PasajeroRepository PasajeroRepository;

	@Resource(name = "ConductorRepository")
	private ConductorRepository ConductorRepository;

	@Resource(name = "ViajeRepository")
	private ViajeRepository ViajeRepository;

	@Resource(name = "CalificacionRepository")
	private CalificacionRepository CalificacionRepository;

	@Resource(name = "MuberRepository")
	private MuberRepository MuberRepository;
	
	private ServiceLocator serviceLocator;

	protected Session getSession() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		@SuppressWarnings("deprecation")
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}

	protected Muber getMuber(Session session) {
		List<Muber> muberList = MuberRepository.obtenerMuber(session, 1);
		Muber muber = muberList.get(0);
		return muber;
	}

	@RequestMapping(value = "/example", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String pasajeros() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}

	@RequestMapping(value = "/muber/nuevo", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String crearMuber() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		Configuration cfg = new Configuration();
		cfg.configure("/hibernate.cfg.xml");
		//new SchemaExport(cfg).drop(true, true);
		//new SchemaExport(cfg).create(true, true);
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Muber muber = new Muber();
		MuberRepository.saveMuber(session, muber);
		aMap.put("result", "OK");	
		return new Gson().toJson(aMap);
	}
	
	@RequestMapping(value = "/pasajeros", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String devolverPasajeros() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		Collection<PasajeroDTO> pasajeros = serviceLocator.getInstance().getPasajerosService().getPasajeros();
		aMap.put("result", "OK");
		aMap.put("Pasajeros", pasajeros);
		return new Gson().toJson(aMap);
	}

	@RequestMapping(value = "/conductores", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String devolverConductores() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		//Collection<ConductorDTO> conductores = ConductorRepository.getAllConductoresAsConductorDTO(getSession());
		aMap.put("result", "OK");
		//aMap.put("Conductores", conductores);
		return new Gson().toJson(aMap);
	}

	@RequestMapping(value = "/viajes/abiertos", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String devolverViajesAbiertos() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		Collection<String> viajesAbiertos = ViajeRepository.getAllViajesAbiertos(getSession());
		aMap.put("result", "OK");
		aMap.put("Viajes Abiertos", viajesAbiertos);
		return new Gson().toJson(aMap);
	}

	@RequestMapping(value = "/conductores/detalle", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String devolverDetalleConductor(@RequestParam("id") long id) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		Collection<String> detallesConductor = ConductorRepository.getInfoById(getSession(), id);
		if (detallesConductor.isEmpty()) {
			aMap.put("result", "El conductor no existe");
		} else {
			Collection<String> viajesConductor = ConductorRepository.getViajesById(getSession(), id);
			aMap.put("result", "OK");
			aMap.put("Detalles Conductor", detallesConductor);
			aMap.put("Viajes", viajesConductor);
		}
		return new Gson().toJson(aMap);
	}

	@RequestMapping(value = "/viajes/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String nuevoViaje(@RequestParam String origen, @RequestParam String destino, @RequestParam long idConductor,
			@RequestParam float costoTotal, @RequestParam int maxPasajeros) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		Session session = getSession();
		List<Conductor> conductor = ConductorRepository.getById(session, idConductor);
		if (conductor.isEmpty()) {
			aMap.put("result", "El conductor no existe");
		} else {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			String fecha = dateFormat.format(date).toString();
			new Viaje(costoTotal, fecha, origen, destino, maxPasajeros, conductor.get(0));
			Muber muber = getMuber(session);
			MuberRepository.update(session, muber);
			aMap.put("result", "OK");
		}
		return new Gson().toJson(aMap);
	}

	@RequestMapping(value = "/viajes/agregarPasajero", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String agregarPasajero(@RequestBody ViajePasajero viajePasajero) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		Session session = getSession();
		List<Viaje> viajes = ViajeRepository.getById(session, viajePasajero.getIdViaje());
		if (viajes.isEmpty()) {
			aMap.put("result", "El viaje no existe");
		} else {
			List<Pasajero> pasajeros = PasajeroRepository.getById(session, viajePasajero.getIdUsuario());
			if (pasajeros.isEmpty()) {
				aMap.put("result", "El pasajero no existe");
			} else {
				Viaje viaje = viajes.get(0);
				Pasajero pasajero = pasajeros.get(0);
				if (pasajero.getCredito() < (viaje.getCostoTotal() / (viaje.getPasajeros().size() + 1))) {
					aMap.put("result", "El pasajero no cuenta con suficiente credito");
				} else {
					int registrarse = pasajero.okRegistrarseA(viaje);
					if (registrarse == 0) {
						pasajero.registrarseA(viaje);
						Muber muber = getMuber(session);
						MuberRepository.update(session, muber);
						aMap.put("result", "OK");
					} else {
						if (registrarse == 1) {
							aMap.put("result", "La capacidad esta llena");
						} else {
							aMap.put("result", "El viaje esta finalizado");
						}
					}
				}

			}

		}

		return new Gson().toJson(aMap);
	}

	@RequestMapping(value = "/viajes/calificar", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String calificarViaje(@RequestParam long idViaje, @RequestParam long idPasajero, @RequestParam int puntaje,
			@RequestParam String comentario) {
		Map<String, Object> aMap = new HashMap<String, Object>();

		Session session = getSession();
		List<Pasajero> pasajeros = PasajeroRepository.getById(session, idPasajero);
		if (pasajeros.isEmpty()) {
			aMap.put("result", "El pasajero no existe");
		} else {
			List<Viaje> viajes = ViajeRepository.getById(session, idViaje);
			if (viajes.isEmpty()) {
				aMap.put("result", "El viaje no existe");
			} else {
				List<Calificacion> existeCalificacion = CalificacionRepository.existeCalificacion(session, idPasajero,
						idViaje);
				if (existeCalificacion.size() > 0) {
					aMap.put("result", "El usuario ya califico este viaje");
				} else {
					Viaje viaje = viajes.get(0);
					Pasajero pasajero = pasajeros.get(0);
					int calificar = pasajero.okCalificar(viaje, pasajero);
					if (calificar == 0) {
						Calificacion calificacion = new Calificacion(viaje, puntaje, comentario, pasajero);
						pasajero.calificar(calificacion, viaje);
						Muber muber = getMuber(session);
						MuberRepository.update(session, muber);
						aMap.put("result", "La calificacion fue agregada");
					} else {
						if (calificar == 1) {
							aMap.put("result", "El viaje no esta finalizado aun");
						} else {
							aMap.put("result", "El pasajero no se encuentra registrado en este viaje");
						}
					}
				}
			}

		}

		return new Gson().toJson(aMap);
	}

	@RequestMapping(value = "/pasajeros/cargarCredito", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String cargarCredito(@RequestBody Pasajero pasajero2) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		Session session = getSession();
		List<Pasajero> pasajeros = PasajeroRepository.getById(session, pasajero2.getIdUsuario());
		if (pasajeros.isEmpty()) {
			aMap.put("result", "El pasajero no existe");
		} else {
			Pasajero pasajero = pasajeros.get(0);
			pasajero.cargarCredito(pasajero2.getCredito());
			Muber muber = getMuber(session);
			MuberRepository.update(session, muber);
			aMap.put("result", "OK");
		}
		return new Gson().toJson(aMap);
	}

	@RequestMapping(value = "/viajes/finalizar", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String finalizarViaje(@RequestBody Viaje viaje2) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		Session session = getSession();
		
		List<Viaje> viajes = ViajeRepository.getById(session, viaje2.getIdViaje());
		if (viajes.isEmpty()) {
			aMap.put("result", "El viaje no existe");
		} else {
			Viaje viaje = viajes.get(0);
			if (viaje.estaFinalizado()) {
				aMap.put("result", "El viaje ya esta finalizado");
			} else {
				viaje.finalizar();
				Muber muber = getMuber(session);
				MuberRepository.update(session, muber);
				aMap.put("result", "OK");
			}

		}

		return new Gson().toJson(aMap);
	}

	@RequestMapping(value = "/conductores/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String nuevoConductor(@RequestParam String nombre, @RequestParam String contrasena,
			@RequestParam String licencia) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String fecha = dateFormat.format(date).toString();
		Session session = getSession();
		Conductor conductor = new Conductor(nombre, contrasena, fecha, licencia);
		Muber muber = getMuber(session);
		muber.agregarConductor(conductor);
		MuberRepository.update(session, muber);
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}

	@RequestMapping(value = "/pasajeros/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String nuevoPasajero(@RequestParam String nombre, @RequestParam String contrasena,
			@RequestParam float credito) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String fecha = dateFormat.format(date).toString();
		Session session = getSession();
		Pasajero pasajero = new Pasajero(nombre, contrasena, fecha, credito);
		Muber muber = getMuber(session);
		muber.agregarPasajero(pasajero);
		MuberRepository.update(session, muber);
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}

	@RequestMapping(value = "/conductores/top10", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String top10() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		Collection<String> top10 = ConductorRepository.getTop10(getSession());
		aMap.put("result", "OK");
		aMap.put("Top 10 Conductores", top10);
		return new Gson().toJson(aMap);
	}

}
