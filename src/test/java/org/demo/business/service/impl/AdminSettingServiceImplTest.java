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

import org.demo.bean.AdminSetting;
import org.demo.bean.jpa.AdminSettingEntity;
import java.util.Date;
import org.demo.business.service.mapping.AdminSettingServiceMapper;
import org.demo.data.repository.jpa.AdminSettingJpaRepository;
import org.demo.test.AdminSettingFactoryForTest;
import org.demo.test.AdminSettingEntityFactoryForTest;
import org.demo.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of AdminSettingService
 */
@RunWith(MockitoJUnitRunner.class)
public class AdminSettingServiceImplTest {

	@InjectMocks
	private AdminSettingServiceImpl adminSettingService;
	@Mock
	private AdminSettingJpaRepository adminSettingJpaRepository;
	@Mock
	private AdminSettingServiceMapper adminSettingServiceMapper;
	
	private AdminSettingFactoryForTest adminSettingFactoryForTest = new AdminSettingFactoryForTest();

	private AdminSettingEntityFactoryForTest adminSettingEntityFactoryForTest = new AdminSettingEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer id = mockValues.nextInteger();
		
		AdminSettingEntity adminSettingEntity = adminSettingJpaRepository.findOne(id);
		
		AdminSetting adminSetting = adminSettingFactoryForTest.newAdminSetting();
		when(adminSettingServiceMapper.mapAdminSettingEntityToAdminSetting(adminSettingEntity)).thenReturn(adminSetting);

		// When
		AdminSetting adminSettingFound = adminSettingService.findById(id);

		// Then
		assertEquals(adminSetting.getId(),adminSettingFound.getId());
	}

	@Test
	public void findAll() {
		// Given
		List<AdminSettingEntity> adminSettingEntitys = new ArrayList<AdminSettingEntity>();
		AdminSettingEntity adminSettingEntity1 = adminSettingEntityFactoryForTest.newAdminSettingEntity();
		adminSettingEntitys.add(adminSettingEntity1);
		AdminSettingEntity adminSettingEntity2 = adminSettingEntityFactoryForTest.newAdminSettingEntity();
		adminSettingEntitys.add(adminSettingEntity2);
		when(adminSettingJpaRepository.findAll()).thenReturn(adminSettingEntitys);
		
		AdminSetting adminSetting1 = adminSettingFactoryForTest.newAdminSetting();
		when(adminSettingServiceMapper.mapAdminSettingEntityToAdminSetting(adminSettingEntity1)).thenReturn(adminSetting1);
		AdminSetting adminSetting2 = adminSettingFactoryForTest.newAdminSetting();
		when(adminSettingServiceMapper.mapAdminSettingEntityToAdminSetting(adminSettingEntity2)).thenReturn(adminSetting2);

		// When
		List<AdminSetting> adminSettingsFounds = adminSettingService.findAll();

		// Then
		assertTrue(adminSetting1 == adminSettingsFounds.get(0));
		assertTrue(adminSetting2 == adminSettingsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		AdminSetting adminSetting = adminSettingFactoryForTest.newAdminSetting();

		AdminSettingEntity adminSettingEntity = adminSettingEntityFactoryForTest.newAdminSettingEntity();
		when(adminSettingJpaRepository.findOne(adminSetting.getId())).thenReturn(null);
		
		adminSettingEntity = new AdminSettingEntity();
		adminSettingServiceMapper.mapAdminSettingToAdminSettingEntity(adminSetting, adminSettingEntity);
		AdminSettingEntity adminSettingEntitySaved = adminSettingJpaRepository.save(adminSettingEntity);
		
		AdminSetting adminSettingSaved = adminSettingFactoryForTest.newAdminSetting();
		when(adminSettingServiceMapper.mapAdminSettingEntityToAdminSetting(adminSettingEntitySaved)).thenReturn(adminSettingSaved);

		// When
		AdminSetting adminSettingResult = adminSettingService.create(adminSetting);

		// Then
		assertTrue(adminSettingResult == adminSettingSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		AdminSetting adminSetting = adminSettingFactoryForTest.newAdminSetting();

		AdminSettingEntity adminSettingEntity = adminSettingEntityFactoryForTest.newAdminSettingEntity();
		when(adminSettingJpaRepository.findOne(adminSetting.getId())).thenReturn(adminSettingEntity);

		// When
		Exception exception = null;
		try {
			adminSettingService.create(adminSetting);
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
		AdminSetting adminSetting = adminSettingFactoryForTest.newAdminSetting();

		AdminSettingEntity adminSettingEntity = adminSettingEntityFactoryForTest.newAdminSettingEntity();
		when(adminSettingJpaRepository.findOne(adminSetting.getId())).thenReturn(adminSettingEntity);
		
		AdminSettingEntity adminSettingEntitySaved = adminSettingEntityFactoryForTest.newAdminSettingEntity();
		when(adminSettingJpaRepository.save(adminSettingEntity)).thenReturn(adminSettingEntitySaved);
		
		AdminSetting adminSettingSaved = adminSettingFactoryForTest.newAdminSetting();
		when(adminSettingServiceMapper.mapAdminSettingEntityToAdminSetting(adminSettingEntitySaved)).thenReturn(adminSettingSaved);

		// When
		AdminSetting adminSettingResult = adminSettingService.update(adminSetting);

		// Then
		verify(adminSettingServiceMapper).mapAdminSettingToAdminSettingEntity(adminSetting, adminSettingEntity);
		assertTrue(adminSettingResult == adminSettingSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer id = mockValues.nextInteger();

		// When
		adminSettingService.delete(id);

		// Then
		verify(adminSettingJpaRepository).delete(id);
		
	}

}
