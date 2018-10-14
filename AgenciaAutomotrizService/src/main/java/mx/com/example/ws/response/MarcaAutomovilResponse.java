package mx.com.example.ws.response;

/**
 * Modelo Response
 * @author German Juarez
 *
 */
public class MarcaAutomovilResponse {
	private int id;
	private String marca;
	private int code;
	private String msgError;
	/**
	 * 
	 */
	public MarcaAutomovilResponse() {
		super();
	}
	
	/**
	 * @param id
	 * @param marca
	 */
	public MarcaAutomovilResponse(int id, String marca, int code) {
		super();
		this.id = id;
		this.marca = marca;
		this.code = 0;
		this.msgError = "Repuesta OK!";
	}

	/**
	 * @param code
	 * @param msgError
	 */
	public MarcaAutomovilResponse(int code, String msgError) {
		super();
		this.code = code;
		this.msgError = msgError;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
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
		
		builder.append("MarcaAutomovilResponse [id=");
		builder.append(id);
		builder.append(", marca=");
		builder.append(marca);
		builder.append(", code=");
		builder.append(code);
		builder.append(", msgError=");
		builder.append(msgError);
		builder.append("]");
	
		return builder.toString();
	}
}
