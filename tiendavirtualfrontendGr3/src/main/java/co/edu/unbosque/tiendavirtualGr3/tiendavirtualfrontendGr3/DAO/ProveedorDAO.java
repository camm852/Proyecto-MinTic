package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.ProveedorVO;
import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.UsuarioVO;
import reactor.core.publisher.Mono;

@Service
public class ProveedorDAO {
private static final String URL = "http://localhost:8080";
	
	@Autowired
	private WebClient webClient;
	
	public ProveedorVO agregarProveedor(ProveedorVO proveedorDto) {
		try {
			WebClient webClient = WebClient.create(URL);
			ProveedorVO objProveedor = null;
			Mono<ProveedorVO> response = webClient.post().uri(URL + "/agregarProveedor")
					.body(Mono.just(proveedorDto), ProveedorVO.class).retrieve().bodyToMono(ProveedorVO.class);
			objProveedor=response.block();
			return objProveedor;
			
		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}
	
	public ProveedorVO actualizarProveedor(ProveedorVO proveedorDto) {
		try {
			WebClient webClient = WebClient.create(URL);
			ProveedorVO objProveedor = null;
			Mono<ProveedorVO> response = webClient.post().uri(URL + "/actualizarProveedor")
					.body(Mono.just(proveedorDto), ProveedorVO.class).retrieve().bodyToMono(ProveedorVO.class);
			objProveedor=response.block();
			return objProveedor;
			
		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}
	
	public ProveedorVO eliminarProveedor(ProveedorVO proveedorDto) {
		try {
			WebClient webClient = WebClient.create(URL);
			ProveedorVO objProveedor = null;
			Mono<ProveedorVO> response = webClient.post().uri(URL + "/eliminarProveedor")
					.body(Mono.just(proveedorDto), ProveedorVO.class).retrieve().bodyToMono(ProveedorVO.class);
			objProveedor=response.block();
			return objProveedor;
			
		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}
	
}

