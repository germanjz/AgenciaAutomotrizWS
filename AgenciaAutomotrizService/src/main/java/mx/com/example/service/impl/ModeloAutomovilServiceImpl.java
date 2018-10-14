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
import mx.com.example.dao.interfaces.ModeloAutomovilDao;
import mx.com.example.entity.MarcaAutomovil;
import mx.com.example.entity.ModeloAutomovil;
import mx.com.example.service.interfaces.ModeloAutomovilService;
import mx.com.example.validator.ValidatorAutomovil;
import mx.com.example.ws.request.ModeloAutomovilRequest;
import mx.com.example.ws.response.ListModelosResponse;
import mx.com.example.ws.response.ModeloAutomovilResponse;
import mx.com.example.ws.response.ObjectResponse;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

/**
 * Service Modelo Automovil
 * @author German Juarez
 *
 */
@Service("modeloAutomovilService")
@Transactional
public class ModeloAutomovilServiceImpl implements ModeloAutomovilService {
	private static final Logger LOG = LoggerFactory.getLogger(ModeloAutomovilServiceImpl.class);
	private static final String MSG_ERROR = "Error en la app: ";
	private static final String MSG_ERROR_1 = "No existe la marca. ";
	private static final String MSG_ERROR_2 = "No existe el modelo. ";
	@Autowired
	private ModeloAutomovilDao modeloAutomovilDao;
	@Autowired
	private MarcaAutomovilDao marcaAutomovilDao;
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT)
	public ResponseEntity<ModeloAutomovilResponse> insertarModelo(ModeloAutomovilRequest request) {
		ModeloAutomovilResponse response;
		ModeloAutomovil modelo;
		MarcaAutomovil marca;
		String error;
		try {
			error = ValidatorAutomovil.validateRequest(request);
			if (!error.isEmpty()) {
				response = new ModeloAutomovilResponse(1, error);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			marca = marcaAutomovilDao.find(request.getIdMarca());
			if (marca == null) {
				response = new ModeloAutomovilResponse(1, MSG_ERROR_1);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			modelo = AutomovilConverter.convert2Modelo(request, marca);
			modeloAutomovilDao.add(modelo);
			
			response = AutomovilConverter.convert2Modeloesponse(modelo);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(MSG_ERROR, e);
			response = new ModeloAutomovilResponse(9999, MSG_ERROR + e);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT)
	public ResponseEntity<ModeloAutomovilResponse> actualizarModelo(int id, ModeloAutomovilRequest request) {
		ModeloAutomovilResponse response;
		ModeloAutomovil modelo;
		MarcaAutomovil marca;
		String error;
		try {
			error = ValidatorAutomovil.validateRequest(request);
			if (!error.isEmpty()) {
				response = new ModeloAutomovilResponse(1, error);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			marca = marcaAutomovilDao.find(request.getIdMarca());
			if (marca == null) {
				response = new ModeloAutomovilResponse(1, MSG_ERROR_1);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			modelo = modeloAutomovilDao.find(id);
			if (modelo == null) {
				response = new ModeloAutomovilResponse(1, MSG_ERROR_2);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			AutomovilConverter.convert2ModeloUpdate(request, modelo, marca);
			modeloAutomovilDao.update(modelo);
			
			response = AutomovilConverter.convert2Modeloesponse(modelo);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(MSG_ERROR, e);
			response = new ModeloAutomovilResponse(9999, MSG_ERROR + e);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT)
	public ResponseEntity<ObjectResponse> eliminarModelo(final int id) {
		ObjectResponse response;
		ModeloAutomovil modelo;
		try {
			modelo = modeloAutomovilDao.find(id);
			if (modelo == null) {
				response = new ObjectResponse(1, MSG_ERROR_2);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			modeloAutomovilDao.remove(modelo);
			
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
	public ResponseEntity<ModeloAutomovilResponse> buscarModelo(final int id) {
		ModeloAutomovilResponse response;
		ModeloAutomovil modelo;
		try {
			modelo = modeloAutomovilDao.find(id);
			if (modelo == null) {
				response = new ModeloAutomovilResponse(1, MSG_ERROR_2);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			response = AutomovilConverter.convert2Modeloesponse(modelo);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(MSG_ERROR, e);
			response = new ModeloAutomovilResponse(9999, MSG_ERROR + e);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT)
	public ResponseEntity<ListModelosResponse> listarModelos() {
		ListModelosResponse response;
		List<ModeloAutomovilResponse> listaResponse;
		List<ModeloAutomovil> listaModelos;
		try {
			listaModelos = modeloAutomovilDao.getAllModelo();
			if (listaModelos.isEmpty()) {
				response = new ListModelosResponse(4, MSG_ERROR_2);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			
			listaResponse = AutomovilConverter.convert2ModeloResponse(listaModelos);
			
			response = new ListModelosResponse(listaResponse);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(MSG_ERROR, e);
			response = new ListModelosResponse(9999, MSG_ERROR + e);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
