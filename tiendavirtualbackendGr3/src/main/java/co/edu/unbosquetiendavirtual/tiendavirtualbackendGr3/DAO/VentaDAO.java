package co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Venta;



public class VentaDAO {
	
	

	
	public Venta agregarVenta(Venta venta) {
		try {
	  		  Conexion conex= new Conexion();
		  	   PreparedStatement consulta = conex.getConnection().prepareStatement("insert into tienda.ventas (cedula_cliente, cedula_usuario, ivaventa, total_venta, valor_venta) values(?,?,?,?,?)");
		  	   System.out.println("Se hizo conexion");
	  	 
	  		   
	  		   consulta.setLong(1, venta.getCedula_cliente());
	  		   consulta.setLong(2, venta.getCedula_usuario());
	  		   consulta.setLong(3, venta.getIvaventa());
	  		   consulta.setLong(4, venta.getTotal_venta());
	  		   consulta.setLong(5, venta.getValor_venta());
	  	    
	  		   consulta.executeUpdate();
	   
	  	    consulta.close();
	  	    conex.desconectar();

	  	 
	  	  } catch (SQLException e) {
	  		venta = null;
	  	   System.out.println("no se pudo agregar la venta\n"+e);
	  	  }
	  	  return venta;
		}
}
