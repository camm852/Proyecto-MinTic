package co.edu.unbosque.tienda.tiendaBackend;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.edu.unbosque.tienda.tiendaBackend.DTO.ProductosDTO;
import co.edu.unbosquetienda.tiendaBackend.DAO.ProductoDAO;



@RestController
public class ProductosController {

	/**
	 * permite consultar la lista de Productos
	 * @return
	 */
	@RequestMapping("/listarProductos")
	public ArrayList<ProductosDTO> listaDeEstudiantes() {
		ProductoDAO objDAO=new ProductoDAO(); 
			return objDAO.listaDeProductos();
		
	}

}
