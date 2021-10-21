package co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Producto;

public class ProductoDAO {
	
	
	public ArrayList<Producto> listaDeProductos() {
		  ArrayList<Producto> misProductos = new ArrayList<Producto>();
		  Conexion conex= new Conexion();
		    
		  try {
		   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM tienda.productos");
		   ResultSet res = consulta.executeQuery();
		   while(res.next()){
		    
		    long codigo_producto = Long.parseLong(res.getString("codigo_producto"));
		    double ivacompra = Double.parseDouble(res.getString("ivacompra"));
		    int nitproveedor = Integer.parseInt(res.getString("nitproveedor"));
		    String nombre_producto = res.getString("nombre_producto");
		    double precio_compra = Double.parseDouble(res.getString("precio_compra"));
		    double precio_venta = Double.parseDouble(res.getString("precio_venta"));
		    
		    Producto producto= new Producto(codigo_producto, ivacompra, nitproveedor, nombre_producto, precio_compra,precio_venta);
		    misProductos.add(producto);
		          }
		          res.close();
		          consulta.close();
		          conex.desconectar();
		   
		  } catch (Exception e) {
		   JOptionPane.showMessageDialog(null, "no se pudo consultar la lista de productos\n"+e);
		  }
		  return misProductos;
		 }
	
	public void eliminarProductos() {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("DELETE FROM productos");
			estatuto.close();
			conex.desconectar();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
	    }
    }
	
	public void unSafeUpdate() {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("SET SQL_SAFE_UPDATES = 0;");
			estatuto.close();
			conex.desconectar();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
    }
	
	public void safeUpdate() {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("SET SQL_SAFE_UPDATES = 1;");
			estatuto.close();
			conex.desconectar();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Producto registrarProducto(Producto p) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO tienda.productos VALUES('"+p.getCodigo_producto()+"','"+p.getIvacompra()+"','"+ p.getNitproveedor()+"','"
					+ p.getNombre_producto()+"','"+ p.getPrecio_compra()+"','"+ p.getPrecio_venta()+"');");
			
			estatuto.close();
			conex.desconectar();
		}
		catch(SQLException e) {
			p = null;
				System.out.println(e.getMessage());
		}
		return p;
	}
}
