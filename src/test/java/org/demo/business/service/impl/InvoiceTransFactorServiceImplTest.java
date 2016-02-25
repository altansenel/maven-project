/*
 * Created on 24 �ub 2016 ( Time 16:27:51 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.demo.bean.InvoiceTransFactor;
import org.demo.bean.jpa.InvoiceTransFactorEntity;
import org.demo.business.service.mapping.InvoiceTransFactorServiceMapper;
import org.demo.data.repository.jpa.InvoiceTransFactorJpaRepository;
import org.demo.test.InvoiceTransFactorFactoryForTest;
import org.demo.test.InvoiceTransFactorEntityFactoryForTest;
import org.demo.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of InvoiceTransFactorService
 */
@RunWith(MockitoJUnitRunner.class)
public class InvoiceTransFactorServiceImplTest {

	@InjectMocks
	private InvoiceTransFactorServiceImpl invoiceTransFactorService;
	@Mock
	private InvoiceTransFactorJpaRepository invoiceTransFactorJpaRepository;
	@Mock
	private InvoiceTransFactorServiceMapper invoiceTransFactorServiceMapper;
	
	private InvoiceTransFactorFactoryForTest invoiceTransFactorFactoryForTest = new InvoiceTransFactorFactoryForTest();

	private InvoiceTransFactorEntityFactoryForTest invoiceTransFactorEntityFactoryForTest = new InvoiceTransFactorEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer id = mockValues.nextInteger();
		
		InvoiceTransFactorEntity invoiceTransFactorEntity = invoiceTransFactorJpaRepository.findOne(id);
		
		InvoiceTransFactor invoiceTransFactor = invoiceTransFactorFactoryForTest.newInvoiceTransFactor();
		when(invoiceTransFactorServiceMapper.mapInvoiceTransFactorEntityToInvoiceTransFactor(invoiceTransFactorEntity)).thenReturn(invoiceTransFactor);

		// When
		InvoiceTransFactor invoiceTransFactorFound = invoiceTransFactorService.findById(id);

		// Then
		assertEquals(invoiceTransFactor.getId(),invoiceTransFactorFound.getId());
	}

	@Test
	public void findAll() {
		// Given
		List<InvoiceTransFactorEntity> invoiceTransFactorEntitys = new ArrayList<InvoiceTransFactorEntity>();
		InvoiceTransFactorEntity invoiceTransFactorEntity1 = invoiceTransFactorEntityFactoryForTest.newInvoiceTransFactorEntity();
		invoiceTransFactorEntitys.add(invoiceTransFactorEntity1);
		InvoiceTransFactorEntity invoiceTransFactorEntity2 = invoiceTransFactorEntityFactoryForTest.newInvoiceTransFactorEntity();
		invoiceTransFactorEntitys.add(invoiceTransFactorEntity2);
		when(invoiceTransFactorJpaRepository.findAll()).thenReturn(invoiceTransFactorEntitys);
		
		InvoiceTransFactor invoiceTransFactor1 = invoiceTransFactorFactoryForTest.newInvoiceTransFactor();
		when(invoiceTransFactorServiceMapper.mapInvoiceTransFactorEntityToInvoiceTransFactor(invoiceTransFactorEntity1)).thenReturn(invoiceTransFactor1);
		InvoiceTransFactor invoiceTransFactor2 = invoiceTransFactorFactoryForTest.newInvoiceTransFactor();
		when(invoiceTransFactorServiceMapper.mapInvoiceTransFactorEntityToInvoiceTransFactor(invoiceTransFactorEntity2)).thenReturn(invoiceTransFactor2);

		// When
		List<InvoiceTransFactor> invoiceTransFactorsFounds = invoiceTransFactorService.findAll();

		// Then
		assertTrue(invoiceTransFactor1 == invoiceTransFactorsFounds.get(0));
		assertTrue(invoiceTransFactor2 == invoiceTransFactorsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		InvoiceTransFactor invoiceTransFactor = invoiceTransFactorFactoryForTest.newInvoiceTransFactor();

		InvoiceTransFactorEntity invoiceTransFactorEntity = invoiceTransFactorEntityFactoryForTest.newInvoiceTransFactorEntity();
		when(invoiceTransFactorJpaRepository.findOne(invoiceTransFactor.getId())).thenReturn(null);
		
		invoiceTransFactorEntity = new InvoiceTransFactorEntity();
		invoiceTransFactorServiceMapper.mapInvoiceTransFactorToInvoiceTransFactorEntity(invoiceTransFactor, invoiceTransFactorEntity);
		InvoiceTransFactorEntity invoiceTransFactorEntitySaved = invoiceTransFactorJpaRepository.save(invoiceTransFactorEntity);
		
		InvoiceTransFactor invoiceTransFactorSaved = invoiceTransFactorFactoryForTest.newInvoiceTransFactor();
		when(invoiceTransFactorServiceMapper.mapInvoiceTransFactorEntityToInvoiceTransFactor(invoiceTransFactorEntitySaved)).thenReturn(invoiceTransFactorSaved);

		// When
		InvoiceTransFactor invoiceTransFactorResult = invoiceTransFactorService.create(invoiceTransFactor);

		// Then
		assertTrue(invoiceTransFactorResult == invoiceTransFactorSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		InvoiceTransFactor invoiceTransFactor = invoiceTransFactorFactoryForTest.newInvoiceTransFactor();

		InvoiceTransFactorEntity invoiceTransFactorEntity = invoiceTransFactorEntityFactoryForTest.newInvoiceTransFactorEntity();
		when(invoiceTransFactorJpaRepository.findOne(invoiceTransFactor.getId())).thenReturn(invoiceTransFactorEntity);

		// When
		Exception exception = null;
		try {
			invoiceTransFactorService.create(invoiceTransFactor);
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
		InvoiceTransFactor invoiceTransFactor = invoiceTransFactorFactoryForTest.newInvoiceTransFactor();

		InvoiceTransFactorEntity invoiceTransFactorEntity = invoiceTransFactorEntityFactoryForTest.newInvoiceTransFactorEntity();
		when(invoiceTransFactorJpaRepository.findOne(invoiceTransFactor.getId())).thenReturn(invoiceTransFactorEntity);
		
		InvoiceTransFactorEntity invoiceTransFactorEntitySaved = invoiceTransFactorEntityFactoryForTest.newInvoiceTransFactorEntity();
		when(invoiceTransFactorJpaRepository.save(invoiceTransFactorEntity)).thenReturn(invoiceTransFactorEntitySaved);
		
		InvoiceTransFactor invoiceTransFactorSaved = invoiceTransFactorFactoryForTest.newInvoiceTransFactor();
		when(invoiceTransFactorServiceMapper.mapInvoiceTransFactorEntityToInvoiceTransFactor(invoiceTransFactorEntitySaved)).thenReturn(invoiceTransFactorSaved);

		// When
		InvoiceTransFactor invoiceTransFactorResult = invoiceTransFactorService.update(invoiceTransFactor);

		// Then
		verify(invoiceTransFactorServiceMapper).mapInvoiceTransFactorToInvoiceTransFactorEntity(invoiceTransFactor, invoiceTransFactorEntity);
		assertTrue(invoiceTransFactorResult == invoiceTransFactorSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer id = mockValues.nextInteger();

		// When
		invoiceTransFactorService.delete(id);

		// Then
		verify(invoiceTransFactorJpaRepository).delete(id);
		
	}

}