package com.miniaturesolutions.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.miniaturesolutions.orm.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring-config.xml"})
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
}
