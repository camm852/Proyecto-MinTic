package co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Cliente;
import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Usuario;
import co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO.ClienteDAO;
import co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO.UsuarioDAO;



@RestController
public class ClienteController {
		
	
	@RequestMapping("/listarClientes")
	public ArrayList<Cliente> listaDeUsuarios() {
		ClienteDAO objDAO=new ClienteDAO(); 
			return objDAO.listaDeClientes();
	}
	
	@PostMapping("/consultarCliente")
	public Cliente agregarCliente(@RequestBody Cliente clienteDTO) {
		ClienteDAO dao = new ClienteDAO();
		return dao.consultarCliente(clienteDTO);
	}
	
	@PostMapping("/agregarCliente")
	public Cliente agregaCliente(@RequestBody Cliente clienteDTO) {
		ClienteDAO dao = new ClienteDAO();
		return dao.agregarCliente(clienteDTO);
	}
	
	
	
	@PostMapping("/actualizarCliente")
	public Cliente actualizarCliente(@RequestBody Cliente clienteDTO) {
		ClienteDAO objDAO = new ClienteDAO();
		return objDAO.actualizar_cliente(clienteDTO);
	   
	}
	
	@PostMapping("/eliminarCliente")
	public Cliente eliminarCliente(@RequestBody Cliente clienteDTO) {
		ClienteDAO objDAO = new ClienteDAO();
		return objDAO.eliminar_cliente(clienteDTO);

	}

}
