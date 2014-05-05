package com.miniaturesolutions.facade;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.miniaturesolutions.model.RoleModel;
import com.miniaturesolutions.model.RoleTypeModel;
import com.miniaturesolutions.model.UserModel;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring-config.xml"})
@TransactionConfiguration(transactionManager="transactionManager")
@Transactional
public class UserFacadeTest {

	@Autowired
	private UserFacade userFacade;
	
	@Test
	public void testCreate() {
		UserModel user = new UserModel();
		user.setEmail("m@m.com");
		
		RoleModel role = new RoleModel();
	//	role.setUser(user); // this wont be done by form binding...
		role.setName("name1");
		
		RoleTypeModel type = new RoleTypeModel();
		type.setId(101L);
		role.setRoleType(type);
		
		user.getRoles().add(role);
		
		UserModel saved = userFacade.create(user);
		
		assertNotEquals("should have id > 0", 0L, saved.getId());	
		
		for(RoleModel savedRole: saved.getRoles()) {
			assertNotEquals("should have id > 0", 0L, savedRole.getId());
			
			RoleTypeModel roleType = savedRole.getRoleType();
			assertNotEquals("should have id > 0", 0L, roleType.getId());
			assertNotNull("should have name populated from db", roleType.getName());			
		}
		
	}
	
	@Test
	public void findById() {
		UserModel saved = userFacade.findById(100L);
		assertNotEquals("should have id > 0", 0L, saved.getId());	
		
		for(RoleModel savedRole: saved.getRoles()) {
			assertNotEquals("should have id > 0", 0L, savedRole.getId());
			
			RoleTypeModel roleType = savedRole.getRoleType();
			assertNotEquals("should have id > 0", 0L, roleType.getId());
			assertNotNull("should have name populated from db", roleType.getName());			
		}
		
	}
	
	@Test
	public void testUpdate() {
		
	}
}
