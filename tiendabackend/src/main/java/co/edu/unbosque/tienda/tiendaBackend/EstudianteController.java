package co.edu.unbosque.tienda.tiendaBackend;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tienda.tiendaBackend.DTO.Estudiante;
import co.edu.unbosquetienda.tiendaBackend.DAO.EstudianteDAO;

@RestController
public class EstudianteController {
	
	
	/**
	 * permite consultar la lista de Clientes
	 * @return
	 */
	@RequestMapping("/listarEstudiantes")
	public ArrayList<Estudiante> listaDeEstudiantes() {
		EstudianteDAO objDAO=new EstudianteDAO(); 
			return objDAO.listaDeEstudiantes();
		
	}


}
