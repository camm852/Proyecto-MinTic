package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO.ClienteDAO;
import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.ClienteVO;




@Controller
public class ClienteController {
	private ArrayList<ClienteVO> listaClientes;
	@Autowired
	private ClienteDAO objDao;
	
	public void consultarCliente() {
		objDao = new ClienteDAO();
		String json = objDao.listarClientes();
		System.out.println("Consultando");
		if(json  != null) {
            Type listType = new TypeToken<ArrayList<ClienteVO>>(){}.getType();
            Gson gson = new Gson();
            listaClientes = gson.fromJson(json, listType);
        }else {
        	listaClientes = new ArrayList<ClienteVO>();
        }
	}


	public ArrayList<ClienteVO> getListaClientes() {
		return listaClientes;
	}


	public void setListaClientes(ArrayList<ClienteVO> listaClientes) {
		this.listaClientes = listaClientes;
	}
	

	@PostMapping("/listarClientes")
	public String listarCliente(Model model, ClienteVO usuario) {
		System.out.println("listando");
		consultarCliente();
		model.addAttribute("clientes", getListaClientes());
		
		return "/pages/reportes/listaClientes";
	}

	@GetMapping("/listarClientes")
	public String listarCliente(Model model) {
		consultarCliente();
		model.addAttribute("clientes", getListaClientes());
		//model.addAttribute("usuarios", clienteTienda.getUsuarios());
		return "/pages/reportes/listaClientes";
	}
	
	@PostMapping("/crearCliente")
	public String crearUsuario(Model model, ClienteVO cliente) {
	
		objDao = new ClienteDAO();
		
		model.addAttribute("cliente", objDao.nuevoCliente(cliente));
	
		return "/pages/clientes/agregarCliente";

	}
	
	@PostMapping("/consultarCliente")
	public String consultarCliente(Model model, ClienteVO cliente) {
		objDao = new ClienteDAO();
		
		ClienteVO clienteConsultado = objDao.consultarCliente(cliente);
		
		if(clienteConsultado!=null) {
			model.addAttribute("cliente", clienteConsultado);
		}else {
			model.addAttribute("error","No se encontro el cliente");
			System.out.println("No encontro");
		}
		return "/pages/clientes/consultarCliente";
	}
	
	@PostMapping("/consultarClienteVenta")
	public String consultarClienteVenta(Model model, ClienteVO cliente) {
		objDao = new ClienteDAO();
		
		ClienteVO clienteConsultado = objDao.consultarCliente(cliente);
		
		if(clienteConsultado!=null) {
			model.addAttribute("cliente", clienteConsultado);
		}else {
			model.addAttribute("error","No se encontro el cliente");
			System.out.println("No encontro");
		}
		return "/pages/ventas/agregarVenta";
	}
	
	
	
	@PostMapping("/actualizarCliente")
	public String actualizarCliente(Model model,ClienteVO cliente) {
		objDao = new ClienteDAO();
		model.addAttribute("cliente",objDao.actualizarCliente(cliente));
		
		return "/pages/clientes/actualizarCliente"; 
	}
	
	@PostMapping("/eliminarCliente")
	public String eliminarCliente(Model model,ClienteVO cliente) {
		objDao = new ClienteDAO();
		model.addAttribute("cliente",objDao.eliminarCliente(cliente));
		return "/pages/clientes/eliminarCliente"; 
	}
	
}
