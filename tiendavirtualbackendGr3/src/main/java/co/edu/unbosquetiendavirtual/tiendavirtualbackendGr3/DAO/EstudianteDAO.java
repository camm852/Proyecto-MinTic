package co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Estudiante;


public class EstudianteDAO {
	
	
	/**
	 * permite consultar la lista de Clientes
	 * @return
	 */
	public ArrayList<Estudiante> listaDeEstudiantes() {
	  ArrayList<Estudiante> misEstudiantes = new ArrayList<Estudiante>();
	  Conexion conex= new Conexion();
	    
	  try {
	   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM estudiante");
	   ResultSet res = consulta.executeQuery();
	   while(res.next()){
	    
	    int id = Integer.parseInt(res.getString("id"));
	    String correoInst = res.getString("correo_institucional");
	    String nombres = res.getString("nombres");
	    String apellidos = res.getString("apellidos");
	    String telefonoFijo = res.getString("telefono_fijo");
	    String telefonoCelular = res.getString("telefono_celular");
	    String correoPersonal = res.getString("correo_personal");
	    String programa = res.getString("programa_academico");
	    String fechaNac = res.getString("fecha_nacimiento");
	    Estudiante persona= new Estudiante(id, correoInst, nombres, apellidos, telefonoFijo,
				telefonoCelular, correoPersonal, programa, fechaNac);
	    misEstudiantes.add(persona);
	          }
	         res.close();
	          consulta.close();
	          conex.desconectar();
	   
	  } catch (Exception e) {
	   JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
	  }
	  return misEstudiantes;
	 }
	
	public Estudiante registrarEstudiante(Estudiante persona) 
	 {
	  Conexion conex= new Conexion();
	  try {
	   Statement estatuto = conex.getConnection().createStatement();
	   estatuto.executeUpdate("INSERT INTO estudiante VALUES ('"+persona.getId()+"', '"+persona.getCorreoInstitucional()+"','"
	     +persona.getNombres()+"', '"+persona.getApellidos()+"','"+persona.getTelefonoFijo()+"', '"+persona.getTelefonoCel()+"','"
	     +persona.getCorreoPersonal()+"','"+persona.getPrograma()+"','"+persona.getFechaNacimiento()+"')");
	   
	   
	   estatuto.close();
	   conex.desconectar();
	   
	  } catch (SQLException e) {
		  persona = null;
	            System.out.println(e.getMessage());
	  }
	  return persona;
	 }
	 

}
