/**
 * 
 */
package bd2.Muber.repositories;

import org.hibernate.Session;

/**
 * @author Lautaro
 * Interface utilizada para representar al repositorio base del cual extienden todos los demás
 * Define un método para obtener la sesión y que pueda utilizarse desde todos los repositorios
 */
public interface BaseRepository {
	
	Session getSession();

}
