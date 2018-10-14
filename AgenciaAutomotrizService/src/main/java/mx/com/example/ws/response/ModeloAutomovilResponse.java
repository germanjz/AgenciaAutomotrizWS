package mx.com.example.ws.response;

/**
 * Marca Response
 * @author German Juarez
 *
 */
public class ModeloAutomovilResponse {
	private int id;
	private MarcaAutomovilResponse marca;
	private String modelo;
	private String anio;
	private int code;
	private String msgError;
	/**
	 * 
	 */
	public ModeloAutomovilResponse() {
		super();
	}
	
	/**
	 * @param id
	 * @param modelo
	 */
	public ModeloAutomovilResponse(int id, String modelo, String anio, MarcaAutomovilResponse marca) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.anio = anio;
		this.marca = marca;
		this.code = 0;
		this.msgError = "Respuesta OK!";
	}

	/**
	 * @param code
	 * @param msgError
	 */
	public ModeloAutomovilResponse(int code, String msgError) {
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
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the marca
	 */
	public MarcaAutomovilResponse getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(MarcaAutomovilResponse marca) {
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

	/**
	 * @return the anio
	 */
	public String getAnio() {
		return anio;
	}

	/**
	 * @param anio the anio to set
	 */
	public void setAnio(String anio) {
		this.anio = anio;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("ModeloAutomovilResponse [id=");
		builder.append(id);
		builder.append(", marca=");
		builder.append(marca);
		builder.append(", modelo=");
		builder.append(modelo);
		builder.append(", anio=");
		builder.append(anio);
		builder.append(", code=");
		builder.append(code);
		builder.append(", msgError=");
		builder.append(msgError);
		builder.append("]");
	
		return builder.toString();
	}
}
