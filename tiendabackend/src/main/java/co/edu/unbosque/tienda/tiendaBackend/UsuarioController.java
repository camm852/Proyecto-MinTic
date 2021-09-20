package co.edu.unbosque.tienda.tiendaBackend;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unbosque.tienda.tiendaBackend.DTO.UsuarioDTO;
import co.edu.unbosquetienda.tiendaBackend.DAO.UsuarioDAO;



@RestController
public class UsuarioController {

	/**
	 * permite consultar la lista de Usuarios
	 * @return
	 */
	@RequestMapping("/listarUsuarios")
	public ArrayList<UsuarioDTO> listaDeUsuarios() {
		UsuarioDAO objDAO=new UsuarioDAO(); 
			return objDAO.listaDeUsuarios();
		
	}

}
