package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO.ClienteDAO;
import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.ClienteVO;

@Controller
public class ClienteController {
	@Autowired
	private ClienteDAO objDao;
	
	@PostMapping("/crearCliente")
	public String crearUsuario(Model model, ClienteVO cliente) {
	
		objDao = new ClienteDAO();
		
		model.addAttribute("cliente", objDao.nuevoCliente(cliente));
	
		return "/pages/clientes/agregarCliente";

	}
	
	
	@PostMapping("/actualizarCliente")
	public String actualizarCliente(Model model,ClienteVO cliente) {
		objDao = new ClienteDAO();
		model.addAttribute("cliente",objDao.actualizarCliente(cliente));
		
		return "/pages/clientes/actualizarCliente"; 
	}
	
	@PostMapping("/eliminarCliente")
	public String eliminarCliente(Model model,ClienteVO cliente) {
		objDao = new ClienteDAO();
		model.addAttribute("cliente",objDao.eliminarCliente(cliente));
		return "/pages/clientes/eliminarCliente"; 
	}
	
}
