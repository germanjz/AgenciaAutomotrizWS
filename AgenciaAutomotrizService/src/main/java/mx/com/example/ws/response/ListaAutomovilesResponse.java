package mx.com.example.ws.response;

import java.util.ArrayList;
import java.util.List;

/**
 * WS Response
 * @author German Juarez
 *
 */
public class ListaAutomovilesResponse {
	private List<AutomovilResponse> listaAutomoviles = new ArrayList<>();
	private int code;
	private String msgError;
	
	/**
	 * 
	 */
	public ListaAutomovilesResponse() {
		super();
	}
	
	/**
	 * @param listaAutomoviles
	 * @param code
	 * @param msgError
	 */
	public ListaAutomovilesResponse(List<AutomovilResponse> listaAutomoviles) {
		super();
		this.listaAutomoviles = listaAutomoviles;
		this.code = 0;
		this.msgError = "Respuesta OK!";
	}
	
	/**
	 * @param code
	 * @param msgError
	 */
	public ListaAutomovilesResponse(int code, String msgError) {
		super();
		this.code = code;
		this.msgError = msgError;
	}
	
	/**
	 * @return the listaAutomoviles
	 */
	public List<AutomovilResponse> getListaAutomoviles() {
		return listaAutomoviles;
	}
	/**
	 * @param listaAutomoviles the listaAutomoviles to set
	 */
	public void setListaAutomoviles(List<AutomovilResponse> listaAutomoviles) {
		this.listaAutomoviles = listaAutomoviles;
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
		
		builder.append("ListaAutomovilesResponse [listaAutomoviles=");
		builder.append(listaAutomoviles);
		builder.append(", code=");
		builder.append(code);
		builder.append(", msgError=");
		builder.append(msgError);
		builder.append("]");
	
		return builder.toString();
	}
}
