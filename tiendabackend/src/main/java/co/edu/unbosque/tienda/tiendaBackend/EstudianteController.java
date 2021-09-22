package co.edu.unbosque.tienda.tiendaBackend;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tienda.tiendaBackend.DTO.Estudiante;
import co.edu.unbosque.tienda.tiendaBackend.DTO.UsuarioDTO;
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
	

	
	@RequestMapping("/getWithoutRequestParam")
	public String getWithoutRequestParam(UsuarioDTO personDTO) {
		EstudianteDAO objDAO = new EstudianteDAO();
		
		
	  return personDTO.getNombre_usuario()+" "+personDTO.getPassword_usuario();
			

	}


}
