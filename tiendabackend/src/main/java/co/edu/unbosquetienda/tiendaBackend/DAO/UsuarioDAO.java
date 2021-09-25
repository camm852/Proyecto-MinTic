package co.edu.unbosquetienda.tiendaBackend.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.tienda.tiendaBackend.DTO.UsuarioDTO;

public class UsuarioDAO {

	/**
	 * permite consultar la lista de Usuarios
	 * @return
	 */
	public ArrayList<UsuarioDTO> listaDeUsuarios() {
	  ArrayList<UsuarioDTO> misUsuarios = new ArrayList<UsuarioDTO>();
	  Conexion conex= new Conexion();
	    
	  try {
	   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM tienda.usuarios");
	   ResultSet res = consulta.executeQuery();
	   while(res.next()){
	    
	    int cedula_usuario = Integer.parseInt(res.getString("cedula_usuario"));
	    String email_usuario = res.getString("email_usuario");
	    String nombre_usuario = res.getString("nombre_usuario");
	    String password_usuario = res.getString("password");
	    String usuario = res.getString("usuario");
	    
	    UsuarioDTO persona= new UsuarioDTO(cedula_usuario, email_usuario, nombre_usuario, password_usuario, usuario);
	    misUsuarios.add(persona);
	          }
	          res.close();
	          consulta.close();
	          conex.desconectar();
	   
	  } catch (Exception e) {
	   JOptionPane.showMessageDialog(null, "no se pudo consultar el usuario\n"+e);
	  }
	  return misUsuarios;
	 }
	
	  
	    public UsuarioDTO insertar_Usuario(UsuarioDTO usuario) {	    	 
	  	  try {
	  		  Conexion conex= new Conexion();
	  	   PreparedStatement consulta = conex.getConnection().prepareStatement("insert into tienda.usuarios (cedula_usuario, email_usuario,nombre_usuario,password,usuario ) values(?,?,?,?,?)");
	  	   System.out.println("Se hizo conexion");
	  	 
	  		   
	  		   consulta.setInt(1, usuario.getCedula_usuario());
	  		   consulta.setString(2, usuario.getEmail_usuario());
	  		   consulta.setString(3, usuario.getNombre_usuario());
	  		   consulta.setString(4, usuario.getPassword_usuario());
	  		   consulta.setString(5, usuario.getUsuario());
	  	    
	  		   consulta.executeUpdate();
	   
	  	    consulta.close();
	  	    conex.desconectar();

	  	 
	  	  } catch (SQLException e) {
	  		usuario = null;
	  	   JOptionPane.showMessageDialog(null, "no se pudo consultar el usuario\n"+e);
	  	  }
	  	  return usuario;
	  	 }
	    
	    public UsuarioDTO consultarUsuario(long cedula) {
	        try {
	            
	             Conexion conex= new Conexion();
	             PreparedStatement sentencia= conex.getConnection().prepareStatement("select * from tienda.usuarios where cedula_usuario=?");
	             sentencia.setLong(1, cedula);
	             ResultSet datos = sentencia.executeQuery();
	             if(datos.next()){
	                 UsuarioDTO estudiante = new UsuarioDTO();
	                 estudiante.setCedula_usuario( datos.getInt("cedula_usuario") );
	                 estudiante.setEmail_usuario(datos.getString("email_usuario"));
	                 estudiante.setNombre_usuario(datos.getString("nombre_usuario"));
	                 estudiante.setPassword_usuario(datos.getString("password"));
	                 estudiante.setUsuario(datos.getString("usuario"));
	                 
	                 conex.desconectar();
	                return estudiante;
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
	    
	    
	    public boolean actualizar_usuario(UsuarioDTO user) {
	        
	        try {
	            System.out.println(user.getCedula_usuario());
	            Conexion conex= new Conexion();
	        PreparedStatement sentencia= conex.getConnection().prepareStatement("update tienda.usuarios set email_usuario=?, nombre_usuario=?,password=?, usuario=? where cedula_usuario=?");
	        sentencia.setString(1, user.getEmail_usuario());
	        sentencia.setString(2, user.getNombre_usuario());
	        sentencia.setString(3, user.getPassword_usuario());
	        sentencia.setString(4, user.getUsuario());
	        sentencia.setInt(5, user.getCedula_usuario());
	  

	        sentencia.executeUpdate();
	        conex.desconectar();
	        return true;
	        } catch (Exception e) {
	            System.out.println("Error: "+e);
	            return false;
	        }
	        
	    }
	    
	    public boolean eliminar_usuario(long cedula) {
	        try {
	        	Conexion conex= new Conexion();
	            PreparedStatement sentencia= conex.getConnection().prepareStatement("delete from tienda.usuarios where cedula_usuario=?");
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


