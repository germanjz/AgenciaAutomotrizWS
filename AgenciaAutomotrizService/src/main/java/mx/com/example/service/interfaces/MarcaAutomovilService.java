package mx.com.example.service.interfaces;

import org.springframework.http.ResponseEntity;

import mx.com.example.ws.request.MarcaAutomovilRequest;
import mx.com.example.ws.response.ListMarcaResponse;
import mx.com.example.ws.response.MarcaAutomovilResponse;
import mx.com.example.ws.response.ObjectResponse;

/**
 * 
 * @author German Juarez
 *
 */
public interface MarcaAutomovilService {
	/**
	 * Inserta Marca de Automovil
	 * @param request
	 * @return automovil
	 */
	ResponseEntity<MarcaAutomovilResponse> insertarMarca(MarcaAutomovilRequest request);
	/**
	 * Actualiza una Marca de automovil
	 * @param id
	 * @param request
	 * @return automovil
	 */
	ResponseEntity<MarcaAutomovilResponse> actualizarMarca(int id, MarcaAutomovilRequest request);
	/**
	 * Elimina una Marca de  automovil
	 * @param ids
	 * @return response
	 */
	ResponseEntity<ObjectResponse> eliminarMarca(int id);
	/**
	 * Obtiene una Marca de automovil con id
	 * @param id
	 * @return automovil
	 */
	ResponseEntity<MarcaAutomovilResponse> buscarMarca(int id);
	/**
	 * Obtiene todos las Marcas de automoviles
	 * @return listaAutomoviles
	 */
	ResponseEntity<ListMarcaResponse> listarMarcas();
}
