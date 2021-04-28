package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


/**
 * La clase de implementación del servlet Log4Servlet
 */
//@WebServlet("/Log4Servlet")
public class Log4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(Log4Servlet.class);
       
    /**
     * Constructor de la clase
     */
    public Log4Servlet() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * peticiones POST (aquellas realizadas al rellenar un formulario que tenga METHOD=POST)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Construir la página que devuelve el servlet con órdenes out.print()
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Nombre: " + request.getParameter("nombre"));
		out.println("</body>");
		out.println("</html>");
		logger.info("InfoMessage");
	}

}
