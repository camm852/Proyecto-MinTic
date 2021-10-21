package co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Producto;
import co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO.ProductoDAO;

@RestController
public class ProductoController {
	
	@GetMapping("/borrarProductos")
	public void borrarProductos() {
		System.out.println("Entro borrar Backend");
		ProductoDAO dao = new ProductoDAO();
		
		dao.unSafeUpdate();
		dao.eliminarProductos();
		dao.safeUpdate();
	}
	
	@PutMapping("/registrarProducto")
	public Producto registrarProducto(@RequestBody Producto p) {
		System.out.println("Entro registrar Backend");
		ProductoDAO dao = new ProductoDAO();
		return dao.registrarProducto(p);
	}
	
	@RequestMapping("/listarProductos")
	public ArrayList<Producto> listaDeUsuarios() {
		ProductoDAO objDAO=new ProductoDAO(); 
			return objDAO.listaDeProductos();
	}
	
	

}
