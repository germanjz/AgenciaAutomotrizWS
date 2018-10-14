package mx.com.example.controller.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import mx.com.example.ws.request.MarcaAutomovilRequest;
import mx.com.example.ws.response.ListMarcaResponse;
import mx.com.example.ws.response.MarcaAutomovilResponse;
import mx.com.example.ws.response.ObjectResponse;

/**
 * 
 * @author germanjz
 *
 */
@WebService(name = "MarcaAutomovilWS", targetNamespace = "http://example.com.mx/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface MarcaAutomovilWSI {
	/**
	 * 
	 * @param request
	 * @return
	 */
	@WebMethod(operationName="insertarMarcaAutomovil")
	@WebResult(name = "MarcaAutomovilResponse", targetNamespace = "http://example.com.mx/", partName = "MarcaAutomovilResponse")
	MarcaAutomovilResponse insertarMarcaAutomovil(
		@WebParam(name = "MarcaAutomovilRequest", targetNamespace = "http://example.com.mx/", partName = "MarcaAutomovilRequest")
		MarcaAutomovilRequest request);
	/**
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@WebMethod(operationName="actualizarMarcaAutomovil")
	@WebResult(name = "MarcaAutomovilResponse", targetNamespace = "http://example.com.mx/", partName = "MarcaAutomovilResponse")
	MarcaAutomovilResponse actualizarMarcaAutomovil(
		@WebParam(name = "id") int id,
		@WebParam(name = "MarcaAutomovilRequest", targetNamespace = "http://example.com.mx/", partName = "MarcaAutomovilRequest")
		MarcaAutomovilRequest request);
	/**
	 * 
	 * @param id
	 * @return
	 */
	@WebMethod(operationName="eliminarMarcaAutomovil")
	@WebResult(name = "ObjectResponse", targetNamespace = "http://example.com.mx/", partName = "ObjectResponse")
	ObjectResponse eliminarMarcaAutomovil(@WebParam(name = "id") int id);
	/**
	 * 
	 * @param id
	 * @return
	 */
	@WebMethod(operationName="buscarMarcaAutomovil")
	@WebResult(name = "MarcaAutomovilResponse", targetNamespace = "http://example.com.mx/", partName = "AutomovilResponse")
	MarcaAutomovilResponse buscarMarcaAutomovil(@WebParam(name = "id") int id);
	/**
	 * 
	 * @return
	 */
	@WebMethod(operationName="listarMarcasAutomoviles")
	@WebResult(name = "ListMarcaResponse", targetNamespace = "http://example.com.mx/", partName = "ListMarcaResponse")
	ListMarcaResponse listarMarcasAutomoviles();
}
