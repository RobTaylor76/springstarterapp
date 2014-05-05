package com.miniaturesolutions.facade;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.miniaturesolutions.model.UserModel;
import com.miniaturesolutions.orm.User;
import com.miniaturesolutions.repository.UserRepository;

@Component
public class UserFacade {
	@Autowired
	UserRepository userRepository;
	
	public UserModel create(UserModel user) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		User userEntity = modelMapper.map(user, User.class);
				
		userRepository.persist(userEntity);
		
		UserModel saved = modelMapper.map(userEntity, UserModel.class);
		return saved;
	}

	public UserModel findById(Long id) {
		ModelMapper modelMapper = new ModelMapper();
		User userEntity = userRepository.findById(id);
		UserModel saved = modelMapper.map(userEntity, UserModel.class);
		return saved;
	}

}
