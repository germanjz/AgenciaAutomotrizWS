package mx.com.example.controller.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import mx.com.example.ws.response.ListMarcaResponse;
import mx.com.example.ws.response.ListModelosResponse;

@WebService(name = "CatalogoControllerWS", targetNamespace = "http://example.com.mx/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface CatalogoControllerWSI {
	/**
	 * 
	 * @param idMarca
	 * @return
	 */
	@WebMethod(operationName="catalogoModelos")
	@WebResult(name = "ListModelosResponse", targetNamespace = "http://example.com.mx/", partName = "ListModelosResponse")
	public ListModelosResponse catalogoModelos(@WebParam(name = "idMarca") int idMarca);
	/**
	 * 
	 * @param idMarca
	 * @return
	 */
	@WebMethod(operationName="catalogoMarcas")
	@WebResult(name = "ListMarcaResponse", targetNamespace = "http://example.com.mx/", partName = "ListMarcaResponse")
	ListMarcaResponse catalogoMarcas();
}
