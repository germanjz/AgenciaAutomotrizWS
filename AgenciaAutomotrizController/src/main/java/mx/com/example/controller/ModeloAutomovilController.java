package mx.com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.example.service.interfaces.ModeloAutomovilService;
import mx.com.example.ws.request.ModeloAutomovilRequest;
import mx.com.example.ws.response.ListModelosResponse;
import mx.com.example.ws.response.ModeloAutomovilResponse;
import mx.com.example.ws.response.ObjectResponse;

/**
 * Automovil Controller
 * @author German Juarez
 *
 */
@RestController
@RequestMapping("/v1/agencia/automovil/modelo")
public class ModeloAutomovilController {
	private static final Logger LOG = LoggerFactory.getLogger(ModeloAutomovilController.class);
	@Autowired
	private ModeloAutomovilService modeloAutomovilService;
	
	@PostMapping(value = "/add",
		 	 	 headers = "Accept=application/json",
				 consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
				 produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ModeloAutomovilResponse> insertarModeloAutomovil(@RequestBody ModeloAutomovilRequest request) {
		LOG.info("EndPoint: / : METHOD: POST Request: " + request);
		return modeloAutomovilService.insertarModelo(request);
	}
	
	@PutMapping(value = "/update/{id}",
				headers = "Accept=application/json",
				consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
				produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ModeloAutomovilResponse> actualizarModeloAutomovil(
			@PathVariable("id") int id,
			@RequestBody ModeloAutomovilRequest request) {
		LOG.info("EndPoint: /update : METHOD: PUT : id: " + id + " Request: " + request);
		return modeloAutomovilService.actualizarModelo(id, request);
	}
	
	@DeleteMapping(value = "/delete/{id}",
				   headers = "Accept=application/json",
				   produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ObjectResponse> eliminarModeloAutomovil(@PathVariable("id") int id) {
		LOG.info("EndPoint: /delete : METHOD: DELETE  id: " + id);
		return modeloAutomovilService.eliminarModelo(id);
	}
	
	@GetMapping(value = "/{id}",
				headers = "Accept=application/json",
				produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ModeloAutomovilResponse> buscarModeloAutomovil(@PathVariable("id") int id) {
		LOG.info("EndPoint: /buscarAlumno : METHOD: GET id: " + id);
		return modeloAutomovilService.buscarModelo(id);
	}
	
	@GetMapping(value = "/listar",
				headers = "Accept=application/json",
				produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ListModelosResponse> listarModelosAutomoviles() {
		LOG.info("EndPoint: /listar : METHOD: GET ");
		return modeloAutomovilService.listarModelos();
	}
}
