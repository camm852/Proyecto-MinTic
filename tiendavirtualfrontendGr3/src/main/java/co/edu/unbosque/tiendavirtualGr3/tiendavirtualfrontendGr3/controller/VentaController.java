package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO.VentaDAO;
import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.VentaVO;

@Controller
public class VentaController {

	@Autowired
	private VentaDAO objDao;
	
	
	@PostMapping("/agregarVenta")
	public String agregarVenta(Model model,VentaVO venta) {
		
		objDao=new VentaDAO();
		VentaVO objventa = objDao.agregarVenta(venta);
		
		if(objventa!=null) {
			model.addAttribute("agrego","se agrego la venta");
		}else {
			model.addAttribute("fallo","fallo al agregar venta");
		}
		
		return "/pages/ventas/agregarVenta";
	}
}
