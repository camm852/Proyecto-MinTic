package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.ProductoVO;
import reactor.core.publisher.Mono;


@Service
public class ProductoDAO {
	
	private static final String URL = "http://localhost:8080";
	
	@Autowired
	private WebClient webClient;
	
	public ProductoVO nuevoProducto(ProductoVO p) {
		try{
		WebClient webClient = WebClient.create(URL);
		ProductoVO objProducto = null;
		System.out.println("Entro nuevo front");
		
		Mono<ProductoVO> response = webClient.put().uri(URL+"/registrarProducto").
		body(Mono.just(p),ProductoVO.class).retrieve().bodyToMono(ProductoVO.class);
		objProducto = response.block();
		return objProducto;
		}
		catch(WebClientResponseException e) {
			e.getMessage();
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	public void borrarProductos() {
		try {

			URL url = new URL(URL+"/borrarProductos");
			System.out.println("Creo url1");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        System.out.println("Creo url 2");
	        conn.setRequestMethod("GET");
	        System.out.println("get");
	        conn.setRequestProperty("Accept", "application/json");
	        System.out.println("json");
	        if (conn.getResponseCode() != 200) {
	        	System.out.println("Entro if");
	            throw new RuntimeException("Failed : HTTP Error code : "
	                    + conn.getResponseCode());
	        }
	        System.out.println("Salio del if ");
	        InputStreamReader in = new InputStreamReader(conn.getInputStream());
	        BufferedReader br = new BufferedReader(in);
	        String json = br.readLine();
	        conn.disconnect();
	        
	        
	    } catch (Exception e) {
	        System.out.println("Exception in NetClientGet:- " + e);
	    }
	}
}
