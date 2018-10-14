package mx.com.example.controller.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import mx.com.example.ws.request.ModeloAutomovilRequest;
import mx.com.example.ws.response.ListModelosResponse;
import mx.com.example.ws.response.ModeloAutomovilResponse;
import mx.com.example.ws.response.ObjectResponse;

/**
 * 
 * @author germanjz
 *
 */
@WebService(name = "ModeloAutomovilWS", targetNamespace = "http://example.com.mx/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface ModeloAutomovilWSI {
	/**
	 * 
	 * @param request
	 * @return
	 */
	@WebMethod(operationName="insertarModeloAutomovil")
	@WebResult(name = "ModeloAutomovilResponse", targetNamespace = "http://example.com.mx/", partName = "ModeloAutomovilResponse")
	ModeloAutomovilResponse insertarModeloAutomovil(
		@WebParam(name = "ModeloAutomovilRequest", targetNamespace = "http://example.com.mx/", partName = "ModeloAutomovilRequest")
		ModeloAutomovilRequest request);
	/**
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@WebMethod(operationName="actualizarModeloAutomovil")
	@WebResult(name = "ModeloAutomovilResponse", targetNamespace = "http://example.com.mx/", partName = "ModeloAutomovilResponse")
	ModeloAutomovilResponse actualizarModeloAutomovil(
		@WebParam(name = "id") int id,
		@WebParam(name = "ModeloAutomovilRequest", targetNamespace = "http://example.com.mx/", partName = "ModeloAutomovilRequest")
		ModeloAutomovilRequest request);
	/**
	 * 
	 * @param id
	 * @return
	 */
	@WebMethod(operationName="eliminarModeloAutomovil")
	@WebResult(name = "ObjectResponse", targetNamespace = "http://example.com.mx/", partName = "ObjectResponse")
	ObjectResponse eliminarModeloAutomovil(@WebParam(name = "id") int id);
	/**
	 * 
	 * @param id
	 * @return
	 */
	@WebMethod(operationName="buscarModeloAutomovil")
	@WebResult(name = "ModeloAutomovilResponse", targetNamespace = "http://example.com.mx/", partName = "AutomovilResponse")
	ModeloAutomovilResponse buscarModeloAutomovil(@WebParam(name = "id") int id);
	/**
	 * 
	 * @return
	 */
	@WebMethod(operationName="listarModelosAutomoviles")
	@WebResult(name = "ListModeloResponse", targetNamespace = "http://example.com.mx/", partName = "ListModeloResponse")
	ListModelosResponse listarModelosAutomoviles();
}
