package co.edu.unbosque.tienda.tiendaBackend;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tienda.tiendaBackend.DTO.ProvedoresDTO;
import co.edu.unbosquetienda.tiendaBackend.DAO.ProvedoresDAO;



@RestController
public class ProveedorController {

	/**
	 * permite consultar la lista de Clientes
	 * @return
	 */
	@RequestMapping("/listarProveedores")
	public ArrayList<ProvedoresDTO> listaDeProveedores() {
		ProvedoresDAO objDAO=new ProvedoresDAO(); 
			return objDAO.listaDeProveedores();
		
	}

}
