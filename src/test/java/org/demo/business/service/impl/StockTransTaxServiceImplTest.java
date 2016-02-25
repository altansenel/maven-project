/*
 * Created on 24 �ub 2016 ( Time 16:27:53 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.demo.bean.StockTransTax;
import org.demo.bean.jpa.StockTransTaxEntity;
import org.demo.business.service.mapping.StockTransTaxServiceMapper;
import org.demo.data.repository.jpa.StockTransTaxJpaRepository;
import org.demo.test.StockTransTaxFactoryForTest;
import org.demo.test.StockTransTaxEntityFactoryForTest;
import org.demo.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of StockTransTaxService
 */
@RunWith(MockitoJUnitRunner.class)
public class StockTransTaxServiceImplTest {

	@InjectMocks
	private StockTransTaxServiceImpl stockTransTaxService;
	@Mock
	private StockTransTaxJpaRepository stockTransTaxJpaRepository;
	@Mock
	private StockTransTaxServiceMapper stockTransTaxServiceMapper;
	
	private StockTransTaxFactoryForTest stockTransTaxFactoryForTest = new StockTransTaxFactoryForTest();

	private StockTransTaxEntityFactoryForTest stockTransTaxEntityFactoryForTest = new StockTransTaxEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer id = mockValues.nextInteger();
		
		StockTransTaxEntity stockTransTaxEntity = stockTransTaxJpaRepository.findOne(id);
		
		StockTransTax stockTransTax = stockTransTaxFactoryForTest.newStockTransTax();
		when(stockTransTaxServiceMapper.mapStockTransTaxEntityToStockTransTax(stockTransTaxEntity)).thenReturn(stockTransTax);

		// When
		StockTransTax stockTransTaxFound = stockTransTaxService.findById(id);

		// Then
		assertEquals(stockTransTax.getId(),stockTransTaxFound.getId());
	}

	@Test
	public void findAll() {
		// Given
		List<StockTransTaxEntity> stockTransTaxEntitys = new ArrayList<StockTransTaxEntity>();
		StockTransTaxEntity stockTransTaxEntity1 = stockTransTaxEntityFactoryForTest.newStockTransTaxEntity();
		stockTransTaxEntitys.add(stockTransTaxEntity1);
		StockTransTaxEntity stockTransTaxEntity2 = stockTransTaxEntityFactoryForTest.newStockTransTaxEntity();
		stockTransTaxEntitys.add(stockTransTaxEntity2);
		when(stockTransTaxJpaRepository.findAll()).thenReturn(stockTransTaxEntitys);
		
		StockTransTax stockTransTax1 = stockTransTaxFactoryForTest.newStockTransTax();
		when(stockTransTaxServiceMapper.mapStockTransTaxEntityToStockTransTax(stockTransTaxEntity1)).thenReturn(stockTransTax1);
		StockTransTax stockTransTax2 = stockTransTaxFactoryForTest.newStockTransTax();
		when(stockTransTaxServiceMapper.mapStockTransTaxEntityToStockTransTax(stockTransTaxEntity2)).thenReturn(stockTransTax2);

		// When
		List<StockTransTax> stockTransTaxsFounds = stockTransTaxService.findAll();

		// Then
		assertTrue(stockTransTax1 == stockTransTaxsFounds.get(0));
		assertTrue(stockTransTax2 == stockTransTaxsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		StockTransTax stockTransTax = stockTransTaxFactoryForTest.newStockTransTax();

		StockTransTaxEntity stockTransTaxEntity = stockTransTaxEntityFactoryForTest.newStockTransTaxEntity();
		when(stockTransTaxJpaRepository.findOne(stockTransTax.getId())).thenReturn(null);
		
		stockTransTaxEntity = new StockTransTaxEntity();
		stockTransTaxServiceMapper.mapStockTransTaxToStockTransTaxEntity(stockTransTax, stockTransTaxEntity);
		StockTransTaxEntity stockTransTaxEntitySaved = stockTransTaxJpaRepository.save(stockTransTaxEntity);
		
		StockTransTax stockTransTaxSaved = stockTransTaxFactoryForTest.newStockTransTax();
		when(stockTransTaxServiceMapper.mapStockTransTaxEntityToStockTransTax(stockTransTaxEntitySaved)).thenReturn(stockTransTaxSaved);

		// When
		StockTransTax stockTransTaxResult = stockTransTaxService.create(stockTransTax);

		// Then
		assertTrue(stockTransTaxResult == stockTransTaxSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		StockTransTax stockTransTax = stockTransTaxFactoryForTest.newStockTransTax();

		StockTransTaxEntity stockTransTaxEntity = stockTransTaxEntityFactoryForTest.newStockTransTaxEntity();
		when(stockTransTaxJpaRepository.findOne(stockTransTax.getId())).thenReturn(stockTransTaxEntity);

		// When
		Exception exception = null;
		try {
			stockTransTaxService.create(stockTransTax);
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
		StockTransTax stockTransTax = stockTransTaxFactoryForTest.newStockTransTax();

		StockTransTaxEntity stockTransTaxEntity = stockTransTaxEntityFactoryForTest.newStockTransTaxEntity();
		when(stockTransTaxJpaRepository.findOne(stockTransTax.getId())).thenReturn(stockTransTaxEntity);
		
		StockTransTaxEntity stockTransTaxEntitySaved = stockTransTaxEntityFactoryForTest.newStockTransTaxEntity();
		when(stockTransTaxJpaRepository.save(stockTransTaxEntity)).thenReturn(stockTransTaxEntitySaved);
		
		StockTransTax stockTransTaxSaved = stockTransTaxFactoryForTest.newStockTransTax();
		when(stockTransTaxServiceMapper.mapStockTransTaxEntityToStockTransTax(stockTransTaxEntitySaved)).thenReturn(stockTransTaxSaved);

		// When
		StockTransTax stockTransTaxResult = stockTransTaxService.update(stockTransTax);

		// Then
		verify(stockTransTaxServiceMapper).mapStockTransTaxToStockTransTaxEntity(stockTransTax, stockTransTaxEntity);
		assertTrue(stockTransTaxResult == stockTransTaxSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer id = mockValues.nextInteger();

		// When
		stockTransTaxService.delete(id);

		// Then
		verify(stockTransTaxJpaRepository).delete(id);
		
	}

}