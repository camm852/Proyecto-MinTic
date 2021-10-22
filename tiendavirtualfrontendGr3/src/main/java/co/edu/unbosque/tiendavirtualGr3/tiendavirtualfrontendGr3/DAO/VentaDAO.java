package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO;

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
}
