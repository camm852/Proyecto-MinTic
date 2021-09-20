package co.edu.unbosquetienda.tiendaBackend.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.tienda.tiendaBackend.DTO.Estudiante;

public class EstudianteDAO {
	
	
	/**
	 * permite consultar la lista de Clientes
	 * @return
	 */
	public ArrayList<Estudiante> listaDeEstudiantes() {
	  ArrayList<Estudiante> misEstudiantes = new ArrayList<Estudiante>();
	  Conexion conex= new Conexion();
	    
	  try {
	   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM estudiantes");
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

}
