package co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Venta;
import co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO.VentaDAO;

@RestController
public class VentaController {
	
	
	@PutMapping("/registrarVenta")
	public Venta registrarVenta(@RequestBody Venta venta) {
		VentaDAO dao = new VentaDAO();
		return dao.registrarVenta(venta);
	}
	
	
	

}
