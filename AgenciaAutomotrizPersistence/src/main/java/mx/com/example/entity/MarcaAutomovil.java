package mx.com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JPA Entity
 * @author German Juarez
 *
 */
@Entity
@Table(name = "marca_automovil")
public class MarcaAutomovil {
	@Id
    @Column(name = "id", nullable = false)
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	@Column(name = "marca")
	private String marca;
	
	/**
	 * 
	 */
	public MarcaAutomovil() {
		super();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Marca [id=");
		builder.append(id);
		builder.append(", marca=");
		builder.append(marca);
		builder.append("]");
	
		return builder.toString();
	}
}
