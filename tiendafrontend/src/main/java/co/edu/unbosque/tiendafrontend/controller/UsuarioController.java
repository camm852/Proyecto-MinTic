package co.edu.unbosque.tiendafrontend.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import co.edu.unbosque.tiendafrontend.DAO.UsuarioDAO;
import co.edu.unbosque.tiendafrontend.vo.UsuarioVO;

public class UsuarioController {
private ArrayList<UsuarioVO> listaUsuarios;
private UsuarioVO consultarUsuario, usuario;
private boolean anadioUsuario = false;
	
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
	
	public void anadirUsuario(UsuarioVO user) {
		objEstDao = new UsuarioDAO();
		String json = objEstDao.añadirUsuario(user);
		if(json  != null) {
			Type listType = new TypeToken<UsuarioVO>(){}.getType();
            Gson gson = new Gson();
			usuario =  gson.fromJson(json, listType);
        }else {
        	usuario = new UsuarioVO();
        }
	}
	
	public void consultaUsuario(long cedula) {
		objEstDao = new UsuarioDAO();
		String json = objEstDao.consultarUsuario(cedula);
		if(json  != null) {
            Type listType = new TypeToken<UsuarioVO>(){}.getType();
            Gson gson = new Gson();
            consultarUsuario = gson.fromJson(json, listType);
        }else {
        	consultarUsuario = new UsuarioVO();
        }
	}

	
	
	public UsuarioVO getconsultarUsuario() {
		return consultarUsuario;
	}


	public void setconsultarUsuario(UsuarioVO consultarUsuario) {
		this.consultarUsuario = consultarUsuario;
	}

	
	public boolean isAnadioUsuario() {
		return anadioUsuario;
	}

	public void setAnadioUsuario(boolean anadioUsuario) {
		this.anadioUsuario = anadioUsuario;
	}
	

	public ArrayList<UsuarioVO> getListaUsuarios() {
		return listaUsuarios;
	}


	public void setListaUsuarios(ArrayList<UsuarioVO> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}


	
	
	

}
