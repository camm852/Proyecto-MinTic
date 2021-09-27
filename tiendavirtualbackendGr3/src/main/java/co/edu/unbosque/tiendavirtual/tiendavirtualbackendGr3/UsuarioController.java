package co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Usuario;
import co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO.UsuarioDAO;

@RestController
public class UsuarioController {
		
	@PostMapping("/login")
	public Usuario auth(String nombre, String contrasena) {
		UsuarioDAO dao =  new UsuarioDAO();
		return dao.consultarUsuario(nombre, contrasena);
	}
	
	@RequestMapping("/listarUsuarios")
	public ArrayList<Usuario> listaDeUsuarios() {
		UsuarioDAO objDAO=new UsuarioDAO(); 
			return objDAO.listaDeUsuarios();
	}
	
	@PostMapping("/agregarUsuario")
	public Usuario agregarUsuario(@RequestBody Usuario usuario) {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.agregarUsuario(usuario);
	}
	
	@RequestMapping("/actualizarUsuario")
	public Usuario actualizarUsuario(@RequestBody Usuario userDTO) {
		UsuarioDAO objDAO = new UsuarioDAO();
		return objDAO.actualizar_usuario(userDTO);
	   
	}
	
	@RequestMapping("/eliminarUsuario")
	public Usuario eliminarUsuario(@RequestBody Usuario userDTO) {
		UsuarioDAO objDAO = new UsuarioDAO();
		return objDAO.eliminar_usuario(userDTO);

	}

}
