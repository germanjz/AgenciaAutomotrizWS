package mx.com.example.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.com.example.dao.interfaces.GenericDao;

@Repository
@SuppressWarnings("unchecked")
public abstract class GenericDaoImpl<E, K extends Serializable> implements GenericDao<E, K> {
	protected Class<? extends E> persistentClass;
    
    @SuppressWarnings("rawtypes")
	public GenericDaoImpl() {
    	Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        persistentClass = (Class) pt.getActualTypeArguments()[0];
    }
     
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    @Override
	public void add(E entity) {
		getSession().save(entity);
	}

	@Override
	public void saveOrUpdate(E entity) {
		getSession().saveOrUpdate(entity);
	}

	@Override
	public void update(E entity) {
		getSession().update(entity);
	}

	@Override
	public void remove(E entity) {
		getSession().delete(entity);
	}

	@Override
	public E find(K key) {
		return (E) getSession().get(persistentClass, key);
	}

	@Override
	public List<E> getAll() {
		return getSession().createCriteria(persistentClass).list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
