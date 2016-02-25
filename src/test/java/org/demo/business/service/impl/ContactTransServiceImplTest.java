/*
 * Created on 24 �ub 2016 ( Time 16:27:50 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.demo.bean.ContactTrans;
import org.demo.bean.jpa.ContactTransEntity;
import java.util.Date;
import org.demo.business.service.mapping.ContactTransServiceMapper;
import org.demo.data.repository.jpa.ContactTransJpaRepository;
import org.demo.test.ContactTransFactoryForTest;
import org.demo.test.ContactTransEntityFactoryForTest;
import org.demo.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of ContactTransService
 */
@RunWith(MockitoJUnitRunner.class)
public class ContactTransServiceImplTest {

	@InjectMocks
	private ContactTransServiceImpl contactTransService;
	@Mock
	private ContactTransJpaRepository contactTransJpaRepository;
	@Mock
	private ContactTransServiceMapper contactTransServiceMapper;
	
	private ContactTransFactoryForTest contactTransFactoryForTest = new ContactTransFactoryForTest();

	private ContactTransEntityFactoryForTest contactTransEntityFactoryForTest = new ContactTransEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer id = mockValues.nextInteger();
		
		ContactTransEntity contactTransEntity = contactTransJpaRepository.findOne(id);
		
		ContactTrans contactTrans = contactTransFactoryForTest.newContactTrans();
		when(contactTransServiceMapper.mapContactTransEntityToContactTrans(contactTransEntity)).thenReturn(contactTrans);

		// When
		ContactTrans contactTransFound = contactTransService.findById(id);

		// Then
		assertEquals(contactTrans.getId(),contactTransFound.getId());
	}

	@Test
	public void findAll() {
		// Given
		List<ContactTransEntity> contactTransEntitys = new ArrayList<ContactTransEntity>();
		ContactTransEntity contactTransEntity1 = contactTransEntityFactoryForTest.newContactTransEntity();
		contactTransEntitys.add(contactTransEntity1);
		ContactTransEntity contactTransEntity2 = contactTransEntityFactoryForTest.newContactTransEntity();
		contactTransEntitys.add(contactTransEntity2);
		when(contactTransJpaRepository.findAll()).thenReturn(contactTransEntitys);
		
		ContactTrans contactTrans1 = contactTransFactoryForTest.newContactTrans();
		when(contactTransServiceMapper.mapContactTransEntityToContactTrans(contactTransEntity1)).thenReturn(contactTrans1);
		ContactTrans contactTrans2 = contactTransFactoryForTest.newContactTrans();
		when(contactTransServiceMapper.mapContactTransEntityToContactTrans(contactTransEntity2)).thenReturn(contactTrans2);

		// When
		List<ContactTrans> contactTranssFounds = contactTransService.findAll();

		// Then
		assertTrue(contactTrans1 == contactTranssFounds.get(0));
		assertTrue(contactTrans2 == contactTranssFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		ContactTrans contactTrans = contactTransFactoryForTest.newContactTrans();

		ContactTransEntity contactTransEntity = contactTransEntityFactoryForTest.newContactTransEntity();
		when(contactTransJpaRepository.findOne(contactTrans.getId())).thenReturn(null);
		
		contactTransEntity = new ContactTransEntity();
		contactTransServiceMapper.mapContactTransToContactTransEntity(contactTrans, contactTransEntity);
		ContactTransEntity contactTransEntitySaved = contactTransJpaRepository.save(contactTransEntity);
		
		ContactTrans contactTransSaved = contactTransFactoryForTest.newContactTrans();
		when(contactTransServiceMapper.mapContactTransEntityToContactTrans(contactTransEntitySaved)).thenReturn(contactTransSaved);

		// When
		ContactTrans contactTransResult = contactTransService.create(contactTrans);

		// Then
		assertTrue(contactTransResult == contactTransSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		ContactTrans contactTrans = contactTransFactoryForTest.newContactTrans();

		ContactTransEntity contactTransEntity = contactTransEntityFactoryForTest.newContactTransEntity();
		when(contactTransJpaRepository.findOne(contactTrans.getId())).thenReturn(contactTransEntity);

		// When
		Exception exception = null;
		try {
			contactTransService.create(contactTrans);
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
		ContactTrans contactTrans = contactTransFactoryForTest.newContactTrans();

		ContactTransEntity contactTransEntity = contactTransEntityFactoryForTest.newContactTransEntity();
		when(contactTransJpaRepository.findOne(contactTrans.getId())).thenReturn(contactTransEntity);
		
		ContactTransEntity contactTransEntitySaved = contactTransEntityFactoryForTest.newContactTransEntity();
		when(contactTransJpaRepository.save(contactTransEntity)).thenReturn(contactTransEntitySaved);
		
		ContactTrans contactTransSaved = contactTransFactoryForTest.newContactTrans();
		when(contactTransServiceMapper.mapContactTransEntityToContactTrans(contactTransEntitySaved)).thenReturn(contactTransSaved);

		// When
		ContactTrans contactTransResult = contactTransService.update(contactTrans);

		// Then
		verify(contactTransServiceMapper).mapContactTransToContactTransEntity(contactTrans, contactTransEntity);
		assertTrue(contactTransResult == contactTransSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer id = mockValues.nextInteger();

		// When
		contactTransService.delete(id);

		// Then
		verify(contactTransJpaRepository).delete(id);
		
	}

}
