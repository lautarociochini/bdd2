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
import bd2.Muber.dto.ViajeDTO;
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
 * Clase Controlador de Muber. Su trabajo es interactuar con los repositorios 
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
	/**
	 *Método que recupera la instancia de Muber en el sistema
	 */
	protected Muber getMuber() {
		List<Muber> muberList = MuberRepository.obtenerMuber(1);
		Muber muber = muberList.get(0);
		return muber;
	}
	/**
	 *Método de ejemplo para verificar conexión con Tomcat
	 */
	@RequestMapping(value = "/example", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String pasajeros() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}
	/**
	 *Método que crea la instancia incial de Muber
	 */
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
	
	/**
	 *Método que retorna los pasajeros de Muber a través del método de requerimiento GET.
	 *Retorna la colección de pasajeros en formato Json
	 */
	@RequestMapping(value = "/pasajeros", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String devolverPasajeros() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		Collection<PasajeroDTO> pasajeros = ServiceLocator.getInstance().getPasajerosService().getPasajeros();
		aMap.put("result", "OK");
		aMap.put("Pasajeros", pasajeros);
		return new Gson().toJson(aMap);
	}

	/**
	 *Método que retorna los conductores de Muber a través del método de requerimiento GET.
	 *Retorna la colección de conductores en formato Json
	 */
	@RequestMapping(value = "/conductores", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String devolverConductores() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		Collection<ConductorDTO> conductores = ServiceLocator.getInstance().getConductoresService().getConductores();
		aMap.put("result", "OK");
		aMap.put("Conductores", conductores);
		return new Gson().toJson(aMap);
	}
	
	/**
	 *Método que retorna los viajes abiertos de Muber a través del método de requerimiento GET.
	 *Retorna la colección de viajes abiertos en formato Json
	 */
	@RequestMapping(value = "/viajes/abiertos", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String devolverViajesAbiertos() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		Collection<ViajeDTO> viajesAbiertos = ServiceLocator.getInstance().getViajesService().getViajesAbiertos();
		aMap.put("result", "OK");
		aMap.put("Viajes Abiertos", viajesAbiertos);
		return new Gson().toJson(aMap);
	}

	/**
	 *Método que retorna el detalle de un conductor. Se pasa el id como parámetro con el requermiento GET.
	 *Retorna los datos asociados al conductor en formato Json.
	 *@param id
	 */
	@RequestMapping(value = "/conductores/detalle", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String devolverDetalleConductor(@RequestParam("idConductor") long idConductor) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		Collection<ConductorDTO> detallesConductor = ServiceLocator.getInstance().getConductoresService().getInfoById(idConductor);
		if (detallesConductor.isEmpty()) {
			aMap.put("result", "El conductor no existe");
		} else {
			Collection<ViajeDTO> viajesConductor = ServiceLocator.getInstance().getConductoresService().getViajesById(idConductor);
			aMap.put("result", "OK");
			aMap.put("Detalles Conductor", detallesConductor);
			aMap.put("Viajes", viajesConductor);
		}
		return new Gson().toJson(aMap);
	}
	/**
	 *Método que realiza el alta de un nuevo viaje a través del requerimiento POST.
	 *
	 *@param origen
	 *@param destino
	 *@param idConductor
	 *@param costoTotal
	 *@param maxPasajeros
	 */
	@RequestMapping(value = "/viajes/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String nuevoViaje(@RequestParam String origen, @RequestParam String destino, @RequestParam long idConductor,
			@RequestParam float costoTotal, @RequestParam int maxPasajeros) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		Session session = getSession();
		List<Conductor> conductor = ConductorRepository.getById(idConductor);
		if (conductor.isEmpty()) {
			aMap.put("result", "El conductor no existe");
		} else {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			String fecha = dateFormat.format(date).toString();
			new Viaje(costoTotal, fecha, origen, destino, maxPasajeros, conductor.get(0));
			Muber muber = getMuber();
			MuberRepository.update(session, muber);
			aMap.put("result", "OK");
		}
		return new Gson().toJson(aMap);
	}

	/**
	 *Método que registra un nuevo pasajero a un viaje a través del requerimiento POST.
	 *Realiza las comprobaciones correspondientes e indica si es posible o no realizar la operación.
	 *@param viajePasajero
	 */
	@RequestMapping(value = "/viajes/agregarPasajero", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String agregarPasajero(@RequestBody ViajePasajero viajePasajero) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		Session session = getSession();
		List<Viaje> viajes = ViajeRepository.getById(viajePasajero.getIdViaje());
		if (viajes.isEmpty()) {
			aMap.put("result", "El viaje no existe");
		} else {
			List<Pasajero> pasajeros = PasajeroRepository.getById(viajePasajero.getIdUsuario());
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
						Muber muber = getMuber();
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
	/**
	 *Método que crea una nueva calificación para un viaje dado. Realiza las comprobaciones correspondientes
	 * y en caso de no poder completar la operación indica cual fue el error.
	 *@param idViaje
	 *@param idPasajero
	 *@param puntaje
	 *@param comentario
	 */
	@RequestMapping(value = "/viajes/calificar", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String calificarViaje(@RequestParam long idViaje, @RequestParam long idPasajero, @RequestParam int puntaje,
			@RequestParam String comentario) {
		Map<String, Object> aMap = new HashMap<String, Object>();

		Session session = getSession();
		List<Pasajero> pasajeros = PasajeroRepository.getById(idPasajero);
		if (pasajeros.isEmpty()) {
			aMap.put("result", "El pasajero no existe");
		} else {
			List<Viaje> viajes = ViajeRepository.getById(idViaje);
			if (viajes.isEmpty()) {
				aMap.put("result", "El viaje no existe");
			} else {
				List<Calificacion> existeCalificacion = CalificacionRepository.existeCalificacion(idPasajero,
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
						Muber muber = getMuber();
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

	/**
	 *Método que implementa la carga de crédito a un pasajero.
	 *@param pasajero2
	 */
	@RequestMapping(value = "/pasajeros/cargarCredito", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String cargarCredito(@RequestBody Pasajero pasajero2) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		Session session = getSession();
		List<Pasajero> pasajeros = PasajeroRepository.getById(pasajero2.getIdUsuario());
		if (pasajeros.isEmpty()) {
			aMap.put("result", "El pasajero no existe");
		} else {
			Pasajero pasajero = pasajeros.get(0);
			pasajero.cargarCredito(pasajero2.getCredito());
			Muber muber = getMuber();
			MuberRepository.update(session, muber);
			aMap.put("result", "OK");
		}
		return new Gson().toJson(aMap);
	}

	/**
	 *Método que se encarga de finalizar un viaje pasado como parámetro.
	 *@param viaje2
	 */
	@RequestMapping(value = "/viajes/finalizar", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String finalizarViaje(@RequestBody Viaje viaje2) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		Session session = getSession();
		
		List<Viaje> viajes = ViajeRepository.getById(viaje2.getIdViaje());
		if (viajes.isEmpty()) {
			aMap.put("result", "El viaje no existe");
		} else {
			Viaje viaje = viajes.get(0);
			if (viaje.estaFinalizado()) {
				aMap.put("result", "El viaje ya esta finalizado");
			} else {
				viaje.finalizar();
				Muber muber = getMuber();
				MuberRepository.update(session, muber);
				aMap.put("result", "OK");
			}

		}

		return new Gson().toJson(aMap);
	}
	
	/**
	 *Método que implementa el alta de un nuevo conductor de Muber a través del requerimiento POST.
	 *@param nombre
	 *@param contrasena
	 *@param licencia
	 */
	@RequestMapping(value = "/conductores/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String nuevoConductor(@RequestParam String nombre, @RequestParam String contrasena,
			@RequestParam String licencia) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String fecha = dateFormat.format(date).toString();
		Session session = getSession();
		Conductor conductor = new Conductor(nombre, contrasena, fecha, licencia);
		Muber muber = getMuber();
		muber.agregarConductor(conductor);
		MuberRepository.update(session, muber);
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}
	
	/**
	 *Método que implementa el alta de un nuevo pasajero de Muber a través del requerimiento POST.
	 *@param nombre
	 *@param contrasena
	 *@param credito
	 */
	@RequestMapping(value = "/pasajeros/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String nuevoPasajero(@RequestParam String nombre, @RequestParam String contrasena,
			@RequestParam float credito) {
		Map<String, Object> aMap = new HashMap<String, Object>();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String fecha = dateFormat.format(date).toString();
		Session session = getSession();
		Pasajero pasajero = new Pasajero(nombre, contrasena, fecha, credito);
		Muber muber = getMuber();
		muber.agregarPasajero(pasajero);
		MuberRepository.update(session, muber);
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}

	/**
	 *Método que retorna el top10 de los conductores de Muber
	 */
	@RequestMapping(value = "/conductores/top10", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String top10() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		List<ConductorDTO> top10 = ServiceLocator.getInstance().getConductoresService().getConductoresTopTen();
		aMap.put("result", "OK");
		aMap.put("Top 10 Conductores", top10);
		return new Gson().toJson(aMap);
	}

}
