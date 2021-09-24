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
	
	@RequestMapping("/anadirUsuario")
	public boolean anadirUsuario(ClienteDTO userDTO) {
		ClienteDAO objDAO = new ClienteDAO();
		objDAO.insertar_cliente(userDTO);
	  return true;

	}
	
	@RequestMapping("/consultarUsuario")
	public ClienteDTO consultarUsuario(long cedula) {
		ClienteDAO objDAO = new ClienteDAO();
		return objDAO.consultar_cliente(cedula);
	   

	}
	
	@RequestMapping("/actualizarUsuario")
	public boolean actualizarUsuario(ClienteDTO userDTO) {
		ClienteDAO objDAO = new ClienteDAO();
		return objDAO.actualizar_cliente(userDTO);
	   
	}
	
	@RequestMapping("/eliminarUsuario")
	public boolean eliminarUsuario(long cedula) {
		ClienteDAO objDAO = new ClienteDAO();
		return objDAO.eliminar_cliente(cedula);

	}

}
