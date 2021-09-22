package co.edu.unbosque.tiendafrontend.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.unbosque.tiendafrontend.DAO.UsuarioDAO;
import co.edu.unbosque.tiendafrontend.vo.UsuarioVO;


/**
 * Servlet implementation class EstudianteServlet
 */
@WebServlet(name="GestorUsuariosServlet", urlPatterns = "/GestorUsuariosServlet")
public class GestorUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestorUsuariosServlet() {
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
		
		int cedula = Integer.parseInt(request.getParameter("cedulaGestor"));
		String usuario = request.getParameter("usuarioGestor");
		String nom_usuario = request.getParameter("nombreGestor");
		String password = request.getParameter("passwordGestor");
		String email = request.getParameter("emailGestor");
		
		
		
		UsuarioVO nuevoUsuario = new UsuarioVO();
		
		nuevoUsuario.setCedula_usuario(cedula);
		nuevoUsuario.setEmail_usuario(email);
		nuevoUsuario.setNombre_usuario(nom_usuario);
		nuevoUsuario.setPassword_usuario(password);
		nuevoUsuario.setUsuario(usuario);
		
		boolean seAnadio = false;
		
		UsuarioController objContro = new UsuarioController();
		objContro.anadirUsuario(nuevoUsuario);
		seAnadio = objContro.isAnadioUsuario();
		
		request.setAttribute("UserAnadido", seAnadio);
		request.getRequestDispatcher("control.jsp").forward(request, response);

		if(seAnadio) {
			System.out.print(seAnadio);
		}
	
	}

}
