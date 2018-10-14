package mx.com.example.controller.impl;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.example.controller.interfaces.ModeloAutomovilWSI;
import mx.com.example.service.interfaces.ModeloAutomovilService;
import mx.com.example.ws.request.ModeloAutomovilRequest;
import mx.com.example.ws.response.ListModelosResponse;
import mx.com.example.ws.response.ModeloAutomovilResponse;
import mx.com.example.ws.response.ObjectResponse;

/**
 * Marca Automovil Controller
 * @author German Juarez
 *
 */
@Component("modeloAutomovilWS")
@WebService(endpointInterface = "mx.com.example.controller.interfaces.ModeloAutomovilWSI")
public class ModeloAutomovilWS implements ModeloAutomovilWSI {
	private static final Logger LOG = LoggerFactory.getLogger(ModeloAutomovilWS.class);
	@Autowired
	private ModeloAutomovilService modeloAutomovilService;

	@Override
	public ModeloAutomovilResponse insertarModeloAutomovil(ModeloAutomovilRequest request) {
		LOG.info("EndPoint: / : METHOD: POST Request: " + request);
		return modeloAutomovilService.insertarModelo(request).getBody();
	}

	@Override
	public ModeloAutomovilResponse actualizarModeloAutomovil(int id, ModeloAutomovilRequest request) {
		LOG.info("EndPoint: /update : METHOD: PUT : id: " + id + " Request: " + request);
		return modeloAutomovilService.actualizarModelo(id, request).getBody();
	}

	@Override
	public ObjectResponse eliminarModeloAutomovil(int id) {
		LOG.info("EndPoint: /delete : METHOD: DELETE  id: " + id);
		return modeloAutomovilService.eliminarModelo(id).getBody();
	}

	@Override
	public ModeloAutomovilResponse buscarModeloAutomovil(int id) {
		LOG.info("EndPoint: /buscarAlumno : METHOD: GET id: " + id);
		return modeloAutomovilService.buscarModelo(id).getBody();
	}

	@Override
	public ListModelosResponse listarModelosAutomoviles() {
		LOG.info("EndPoint: /listar : METHOD: GET ");
		return modeloAutomovilService.listarModelos().getBody();
	}
}
