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
			return "Debe de a�adir la clave del modelo del aut�movil";
		}
		if ((request.getColor().isEmpty() && request.getColor() != null) || request.getColor() == null) {
			return "Debe de a�adir el color del aut�movil";
		}
		if (request.getPrecio() == 0) {
			return "Debe de a�adir el precio al aut�movil";
		}
		
		return "";
	}

	public static String validateRequest(MarcaAutomovilRequest request) {
		if ((request.getMarca().isEmpty() && request.getMarca() != null) || request.getMarca() == null) {
			return "Debe de a�adir la marca";
		}
		return "";
	}

	public static String validateRequest(ModeloAutomovilRequest request) {
		if ((request.getModelo().isEmpty() && request.getModelo() != null) || request.getModelo() == null) {
			return "Se debe de a�adir el modelo del aut�movil";
		}
		if (request.getIdMarca() == 0) {
			return "Se debe de a�adir el id de la marca.";
		}
		return "";
	}

}
