package mx.com.example.controller.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import mx.com.example.ws.request.AutomovilRequest;
import mx.com.example.ws.response.AutomovilResponse;
import mx.com.example.ws.response.ListaAutomovilesResponse;
import mx.com.example.ws.response.ObjectResponse;

@WebService(name = "AutomovilControllerWS", targetNamespace = "http://example.com.mx/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface AutomovilControllerWSI {
	/**
	 * 
	 * @param request
	 * @return
	 */
	@WebMethod(operationName="insertarAutomovil")
	@WebResult(name = "AutomovilResponse", targetNamespace = "http://example.com.mx/", partName = "AutomovilResponse")
	AutomovilResponse insertarAutomovil(
		@WebParam(name = "AutomovilRequest", targetNamespace = "http://example.com.mx/", partName = "AutomovilRequest")
		AutomovilRequest request);
	/**
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@WebMethod(operationName="actualizarAutomovil")
	@WebResult(name = "AutomovilResponse", targetNamespace = "http://example.com.mx/", partName = "AutomovilResponse")
	AutomovilResponse actualizarAutomovil(
		@WebParam(name = "id") int id,
		@WebParam(name = "AutomovilRequest", targetNamespace = "http://example.com.mx/", partName = "AutomovilRequest")
		AutomovilRequest request);
	/**
	 * 
	 * @param id
	 * @return
	 */
	@WebMethod(operationName="eliminarAutomovil")
	@WebResult(name = "ObjectResponse", targetNamespace = "http://example.com.mx/", partName = "ObjectResponse")
	ObjectResponse eliminarAutomovil(@WebParam(name = "id") int id);
	/**
	 * 
	 * @param id
	 * @return
	 */
	@WebMethod(operationName="buscarAutomovil")
	@WebResult(name = "AutomovilResponse", targetNamespace = "http://example.com.mx/", partName = "AutomovilResponse")
	AutomovilResponse buscarAutomovil(@WebParam(name = "id") int id);
	/**
	 * 
	 * @return
	 */
	@WebMethod(operationName="listarAutomoviles")
	@WebResult(name = "ListaAutomovilesResponse", targetNamespace = "http://example.com.mx/", partName = "ListaAutomovilesResponse")
	ListaAutomovilesResponse listarAutomoviles();
}
