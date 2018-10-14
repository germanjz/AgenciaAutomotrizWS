package mx.com.example.validator;

import mx.com.example.ws.request.AutomovilRequest;
import mx.com.example.ws.request.MarcaAutomovilRequest;
import mx.com.example.ws.request.ModeloAutomovilRequest;

/**
 * 
 * @author German Juarez
 *
 */
public class ValidatorAutomovil {

	/**
	 * 
	 */
	private ValidatorAutomovil() {
		super();
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public static String validateRequest(AutomovilRequest request) {
		if (request.getIdModelo() == 0L ) {
			return "Debe de añadir la clave del modelo del autómovil";
		}
		if ((request.getColor().isEmpty() && request.getColor() != null) || request.getColor() == null) {
			return "Debe de añadir el color del autómovil";
		}
		if (request.getPrecio() == 0) {
			return "Debe de añadir el precio al autómovil";
		}
		
		return "";
	}

	public static String validateRequest(MarcaAutomovilRequest request) {
		if ((request.getMarca().isEmpty() && request.getMarca() != null) || request.getMarca() == null) {
			return "Debe de añadir la marca";
		}
		return "";
	}

	public static String validateRequest(ModeloAutomovilRequest request) {
		if ((request.getModelo().isEmpty() && request.getModelo() != null) || request.getModelo() == null) {
			return "Se debe de añadir el modelo del autómovil";
		}
		if (request.getIdMarca() == 0) {
			return "Se debe de añadir el id de la marca.";
		}
		return "";
	}

}
