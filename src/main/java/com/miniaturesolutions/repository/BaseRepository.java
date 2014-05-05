package com.miniaturesolutions.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseRepository<T> implements Repository<T> {

	private Class<T> klass;
	
	protected BaseRepository(Class<T> klass) {
		this.klass = klass;
	}
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public T findById(Long id) {
		return em.find(klass, id);
	}

	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return null; // named query?  em.findAll(User.class);
	}

	@Override
	public void persist(T newObject) {
		beforePersist(newObject);
		em.persist(newObject);
		refresh(newObject); //refreshing will mean lookups are populated
	}

	@Override
	public void refresh(T refreshThis) {
		em.refresh(refreshThis);
	}
	
	protected void beforePersist(T newObject) {
		
	}
	
	protected void beforeUpdate(T newObject) {
		
	}
}
