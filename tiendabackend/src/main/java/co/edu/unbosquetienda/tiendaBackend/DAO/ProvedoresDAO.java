package co.edu.unbosquetienda.tiendaBackend.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.tienda.tiendaBackend.DTO.ProvedoresDTO;

public class ProvedoresDAO {

	/**
	 * permite consultar la lista de Clientes
	 * @return
	 */
	public ArrayList<ProvedoresDTO> listaDeProveedores() {
	  ArrayList<ProvedoresDTO> misProveedores = new ArrayList<ProvedoresDTO>();
	  Conexion conex= new Conexion();
	    
	  try {
	   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM tienda.proveedores");
	   ResultSet res = consulta.executeQuery();
	   while(res.next()){
	    
	    int nitproveedor = Integer.parseInt(res.getString("nitproveedor"));
	    String ciudad_proveedor = res.getString("ciudad_proveedor");
	    String direccion_proveedor = res.getString("direccion_proveedor");
	    String nombre_proveedor = res.getString("nombre_proveedor");
	    String telefono_proveedor = res.getString("telefono_proveedor");
	    
	    ProvedoresDTO proveedor= new ProvedoresDTO(nitproveedor, ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor);
	    misProveedores.add(proveedor);
	          }
	          res.close();
	          consulta.close();
	          conex.desconectar();
	   
	  } catch (Exception e) {
	   JOptionPane.showMessageDialog(null, "no se pudo consultar el proveedor\n"+e);
	  }
	  return misProveedores;
	 }

}
