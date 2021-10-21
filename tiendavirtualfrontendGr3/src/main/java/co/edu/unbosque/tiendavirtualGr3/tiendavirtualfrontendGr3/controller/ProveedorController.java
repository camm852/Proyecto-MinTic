package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO.ProveedorDAO;
import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.ProveedorVO;

@Controller
public class ProveedorController {
	
	@Autowired
	private ProveedorDAO objDao;
	
	@PostMapping("/agregarProveedor")
	public String agregarProveedor(Model model,ProveedorVO proveedor) {
		objDao=new ProveedorDAO();
		
		model.addAttribute("proveedor",objDao.agregarProveedor(proveedor));
		
		return "/pages/proveedores/agregarProveedor";
	}
	
	@PostMapping("/actualizarProveedor")
	public String actualizarProveedor(Model model,ProveedorVO proveedor) {
		objDao=new ProveedorDAO();
		
		model.addAttribute("proveedor",objDao.actualizarProveedor(proveedor));
		
		return "/pages/proveedores/actualizarProveedor";
	}
	
	@PostMapping("/eliminarProveedor")
	public String eliminarProveedor(Model model,ProveedorVO proveedor) {
		objDao=new ProveedorDAO();
		
		model.addAttribute("proveedor",objDao.eliminarProveedor(proveedor));
		
		return "/pages/proveedores/eliminarProveedor";
	}
}
