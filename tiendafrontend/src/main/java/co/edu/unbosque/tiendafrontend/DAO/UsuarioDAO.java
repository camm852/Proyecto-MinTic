package co.edu.unbosque.tiendafrontend.DAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JOptionPane;


import co.edu.unbosque.tiendafrontend.vo.UsuarioVO;

public class UsuarioDAO {

public String listarUsuarios() {
		
		try {

            URL url = new URL("http://localhost:8080/listarUsuarios");//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String json = br.readLine();
            conn.disconnect();
            return json;
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
		return null;
	}

public String añadirUsuario(UsuarioVO user) {
	
	try {
		
        URL url = new URL("http://localhost:8080/anadirUsuario?cedula_usuario="+ user.getCedula_usuario()+"&email_usuario="+user.getEmail_usuario()+"&nombre_usuario="+user.getNombre_usuario()+"&password_usuario="+user.getPassword_usuario()+"&usuario="+user.getUsuario());//your url i.e fetch data from .
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP Error code : "
                    + conn.getResponseCode());
        }
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String json = br.readLine();
        conn.disconnect();
        return json;
    } catch (Exception e) {
        System.out.println("Exception in NetClientGet:- " + e);
    }
	return null;
}

public String consultarUsuario(long cedula) {
	
	try {

        URL url = new URL("http://localhost:8080/consultarUsuario?cedula="+cedula);//your url i.e fetch data from .
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP Error code : "
                    + conn.getResponseCode());
        }
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String json = br.readLine();
        conn.disconnect();
        return json;
    } catch (Exception e) {
        System.out.println("Exception in NetClientGet:- " + e);
    }
	return null;
}


}
