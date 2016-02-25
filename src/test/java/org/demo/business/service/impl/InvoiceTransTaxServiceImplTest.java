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

import org.demo.bean.InvoiceTransTax;
import org.demo.bean.jpa.InvoiceTransTaxEntity;
import org.demo.business.service.mapping.InvoiceTransTaxServiceMapper;
import org.demo.data.repository.jpa.InvoiceTransTaxJpaRepository;
import org.demo.test.InvoiceTransTaxFactoryForTest;
import org.demo.test.InvoiceTransTaxEntityFactoryForTest;
import org.demo.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of InvoiceTransTaxService
 */
@RunWith(MockitoJUnitRunner.class)
public class InvoiceTransTaxServiceImplTest {

	@InjectMocks
	private InvoiceTransTaxServiceImpl invoiceTransTaxService;
	@Mock
	private InvoiceTransTaxJpaRepository invoiceTransTaxJpaRepository;
	@Mock
	private InvoiceTransTaxServiceMapper invoiceTransTaxServiceMapper;
	
	private InvoiceTransTaxFactoryForTest invoiceTransTaxFactoryForTest = new InvoiceTransTaxFactoryForTest();

	private InvoiceTransTaxEntityFactoryForTest invoiceTransTaxEntityFactoryForTest = new InvoiceTransTaxEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer id = mockValues.nextInteger();
		
		InvoiceTransTaxEntity invoiceTransTaxEntity = invoiceTransTaxJpaRepository.findOne(id);
		
		InvoiceTransTax invoiceTransTax = invoiceTransTaxFactoryForTest.newInvoiceTransTax();
		when(invoiceTransTaxServiceMapper.mapInvoiceTransTaxEntityToInvoiceTransTax(invoiceTransTaxEntity)).thenReturn(invoiceTransTax);

		// When
		InvoiceTransTax invoiceTransTaxFound = invoiceTransTaxService.findById(id);

		// Then
		assertEquals(invoiceTransTax.getId(),invoiceTransTaxFound.getId());
	}

	@Test
	public void findAll() {
		// Given
		List<InvoiceTransTaxEntity> invoiceTransTaxEntitys = new ArrayList<InvoiceTransTaxEntity>();
		InvoiceTransTaxEntity invoiceTransTaxEntity1 = invoiceTransTaxEntityFactoryForTest.newInvoiceTransTaxEntity();
		invoiceTransTaxEntitys.add(invoiceTransTaxEntity1);
		InvoiceTransTaxEntity invoiceTransTaxEntity2 = invoiceTransTaxEntityFactoryForTest.newInvoiceTransTaxEntity();
		invoiceTransTaxEntitys.add(invoiceTransTaxEntity2);
		when(invoiceTransTaxJpaRepository.findAll()).thenReturn(invoiceTransTaxEntitys);
		
		InvoiceTransTax invoiceTransTax1 = invoiceTransTaxFactoryForTest.newInvoiceTransTax();
		when(invoiceTransTaxServiceMapper.mapInvoiceTransTaxEntityToInvoiceTransTax(invoiceTransTaxEntity1)).thenReturn(invoiceTransTax1);
		InvoiceTransTax invoiceTransTax2 = invoiceTransTaxFactoryForTest.newInvoiceTransTax();
		when(invoiceTransTaxServiceMapper.mapInvoiceTransTaxEntityToInvoiceTransTax(invoiceTransTaxEntity2)).thenReturn(invoiceTransTax2);

		// When
		List<InvoiceTransTax> invoiceTransTaxsFounds = invoiceTransTaxService.findAll();

		// Then
		assertTrue(invoiceTransTax1 == invoiceTransTaxsFounds.get(0));
		assertTrue(invoiceTransTax2 == invoiceTransTaxsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		InvoiceTransTax invoiceTransTax = invoiceTransTaxFactoryForTest.newInvoiceTransTax();

		InvoiceTransTaxEntity invoiceTransTaxEntity = invoiceTransTaxEntityFactoryForTest.newInvoiceTransTaxEntity();
		when(invoiceTransTaxJpaRepository.findOne(invoiceTransTax.getId())).thenReturn(null);
		
		invoiceTransTaxEntity = new InvoiceTransTaxEntity();
		invoiceTransTaxServiceMapper.mapInvoiceTransTaxToInvoiceTransTaxEntity(invoiceTransTax, invoiceTransTaxEntity);
		InvoiceTransTaxEntity invoiceTransTaxEntitySaved = invoiceTransTaxJpaRepository.save(invoiceTransTaxEntity);
		
		InvoiceTransTax invoiceTransTaxSaved = invoiceTransTaxFactoryForTest.newInvoiceTransTax();
		when(invoiceTransTaxServiceMapper.mapInvoiceTransTaxEntityToInvoiceTransTax(invoiceTransTaxEntitySaved)).thenReturn(invoiceTransTaxSaved);

		// When
		InvoiceTransTax invoiceTransTaxResult = invoiceTransTaxService.create(invoiceTransTax);

		// Then
		assertTrue(invoiceTransTaxResult == invoiceTransTaxSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		InvoiceTransTax invoiceTransTax = invoiceTransTaxFactoryForTest.newInvoiceTransTax();

		InvoiceTransTaxEntity invoiceTransTaxEntity = invoiceTransTaxEntityFactoryForTest.newInvoiceTransTaxEntity();
		when(invoiceTransTaxJpaRepository.findOne(invoiceTransTax.getId())).thenReturn(invoiceTransTaxEntity);

		// When
		Exception exception = null;
		try {
			invoiceTransTaxService.create(invoiceTransTax);
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
		InvoiceTransTax invoiceTransTax = invoiceTransTaxFactoryForTest.newInvoiceTransTax();

		InvoiceTransTaxEntity invoiceTransTaxEntity = invoiceTransTaxEntityFactoryForTest.newInvoiceTransTaxEntity();
		when(invoiceTransTaxJpaRepository.findOne(invoiceTransTax.getId())).thenReturn(invoiceTransTaxEntity);
		
		InvoiceTransTaxEntity invoiceTransTaxEntitySaved = invoiceTransTaxEntityFactoryForTest.newInvoiceTransTaxEntity();
		when(invoiceTransTaxJpaRepository.save(invoiceTransTaxEntity)).thenReturn(invoiceTransTaxEntitySaved);
		
		InvoiceTransTax invoiceTransTaxSaved = invoiceTransTaxFactoryForTest.newInvoiceTransTax();
		when(invoiceTransTaxServiceMapper.mapInvoiceTransTaxEntityToInvoiceTransTax(invoiceTransTaxEntitySaved)).thenReturn(invoiceTransTaxSaved);

		// When
		InvoiceTransTax invoiceTransTaxResult = invoiceTransTaxService.update(invoiceTransTax);

		// Then
		verify(invoiceTransTaxServiceMapper).mapInvoiceTransTaxToInvoiceTransTaxEntity(invoiceTransTax, invoiceTransTaxEntity);
		assertTrue(invoiceTransTaxResult == invoiceTransTaxSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer id = mockValues.nextInteger();

		// When
		invoiceTransTaxService.delete(id);

		// Then
		verify(invoiceTransTaxJpaRepository).delete(id);
		
	}

}
