package mx.com.example.ws.request;

/**
 * 
 * @author German Juarez
 *
 */
public class MarcaAutomovilRequest {
	private String marca;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("MarcaAutomovilRequest [marca=");
		builder.append(marca);
		builder.append("]");
	
		return builder.toString();
	}
}
