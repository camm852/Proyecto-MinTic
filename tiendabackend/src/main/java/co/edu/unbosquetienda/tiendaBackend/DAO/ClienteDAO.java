package co.edu.unbosquetienda.tiendaBackend.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.tienda.tiendaBackend.DTO.ClienteDTO;

public class ClienteDAO {

	/**
	 * permite consultar la lista de Clientes
	 * @return
	 */
	public ArrayList<ClienteDTO> listaDeClientes() {
	  ArrayList<ClienteDTO> misClientes = new ArrayList<ClienteDTO>();
	  Conexion conex= new Conexion();
	    
	  try {
	   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM tienda.clientes");
	   ResultSet res = consulta.executeQuery();
	   while(res.next()){
	    
	    int cedula_cliente = Integer.parseInt(res.getString("cedula_cliente"));
	    String direccion_cliente = res.getString("direccion_cliente");
	    String email_cliente = res.getString("email_cliente");
	    String nombre_cliente = res.getString("nombre_cliente");
	    String telefono_cliente = res.getString("telefono_cliente");
	    
	    ClienteDTO persona= new ClienteDTO(cedula_cliente, direccion_cliente, email_cliente, nombre_cliente, telefono_cliente);
	    misClientes.add(persona);
	          }
	          res.close();
	          consulta.close();
	          conex.desconectar();
	   
	  } catch (Exception e) {
	   JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
	  }
	  return misClientes;
	 }

}
