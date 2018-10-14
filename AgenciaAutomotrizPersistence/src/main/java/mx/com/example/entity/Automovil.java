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
@Table(name = "automovil")
public class Automovil {
	@Id
    @Column(name = "id", nullable = false)
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	@Column(name = "color")
	private String color;
	@Column(name = "precio")
	private Double precio;
	@JoinColumn(name = "id_modelo", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.MERGE, targetEntity = ModeloAutomovil.class)
	private ModeloAutomovil modelo;
	/**
	 * 
	 */
	public Automovil() {
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
	public ModeloAutomovil getModelo() {
		return modelo;
	}
	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(ModeloAutomovil modelo) {
		this.modelo = modelo;
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
	public Double getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Automovil [id=");
		builder.append(id);
		builder.append(", modelo=");
		builder.append(modelo);
		builder.append(", color=");
		builder.append(color);
		builder.append(", precio=");
		builder.append(precio);
		builder.append("]");
	
		return builder.toString();
	}
}
