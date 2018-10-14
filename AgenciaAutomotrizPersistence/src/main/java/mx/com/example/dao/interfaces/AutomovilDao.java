package mx.com.example.dao.interfaces;

import java.util.List;

import mx.com.example.entity.Automovil;

public interface AutomovilDao extends GenericDao<Automovil, Integer> {
	List<Automovil> getAllAutomovil();
}
