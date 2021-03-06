/*
 * Created on 24 �ub 2016 ( Time 16:27:49 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.demo.bean.AdminUserGivenRole;
import org.demo.bean.jpa.AdminUserGivenRoleEntity;
import org.demo.business.service.mapping.AdminUserGivenRoleServiceMapper;
import org.demo.data.repository.jpa.AdminUserGivenRoleJpaRepository;
import org.demo.test.AdminUserGivenRoleFactoryForTest;
import org.demo.test.AdminUserGivenRoleEntityFactoryForTest;
import org.demo.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of AdminUserGivenRoleService
 */
@RunWith(MockitoJUnitRunner.class)
public class AdminUserGivenRoleServiceImplTest {

	@InjectMocks
	private AdminUserGivenRoleServiceImpl adminUserGivenRoleService;
	@Mock
	private AdminUserGivenRoleJpaRepository adminUserGivenRoleJpaRepository;
	@Mock
	private AdminUserGivenRoleServiceMapper adminUserGivenRoleServiceMapper;
	
	private AdminUserGivenRoleFactoryForTest adminUserGivenRoleFactoryForTest = new AdminUserGivenRoleFactoryForTest();

	private AdminUserGivenRoleEntityFactoryForTest adminUserGivenRoleEntityFactoryForTest = new AdminUserGivenRoleEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer id = mockValues.nextInteger();
		
		AdminUserGivenRoleEntity adminUserGivenRoleEntity = adminUserGivenRoleJpaRepository.findOne(id);
		
		AdminUserGivenRole adminUserGivenRole = adminUserGivenRoleFactoryForTest.newAdminUserGivenRole();
		when(adminUserGivenRoleServiceMapper.mapAdminUserGivenRoleEntityToAdminUserGivenRole(adminUserGivenRoleEntity)).thenReturn(adminUserGivenRole);

		// When
		AdminUserGivenRole adminUserGivenRoleFound = adminUserGivenRoleService.findById(id);

		// Then
		assertEquals(adminUserGivenRole.getId(),adminUserGivenRoleFound.getId());
	}

	@Test
	public void findAll() {
		// Given
		List<AdminUserGivenRoleEntity> adminUserGivenRoleEntitys = new ArrayList<AdminUserGivenRoleEntity>();
		AdminUserGivenRoleEntity adminUserGivenRoleEntity1 = adminUserGivenRoleEntityFactoryForTest.newAdminUserGivenRoleEntity();
		adminUserGivenRoleEntitys.add(adminUserGivenRoleEntity1);
		AdminUserGivenRoleEntity adminUserGivenRoleEntity2 = adminUserGivenRoleEntityFactoryForTest.newAdminUserGivenRoleEntity();
		adminUserGivenRoleEntitys.add(adminUserGivenRoleEntity2);
		when(adminUserGivenRoleJpaRepository.findAll()).thenReturn(adminUserGivenRoleEntitys);
		
		AdminUserGivenRole adminUserGivenRole1 = adminUserGivenRoleFactoryForTest.newAdminUserGivenRole();
		when(adminUserGivenRoleServiceMapper.mapAdminUserGivenRoleEntityToAdminUserGivenRole(adminUserGivenRoleEntity1)).thenReturn(adminUserGivenRole1);
		AdminUserGivenRole adminUserGivenRole2 = adminUserGivenRoleFactoryForTest.newAdminUserGivenRole();
		when(adminUserGivenRoleServiceMapper.mapAdminUserGivenRoleEntityToAdminUserGivenRole(adminUserGivenRoleEntity2)).thenReturn(adminUserGivenRole2);

		// When
		List<AdminUserGivenRole> adminUserGivenRolesFounds = adminUserGivenRoleService.findAll();

		// Then
		assertTrue(adminUserGivenRole1 == adminUserGivenRolesFounds.get(0));
		assertTrue(adminUserGivenRole2 == adminUserGivenRolesFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		AdminUserGivenRole adminUserGivenRole = adminUserGivenRoleFactoryForTest.newAdminUserGivenRole();

		AdminUserGivenRoleEntity adminUserGivenRoleEntity = adminUserGivenRoleEntityFactoryForTest.newAdminUserGivenRoleEntity();
		when(adminUserGivenRoleJpaRepository.findOne(adminUserGivenRole.getId())).thenReturn(null);
		
		adminUserGivenRoleEntity = new AdminUserGivenRoleEntity();
		adminUserGivenRoleServiceMapper.mapAdminUserGivenRoleToAdminUserGivenRoleEntity(adminUserGivenRole, adminUserGivenRoleEntity);
		AdminUserGivenRoleEntity adminUserGivenRoleEntitySaved = adminUserGivenRoleJpaRepository.save(adminUserGivenRoleEntity);
		
		AdminUserGivenRole adminUserGivenRoleSaved = adminUserGivenRoleFactoryForTest.newAdminUserGivenRole();
		when(adminUserGivenRoleServiceMapper.mapAdminUserGivenRoleEntityToAdminUserGivenRole(adminUserGivenRoleEntitySaved)).thenReturn(adminUserGivenRoleSaved);

		// When
		AdminUserGivenRole adminUserGivenRoleResult = adminUserGivenRoleService.create(adminUserGivenRole);

		// Then
		assertTrue(adminUserGivenRoleResult == adminUserGivenRoleSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		AdminUserGivenRole adminUserGivenRole = adminUserGivenRoleFactoryForTest.newAdminUserGivenRole();

		AdminUserGivenRoleEntity adminUserGivenRoleEntity = adminUserGivenRoleEntityFactoryForTest.newAdminUserGivenRoleEntity();
		when(adminUserGivenRoleJpaRepository.findOne(adminUserGivenRole.getId())).thenReturn(adminUserGivenRoleEntity);

		// When
		Exception exception = null;
		try {
			adminUserGivenRoleService.create(adminUserGivenRole);
		} catch(Exception e) {
			exception = e;
		}

		// Then
		assertTrue(exception instanceof IllegalStateException);
		assertEquals("already.exists", exception.getMessage());
	}

	@Test
	public void update() {
		// Given
		AdminUserGivenRole adminUserGivenRole = adminUserGivenRoleFactoryForTest.newAdminUserGivenRole();

		AdminUserGivenRoleEntity adminUserGivenRoleEntity = adminUserGivenRoleEntityFactoryForTest.newAdminUserGivenRoleEntity();
		when(adminUserGivenRoleJpaRepository.findOne(adminUserGivenRole.getId())).thenReturn(adminUserGivenRoleEntity);
		
		AdminUserGivenRoleEntity adminUserGivenRoleEntitySaved = adminUserGivenRoleEntityFactoryForTest.newAdminUserGivenRoleEntity();
		when(adminUserGivenRoleJpaRepository.save(adminUserGivenRoleEntity)).thenReturn(adminUserGivenRoleEntitySaved);
		
		AdminUserGivenRole adminUserGivenRoleSaved = adminUserGivenRoleFactoryForTest.newAdminUserGivenRole();
		when(adminUserGivenRoleServiceMapper.mapAdminUserGivenRoleEntityToAdminUserGivenRole(adminUserGivenRoleEntitySaved)).thenReturn(adminUserGivenRoleSaved);

		// When
		AdminUserGivenRole adminUserGivenRoleResult = adminUserGivenRoleService.update(adminUserGivenRole);

		// Then
		verify(adminUserGivenRoleServiceMapper).mapAdminUserGivenRoleToAdminUserGivenRoleEntity(adminUserGivenRole, adminUserGivenRoleEntity);
		assertTrue(adminUserGivenRoleResult == adminUserGivenRoleSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer id = mockValues.nextInteger();

		// When
		adminUserGivenRoleService.delete(id);

		// Then
		verify(adminUserGivenRoleJpaRepository).delete(id);
		
	}

}
