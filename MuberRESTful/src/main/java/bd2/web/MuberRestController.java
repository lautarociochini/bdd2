package bd2.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.google.gson.Gson;
import bd2.Muber.model.clasesDAO.PasajeroDAO;
import bd2.Muber.model.clasesDAO.ConductorDAO;
import bd2.Muber.model.clasesDAO.ViajeDAO;

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
		Collection<String> pasajeros = PasajeroDAO.getAllPasajeros(getSession());
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
	
}
