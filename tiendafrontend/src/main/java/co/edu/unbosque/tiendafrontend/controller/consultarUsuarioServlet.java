package co.edu.unbosque.tiendafrontend.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class EstudianteServlet
 */
@WebServlet(name="consultarUsuarioServlet", urlPatterns = "/consultarUsuarioServlet")
public class consultarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public consultarUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.print("Consulta");
		long cedula = Long.parseLong(request.getParameter("cedulaGestor"));
		

		
		UsuarioController objContro = new UsuarioController();
		objContro.consultaUsuario(cedula);
			

		
	}

}
