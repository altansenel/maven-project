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

import org.demo.bean.AdminDocumentField;
import org.demo.bean.jpa.AdminDocumentFieldEntity;
import org.demo.business.service.mapping.AdminDocumentFieldServiceMapper;
import org.demo.data.repository.jpa.AdminDocumentFieldJpaRepository;
import org.demo.test.AdminDocumentFieldFactoryForTest;
import org.demo.test.AdminDocumentFieldEntityFactoryForTest;
import org.demo.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of AdminDocumentFieldService
 */
@RunWith(MockitoJUnitRunner.class)
public class AdminDocumentFieldServiceImplTest {

	@InjectMocks
	private AdminDocumentFieldServiceImpl adminDocumentFieldService;
	@Mock
	private AdminDocumentFieldJpaRepository adminDocumentFieldJpaRepository;
	@Mock
	private AdminDocumentFieldServiceMapper adminDocumentFieldServiceMapper;
	
	private AdminDocumentFieldFactoryForTest adminDocumentFieldFactoryForTest = new AdminDocumentFieldFactoryForTest();

	private AdminDocumentFieldEntityFactoryForTest adminDocumentFieldEntityFactoryForTest = new AdminDocumentFieldEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer id = mockValues.nextInteger();
		
		AdminDocumentFieldEntity adminDocumentFieldEntity = adminDocumentFieldJpaRepository.findOne(id);
		
		AdminDocumentField adminDocumentField = adminDocumentFieldFactoryForTest.newAdminDocumentField();
		when(adminDocumentFieldServiceMapper.mapAdminDocumentFieldEntityToAdminDocumentField(adminDocumentFieldEntity)).thenReturn(adminDocumentField);

		// When
		AdminDocumentField adminDocumentFieldFound = adminDocumentFieldService.findById(id);

		// Then
		assertEquals(adminDocumentField.getId(),adminDocumentFieldFound.getId());
	}

	@Test
	public void findAll() {
		// Given
		List<AdminDocumentFieldEntity> adminDocumentFieldEntitys = new ArrayList<AdminDocumentFieldEntity>();
		AdminDocumentFieldEntity adminDocumentFieldEntity1 = adminDocumentFieldEntityFactoryForTest.newAdminDocumentFieldEntity();
		adminDocumentFieldEntitys.add(adminDocumentFieldEntity1);
		AdminDocumentFieldEntity adminDocumentFieldEntity2 = adminDocumentFieldEntityFactoryForTest.newAdminDocumentFieldEntity();
		adminDocumentFieldEntitys.add(adminDocumentFieldEntity2);
		when(adminDocumentFieldJpaRepository.findAll()).thenReturn(adminDocumentFieldEntitys);
		
		AdminDocumentField adminDocumentField1 = adminDocumentFieldFactoryForTest.newAdminDocumentField();
		when(adminDocumentFieldServiceMapper.mapAdminDocumentFieldEntityToAdminDocumentField(adminDocumentFieldEntity1)).thenReturn(adminDocumentField1);
		AdminDocumentField adminDocumentField2 = adminDocumentFieldFactoryForTest.newAdminDocumentField();
		when(adminDocumentFieldServiceMapper.mapAdminDocumentFieldEntityToAdminDocumentField(adminDocumentFieldEntity2)).thenReturn(adminDocumentField2);

		// When
		List<AdminDocumentField> adminDocumentFieldsFounds = adminDocumentFieldService.findAll();

		// Then
		assertTrue(adminDocumentField1 == adminDocumentFieldsFounds.get(0));
		assertTrue(adminDocumentField2 == adminDocumentFieldsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		AdminDocumentField adminDocumentField = adminDocumentFieldFactoryForTest.newAdminDocumentField();

		AdminDocumentFieldEntity adminDocumentFieldEntity = adminDocumentFieldEntityFactoryForTest.newAdminDocumentFieldEntity();
		when(adminDocumentFieldJpaRepository.findOne(adminDocumentField.getId())).thenReturn(null);
		
		adminDocumentFieldEntity = new AdminDocumentFieldEntity();
		adminDocumentFieldServiceMapper.mapAdminDocumentFieldToAdminDocumentFieldEntity(adminDocumentField, adminDocumentFieldEntity);
		AdminDocumentFieldEntity adminDocumentFieldEntitySaved = adminDocumentFieldJpaRepository.save(adminDocumentFieldEntity);
		
		AdminDocumentField adminDocumentFieldSaved = adminDocumentFieldFactoryForTest.newAdminDocumentField();
		when(adminDocumentFieldServiceMapper.mapAdminDocumentFieldEntityToAdminDocumentField(adminDocumentFieldEntitySaved)).thenReturn(adminDocumentFieldSaved);

		// When
		AdminDocumentField adminDocumentFieldResult = adminDocumentFieldService.create(adminDocumentField);

		// Then
		assertTrue(adminDocumentFieldResult == adminDocumentFieldSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		AdminDocumentField adminDocumentField = adminDocumentFieldFactoryForTest.newAdminDocumentField();

		AdminDocumentFieldEntity adminDocumentFieldEntity = adminDocumentFieldEntityFactoryForTest.newAdminDocumentFieldEntity();
		when(adminDocumentFieldJpaRepository.findOne(adminDocumentField.getId())).thenReturn(adminDocumentFieldEntity);

		// When
		Exception exception = null;
		try {
			adminDocumentFieldService.create(adminDocumentField);
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
		AdminDocumentField adminDocumentField = adminDocumentFieldFactoryForTest.newAdminDocumentField();

		AdminDocumentFieldEntity adminDocumentFieldEntity = adminDocumentFieldEntityFactoryForTest.newAdminDocumentFieldEntity();
		when(adminDocumentFieldJpaRepository.findOne(adminDocumentField.getId())).thenReturn(adminDocumentFieldEntity);
		
		AdminDocumentFieldEntity adminDocumentFieldEntitySaved = adminDocumentFieldEntityFactoryForTest.newAdminDocumentFieldEntity();
		when(adminDocumentFieldJpaRepository.save(adminDocumentFieldEntity)).thenReturn(adminDocumentFieldEntitySaved);
		
		AdminDocumentField adminDocumentFieldSaved = adminDocumentFieldFactoryForTest.newAdminDocumentField();
		when(adminDocumentFieldServiceMapper.mapAdminDocumentFieldEntityToAdminDocumentField(adminDocumentFieldEntitySaved)).thenReturn(adminDocumentFieldSaved);

		// When
		AdminDocumentField adminDocumentFieldResult = adminDocumentFieldService.update(adminDocumentField);

		// Then
		verify(adminDocumentFieldServiceMapper).mapAdminDocumentFieldToAdminDocumentFieldEntity(adminDocumentField, adminDocumentFieldEntity);
		assertTrue(adminDocumentFieldResult == adminDocumentFieldSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer id = mockValues.nextInteger();

		// When
		adminDocumentFieldService.delete(id);

		// Then
		verify(adminDocumentFieldJpaRepository).delete(id);
		
	}

}
