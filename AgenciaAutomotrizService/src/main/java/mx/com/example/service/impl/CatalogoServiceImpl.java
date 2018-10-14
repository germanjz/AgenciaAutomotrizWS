package mx.com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.example.dao.interfaces.MarcaAutomovilDao;
import mx.com.example.dao.interfaces.ModeloAutomovilDao;
import mx.com.example.entity.MarcaAutomovil;
import mx.com.example.entity.ModeloAutomovil;
import mx.com.example.service.interfaces.CatalogoService;
import mx.com.example.ws.response.ListMarcaResponse;
import mx.com.example.ws.response.ListModelosResponse;
import mx.com.example.ws.response.MarcaAutomovilResponse;
import mx.com.example.ws.response.ModeloAutomovilResponse;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

/**
 * Service Automovil
 * @author German Juarez
 *
 */
@Service("catalogoService")
@Transactional
public class CatalogoServiceImpl implements CatalogoService {
	private static final Logger LOG = LoggerFactory.getLogger(CatalogoServiceImpl.class);
	private static final String MSG_ERROR = "Error en la app: ";
	@Autowired
	private MarcaAutomovilDao marcaAutomovilDao;
	@Autowired
	private ModeloAutomovilDao modeloAutomovilDao;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT)
	public ResponseEntity<ListMarcaResponse> catalogoMarcas() {
		ListMarcaResponse response;
		List<MarcaAutomovil> listaMarcas;
		List<MarcaAutomovilResponse> listResponse;
		try {
			listResponse = new ArrayList<>();
			
			listaMarcas = marcaAutomovilDao.getAllMarca();
			if (listaMarcas.isEmpty()) {
				response = new ListMarcaResponse(1, "No existen elementos");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			for (MarcaAutomovil marca : listaMarcas) {
				listResponse.add(new MarcaAutomovilResponse(marca.getId(), marca.getMarca(), 0));
			}
			
			response = new ListMarcaResponse(listResponse);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(MSG_ERROR, e);
			response = new ListMarcaResponse(9999, MSG_ERROR + e);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT)
	public ResponseEntity<ListModelosResponse> catalogoModelos(int idMarca) {
		ListModelosResponse response;
		List<ModeloAutomovil> listaModelos;
		List<ModeloAutomovilResponse> listResponse;
		try {
			listResponse = new ArrayList<>();

			listaModelos = modeloAutomovilDao.getAllModelo(idMarca);
			if (listaModelos.isEmpty()) {
				response = new ListModelosResponse(1, "No existen elementos");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			for (ModeloAutomovil modelo : listaModelos) {
				MarcaAutomovilResponse marca = new MarcaAutomovilResponse(modelo.getMarca().getId(), modelo.getMarca().getMarca(), 0);
				listResponse.add(new ModeloAutomovilResponse(modelo.getId(), modelo.getModelo(), modelo.getAnio(), marca));
			}
			
			response = new ListModelosResponse(listResponse);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(MSG_ERROR, e);
			response = new ListModelosResponse(9999, MSG_ERROR + e);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
