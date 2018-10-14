package mx.com.example.controller.impl;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.example.controller.interfaces.MarcaAutomovilWSI;
import mx.com.example.service.interfaces.MarcaAutomovilService;
import mx.com.example.ws.request.MarcaAutomovilRequest;
import mx.com.example.ws.response.ListMarcaResponse;
import mx.com.example.ws.response.MarcaAutomovilResponse;
import mx.com.example.ws.response.ObjectResponse;

/**
 * Marca Automovil Controller
 * @author German Juarez
 *
 */
@Component("marcaAutomovilWS")
@WebService(endpointInterface = "mx.com.example.controller.interfaces.MarcaAutomovilWSI")
public class MarcaAutomovilWS implements MarcaAutomovilWSI {
	private static final Logger LOG = LoggerFactory.getLogger(MarcaAutomovilWS.class);
	@Autowired
	private MarcaAutomovilService marcaAutomovilService;
	
	@Override
	public MarcaAutomovilResponse insertarMarcaAutomovil(MarcaAutomovilRequest request) {
		LOG.info("EndPoint: / : METHOD: POST Request: " + request);
		return marcaAutomovilService.insertarMarca(request).getBody();
	}

	@Override
	public MarcaAutomovilResponse actualizarMarcaAutomovil(int id, MarcaAutomovilRequest request) {
		LOG.info("EndPoint: /update : METHOD: PUT : id: " + id + " Request: " + request);
		return marcaAutomovilService.actualizarMarca(id, request).getBody();
	}

	@Override
	public ObjectResponse eliminarMarcaAutomovil(int id) {
		LOG.info("EndPoint: /delete : METHOD: DELETE  id: " + id);
		return marcaAutomovilService.eliminarMarca(id).getBody();
	}

	@Override
	public MarcaAutomovilResponse buscarMarcaAutomovil(int id) {
		LOG.info("EndPoint: /buscarAlumno : METHOD: GET id: " + id);
		return marcaAutomovilService.buscarMarca(id).getBody();
	}

	@Override
	public ListMarcaResponse listarMarcasAutomoviles() {
		LOG.info("EndPoint: /listar : METHOD: GET ");
		return marcaAutomovilService.listarMarcas().getBody();
	}

}
