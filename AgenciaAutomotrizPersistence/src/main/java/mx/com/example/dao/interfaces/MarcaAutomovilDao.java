package mx.com.example.dao.interfaces;

import java.util.List;

import mx.com.example.entity.MarcaAutomovil;

public interface MarcaAutomovilDao extends GenericDao<MarcaAutomovil, Integer> {
	/**
	 * 
	 * @return
	 */
	List<MarcaAutomovil> getAllMarca();
}
