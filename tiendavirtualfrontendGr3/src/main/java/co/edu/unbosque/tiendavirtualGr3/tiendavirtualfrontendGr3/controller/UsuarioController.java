package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO.UsuarioDAO;
import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.UsuarioVO;

@Controller
public class UsuarioController {
	
	
	@Autowired
	private UsuarioDAO objDao;
	
	@PostMapping("/login")
	public String loginUsuario(Model model, String nombreU,String contrasenaU) {
		
		objDao = new UsuarioDAO();
		
		model.addAttribute("usuario",objDao.consultarUsuario(nombreU,contrasenaU));
		
		
		return "admin";
	}
	
	
	
}
