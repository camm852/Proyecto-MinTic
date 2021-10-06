package co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.swing.JOptionPane;

import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Proveedor;



public class ProveedorDAO {
	
	
	public ArrayList<Proveedor> listaDeProveedores() {
		  ArrayList<Proveedor> misProveedores = new ArrayList<Proveedor>();
		  Conexion conex= new Conexion();
		    
		  try {
		   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM tienda.proveedores");
		   ResultSet res = consulta.executeQuery();
		   while(res.next()){
			    int nit = Integer.parseInt(res.getString("nitproveedor"));
			    String ciudad = res.getString("ciudad_proveedor");
			    String direccion	 = res.getString("direccion_proveedor");
			    String nombre = res.getString("nombre_proveedor");
			    String telefono = res.getString("telefono_proveedor");
			    
			    Proveedor persona= new Proveedor(nit, ciudad, direccion, nombre, telefono);
			    misProveedores.add(persona);
		   	}
	          res.close();
	          consulta.close();
	          conex.desconectar();
		   
		  } catch (Exception e) {
			  JOptionPane.showMessageDialog(null, "no se pudo consultar el proveedor\n"+e);
		  }
		  return misProveedores;
	}

	
	public Proveedor agregarProveedor(Proveedor proveedor) {
		try {
  		   Conexion conex= new Conexion();
	  	   PreparedStatement consulta = conex.getConnection().prepareStatement("insert into tienda.proveedores (nitproveedor, ciudad_proveedor,direccion_proveedor,nombre_proveedor,telefono_proveedor ) values(?,?,?,?,?)");
	  	   System.out.println("Se hizo conexion");
  	 
  		   
  		   consulta.setLong(1, proveedor.getNit());
  		   consulta.setString(2, proveedor.getCiudad());
  		   consulta.setString(3, proveedor.getDireccion());
  		   consulta.setString(4, proveedor.getNombre());
  		   consulta.setString(5, proveedor.getTelefono());
  	    
  		   consulta.executeUpdate();
   
	  	   consulta.close();
	  	   conex.desconectar();

	  	 
	  	  }catch (SQLException e) {
	  		proveedor = null;
	  		JOptionPane.showMessageDialog(null, "no se pudo consultar el proveedor\n"+e);
	  	  }
	  	  return proveedor;
	}
	
	 public Proveedor actualizarProveedor(Proveedor proveedor) {
	        
	        try {
	        
	            Conexion conex= new Conexion();
		        PreparedStatement sentencia= conex.getConnection().prepareStatement("update tienda.proveedores set ciudad_proveedor=?, direccion_proveedor=?,nombre_proveedor=?, telefono_proveedor=? where nitproveedor=?");
		        sentencia.setString(1, proveedor.getCiudad());
		        sentencia.setString(2, proveedor.getDireccion());
		        sentencia.setString(3, proveedor.getNombre());
		        sentencia.setString(4, proveedor.getTelefono());
		        sentencia.setLong(5, proveedor.getNit());
		  
	
		        sentencia.executeUpdate();
		        conex.desconectar();
		        return proveedor;
	        } catch (Exception e) {
	            System.out.println("Error: "+e);
	            return null;
	        }
	        
	    }
	    
	    public Proveedor eliminarProveedor(Proveedor cliente) {
	        try {
		    	Conexion conex= new Conexion();
		        PreparedStatement sentencia= conex.getConnection().prepareStatement("delete from tienda.proveedores where nitproveedor=?");
		        sentencia.setLong(1, cliente.getNit());
	        
		        sentencia.executeUpdate();
		        conex.desconectar();
	      
		        return null;
	        } catch (Exception e) {
	            System.out.println("Error: "+e);
	            return null;
	        }
	    }
	
	
}
