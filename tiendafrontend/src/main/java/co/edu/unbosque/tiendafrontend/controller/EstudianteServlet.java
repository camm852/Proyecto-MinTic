package co.edu.unbosque.tiendafrontend.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.unbosque.tiendafrontend.vo.EstudianteVO;

/**
 * Servlet implementation class EstudianteServlet
 */
@WebServlet(name="estudianteServlet", urlPatterns = "/estudianteServlet")
public class EstudianteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EstudianteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EstudianteController objContro = new EstudianteController();
		objContro.consultarEstudiantes();
		ArrayList<EstudianteVO> listaEstudiantes = objContro.getListaEstudiantes();
		request.setAttribute("listaEstudiantes", listaEstudiantes);
		request.getRequestDispatcher("listarEstudiantesServlet.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
