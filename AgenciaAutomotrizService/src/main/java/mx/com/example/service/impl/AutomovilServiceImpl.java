package mx.com.example.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mx.com.example.converter.AutomovilConverter;
import mx.com.example.dao.interfaces.AutomovilDao;
import mx.com.example.dao.interfaces.ModeloAutomovilDao;
import mx.com.example.entity.Automovil;
import mx.com.example.entity.ModeloAutomovil;
import mx.com.example.service.interfaces.AutomovilService;
import mx.com.example.validator.ValidatorAutomovil;
import mx.com.example.ws.request.AutomovilRequest;
import mx.com.example.ws.response.AutomovilResponse;
import mx.com.example.ws.response.ListaAutomovilesResponse;
import mx.com.example.ws.response.ObjectResponse;

/**
 * Service Automovil
 * @author German Juarez
 *
 */
@Service("automovilService")
@Transactional
public class AutomovilServiceImpl implements AutomovilService {
	private static final Logger LOG = LoggerFactory.getLogger(AutomovilServiceImpl.class);
	private static final String MSG_ERROR = "Error en la app: ";
	private static final String MSG_ERROR_1 = "No se encontro el automovil";
	private static final String MSG_ERROR_2 = "No existe el modelo del automovil";
	private static final String MSG_ERROR_3 = "No se encontraron automoviles";
	
	@Autowired
	private AutomovilDao automovilDao;
	@Autowired
	private ModeloAutomovilDao modeloAutomovilDao;
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT)
	public ResponseEntity<AutomovilResponse> insertarAutomovil(AutomovilRequest request) {
		AutomovilResponse response;
		Automovil automovil;
		ModeloAutomovil modelo;
		String error;
		try {
			error = ValidatorAutomovil.validateRequest(request);
			if (!error.isEmpty()) {
				response = new AutomovilResponse(1, error);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			
			modelo = modeloAutomovilDao.find(request.getIdModelo());
			if (modelo == null) {
				response = new AutomovilResponse(2, MSG_ERROR_2);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			automovil = AutomovilConverter.convert2Automovil(request, modelo);
			automovilDao.add(automovil);
			
			response = AutomovilConverter.convert2Response(automovil);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(MSG_ERROR, e);
			response = new AutomovilResponse(9999, MSG_ERROR + e);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT)
	public ResponseEntity<AutomovilResponse> actualizarAutomovil(int id, AutomovilRequest request) {
		AutomovilResponse response;
		Automovil automovil;
		ModeloAutomovil modelo;
		String error;
		try {
			automovil = automovilDao.find(id);
			if (automovil == null) {
				response = new AutomovilResponse(3, MSG_ERROR_1);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			error = ValidatorAutomovil.validateRequest(request);
			if (!error.isEmpty()) {
				response = new AutomovilResponse(1, error);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			modelo = modeloAutomovilDao.find(request.getIdModelo());
			if (modelo == null) {
				response = new AutomovilResponse(2, MSG_ERROR_2);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			AutomovilConverter.setAutomovilUpdate(request, automovil, modelo);
			automovilDao.update(automovil);
			
			response = AutomovilConverter.convert2Response(automovil);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(MSG_ERROR, e);
			response = new AutomovilResponse(9999, MSG_ERROR + e);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT)
	public ResponseEntity<ObjectResponse> eliminarAutomovil(int id) {
		ObjectResponse response;
		Automovil automovil;
		try {
			automovil = automovilDao.find(id);
			if (automovil == null) {
				response = new ObjectResponse(3, MSG_ERROR_1);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			automovilDao.remove(automovil);
			
			response = new ObjectResponse(0, "Respuesta OK!");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(MSG_ERROR, e);
			response = new ObjectResponse(9999, MSG_ERROR + e);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT)
	public ResponseEntity<AutomovilResponse> buscarAutomovil(int id) {
		AutomovilResponse response;
		Automovil automovil;
		try {
			automovil = automovilDao.find(id);
			if (automovil == null) {
				response = new AutomovilResponse(3, MSG_ERROR_1);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			response = AutomovilConverter.convert2Response(automovil);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(MSG_ERROR, e);
			response = new AutomovilResponse(9999, MSG_ERROR + e);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT)
	public ResponseEntity<ListaAutomovilesResponse> listarAutomoviles() {
		ListaAutomovilesResponse response;
		List<AutomovilResponse> listaResponse;
		List<Automovil> listaAutomoviles;
		try {
			listaAutomoviles = automovilDao.getAllAutomovil();
			if (listaAutomoviles.isEmpty()) {
				response = new ListaAutomovilesResponse(4, MSG_ERROR_3);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			listaResponse = AutomovilConverter.convert2Response(listaAutomoviles);
			
			response = new ListaAutomovilesResponse(listaResponse);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(MSG_ERROR, e);
			response = new ListaAutomovilesResponse(9999, MSG_ERROR + e);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
