package mx.com.example.service.interfaces;

import org.springframework.http.ResponseEntity;

import mx.com.example.ws.request.ModeloAutomovilRequest;
import mx.com.example.ws.response.ListModelosResponse;
import mx.com.example.ws.response.ModeloAutomovilResponse;
import mx.com.example.ws.response.ObjectResponse;

/**
 * 
 * @author German Juarez
 *
 */
public interface ModeloAutomovilService {
	/**
	 * Inserta Modelo Automovil
	 * @param request
	 * @return automovil
	 */
	ResponseEntity<ModeloAutomovilResponse> insertarModelo(ModeloAutomovilRequest request);
	/**
	 * Actualiza un Modelo de automovil
	 * @param id
	 * @param request
	 * @return automovil
	 */
	ResponseEntity<ModeloAutomovilResponse> actualizarModelo(int id, ModeloAutomovilRequest request);
	/**
	 * Elimina un Modelo de automovil
	 * @param id
	 * @return response
	 */
	ResponseEntity<ObjectResponse> eliminarModelo(int id);
	/**
	 * Obtiene un Modelo de automovil con id
	 * @param id
	 * @return automovil
	 */
	ResponseEntity<ModeloAutomovilResponse> buscarModelo(int id);
	/**
	 * Obtiene todos los Modelos de automoviles
	 * @return listaAutomoviles
	 */
	ResponseEntity<ListModelosResponse> listarModelos();
}
