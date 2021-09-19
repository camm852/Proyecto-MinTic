package co.edu.unbosque.tiendafrontend.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import co.edu.unbosque.tiendafrontend.DAO.ClienteDAO;
import co.edu.unbosque.tiendafrontend.vo.ClienteVO;

public class ClienteController {
private ArrayList<ClienteVO> listaClientes;
	
	private ClienteDAO objEstDao;
	
	
	public void consultarClientes() {
		objEstDao = new ClienteDAO();
		String json = objEstDao.listarClientes();
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


	
	
	

}
