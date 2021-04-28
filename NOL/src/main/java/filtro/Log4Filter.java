package filtro;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;
//Import log4j classes.
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * @author lisas
 *
 */
public class Log4Filter implements Filter {
	ServletContext context;

	// La case Logger permite crear mensajes para el seguimiento o registro de la
	// ejecución de una aplicación.
	// Esta clase no ofrece un método constructor, por lo que se debe usar el método
	// getLogger() que permite obtener un objeto Logger relacionado con el nombre
	// que se asigne como parámetro
	private static final Logger logger = LogManager.getLogger(Log4Filter.class);

	/**
	 * Un filtro es un objeto que realiza tareas de filtrado en la solicitud a un
	 * recurso (un servlet o contenido estático), en la respuesta de un recurso o en
	 * ambos. El contenedor llama a este método para cada solicitud de servlet
	 * correlacionada con este filtro antes de invocar el servlet.
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		// Objeto de la clase HttpServletRequest que extiende la clase ServletRequest.
		// Se utiliza para proporcionar información de solicitud para servlets HTTP.
		HttpServletRequest request = (HttpServletRequest) req;

		// Creamos un objeto de Date que representa la fecha y la hora actual
		Date myreqdate = new Date();

		String mylog = new String(new Date() + " " + request.getRemoteAddr() + " " + request.getMethod());

		// Usando la constante creada anteriormente
		// generar los mensajes de registro
		// alternativa: logger.info(mylog);
		logger.log(null, "info", mylog);
		
		//proceder al siguiente elemento de la cadena.
		chain.doFilter(req, res);
	}

	/*
	 * Este método lo llama el contenedor una vez cuando el filtro de servlet entra
	 * en funcionamiento.
	 */
	public void init(FilterConfig confy) {
		context = confy.getServletContext();
	}

	/*
	 * Este método lo llama el contenedor cuando el filtro de servlets deja de
	 * funcionar.
	 */
	public void destroy() {
	}
}
