package co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.swing.JOptionPane;

import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Cliente;








public class ClienteDAO {
	
	
	public ArrayList<Cliente> listaDeClientes() {
		  ArrayList<Cliente> misClientes = new ArrayList<Cliente>();
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
		    
		    Cliente persona= new Cliente(cedula_cliente, direccion_cliente, email_cliente, nombre_cliente, telefono_cliente);
		    misClientes.add(persona);
		          }
		          res.close();
		          consulta.close();
		          conex.desconectar();
		   
		  } catch (Exception e) {
		   JOptionPane.showMessageDialog(null, "no se pudo consultar el cliente\n"+e);
		  }
		  return misClientes;
		 }

	
	public Cliente agregarCliente(Cliente cliente) {
		try {
	  		  Conexion conex= new Conexion();
	  	   PreparedStatement consulta = conex.getConnection().prepareStatement("insert into tienda.clientes (cedula_cliente, direccion_cliente,email_cliente,nombre_cliente,telefono_cliente ) values(?,?,?,?,?)");
	  	   System.out.println("Se hizo conexion");
	  	 
	  		   
	  		   consulta.setLong(1, cliente.getCedula());
	  		   consulta.setString(2, cliente.getDireccion());
	  		   consulta.setString(3, cliente.getEmail());
	  		   consulta.setString(4, cliente.getNombre());
	  		   consulta.setString(5, cliente.getTelefono());
	  	    
	  		   consulta.executeUpdate();
	   
	  	    consulta.close();
	  	    conex.desconectar();

	  	 
	  	  } catch (SQLException e) {
	  		cliente = null;
	  	   JOptionPane.showMessageDialog(null, "no se pudo consultar el cliente\n"+e);
	  	  }
	  	  return cliente;
	}
	
	 public Cliente actualizar_cliente(Cliente cliente) {
	        
	        try {
	        
	            Conexion conex= new Conexion();
	        PreparedStatement sentencia= conex.getConnection().prepareStatement("update tienda.clientes set direccion_cliente=?, email_cliente=?,nombre_cliente=?, telefono_cliente=? where cedula_cliente=?");
	        sentencia.setString(1, cliente.getDireccion());
	        sentencia.setString(2, cliente.getEmail());
	        sentencia.setString(3, cliente.getNombre());
	        sentencia.setString(4, cliente.getTelefono());
	        sentencia.setLong(5, cliente.getCedula());
	  

	        sentencia.executeUpdate();
	        conex.desconectar();
	        return cliente;
	        } catch (Exception e) {
	            System.out.println("Error: "+e);
	            return null;
	        }
	        
	    }
	    
	    public Cliente eliminar_cliente(Cliente cliente) {
	        try {
	        	Conexion conex= new Conexion();
	            PreparedStatement sentencia= conex.getConnection().prepareStatement("delete from tienda.clientes where cedula_clinete=?");
	        sentencia.setLong(1, cliente.getCedula());
	        
	        sentencia.executeUpdate();
	        conex.desconectar();
	      
	        return null;
	        } catch (Exception e) {
	            System.out.println("Error: "+e);
	            return null;
	        }
	    }
	
	
}
