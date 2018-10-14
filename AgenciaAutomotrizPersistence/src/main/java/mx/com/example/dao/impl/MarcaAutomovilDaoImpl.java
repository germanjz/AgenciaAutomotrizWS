package mx.com.example.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import mx.com.example.dao.interfaces.MarcaAutomovilDao;
import mx.com.example.entity.MarcaAutomovil;

@Repository("marcaAutomovilDao")
public class MarcaAutomovilDaoImpl extends GenericDaoImpl<MarcaAutomovil, Integer> implements MarcaAutomovilDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<MarcaAutomovil> getAllMarca() {
		Criteria crit = getSession().createCriteria(MarcaAutomovil.class);
		crit.addOrder(Order.asc("id"));
		
		return crit.list();
	}

}
