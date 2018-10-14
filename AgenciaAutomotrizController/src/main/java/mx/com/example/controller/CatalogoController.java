package mx.com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.example.service.interfaces.CatalogoService;
import mx.com.example.ws.response.ListMarcaResponse;
import mx.com.example.ws.response.ListModelosResponse;

/**
 * Automovil Controller
 * @author German Juarez
 *
 */
@RestController
@RequestMapping("/v1/agencia/catalogos")
public class CatalogoController {
	private static final Logger LOG = LoggerFactory.getLogger(CatalogoController.class);
	@Autowired
	private CatalogoService catalogoService;
	
	@GetMapping(value = "/catalogoModelos/{idMarca}",
				headers = "Accept=application/json",
				produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ListModelosResponse> catalogoModelos(@PathVariable("idMarca") int idMarca) {
		LOG.info("EndPoint: /catalogoModelos : METHOD: GET id: " + idMarca);
		return catalogoService.catalogoModelos(idMarca);
	}
	
	@GetMapping(value = "/catalogoMarcas",
				headers = "Accept=application/json",
				produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ListMarcaResponse> catalogoMarcas() {
		LOG.info("EndPoint : METHOD: GET id: ");
		return catalogoService.catalogoMarcas();
	}
}
