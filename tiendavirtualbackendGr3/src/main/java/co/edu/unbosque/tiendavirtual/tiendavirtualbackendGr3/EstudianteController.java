package co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Estudiante;
import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Usuario;
import co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO.EstudianteDAO;

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
	
	@PostMapping("/registrarEstudiante")
	public Estudiante registrarEstudiante(@RequestBody Estudiante persona) 
	 {
		EstudianteDAO dao=new EstudianteDAO(); 
	    return dao.registrarEstudiante(persona);
	 }

}
