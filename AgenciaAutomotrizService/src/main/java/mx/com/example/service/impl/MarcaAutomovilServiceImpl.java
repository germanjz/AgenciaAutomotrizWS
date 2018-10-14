package mx.com.example.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.example.converter.AutomovilConverter;
import mx.com.example.dao.interfaces.MarcaAutomovilDao;
import mx.com.example.entity.MarcaAutomovil;
import mx.com.example.service.interfaces.MarcaAutomovilService;
import mx.com.example.validator.ValidatorAutomovil;
import mx.com.example.ws.request.MarcaAutomovilRequest;
import mx.com.example.ws.response.ListMarcaResponse;
import mx.com.example.ws.response.MarcaAutomovilResponse;
import mx.com.example.ws.response.ObjectResponse;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

/**
 * Service Marca Automovil
 * @author German Juarez
 *
 */
@Service("marcaAutomovilService")
@Transactional
public class MarcaAutomovilServiceImpl implements MarcaAutomovilService {
	private static final Logger LOG = LoggerFactory.getLogger(MarcaAutomovilServiceImpl.class);
	private static final String MSG_ERROR = "Error en la app: ";
	private static final String MSG_ERROR_1 = "No existe la marca. ";
	private static final String MSG_ERROR_2 = "No existen registros de marcas. ";
	@Autowired
	private MarcaAutomovilDao marcaAutomovilDao;
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT)
	public ResponseEntity<MarcaAutomovilResponse> insertarMarca(MarcaAutomovilRequest request) {
		MarcaAutomovilResponse response;
		MarcaAutomovil marca;
		String error;
		try {
			error = ValidatorAutomovil.validateRequest(request);
			if (!error.isEmpty()) {
				response = new MarcaAutomovilResponse(1, error);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			marca = AutomovilConverter.convert2Marca(request);
			marcaAutomovilDao.add(marca);
			
			response = AutomovilConverter.convert2MarcaResponse(marca);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(MSG_ERROR, e);
			response = new MarcaAutomovilResponse(9999, MSG_ERROR + e);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT)
	public ResponseEntity<MarcaAutomovilResponse> actualizarMarca(int id, MarcaAutomovilRequest request) {
		MarcaAutomovilResponse response;
		MarcaAutomovil marca;
		String error;
		try {
			error = ValidatorAutomovil.validateRequest(request);
			if (!error.isEmpty()) {
				response = new MarcaAutomovilResponse(1, error);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			marca = marcaAutomovilDao.find(id);
			if (marca == null) {
				response = new MarcaAutomovilResponse(1, MSG_ERROR_1);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			marca.setMarca(request.getMarca());
			marcaAutomovilDao.update(marca);
			
			response = AutomovilConverter.convert2MarcaResponse(marca);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(MSG_ERROR, e);
			response = new MarcaAutomovilResponse(9999, MSG_ERROR + e);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT)
	public ResponseEntity<ObjectResponse> eliminarMarca(int id) {
		ObjectResponse response;
		MarcaAutomovil marca;
		try {
			marca = marcaAutomovilDao.find(id);
			if (marca == null) {
				response = new ObjectResponse(3, MSG_ERROR_1);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			marcaAutomovilDao.remove(marca);
			
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
	public ResponseEntity<MarcaAutomovilResponse> buscarMarca(int id) {
		MarcaAutomovilResponse response;
		MarcaAutomovil marca;
		try {
			marca = marcaAutomovilDao.find(id);
			if (marca == null) {
				response = new MarcaAutomovilResponse(3, MSG_ERROR_1);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			response = AutomovilConverter.convert2MarcaResponse(marca);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(MSG_ERROR, e);
			response = new MarcaAutomovilResponse(9999, MSG_ERROR + e);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT)
	public ResponseEntity<ListMarcaResponse> listarMarcas() {
		ListMarcaResponse response;
		List<MarcaAutomovilResponse> listaResponse;
		List<MarcaAutomovil> listaMarcas;
		try {
			listaMarcas = marcaAutomovilDao.getAllMarca();
			if (listaMarcas.isEmpty()) {
				response = new ListMarcaResponse(4, MSG_ERROR_2);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			listaResponse = AutomovilConverter.convert2MarcaResponse(listaMarcas);
			
			response = new ListMarcaResponse(listaResponse);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(MSG_ERROR, e);
			response = new ListMarcaResponse(9999, MSG_ERROR + e);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
