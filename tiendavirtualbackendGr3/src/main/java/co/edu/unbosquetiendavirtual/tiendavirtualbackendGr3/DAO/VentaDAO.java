package co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Venta;
import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.VentaLista;



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
	
	public ArrayList<VentaLista> listaDeVentas() {
		  ArrayList<VentaLista> misVentas = new ArrayList<VentaLista>();
		  Conexion conex= new Conexion();
		    
		  try {
		   PreparedStatement consulta = conex.getConnection().prepareStatement("select c.cedula_cliente,c.nombre_cliente,sum(v.valor_venta) AS valor_total from clientes AS c inner join ventas AS v on c.cedula_cliente = v.cedula_cliente group by c.cedula_cliente;");
		   ResultSet res = consulta.executeQuery();
		   while(res.next()){
		    System.out.println("paso1");
		    long cedula_cliente = Long.parseLong(res.getString("cedula_cliente"));
		    String nombre_cliente = res.getString("nombre_cliente");
		    System.out.println("paso2");
		    long total = res.getLong("valor_total");
		    System.out.println("paso3");
		    
		    
		    VentaLista venta= new VentaLista(cedula_cliente, nombre_cliente, total);
		    misVentas.add(venta);
		          }
		          res.close();
		          consulta.close();
		          conex.desconectar();
		   
		  } catch (Exception e) {
		   JOptionPane.showMessageDialog(null, "no se pudo consultar la venta\n"+e);
		  }
		  return misVentas;
		 }
	
}
