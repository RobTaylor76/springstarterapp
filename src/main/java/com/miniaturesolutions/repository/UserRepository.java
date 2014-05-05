package com.miniaturesolutions.repository;

import org.springframework.stereotype.Service;

import com.miniaturesolutions.orm.Role;
import com.miniaturesolutions.orm.User;

@Service
public class UserRepository extends BaseRepository<User>{

	public UserRepository() {
		super(User.class);
	}
	
	@Override
	protected void beforePersist(User newUser) {
		for(Role role: newUser.getRoles()) {
			role.setUser(newUser); // links up child to parent...
		}	
	}
}
