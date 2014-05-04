package com.miniaturesolutions.repository;

import java.util.List;

public interface Repository<T> {

	T findById(Long id);
	List<T> getAll();
	
	void persist(T newObject);
	
}
