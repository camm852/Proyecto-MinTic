package co.edu.unbosque.tiendafrontend.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.unbosque.tiendafrontend.vo.UsuarioVO;


/**
 * Servlet implementation class EstudianteServlet
 */
@WebServlet(name="loginServlet", urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioController objContro = new UsuarioController();
		objContro.consultarUsuarios();
		ArrayList<UsuarioVO> listaUsuarios = objContro.getListaUsuarios();
		request.setAttribute("listaUsuarios", listaUsuarios);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		for(UsuarioVO dto : listaUsuarios){ 
			String user = dto.getNombre_usuario();
			System.out.println(user);
			if ( user == request.getParameter("usuarioInput")){
				System.out.println("sta admin");
			}
			else{
				System.out.println("No esta"+request.getParameter("usuarioInput"));
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioController objContro = new UsuarioController();
		objContro.consultarUsuarios();
		ArrayList<UsuarioVO> listaUsuarios = objContro.getListaUsuarios();
		
		
		String user = request.getParameter("usuarioInput");
		

		for(UsuarioVO dto : listaUsuarios){ 
			String misUsuarios = dto.getNombre_usuario();
			System.out.println(user);
			System.out.println(misUsuarios);
			if ( misUsuarios.equals(user)){
				System.out.println("EstaUsuario");
				response.sendRedirect("listarClientesServlet.jsp");
				
			}
			else{
				System.out.println("NOOOOOOOO");
				response.sendRedirect("index.jsp");
			}
			
		}
	
	}

}
