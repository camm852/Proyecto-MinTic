package co.edu.unbosque.tiendafrontend.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;

import co.edu.unbosque.tiendafrontend.DAO.EstudianteDAO;
import co.edu.unbosque.tiendafrontend.vo.EstudianteVO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class EstudianteController {
	
	private ArrayList<EstudianteVO> listaEstudiantes;
	
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


	public ArrayList<EstudianteVO> getListaEstudiantes() {
		return listaEstudiantes;
	}


	public void setListaEstudiantes(ArrayList<EstudianteVO> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}
	
	

}
