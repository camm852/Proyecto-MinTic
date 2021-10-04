package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.UsuarioVO;
import reactor.core.publisher.Mono;


@Service
public class UsuarioDAO {
	
	private static final String URL = "http://localhost:8080";
	
	@Autowired
	private WebClient webClient;
	
	public String listarUsuarios() {
		
		try {

            URL url = new URL(URL+"/listarUsuarios");//your url i.e fetch data from .
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
	
	public UsuarioVO login(UsuarioVO usr){
		try {
			WebClient webClient =  WebClient.create(URL);
			
			UsuarioVO objUsuario = null;
			
			Mono<UsuarioVO> response = webClient.post().uri(URL+"/login").
			body(Mono.just(usr),UsuarioVO.class).retrieve().bodyToMono(UsuarioVO.class);
			objUsuario = response.block();
			System.out.println("Entro al dao");
			return objUsuario;
		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			System.out.println("Fallo el dao");
			return null;
		}
			
	}
	
	public UsuarioVO nuevoUsuario(UsuarioVO usuarioDto) {

		try {
			WebClient webClient = WebClient.create(URL);
			UsuarioVO objUsuario = null;
			System.out.println("llamando url");
			System.out.println("envio"+usuarioDto);
			Mono<UsuarioVO> response = webClient.post().uri(URL + "/agregarUsuario")
					.body(Mono.just(usuarioDto), UsuarioVO.class).retrieve().bodyToMono(UsuarioVO.class);
			System.out.println(response);
			objUsuario = response.block();
			System.out.println("retornando");
			return objUsuario;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}

	}
	
	public UsuarioVO actualizarUsuario(UsuarioVO usuarioDto) {

		try {
			WebClient webClient = WebClient.create(URL);
			UsuarioVO objUsuario = null;
			Mono<UsuarioVO> response = webClient.post().uri(URL + "/actualizarUsuario")
					.body(Mono.just(usuarioDto), UsuarioVO.class).retrieve().bodyToMono(UsuarioVO.class);

			objUsuario = response.block();
			return objUsuario;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}

	}
	
	
	public UsuarioVO eliminarUsuario(UsuarioVO usuarioDto) {

		try {
			WebClient webClient = WebClient.create(URL);
			UsuarioVO objUsuario = null;
			Mono<UsuarioVO> response = webClient.post().uri(URL + "/eliminarUsuario")
					.body(Mono.just(usuarioDto), UsuarioVO.class).retrieve().bodyToMono(UsuarioVO.class);

			objUsuario = response.block();
			return objUsuario;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}

	}
	
}
