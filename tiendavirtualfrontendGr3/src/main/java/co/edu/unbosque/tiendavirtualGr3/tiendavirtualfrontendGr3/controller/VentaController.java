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


import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO.VentaDAO;
import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.VentaListaVO;
import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.VentaVO;

@Controller
public class VentaController {

	private ArrayList<VentaListaVO> listaVentas;
	@Autowired
	private VentaDAO objDao;
	
	public void consultarVenta() {
		objDao = new VentaDAO();
		String json = objDao.listarVentas();
		System.out.println("Consultando");
		if(json  != null) {
            Type listType = new TypeToken<ArrayList<VentaListaVO>>(){}.getType();
            Gson gson = new Gson();
            listaVentas = gson.fromJson(json, listType);
        }else {
        	listaVentas = new ArrayList<VentaListaVO>();
        }
	}
	
	public ArrayList<VentaListaVO> getListaVentas() {
		return listaVentas;
	}


	public void setListaVentas(ArrayList<VentaListaVO> listaVentas) {
		this.listaVentas = listaVentas;
	}
	
	
	@PostMapping("/agregarVenta")
	public String agregarVenta(Model model,VentaVO venta) {
		
		objDao=new VentaDAO();
		VentaVO objventa = objDao.agregarVenta(venta);
		
		if(objventa!=null) {
			model.addAttribute("agrego","se agrego la venta");
		}else {
			model.addAttribute("fallo","fallo al agregar venta");
		}
		
		return "/pages/ventas/agregarVenta";
	}
	
	@PostMapping("/listarVentas")
	public String listarCliente(Model model, VentaListaVO usuario) {
		System.out.println("listando");
		consultarVenta();
		model.addAttribute("clientes", getListaVentas());
		
		return "/pages/reportes/listaClientes";
	}

	@GetMapping("/listarVentas")
	public String listarCliente(Model model) {
		consultarVenta();
		model.addAttribute("ventas", getListaVentas());
		//model.addAttribute("usuarios", clienteTienda.getUsuarios());
		return "/pages/reportes/listaVentas";
	}
	
	
}
