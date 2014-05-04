package com.miniaturesolutions.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.miniaturesolutions.orm.User;

@Service
public class UserRepository implements Repository<User> {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User findById(Long id) {
		return em.find(User.class, id);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null; // named query?  em.findAll(User.class);
	}

	@Override
	public void persist(User newObject) {
		em.persist(newObject);
	}

}
