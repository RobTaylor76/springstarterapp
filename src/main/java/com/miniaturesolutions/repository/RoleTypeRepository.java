package com.miniaturesolutions.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.miniaturesolutions.orm.RoleType;
import com.miniaturesolutions.orm.User;

@Service
public class RoleTypeRepository implements Repository<RoleType> {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public RoleType findById(Long id) {
		return em.find(RoleType.class, id);
	}

	@Override
	public List<RoleType> getAll() {
		// TODO Auto-generated method stub
		return null; // named query?  em.findAll(User.class);
	}

	@Override
	public void persist(RoleType newObject) {
		em.persist(newObject);
	}

	@Override
	public void refresh(RoleType refreshThis) {
		em.refresh(refreshThis);
	}

}
