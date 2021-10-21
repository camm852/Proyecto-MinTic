package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO.ProductoDAO;
import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.ProductoVO;

@Controller
public class ProductoContoller {
	
	@PostMapping("/uploadCSVFile")
	public String uploadFile(Model model, MultipartFile file) throws IOException {
		try {
			System.out.println("Entro");
			List<ProductoVO> misP = new ArrayList<ProductoVO>();
				List<String[]> datos = CSVHelper.csvToTutorials(file.getInputStream());
				ProductoVO p;
				for(String[] s:datos) {
					StringTokenizer token = new StringTokenizer(s[0],";");
					String[]tok = new String[6];
					int i = 0;
					while(token.hasMoreTokens()) {
						tok[i]=token.nextToken();
						System.out.println(tok [i]+"-");
						i++;
					}
					
					p =  new ProductoVO(Long.parseLong(tok[0]), Double.parseDouble(tok[1]), Integer.parseInt(tok[2]),
							tok[3], Double.parseDouble(tok[4]), Double.parseDouble(tok[5]));
			    	misP.add(p);	  
				}
				
				ProductoDAO miDao = new ProductoDAO();
				miDao.borrarProductos();
				System.out.println("Borro");
				for(ProductoVO prod:misP) {
					ProductoVO pRec = miDao.nuevoProducto(prod);
					System.out.println("Nuevo producto");
					if(pRec != null) {
						System.out.println("Cargo");
						model.addAttribute("cargaArchivo","Productos guardados");
					}
					else {
						System.out.println("No cargo");
						model.addAttribute("ErrorCargaArchivo","No se pudo guardar el producto");
					}
				}
		}catch (IOException e) {
			throw new RuntimeException("fail to store csv data: "+e.getMessage());
		}
		return"/pages/uploadfile";
	}

}
