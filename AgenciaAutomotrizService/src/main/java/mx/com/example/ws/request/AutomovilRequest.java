package mx.com.example.ws.request;

/**
 * Request class
 * @author German Juarez
 *
 */
public class AutomovilRequest {
	private int idModelo;
	private String color;
	private double precio;
		
	/**
	 * 
	 */
	public AutomovilRequest() {
		super();
	}

	/**
	 * 
	 * @param modelo
	 * @param color
	 * @param anio
	 * @param precio
	 */
	public AutomovilRequest(int idModelo, String color, double precio) {
		super();
		this.idModelo = idModelo;
		this.color = color;
		this.precio = precio;
	}

	
	/**
	 * @return the idModelo
	 */
	public int getIdModelo() {
		return idModelo;
	}

	/**
	 * @param idModelo the idModelo to set
	 */
	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("AutomovilRequest [idModelo=");
		builder.append(idModelo);
		builder.append(", color=");
		builder.append(color);
		builder.append(", precio=");
		builder.append(precio);
		builder.append("]");
		
		return builder.toString();
	}
}
