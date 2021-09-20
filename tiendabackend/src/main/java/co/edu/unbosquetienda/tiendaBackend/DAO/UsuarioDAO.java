package co.edu.unbosquetienda.tiendaBackend.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

}
