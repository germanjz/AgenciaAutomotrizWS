package mx.com.example.dao.interfaces;

import java.util.List;

import mx.com.example.entity.ModeloAutomovil;

public interface ModeloAutomovilDao extends GenericDao<ModeloAutomovil, Integer> {
	/**
	 * 
	 * @return
	 */
	List<ModeloAutomovil> getAllModelo();
	/**
	 * 
	 * @param idMarca
	 * @return
	 */
	List<ModeloAutomovil> getAllModelo(int idMarca);
}
