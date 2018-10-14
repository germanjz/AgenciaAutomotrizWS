package mx.com.example.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import mx.com.example.dao.interfaces.AutomovilDao;
import mx.com.example.entity.Automovil;

@Repository("automovilDao")
public class AutomovilDaoImpl extends GenericDaoImpl<Automovil, Integer> implements AutomovilDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<Automovil> getAllAutomovil() {
		Criteria crit = getSession().createCriteria(Automovil.class);
		crit.addOrder(Order.asc("id"));
		
		return crit.list();
	}

}
