package mx.com.example.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.example.dao.interfaces.ModeloAutomovilDao;
import mx.com.example.entity.ModeloAutomovil;

@Repository("modeloAutomovilDao")
public class ModeloAutomovilDaoImpl extends GenericDaoImpl<ModeloAutomovil, Integer> implements ModeloAutomovilDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<ModeloAutomovil> getAllModelo() {
		Criteria crit = getSession().createCriteria(ModeloAutomovil.class);
		crit.addOrder(Order.asc("id"));
		
		return crit.list();
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<ModeloAutomovil> getAllModelo(int idMarca) {
		Criteria crit = getSession().createCriteria(ModeloAutomovil.class);
		crit.add(Restrictions.eq("marca.id", idMarca));
		crit.addOrder(Order.asc("id"));
		
		return crit.list();
	}

}
