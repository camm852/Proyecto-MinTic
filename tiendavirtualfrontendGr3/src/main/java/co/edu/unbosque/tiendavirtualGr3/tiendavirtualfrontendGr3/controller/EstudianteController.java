package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO.EstudianteDAO;
import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.EstudianteVO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class EstudianteController {
	
	private ArrayList<EstudianteVO> listaEstudiantes;
	
	@Autowired
	private EstudianteDAO objEstDao;
	
	
	public void consultarEstudiantes() {
		objEstDao = new EstudianteDAO();
		String json = objEstDao.listarUsuarios();
		if(json  != null) {
            Type listType = new TypeToken<ArrayList<EstudianteVO>>(){}.getType();
            Gson gson = new Gson();
            listaEstudiantes = gson.fromJson(json, listType);
        }else {
        	listaEstudiantes = new ArrayList<EstudianteVO>();
        }
	}

	public EstudianteVO guardarEstudiante(EstudianteVO est) {
		objEstDao = new EstudianteDAO();
		return objEstDao.nuevoUsuario(est);
	}

	public ArrayList<EstudianteVO> getListaEstudiantes() {
		return listaEstudiantes;
	}


	public void setListaEstudiantes(ArrayList<EstudianteVO> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}
	
	@PostMapping("/crearEstudiante")
	public String crearEstudiante(Model model, EstudianteVO estudiante) {

		objEstDao = new EstudianteDAO();
		
		model.addAttribute("estudiante", objEstDao.nuevoUsuario(estudiante));
		consultarEstudiantes();
		model.addAttribute("estudiantes", getListaEstudiantes());

		return "crearEstudiante";

			}

	@GetMapping("/crearEstudiante")
	public String estudiante(Model model) {
		consultarEstudiantes();
		model.addAttribute("estudiantes", getListaEstudiantes());
		//model.addAttribute("usuarios", clienteTienda.getUsuarios());
		return "crearEstudiante";
	}

	

}
