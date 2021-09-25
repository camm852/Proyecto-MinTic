package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.UsuarioVO;
import reactor.core.publisher.Mono;


@Service
public class UsuarioDAO {
	
	private static final String URL = "http://localhost:8080";
	
	@Autowired
	private WebClient webClient;
	
	
	public UsuarioVO consultarUsuario(String nombreU, String contrasenaU){
		try {
			webClient = WebClient.create(URL);
			UsuarioVO objUsuario=null;
			Mono<UsuarioVO> response = webClient.post().uri(URL+"/login").body(Mono.just(nombreU),UsuarioVO.class).retrieve().bodyToMono(UsuarioVO.class);
			
			objUsuario = response.block();
			
			return objUsuario;
		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
			
	}
	
	
}
