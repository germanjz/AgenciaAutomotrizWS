package mx.com.example.controller.impl;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.example.controller.interfaces.CatalogoControllerWSI;
import mx.com.example.service.interfaces.CatalogoService;
import mx.com.example.ws.response.ListMarcaResponse;
import mx.com.example.ws.response.ListModelosResponse;

/**
 * Automovil Controller
 * @author German Juarez
 *
 */
@Component("catalogoControllerWS")
@WebService(endpointInterface = "mx.com.example.controller.interfaces.CatalogoControllerWSI")
public class CatalogoControllerWS implements CatalogoControllerWSI {
	private static final Logger LOG = LoggerFactory.getLogger(CatalogoControllerWS.class);
	@Autowired
	CatalogoService catalogoService;
	
	@Override
	public ListModelosResponse catalogoModelos(int idMarca) {
		LOG.info("EndPoint: /catalogoModelos : METHOD: GET id: " + idMarca);
		return catalogoService.catalogoModelos(idMarca).getBody();
	}
	
	@Override
	public ListMarcaResponse catalogoMarcas() {
		try {
			LOG.info("EndPoint : METHOD: GET id: ");
			return catalogoService.catalogoMarcas().getBody();
		} catch (Exception e) {
			System.out.println("ERROR controller");
			e.printStackTrace();
			return new ListMarcaResponse(9999, e.getMessage());
		}
	}
}
