package mx.com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * JPA Entity
 * @author German Juarez
 *
 */
@Entity
@Table(name = "modelo_automovil")
public class ModeloAutomovil {
	@Id
    @Column(name = "id", nullable = false)
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	@Column(name = "modelo")
	private String modelo;
	@Column(name = "anio")
	private String anio;
	@JoinColumn(name = "id_marca", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.MERGE, targetEntity = MarcaAutomovil.class)
	private MarcaAutomovil marca;
	/**
	 * 
	 */
	public ModeloAutomovil() {
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
	/**
	 * @return the marca
	 */
	public MarcaAutomovil getMarca() {
		return marca;
	}
	/**
	 * @param marca the marca to set
	 */
	public void setMarca(MarcaAutomovil marca) {
		this.marca = marca;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Modelo [id=");
		builder.append(id);
		builder.append(", modelo=");
		builder.append(modelo);
		builder.append(", anio=");
		builder.append(anio);
		builder.append(", marca=");
		builder.append(marca);
		builder.append("]");
	
		return builder.toString();
	}
}
