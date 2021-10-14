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
	public String loginUsuario(Model model, UsuarioVO usuario) {
		
		objDao = new UsuarioDAO();
		UsuarioVO usr = objDao.login(usuario);
		if(usr!=null) {
			model.addAttribute("usuario",usr);
			return "/imports/sidebar";
		}else {
			model.addAttribute("error","Usuario o contraseña invalidos");
		}
		return "index";
	}
	
	@PostMapping("/listarUsuarios")
	public String listarUsuario(Model model, UsuarioVO usuario) {
		System.out.println("listando");
		consultarUsuarios();
		model.addAttribute("usuarios", getListaUsuarios());
		
		return "/pages/reportes/listaUsuarios";

	}

	@GetMapping("/listarUsuarios")
	public String listarUsuario(Model model) {
		consultarUsuarios();
		model.addAttribute("usuarios", getListaUsuarios());
		//model.addAttribute("usuarios", clienteTienda.getUsuarios());
		return "/pages/reportes/listaUsuarios";
	}
	
	
	@PostMapping("/crearUsuario")
	public String crearUsuario(Model model, UsuarioVO usuario) {
	
		objDao = new UsuarioDAO();
		
		model.addAttribute("usuario", objDao.nuevoUsuario(usuario));
		consultarUsuarios();
		model.addAttribute("usuarios", getListaUsuarios());
		
		return "/pages/usuarios/agregarUsuario";

	}

	@GetMapping("/crearUsuario")
	public String usuario(Model model) {
		consultarUsuarios();
		model.addAttribute("usuarios", getListaUsuarios());
		//model.addAttribute("usuarios", clienteTienda.getUsuarios());
		return "/pages/usuarios/agregarUsuario";
	}
	
	@PostMapping("/actualizarUsuario")
	public String actualizarUsuario(Model model, UsuarioVO usuario) {
	
		objDao = new UsuarioDAO();
		
		model.addAttribute("usuario", objDao.actualizarUsuario(usuario));
		consultarUsuarios();
		model.addAttribute("usuarios", getListaUsuarios());
		
		return "/pages/usuarios/actualizarUsuario";

			}

	@GetMapping("/actualizarUsuario")
	public String actualizarUsuario(Model model) {
		//consultarUsuarios();
		//model.addAttribute("usuarios", getListaUsuarios());
		//model.addAttribute("usuarios", clienteTienda.getUsuarios());
		return "/pages/usuarios/actualizarUsuario";
	}
	
	
	@PostMapping("/eliminarUsuario")
	public String eliminarUsuario(Model model, UsuarioVO usuario) {
	
		objDao = new UsuarioDAO();
		
		model.addAttribute("usuario", objDao.eliminarUsuario(usuario));
		consultarUsuarios();
		model.addAttribute("usuarios", getListaUsuarios());
		
		return "/pages/usuarios/eliminarUsuario";

			}

	@GetMapping("/eliminarUsuario")
	public String eliminarUsuario(Model model) {
		consultarUsuarios();
		model.addAttribute("usuarios", getListaUsuarios());
		//model.addAttribute("usuarios", clienteTienda.getUsuarios());
		return "/pages/usuarios/eliminarUsuario";
	}
	
	
}
