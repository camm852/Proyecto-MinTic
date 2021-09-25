package co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Usuario;


public class UsuarioDAO {
	public Usuario consultarUsuario(String nombreU, String contrasenaU) {
		Conexion conn =  new Conexion();
		Usuario usuarioEnc = null;
		PreparedStatement ps = null;
		Usuario usuarioRet = null;
		
		String sql = "SELECT * FROM tienda.usuario u WHERE u.nombre like ?";
		
		try {
			ps =  conn.getConnection().prepareStatement(sql);
			ps.setString(1, nombreU);
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				Integer cedula = rs.getInt(1);
				String email = rs.getString(2);
				String nombre =  rs.getString(3);
				String psswrd =  rs.getString(4);
				String rol = rs.getString(5);
				usuarioEnc =  new Usuario(cedula,email,nombre, psswrd, rol);
			}
			
			if(usuarioEnc.getContrasena().equals(contrasenaU)) {
				usuarioRet = usuarioEnc;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuarioRet;
	}
	
	public Usuario agregarUsuario(Usuario usuario) {
		Conexion conn= new Conexion();
		PreparedStatement ps = null;
		Usuario addUser = null;
		String sql = "INSER INTO tienda.usuario values(?,?,?,?,?)";
		try {
			ps.getConnection().prepareStatement(sql);
			ps.setInt(1, usuario.getCedula());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getNombre());
			ps.setString(4, usuario.getContrasena());
			ps.setString(5, usuario.getRol());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs != null) {
				Integer cedula = rs.getInt(1);
				String email = rs.getString(2);
				String nombre =  rs.getString(3);
				String psswrd =  rs.getString(4);
				String rol = rs.getString(5);
				addUser =  new Usuario(cedula,email,nombre, psswrd, rol);
				System.out.println("Se agrego el estudiante");
			}else {
				System.out.println("No se agrego el estudiante");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
}
