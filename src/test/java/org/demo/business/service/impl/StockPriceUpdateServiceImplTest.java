/*
 * Created on 24 �ub 2016 ( Time 16:27:52 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.demo.bean.StockPriceUpdate;
import org.demo.bean.jpa.StockPriceUpdateEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.mapping.StockPriceUpdateServiceMapper;
import org.demo.data.repository.jpa.StockPriceUpdateJpaRepository;
import org.demo.test.StockPriceUpdateFactoryForTest;
import org.demo.test.StockPriceUpdateEntityFactoryForTest;
import org.demo.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of StockPriceUpdateService
 */
@RunWith(MockitoJUnitRunner.class)
public class StockPriceUpdateServiceImplTest {

	@InjectMocks
	private StockPriceUpdateServiceImpl stockPriceUpdateService;
	@Mock
	private StockPriceUpdateJpaRepository stockPriceUpdateJpaRepository;
	@Mock
	private StockPriceUpdateServiceMapper stockPriceUpdateServiceMapper;
	
	private StockPriceUpdateFactoryForTest stockPriceUpdateFactoryForTest = new StockPriceUpdateFactoryForTest();

	private StockPriceUpdateEntityFactoryForTest stockPriceUpdateEntityFactoryForTest = new StockPriceUpdateEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer id = mockValues.nextInteger();
		
		StockPriceUpdateEntity stockPriceUpdateEntity = stockPriceUpdateJpaRepository.findOne(id);
		
		StockPriceUpdate stockPriceUpdate = stockPriceUpdateFactoryForTest.newStockPriceUpdate();
		when(stockPriceUpdateServiceMapper.mapStockPriceUpdateEntityToStockPriceUpdate(stockPriceUpdateEntity)).thenReturn(stockPriceUpdate);

		// When
		StockPriceUpdate stockPriceUpdateFound = stockPriceUpdateService.findById(id);

		// Then
		assertEquals(stockPriceUpdate.getId(),stockPriceUpdateFound.getId());
	}

	@Test
	public void findAll() {
		// Given
		List<StockPriceUpdateEntity> stockPriceUpdateEntitys = new ArrayList<StockPriceUpdateEntity>();
		StockPriceUpdateEntity stockPriceUpdateEntity1 = stockPriceUpdateEntityFactoryForTest.newStockPriceUpdateEntity();
		stockPriceUpdateEntitys.add(stockPriceUpdateEntity1);
		StockPriceUpdateEntity stockPriceUpdateEntity2 = stockPriceUpdateEntityFactoryForTest.newStockPriceUpdateEntity();
		stockPriceUpdateEntitys.add(stockPriceUpdateEntity2);
		when(stockPriceUpdateJpaRepository.findAll()).thenReturn(stockPriceUpdateEntitys);
		
		StockPriceUpdate stockPriceUpdate1 = stockPriceUpdateFactoryForTest.newStockPriceUpdate();
		when(stockPriceUpdateServiceMapper.mapStockPriceUpdateEntityToStockPriceUpdate(stockPriceUpdateEntity1)).thenReturn(stockPriceUpdate1);
		StockPriceUpdate stockPriceUpdate2 = stockPriceUpdateFactoryForTest.newStockPriceUpdate();
		when(stockPriceUpdateServiceMapper.mapStockPriceUpdateEntityToStockPriceUpdate(stockPriceUpdateEntity2)).thenReturn(stockPriceUpdate2);

		// When
		List<StockPriceUpdate> stockPriceUpdatesFounds = stockPriceUpdateService.findAll();

		// Then
		assertTrue(stockPriceUpdate1 == stockPriceUpdatesFounds.get(0));
		assertTrue(stockPriceUpdate2 == stockPriceUpdatesFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		StockPriceUpdate stockPriceUpdate = stockPriceUpdateFactoryForTest.newStockPriceUpdate();

		StockPriceUpdateEntity stockPriceUpdateEntity = stockPriceUpdateEntityFactoryForTest.newStockPriceUpdateEntity();
		when(stockPriceUpdateJpaRepository.findOne(stockPriceUpdate.getId())).thenReturn(null);
		
		stockPriceUpdateEntity = new StockPriceUpdateEntity();
		stockPriceUpdateServiceMapper.mapStockPriceUpdateToStockPriceUpdateEntity(stockPriceUpdate, stockPriceUpdateEntity);
		StockPriceUpdateEntity stockPriceUpdateEntitySaved = stockPriceUpdateJpaRepository.save(stockPriceUpdateEntity);
		
		StockPriceUpdate stockPriceUpdateSaved = stockPriceUpdateFactoryForTest.newStockPriceUpdate();
		when(stockPriceUpdateServiceMapper.mapStockPriceUpdateEntityToStockPriceUpdate(stockPriceUpdateEntitySaved)).thenReturn(stockPriceUpdateSaved);

		// When
		StockPriceUpdate stockPriceUpdateResult = stockPriceUpdateService.create(stockPriceUpdate);

		// Then
		assertTrue(stockPriceUpdateResult == stockPriceUpdateSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		StockPriceUpdate stockPriceUpdate = stockPriceUpdateFactoryForTest.newStockPriceUpdate();

		StockPriceUpdateEntity stockPriceUpdateEntity = stockPriceUpdateEntityFactoryForTest.newStockPriceUpdateEntity();
		when(stockPriceUpdateJpaRepository.findOne(stockPriceUpdate.getId())).thenReturn(stockPriceUpdateEntity);

		// When
		Exception exception = null;
		try {
			stockPriceUpdateService.create(stockPriceUpdate);
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
		StockPriceUpdate stockPriceUpdate = stockPriceUpdateFactoryForTest.newStockPriceUpdate();

		StockPriceUpdateEntity stockPriceUpdateEntity = stockPriceUpdateEntityFactoryForTest.newStockPriceUpdateEntity();
		when(stockPriceUpdateJpaRepository.findOne(stockPriceUpdate.getId())).thenReturn(stockPriceUpdateEntity);
		
		StockPriceUpdateEntity stockPriceUpdateEntitySaved = stockPriceUpdateEntityFactoryForTest.newStockPriceUpdateEntity();
		when(stockPriceUpdateJpaRepository.save(stockPriceUpdateEntity)).thenReturn(stockPriceUpdateEntitySaved);
		
		StockPriceUpdate stockPriceUpdateSaved = stockPriceUpdateFactoryForTest.newStockPriceUpdate();
		when(stockPriceUpdateServiceMapper.mapStockPriceUpdateEntityToStockPriceUpdate(stockPriceUpdateEntitySaved)).thenReturn(stockPriceUpdateSaved);

		// When
		StockPriceUpdate stockPriceUpdateResult = stockPriceUpdateService.update(stockPriceUpdate);

		// Then
		verify(stockPriceUpdateServiceMapper).mapStockPriceUpdateToStockPriceUpdateEntity(stockPriceUpdate, stockPriceUpdateEntity);
		assertTrue(stockPriceUpdateResult == stockPriceUpdateSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer id = mockValues.nextInteger();

		// When
		stockPriceUpdateService.delete(id);

		// Then
		verify(stockPriceUpdateJpaRepository).delete(id);
		
	}

}