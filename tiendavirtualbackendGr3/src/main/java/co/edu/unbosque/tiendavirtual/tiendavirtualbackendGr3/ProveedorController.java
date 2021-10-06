package co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Proveedor;
import co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO.ProveedorDAO;





@RestController
public class ProveedorController {
		
	
	@RequestMapping("/listarProveedores")
	public ArrayList<Proveedor> listaDeClientes() {
		ProveedorDAO objDAO=new ProveedorDAO(); 
			return objDAO.listaDeProveedores();
	}
	
	@PostMapping("/agregarProveedor")
	public Proveedor agregarProveedor(@RequestBody Proveedor proveedorDTO) {
		ProveedorDAO dao = new ProveedorDAO();
		return dao.agregarProveedor(proveedorDTO);
	}
	
	@PostMapping("/actualizarProveedor")
	public Proveedor actualizarProveedor(@RequestBody Proveedor proveedorDTO) {
		ProveedorDAO objDAO = new ProveedorDAO();
		return objDAO.actualizarProveedor(proveedorDTO);
	   
	}
	
	@PostMapping("/eliminarProveedor")
	public Proveedor eliminarProveedor(@RequestBody Proveedor proveedorDTO) {
		ProveedorDAO objDAO = new ProveedorDAO();
		return objDAO.eliminarProveedor(proveedorDTO);

	}

}
