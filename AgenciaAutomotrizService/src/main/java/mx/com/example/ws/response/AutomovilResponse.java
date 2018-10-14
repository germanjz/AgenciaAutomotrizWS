package mx.com.example.ws.response;

/**
 * Response class
 * 
 * @author German Juarez
 *
 */
public class AutomovilResponse {
	private int id;
	private int idMarca;
	private String marca;
	private int idModelo;
	private String modelo;
	private String color;
	private String anio;
	private double precio;
	private int code;
	private String msgError;

	/**
	 * 
	 */
	public AutomovilResponse() {
		super();
	}

	/**
	 * @param code
	 * @param msgError
	 */
	public AutomovilResponse(int code, String msgError) {
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
	 * @param id
	 *            the id to set
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
	 * @param marca
	 *            the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo
	 *            the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the anio
	 */
	public String getAnio() {
		return anio;
	}

	/**
	 * @param anio
	 *            the anio to set
	 */
	public void setAnio(String anio) {
		this.anio = anio;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio
	 *            the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
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
	 * @param msgError
	 *            the msgError to set
	 */
	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}

	/**
	 * @return the idMarca
	 */
	public int getIdMarca() {
		return idMarca;
	}

	/**
	 * @param idMarca
	 *            the idMarca to set
	 */
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	/**
	 * @return the idModelo
	 */
	public int getIdModelo() {
		return idModelo;
	}

	/**
	 * @param idModelo
	 *            the idModelo to set
	 */
	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("AutomovilResponse [id=");
		builder.append(id);
		builder.append(", idMarca=");
		builder.append(idMarca);
		builder.append(", marca=");
		builder.append(marca);
		builder.append(", idModelo=");
		builder.append(idModelo);
		builder.append(", modelo=");
		builder.append(modelo);
		builder.append(", color=");
		builder.append(color);
		builder.append(", anio=");
		builder.append(anio);
		builder.append(", precio=");
		builder.append(precio);
		builder.append(", code=");
		builder.append(code);
		builder.append(", msgError=");
		builder.append(msgError);
		builder.append("]");
	
		return builder.toString();
	}
}
