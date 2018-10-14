package mx.com.example.ws.response;

import java.util.ArrayList;
import java.util.List;

public class ListMarcaResponse {
	private List<MarcaAutomovilResponse> listaMarcas = new ArrayList<>();
	private int code;
	private String msgError;
	/**
	 * 
	 */
	public ListMarcaResponse() {
		super();
	}
	
	/**
	 * @param listaMarcas
	 * @param code
	 * @param msgError
	 */
	public ListMarcaResponse(List<MarcaAutomovilResponse> listaMarcas) {
		super();
		this.listaMarcas = listaMarcas;
		this.code = 0;
		this.msgError = "Respuesta OK!";
	}

	/**
	 * @param code
	 * @param msgError
	 */
	public ListMarcaResponse(int code, String msgError) {
		super();
		this.code = code;
		this.msgError = msgError;
	}

	/**
	 * @return the listaMarcas
	 */
	public List<MarcaAutomovilResponse> getListaMarcas() {
		return listaMarcas;
	}
	/**
	 * @param listaMarcas the listaMarcas to set
	 */
	public void setListaMarcas(List<MarcaAutomovilResponse> listaMarcas) {
		this.listaMarcas = listaMarcas;
	}
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * @return the msgError
	 */
	public String getMsgError() {
		return msgError;
	}
	/**
	 * @param msgError the msgError to set
	 */
	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("ListMarcaResponse [listaMarcas=");
		builder.append(listaMarcas);
		builder.append(", code=");
		builder.append(code);
		builder.append(", msgError=");
		builder.append(msgError);
		builder.append("]");
	
		return builder.toString();
	}
}
