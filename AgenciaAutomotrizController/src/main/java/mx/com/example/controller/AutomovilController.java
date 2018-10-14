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

import mx.com.example.service.interfaces.AutomovilService;
import mx.com.example.ws.request.AutomovilRequest;
import mx.com.example.ws.response.AutomovilResponse;
import mx.com.example.ws.response.ListaAutomovilesResponse;
import mx.com.example.ws.response.ObjectResponse;

/**
 * Automovil Controller
 * @author German Juarez
 *
 */
@RestController
@RequestMapping("/v1/agencia/automovil")
public class AutomovilController {
	private static final Logger LOG = LoggerFactory.getLogger(AutomovilController.class);
	@Autowired
	private AutomovilService automovilService;
	

	@PostMapping(value = "/add",
				 headers = "Accept=application/json",
				 consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
				 produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<AutomovilResponse> insertarAutomovil(@RequestBody AutomovilRequest request) {
		LOG.info("EndPoint: / : METHOD: POST Request: " + request);
		return automovilService.insertarAutomovil(request);
	}
	
	@PutMapping(value = "/update/{id}",
				headers = "Accept=application/json",
				consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
				produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<AutomovilResponse> actualizarAutomovil(
			@PathVariable("id") int id,
			@RequestBody AutomovilRequest request) {
		LOG.info("EndPoint: /update : METHOD: PUT : id: " + id + " Request: " + request);
		return automovilService.actualizarAutomovil(id, request);
	}
	
	@DeleteMapping(value = "/delete/{id}",
				   headers = "Accept=application/json",
				   produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ObjectResponse> eliminarAutomovil(@PathVariable("id") int id) {
		LOG.info("EndPoint: /delete : METHOD: DELETE  id: " + id);
		return automovilService.eliminarAutomovil(id);
	}
	
	@GetMapping(value = "/{id}",
				headers = "Accept=application/json",
				produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<AutomovilResponse> buscarAutomovil(@PathVariable("id") int id) {
		LOG.info("EndPoint: /buscarAlumno : METHOD: GET id: " + id);
		return automovilService.buscarAutomovil(id);
	}
	
	@GetMapping(value = "/listar",
				headers = "Accept=application/json",
				produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ListaAutomovilesResponse> listarAutomoviles() {
		LOG.info("EndPoint: /listar : METHOD: GET ");
		return automovilService.listarAutomoviles();
	}
}
