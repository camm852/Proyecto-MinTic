package co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3;

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
	
	
	@PostMapping("/agregarUsuario")
	public Usuario agregarUsuario(@RequestBody Usuario usuario) {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.agregarUsuario(usuario);
	}

}
