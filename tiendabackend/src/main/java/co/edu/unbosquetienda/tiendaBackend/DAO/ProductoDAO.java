package co.edu.unbosquetienda.tiendaBackend.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.tienda.tiendaBackend.DTO.ProductosDTO;

public class ProductoDAO {

	/**
	 * permite consultar la lista de Productos
	 * @return
	 */
	public ArrayList<ProductosDTO> listaDeProductos() {
	  ArrayList<ProductosDTO> misProductos = new ArrayList<ProductosDTO>();
	  Conexion conex= new Conexion();
	    
	  try {
	   PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM tienda.productos");
	   ResultSet res = consulta.executeQuery();
	   while(res.next()){
	    
	    int codigo_producto = Integer.parseInt(res.getString("codigo_producto"));
	    double ivacompra = Double.parseDouble(res.getString("ivacompra"));
	    int nitproveedor = Integer.parseInt(res.getString("nitproveedor"));
	    String nombre_producto = res.getString("nombre_producto");
	    double precio_compra = Double.parseDouble(res.getString("precio_compra"));
	    double precio_venta = Double.parseDouble(res.getString("precio_venta"));
	    
	    ProductosDTO producto= new ProductosDTO(codigo_producto, ivacompra, nitproveedor, nombre_producto, precio_compra,precio_venta);
	    misProductos.add(producto);
	          }
	          res.close();
	          consulta.close();
	          conex.desconectar();
	   
	  } catch (Exception e) {
	   JOptionPane.showMessageDialog(null, "no se pudo consultar el producto\n"+e);
	  }
	  return misProductos;
	 }

}
