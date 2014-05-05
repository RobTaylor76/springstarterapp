package com.miniaturesolutions.repository;

import org.springframework.stereotype.Service;

import com.miniaturesolutions.orm.User;

@Service
public class UserRepository extends BaseRepository<User>{

	public UserRepository() {
		super(User.class);
	}

}
