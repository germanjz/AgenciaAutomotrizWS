package mx.com.example.controller.impl;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.example.controller.interfaces.AutomovilControllerWSI;
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
@Component("automovilControllerWS")
@WebService(endpointInterface = "mx.com.example.controller.interfaces.AutomovilControllerWSI")
public class AutomovilControllerWS implements AutomovilControllerWSI {
	private static final Logger LOG = LoggerFactory.getLogger(AutomovilControllerWS.class);
	@Autowired
	private AutomovilService automovilService;
		
	@Override
	public AutomovilResponse insertarAutomovil(AutomovilRequest request) {
		LOG.info("EndPoint: / : METHOD: POST Request: " + request);
		return automovilService.insertarAutomovil(request).getBody();
	}
	
	@Override
	public AutomovilResponse actualizarAutomovil(int id, AutomovilRequest request) {
		LOG.info("EndPoint: /update : METHOD: PUT : id: " + id + " Request: " + request);
		return automovilService.actualizarAutomovil(id, request).getBody();
	}
	
	@Override
	public ObjectResponse eliminarAutomovil(int id) {
		LOG.info("EndPoint: /delete : METHOD: DELETE  id: " + id);
		return automovilService.eliminarAutomovil(id).getBody();
	}
	
	@Override
	public AutomovilResponse buscarAutomovil(int id) {
		LOG.info("EndPoint: /buscarAlumno : METHOD: GET id: " + id);
		return automovilService.buscarAutomovil(id).getBody();
	}
	
	@Override
	public ListaAutomovilesResponse listarAutomoviles() {
		LOG.info("EndPoint: /listar : METHOD: GET ");
		return automovilService.listarAutomoviles().getBody();
	}
	
}
