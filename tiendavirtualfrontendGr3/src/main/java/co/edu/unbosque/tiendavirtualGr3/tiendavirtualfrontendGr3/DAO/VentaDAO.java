package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.VentaVO;
import reactor.core.publisher.Mono;

@Service
public class VentaDAO {
private static final String URL = "http://localhost:8080";
	
	@Autowired
	private WebClient webClient;
	
	public VentaVO agregarVenta(VentaVO venta) {
		try {
			WebClient webClient= WebClient.create(URL);
			
			VentaVO objVenta = null;
			
			Mono<VentaVO> response = webClient.post().uri(URL+"/agregarVenta").
			body(Mono.just(venta),VentaVO.class).retrieve().bodyToMono(VentaVO.class);
			objVenta = response.block();
			
			return objVenta;
			
		} catch (Exception e) {
			return null;
		}
	}
	
public String listarVentas() {
		
		try {

            URL url = new URL(URL+"/listarVentas");//your url i.e fetch data from .
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
