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
	
	  
    public boolean insertar_cliente(ClienteDTO cliente) {	    	 
  	  try {
  		  Conexion conex= new Conexion();
  	   PreparedStatement consulta = conex.getConnection().prepareStatement("insert into tienda.clientes (cedula_cliente, direccion_cliente,email_cliente,nombre_cliente,telefono_cliente ) values(?,?,?,?,?)");
  	   System.out.println("Se hizo conexion");
  	 
  		   
  		   consulta.setInt(1, cliente.getCedula_cliente());
  		   consulta.setString(2, cliente.getDireccion_cliente());
  		   consulta.setString(3, cliente.getEmail_cliente());
  		   consulta.setString(4, cliente.getNombre_cliente());
  		   consulta.setString(5, cliente.getTelefono_cliente());
  	    
  		   consulta.executeUpdate();
   
  	    consulta.close();
  	    conex.desconectar();
  	    return true;
  	 
  	  } catch (Exception e) {
  	   JOptionPane.showMessageDialog(null, "no se pudo insertar el cliente\n"+e);
  	  }
  	  return false;
  	 }
    
    public ClienteDTO consultar_cliente(long cedula) {
        try {
            
             Conexion conex= new Conexion();
             PreparedStatement sentencia= conex.getConnection().prepareStatement("select * from tienda.clientes where cedula_cliente=?");
             sentencia.setLong(1, cedula);
             ResultSet datos = sentencia.executeQuery();
             if(datos.next()){
            	 ClienteDTO cliente = new ClienteDTO();
                 cliente.setCedula_cliente( datos.getInt("cedula_cliente") );
                 cliente.setDireccion_cliente(datos.getString("direccion_cliente"));
                 cliente.setEmail_cliente(datos.getString("email_cliente"));
                 cliente.setNombre_cliente(datos.getString("nombre_cliente"));
                 cliente.setTelefono_cliente(datos.getString("telefono_cliente"));
                 
                 conex.desconectar();
                return cliente;
             }
             else{
            	 conex.desconectar();
                 return null;
             }
              
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return null;
        }
    }
    
    
    public boolean actualizar_cliente(ClienteDTO cliente) {
        
        try {
    
            Conexion conex= new Conexion();
        PreparedStatement sentencia= conex.getConnection().prepareStatement("update tienda.clientes set direccion_cliente=?, email_cliente=?,nombre_cliente=?, telefono_cliente=? where cedula_cliente=?");
        sentencia.setString(1, cliente.getDireccion_cliente());
        sentencia.setString(2, cliente.getEmail_cliente());
        sentencia.setString(3, cliente.getNombre_cliente());
        sentencia.setString(4, cliente.getTelefono_cliente());
        sentencia.setInt(5, cliente.getCedula_cliente());
  

        sentencia.executeUpdate();
        conex.desconectar();
        return true;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return false;
        }
        
    }
    
    public boolean eliminar_cliente(long cedula) {
        try {
        	Conexion conex= new Conexion();
            PreparedStatement sentencia= conex.getConnection().prepareStatement("delete from tienda.clientes where cedula_cliente=?");
        sentencia.setLong(1, cedula);
        
        sentencia.executeUpdate();
        conex.desconectar();
      
        return true;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return false;
        }
    }

}
