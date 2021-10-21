package co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO;

import java.sql.SQLException;
import java.sql.Statement;

import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Producto;

public class ProductoDAO {
	
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
