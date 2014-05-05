package com.miniaturesolutions.repository;

import org.springframework.stereotype.Service;

import com.miniaturesolutions.orm.RoleType;

@Service
public class RoleTypeRepository extends BaseRepository<RoleType> {

	public RoleTypeRepository() {
		super(RoleType.class);
	}
}
