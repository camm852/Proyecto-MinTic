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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioController objContro = new UsuarioController();
		objContro.consultarUsuarios();
		ArrayList<UsuarioVO> listaUsuarios = objContro.getListaUsuarios();
		
		
		String user = request.getParameter("usuarioInput");
		String contra = request.getParameter("passwordInput");
		

		for(UsuarioVO dto : listaUsuarios){ 
			String misUsuarios = dto.getNombre_usuario();
			String misContra = dto.getPassword_usuario();
			
			if ( misUsuarios.equals(user) && misContra.equals(contra)){
				System.out.println("EstaUsuario");
				response.sendRedirect("control.jsp");
				
			}
			else{
				System.out.println("No esta usuario");
				response.sendRedirect("index.jsp");
			}
			
		}
	
	}

}
