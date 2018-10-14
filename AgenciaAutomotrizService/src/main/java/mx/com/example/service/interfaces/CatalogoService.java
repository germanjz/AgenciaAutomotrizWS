package mx.com.example.service.interfaces;

import org.springframework.http.ResponseEntity;

import mx.com.example.ws.response.ListMarcaResponse;
import mx.com.example.ws.response.ListModelosResponse;

/**
 * 
 * @author German Juarez
 *
 */
public interface CatalogoService {
	/**
	 * 
	 * @return
	 */
	ResponseEntity<ListMarcaResponse> catalogoMarcas();
	/**
	 * 
	 * @param idMarca
	 * @return
	 */
	ResponseEntity<ListModelosResponse> catalogoModelos(int idMarca);
}
