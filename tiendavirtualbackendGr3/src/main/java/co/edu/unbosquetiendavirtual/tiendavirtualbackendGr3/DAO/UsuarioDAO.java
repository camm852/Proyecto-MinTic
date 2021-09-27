package co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.swing.JOptionPane;


import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Usuario;





public class UsuarioDAO {
	
	
	public ArrayList<Usuario> listaDeUsuarios() {
		  ArrayList<Usuario> misUsuarios = new ArrayList<Usuario>();
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
		    
		    Usuario persona= new Usuario(cedula_usuario, email_usuario, nombre_usuario, password_usuario, usuario);
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

	public Usuario consultarUsuario(String nombreU, String contrasenaU) {
		Conexion conn =  new Conexion();
		Usuario usuarioEnc = null;
		PreparedStatement ps = null;
		Usuario usuarioRet = null;
		
		String sql = "SELECT * FROM tienda.usuarios WHERE nombre_usuario like ?";
		
		try {
			ps =  conn.getConnection().prepareStatement(sql);
			ps.setString(1, nombreU);
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				Integer cedula = rs.getInt(1);
				String email = rs.getString(2);
				String nombre =  rs.getString(3);
				String psswrd =  rs.getString(4);
				String rol = rs.getString(5);
				usuarioEnc =  new Usuario(cedula,email,nombre, psswrd, rol);
			}
			
			if(usuarioEnc.getContrasena().equals(contrasenaU)) {
				usuarioRet = usuarioEnc;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuarioRet;
	}
	
	public Usuario agregarUsuario(Usuario usuario) {
		try {
	  		  Conexion conex= new Conexion();
	  	   PreparedStatement consulta = conex.getConnection().prepareStatement("insert into tienda.usuarios (cedula_usuario, email_usuario,nombre_usuario,password,usuario ) values(?,?,?,?,?)");
	  	   System.out.println("Se hizo conexion");
	  	 
	  		   
	  		   consulta.setInt(1, usuario.getCedula());
	  		   consulta.setString(2, usuario.getEmail());
	  		   consulta.setString(3, usuario.getNombre());
	  		   consulta.setString(4, usuario.getContrasena());
	  		   consulta.setString(5, usuario.getRol());
	  	    
	  		   consulta.executeUpdate();
	   
	  	    consulta.close();
	  	    conex.desconectar();

	  	 
	  	  } catch (SQLException e) {
	  		usuario = null;
	  	   JOptionPane.showMessageDialog(null, "no se pudo consultar el usuario\n"+e);
	  	  }
	  	  return usuario;
	}
	
	 public Usuario actualizar_usuario(Usuario user) {
	        
	        try {
	        
	            Conexion conex= new Conexion();
	        PreparedStatement sentencia= conex.getConnection().prepareStatement("update tienda.usuarios set email_usuario=?, nombre_usuario=?,password=?, usuario=? where cedula_usuario=?");
	        sentencia.setString(1, user.getEmail());
	        sentencia.setString(2, user.getNombre());
	        sentencia.setString(3, user.getContrasena());
	        sentencia.setString(4, user.getRol());
	        sentencia.setInt(5, user.getCedula());
	  

	        sentencia.executeUpdate();
	        conex.desconectar();
	        return user;
	        } catch (Exception e) {
	            System.out.println("Error: "+e);
	            return null;
	        }
	        
	    }
	    
	    public Usuario eliminar_usuario(Usuario user) {
	        try {
	        	Conexion conex= new Conexion();
	            PreparedStatement sentencia= conex.getConnection().prepareStatement("delete from tienda.usuarios where cedula_usuario=?");
	        sentencia.setLong(1, user.getCedula());
	        
	        sentencia.executeUpdate();
	        conex.desconectar();
	      
	        return null;
	        } catch (Exception e) {
	            System.out.println("Error: "+e);
	            return null;
	        }
	    }
	
	
}
