package co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Usuario;
import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Venta;
import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.VentaLista;
import co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO.UsuarioDAO;
import co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO.VentaDAO;

@RestController
public class VentaController {
	
	
	@PostMapping("/agregarVenta")
	public Venta registrarVenta(@RequestBody Venta venta) {
		VentaDAO dao = new VentaDAO();
		return dao.agregarVenta(venta);
	}
	
	@RequestMapping("/listarVentas")
	public ArrayList<VentaLista> listaDeVentas() {
		VentaDAO objDAO=new VentaDAO(); 
			return objDAO.listaDeVentas();
	}
	

}
