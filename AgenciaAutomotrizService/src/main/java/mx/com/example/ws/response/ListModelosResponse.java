package mx.com.example.ws.response;

import java.util.ArrayList;
import java.util.List;

public class ListModelosResponse {
	private List<ModeloAutomovilResponse> listaModelos = new ArrayList<>();
	private int code;
	private String msgError;
	
	/**
	 * 
	 */
	public ListModelosResponse() {
		super();
	}
	
	/**
	 * @param listaModelos
	 * @param code
	 * @param msgError
	 */
	public ListModelosResponse(List<ModeloAutomovilResponse> listaModelos) {
		super();
		this.listaModelos = listaModelos;
		this.code = 0;
		this.msgError = "Respuesta OK!";
	}

	/**
	 * @param code
	 * @param msgError
	 */
	public ListModelosResponse(int code, String msgError) {
		super();
		this.code = code;
		this.msgError = msgError;
	}
	
	/**
	 * @return the listaModelos
	 */
	public List<ModeloAutomovilResponse> getListaModelos() {
		return listaModelos;
	}
	/**
	 * @param listaModelos the listaModelos to set
	 */
	public void setListaModelos(List<ModeloAutomovilResponse> listaModelos) {
		this.listaModelos = listaModelos;
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
		
		builder.append("ListModelosResponse [listaModelos=");
		builder.append(listaModelos);
		builder.append(", code=");
		builder.append(code);
		builder.append(", msgError=");
		builder.append(msgError);
		builder.append("]");
	
		return builder.toString();
	}	
}
