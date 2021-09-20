package co.edu.unbosque.tienda.tiendaBackend;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tienda.tiendaBackend.DTO.ClienteDTO;
import co.edu.unbosquetienda.tiendaBackend.DAO.ClienteDAO;



@RestController
public class ClienteController {

	/**
	 * permite consultar la lista de Clientes
	 * @return
	 */
	@RequestMapping("/listarClientes")
	public ArrayList<ClienteDTO> listaDeEstudiantes() {
		ClienteDAO objDAO=new ClienteDAO(); 
			return objDAO.listaDeClientes();
		
	}

}
