package com.miniaturesolutions.repository;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.miniaturesolutions.orm.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring-config.xml"})
@TransactionConfiguration(transactionManager="transactionManager")
@Transactional
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;
	
	@Test
	public void getUser() {
		User rob = userRepository.findById(100L);
		
		assertNotNull("should have a user",rob);
		assertEquals("r@b.com", rob.getEmail());
		
		User bob = userRepository.findById(101L);
		assertEquals("b@b.com", bob.getEmail());	
		
	}
	
	@Test
	public void addUser() {
		User newUser = new User("f@f.com");
		
		userRepository.persist(newUser);
		
		assertNotEquals("should have id > 0", 0L, newUser.getId());
		
		
		
	}
}
