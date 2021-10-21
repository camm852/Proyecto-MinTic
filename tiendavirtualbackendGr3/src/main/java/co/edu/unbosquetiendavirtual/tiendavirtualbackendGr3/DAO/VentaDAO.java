package co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Venta;



public class VentaDAO {
	
	

	
	public Venta registrarVenta(Venta venta) {
		Conexion conex = new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO tienda.ventas VALUES('"+venta.getCodigo_detalle_venta()+"','"+venta.getCantidad_producto()+"','"+ venta.getCodigo_producto()+"','"
					+ venta.getCodigo_venta()+"','"+ venta.getValor_total()+"','"+ venta.getValor_venta()+"','"+venta.getValoriva()+"');");
			
			estatuto.close();
			conex.desconectar();
		}
		catch(SQLException e) {
			venta = null;
				System.out.println(e.getMessage());
		}
		return venta;
	}
}
