package co.edu.unbosque.tienda.tiendaBackend;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping("/anadirUsuario")
	public UsuarioDTO anadirUsuario(@RequestBody UsuarioDTO userDTO) {
		UsuarioDAO objDAO = new UsuarioDAO();
		return objDAO.insertar_Usuario(userDTO);
	   

	}
	
	@RequestMapping("/consultarUsuario")
	public UsuarioDTO consultarUsuario(long cedula) {
		UsuarioDAO objDAO = new UsuarioDAO();
		return objDAO.consultarUsuario(cedula);
	   

	}
	
	@RequestMapping("/actualizarUsuario")
	public boolean actualizarUsuario(UsuarioDTO userDTO) {
		UsuarioDAO objDAO = new UsuarioDAO();
		return objDAO.actualizar_usuario(userDTO);
	   
	}
	
	@RequestMapping("/eliminarUsuario")
	public boolean eliminarUsuario(long cedula) {
		UsuarioDAO objDAO = new UsuarioDAO();
		return objDAO.eliminar_usuario(cedula);

	}
	

}
