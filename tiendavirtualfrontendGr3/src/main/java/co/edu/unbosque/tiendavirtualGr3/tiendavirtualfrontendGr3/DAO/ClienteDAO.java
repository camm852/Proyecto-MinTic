package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.ClienteVO;
import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.UsuarioVO;
import reactor.core.publisher.Mono;

@Service
public class ClienteDAO {
	private static final String URL = "http://localhost:8080";
	
	@Autowired
	private WebClient webClient;
	
	
public String listarClientes() {
		
		try {

            URL url = new URL(URL+"/listarClientes");//your url i.e fetch data from .
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
	
	public ClienteVO nuevoCliente(ClienteVO clienteDto) {
		try {
			WebClient webClient = WebClient.create(URL);
			ClienteVO objCliente=null;
			Mono<ClienteVO> response = webClient.post().uri(URL + "/agregarCliente")
					.body(Mono.just(clienteDto), ClienteVO.class).retrieve().bodyToMono(ClienteVO.class);
			objCliente=response.block();
			return objCliente;
		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
		
	}
	
	public ClienteVO consultarCliente(ClienteVO clienteDto) {
		try {
			WebClient webClient = WebClient.create(URL);
			ClienteVO objCliente=null;
			Mono<ClienteVO> response = webClient.post().uri(URL + "/consultarCliente")
					.body(Mono.just(clienteDto), ClienteVO.class).retrieve().bodyToMono(ClienteVO.class);
			objCliente=response.block();
			return objCliente;
		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
		
	}
	
	public ClienteVO actualizarCliente(ClienteVO clienteDto) {
		try {
			WebClient webClient = WebClient.create(URL);
			ClienteVO objCliente = null;
			Mono<ClienteVO> response = webClient.post().uri(URL + "/actualizarCliente")
					.body(Mono.just(clienteDto), ClienteVO.class).retrieve().bodyToMono(ClienteVO.class);
			objCliente = response.block();
			return objCliente;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			System.out.println("no actualizoDAO");
			return null;
		}
	}
	
	
	public ClienteVO eliminarCliente(ClienteVO clienteDto) {
		try {
			WebClient webClient = WebClient.create(URL);
			ClienteVO objCliente = null;
			Mono<ClienteVO> response = webClient.post().uri(URL + "/eliminarCliente")
					.body(Mono.just(clienteDto), ClienteVO.class).retrieve().bodyToMono(ClienteVO.class);

			objCliente = response.block();
			return objCliente;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}
}
