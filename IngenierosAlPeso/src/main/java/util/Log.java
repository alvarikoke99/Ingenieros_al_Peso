
package util;

/**
 *
 * @author alvarikoke
 */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
* Logger que se encargará de registrar acciones relacionadas con la BBDD
*/
public class Log
{
	public static Logger log = LogManager.getLogger("log");
	public static Logger logdb = LogManager.getLogger("logdb");

}
