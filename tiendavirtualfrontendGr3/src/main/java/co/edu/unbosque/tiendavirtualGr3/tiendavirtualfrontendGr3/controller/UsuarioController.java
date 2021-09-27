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

import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO.UsuarioDAO;
import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.UsuarioVO;

@Controller
public class UsuarioController {
	
	private ArrayList<UsuarioVO> listaEstudiantes;
	@Autowired
	private UsuarioDAO objDao;
	
	
	public void consultarUsuarios() {
		objDao = new UsuarioDAO();
		String json = objDao.listarUsuarios();
		System.out.println("Consultando");
		if(json  != null) {
            Type listType = new TypeToken<ArrayList<UsuarioVO>>(){}.getType();
            Gson gson = new Gson();
            listaEstudiantes = gson.fromJson(json, listType);
        }else {
        	listaEstudiantes = new ArrayList<UsuarioVO>();
        }
	}

	public UsuarioVO guardarUsuario(UsuarioVO est) {
		objDao = new UsuarioDAO();
		return objDao.nuevoUsuario(est);
	}

	public ArrayList<UsuarioVO> getListaUsuarios() {
		return listaEstudiantes;
	}


	public void setListaUsuarios(ArrayList<UsuarioVO> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}
	
	@PostMapping("/login")
	public String loginUsuario(Model model, String nombreU,String contrasenaU) {
		
		objDao = new UsuarioDAO();
		
		model.addAttribute("usuario",objDao.consultarUsuario(nombreU,contrasenaU));
		System.out.println("pasaController");
		
		return "control";
	}
	
	
	@PostMapping("/crearUsuario")
	public String crearUsuario(Model model, UsuarioVO usuario) {
	
		objDao = new UsuarioDAO();
		
		model.addAttribute("usuario", objDao.nuevoUsuario(usuario));
		consultarUsuarios();
		model.addAttribute("usuarios", getListaUsuarios());
		
		return "crearUsuario";

			}

	@GetMapping("/crearUsuario")
	public String usuario(Model model) {
		consultarUsuarios();
		model.addAttribute("usuarios", getListaUsuarios());
		//model.addAttribute("usuarios", clienteTienda.getUsuarios());
		return "crearUsuario";
	}
	
	@PostMapping("/actualizarUsuario")
	public String actualizarUsuario(Model model, UsuarioVO usuario) {
	
		objDao = new UsuarioDAO();
		
		model.addAttribute("usuario", objDao.actualizarUsuario(usuario));
		consultarUsuarios();
		model.addAttribute("usuarios", getListaUsuarios());
		
		return "actualizarUsuario";

			}

	@GetMapping("/actualizarUsuario")
	public String actualizarUsuario(Model model) {
		//consultarUsuarios();
		//model.addAttribute("usuarios", getListaUsuarios());
		//model.addAttribute("usuarios", clienteTienda.getUsuarios());
		return "actualizarUsuario";
	}
	
	
	@PostMapping("/eliminarUsuario")
	public String eliminarUsuario(Model model, UsuarioVO usuario) {
	
		objDao = new UsuarioDAO();
		
		model.addAttribute("usuario", objDao.eliminarUsuario(usuario));
		consultarUsuarios();
		model.addAttribute("usuarios", getListaUsuarios());
		
		return "eliminarUsuario";

			}

	@GetMapping("/eliminarUsuario")
	public String eliminarUsuario(Model model) {
		consultarUsuarios();
		model.addAttribute("usuarios", getListaUsuarios());
		//model.addAttribute("usuarios", clienteTienda.getUsuarios());
		return "eliminarUsuario";
	}
	
	
}
