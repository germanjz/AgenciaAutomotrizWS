package mx.com.example.ws.request;

/**
 * 
 * @author German Juarez
 *
 */
public class ModeloAutomovilRequest {
	private int idMarca;
	private String modelo;
	private String anio;
	/**
	 * @return the idMarca
	 */
	public int getIdMarca() {
		return idMarca;
	}
	/**
	 * @param idMarca the idMarca to set
	 */
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
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
		
		builder.append("ModeloAutomovilRequest [idMarca=");
		builder.append(idMarca);
		builder.append(", modelo=");
		builder.append(modelo);
		builder.append(", anio=");
		builder.append(anio);
		builder.append("]");
	
		return builder.toString();
	}
}
