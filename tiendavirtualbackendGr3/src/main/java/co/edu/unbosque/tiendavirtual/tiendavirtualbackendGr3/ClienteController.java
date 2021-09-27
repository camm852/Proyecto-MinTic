package co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Cliente;
import co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO.ClienteDAO;



@RestController
public class ClienteController {
		
	
	@RequestMapping("/listarClientes")
	public ArrayList<Cliente> listaDeUsuarios() {
		ClienteDAO objDAO=new ClienteDAO(); 
			return objDAO.listaDeClientes();
	}
	
	@PostMapping("/agregarCliente")
	public Cliente agregarUsuario(@RequestBody Cliente clienteDTO) {
		ClienteDAO dao = new ClienteDAO();
		return dao.agregarCliente(clienteDTO);
	}
	
	@RequestMapping("/actualizarCliente")
	public Cliente actualizarUsuario(@RequestBody Cliente clienteDTO) {
		ClienteDAO objDAO = new ClienteDAO();
		return objDAO.actualizar_cliente(clienteDTO);
	   
	}
	
	@RequestMapping("/eliminarCliente")
	public Cliente eliminarUsuario(@RequestBody Cliente clienteDTO) {
		ClienteDAO objDAO = new ClienteDAO();
		return objDAO.eliminar_usuario(clienteDTO);

	}

}
