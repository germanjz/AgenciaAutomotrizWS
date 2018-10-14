package mx.com.example.service.interfaces;

import org.springframework.http.ResponseEntity;

import mx.com.example.ws.request.AutomovilRequest;
import mx.com.example.ws.response.AutomovilResponse;
import mx.com.example.ws.response.ListaAutomovilesResponse;
import mx.com.example.ws.response.ObjectResponse;

/**
 * 
 * @author German Juarez
 *
 */
public interface AutomovilService {
	/**
	 * Inserta Automovil
	 * @param request
	 * @return automovil
	 */
	ResponseEntity<AutomovilResponse> insertarAutomovil(AutomovilRequest request);
	/**
	 * Actualiza un automovil
	 * @param id
	 * @param request
	 * @return automovil
	 */
	ResponseEntity<AutomovilResponse> actualizarAutomovil(int id, AutomovilRequest request);
	/**
	 * Elimina un automovil
	 * @param id
	 * @return response
	 */
	ResponseEntity<ObjectResponse> eliminarAutomovil(int id);
	/**
	 * Obtiene un automovil con id
	 * @param id
	 * @return automovil
	 */
	ResponseEntity<AutomovilResponse> buscarAutomovil(int id);
	/**
	 * Obtiene todos los automoviles
	 * @return listaAutomoviles
	 */
	ResponseEntity<ListaAutomovilesResponse> listarAutomoviles();
}
