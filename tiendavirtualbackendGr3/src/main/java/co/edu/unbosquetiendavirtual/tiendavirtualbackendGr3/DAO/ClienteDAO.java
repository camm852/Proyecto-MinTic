package co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.swing.JOptionPane;

import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Cliente;
import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Usuario;








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

	public Cliente consultarCliente(Cliente cliente) {
		Conexion conn =  new Conexion();
		Cliente clienteEnc = null;
		PreparedStatement ps = null;
		Cliente clienteRet = null;
		ResultSet rs =null;
		
		String sql = "SELECT * FROM tienda.clientes WHERE cedula_cliente like ?";
		
		try {
			ps =  conn.getConnection().prepareStatement(sql);
			ps.setLong(1, cliente.getCedula());
			rs =  ps.executeQuery();
			while(rs.next()) {
				Long cedula = rs.getLong(1);
				String direccion = rs.getString(2);
				String email = rs.getString(3);
				String nombre =  rs.getString(4);
				String telefono =  rs.getString(4);
				clienteEnc =  new Cliente(cedula,direccion,email,nombre, telefono);
			}
			clienteRet = clienteEnc;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conn.desconectar();
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return clienteRet;
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
	            PreparedStatement sentencia= conex.getConnection().prepareStatement("delete from tienda.clientes where cedula_cliente=?");
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
