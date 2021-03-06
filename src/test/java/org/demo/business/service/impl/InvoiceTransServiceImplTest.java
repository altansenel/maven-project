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

import org.demo.bean.InvoiceTrans;
import org.demo.bean.jpa.InvoiceTransEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.mapping.InvoiceTransServiceMapper;
import org.demo.data.repository.jpa.InvoiceTransJpaRepository;
import org.demo.test.InvoiceTransFactoryForTest;
import org.demo.test.InvoiceTransEntityFactoryForTest;
import org.demo.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of InvoiceTransService
 */
@RunWith(MockitoJUnitRunner.class)
public class InvoiceTransServiceImplTest {

	@InjectMocks
	private InvoiceTransServiceImpl invoiceTransService;
	@Mock
	private InvoiceTransJpaRepository invoiceTransJpaRepository;
	@Mock
	private InvoiceTransServiceMapper invoiceTransServiceMapper;
	
	private InvoiceTransFactoryForTest invoiceTransFactoryForTest = new InvoiceTransFactoryForTest();

	private InvoiceTransEntityFactoryForTest invoiceTransEntityFactoryForTest = new InvoiceTransEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer id = mockValues.nextInteger();
		
		InvoiceTransEntity invoiceTransEntity = invoiceTransJpaRepository.findOne(id);
		
		InvoiceTrans invoiceTrans = invoiceTransFactoryForTest.newInvoiceTrans();
		when(invoiceTransServiceMapper.mapInvoiceTransEntityToInvoiceTrans(invoiceTransEntity)).thenReturn(invoiceTrans);

		// When
		InvoiceTrans invoiceTransFound = invoiceTransService.findById(id);

		// Then
		assertEquals(invoiceTrans.getId(),invoiceTransFound.getId());
	}

	@Test
	public void findAll() {
		// Given
		List<InvoiceTransEntity> invoiceTransEntitys = new ArrayList<InvoiceTransEntity>();
		InvoiceTransEntity invoiceTransEntity1 = invoiceTransEntityFactoryForTest.newInvoiceTransEntity();
		invoiceTransEntitys.add(invoiceTransEntity1);
		InvoiceTransEntity invoiceTransEntity2 = invoiceTransEntityFactoryForTest.newInvoiceTransEntity();
		invoiceTransEntitys.add(invoiceTransEntity2);
		when(invoiceTransJpaRepository.findAll()).thenReturn(invoiceTransEntitys);
		
		InvoiceTrans invoiceTrans1 = invoiceTransFactoryForTest.newInvoiceTrans();
		when(invoiceTransServiceMapper.mapInvoiceTransEntityToInvoiceTrans(invoiceTransEntity1)).thenReturn(invoiceTrans1);
		InvoiceTrans invoiceTrans2 = invoiceTransFactoryForTest.newInvoiceTrans();
		when(invoiceTransServiceMapper.mapInvoiceTransEntityToInvoiceTrans(invoiceTransEntity2)).thenReturn(invoiceTrans2);

		// When
		List<InvoiceTrans> invoiceTranssFounds = invoiceTransService.findAll();

		// Then
		assertTrue(invoiceTrans1 == invoiceTranssFounds.get(0));
		assertTrue(invoiceTrans2 == invoiceTranssFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		InvoiceTrans invoiceTrans = invoiceTransFactoryForTest.newInvoiceTrans();

		InvoiceTransEntity invoiceTransEntity = invoiceTransEntityFactoryForTest.newInvoiceTransEntity();
		when(invoiceTransJpaRepository.findOne(invoiceTrans.getId())).thenReturn(null);
		
		invoiceTransEntity = new InvoiceTransEntity();
		invoiceTransServiceMapper.mapInvoiceTransToInvoiceTransEntity(invoiceTrans, invoiceTransEntity);
		InvoiceTransEntity invoiceTransEntitySaved = invoiceTransJpaRepository.save(invoiceTransEntity);
		
		InvoiceTrans invoiceTransSaved = invoiceTransFactoryForTest.newInvoiceTrans();
		when(invoiceTransServiceMapper.mapInvoiceTransEntityToInvoiceTrans(invoiceTransEntitySaved)).thenReturn(invoiceTransSaved);

		// When
		InvoiceTrans invoiceTransResult = invoiceTransService.create(invoiceTrans);

		// Then
		assertTrue(invoiceTransResult == invoiceTransSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		InvoiceTrans invoiceTrans = invoiceTransFactoryForTest.newInvoiceTrans();

		InvoiceTransEntity invoiceTransEntity = invoiceTransEntityFactoryForTest.newInvoiceTransEntity();
		when(invoiceTransJpaRepository.findOne(invoiceTrans.getId())).thenReturn(invoiceTransEntity);

		// When
		Exception exception = null;
		try {
			invoiceTransService.create(invoiceTrans);
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
		InvoiceTrans invoiceTrans = invoiceTransFactoryForTest.newInvoiceTrans();

		InvoiceTransEntity invoiceTransEntity = invoiceTransEntityFactoryForTest.newInvoiceTransEntity();
		when(invoiceTransJpaRepository.findOne(invoiceTrans.getId())).thenReturn(invoiceTransEntity);
		
		InvoiceTransEntity invoiceTransEntitySaved = invoiceTransEntityFactoryForTest.newInvoiceTransEntity();
		when(invoiceTransJpaRepository.save(invoiceTransEntity)).thenReturn(invoiceTransEntitySaved);
		
		InvoiceTrans invoiceTransSaved = invoiceTransFactoryForTest.newInvoiceTrans();
		when(invoiceTransServiceMapper.mapInvoiceTransEntityToInvoiceTrans(invoiceTransEntitySaved)).thenReturn(invoiceTransSaved);

		// When
		InvoiceTrans invoiceTransResult = invoiceTransService.update(invoiceTrans);

		// Then
		verify(invoiceTransServiceMapper).mapInvoiceTransToInvoiceTransEntity(invoiceTrans, invoiceTransEntity);
		assertTrue(invoiceTransResult == invoiceTransSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer id = mockValues.nextInteger();

		// When
		invoiceTransService.delete(id);

		// Then
		verify(invoiceTransJpaRepository).delete(id);
		
	}

}
