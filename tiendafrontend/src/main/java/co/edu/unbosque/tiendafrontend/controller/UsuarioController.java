package co.edu.unbosque.tiendafrontend.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import co.edu.unbosque.tiendafrontend.DAO.UsuarioDAO;
import co.edu.unbosque.tiendafrontend.vo.UsuarioVO;

public class UsuarioController {
private ArrayList<UsuarioVO> listaUsuarios;
	
	private UsuarioDAO objEstDao;
	
	
	public void consultarUsuarios() {
		objEstDao = new UsuarioDAO();
		String json = objEstDao.listarUsuarios();
		if(json  != null) {
            Type listType = new TypeToken<ArrayList<UsuarioVO>>(){}.getType();
            Gson gson = new Gson();
            listaUsuarios = gson.fromJson(json, listType);
        }else {
        	listaUsuarios = new ArrayList<UsuarioVO>();
        }
	}


	public ArrayList<UsuarioVO> getListaUsuarios() {
		return listaUsuarios;
	}


	public void setListaUsuarios(ArrayList<UsuarioVO> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}


	
	
	

}
