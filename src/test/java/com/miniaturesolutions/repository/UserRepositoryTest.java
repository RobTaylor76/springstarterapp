package com.miniaturesolutions.repository;

import static org.junit.Assert.*;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.miniaturesolutions.orm.Role;
import com.miniaturesolutions.orm.RoleType;
import com.miniaturesolutions.orm.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring-config.xml"})
@TransactionConfiguration(transactionManager="transactionManager")
@Transactional
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleTypeRepository roleTypeRepository;	
	@Test
	public void getUser() {
		User rob = userRepository.findById(100L);
		
		assertNotNull("should have a user",rob);
		assertEquals("r@b.com", rob.getEmail());
		
		assertTrue("should have  1 role", rob.getRoles().size() == 1);
		
		
		User bob = userRepository.findById(101L);
		assertEquals("b@b.com", bob.getEmail());	
		
	}
	
	@Test
	public void addUser() {
		User newUser = new User("f@f.com");
		//RoleType loadedType1 = roleTypeRepository.findById(100L);		
		Role newRole = new Role();
		
		Collection<Role> roles = newUser.getRoles();
		
		newRole.setUser(newUser);
		newRole.setName("role1");
		
		RoleType type = new RoleType();
		type.setId(100L);
		
		newRole.setRoleType(type);
	
		roles.add(newRole);
		
		userRepository.persist(newUser);
		
		assertNotEquals("should have id > 0", 0L, newUser.getId());		
		
		//RoleType loadedType2 = roleTypeRepository.findById(100L);


		
		for(Role role: newUser.getRoles()) {
			assertNotEquals("should have id > 0", 0L, role.getId());
			
			RoleType roleType = role.getRoleType();
			assertNotEquals("should have id > 0", 0L, roleType.getId());
			assertNotNull("should have name populated from db", roleType.getName());			
			
			
		}
		
		//userRepository.refresh(newUser);

	}
}
