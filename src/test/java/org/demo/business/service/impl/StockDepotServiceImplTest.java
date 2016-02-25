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

import org.demo.bean.StockDepot;
import org.demo.bean.jpa.StockDepotEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.mapping.StockDepotServiceMapper;
import org.demo.data.repository.jpa.StockDepotJpaRepository;
import org.demo.test.StockDepotFactoryForTest;
import org.demo.test.StockDepotEntityFactoryForTest;
import org.demo.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of StockDepotService
 */
@RunWith(MockitoJUnitRunner.class)
public class StockDepotServiceImplTest {

	@InjectMocks
	private StockDepotServiceImpl stockDepotService;
	@Mock
	private StockDepotJpaRepository stockDepotJpaRepository;
	@Mock
	private StockDepotServiceMapper stockDepotServiceMapper;
	
	private StockDepotFactoryForTest stockDepotFactoryForTest = new StockDepotFactoryForTest();

	private StockDepotEntityFactoryForTest stockDepotEntityFactoryForTest = new StockDepotEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer id = mockValues.nextInteger();
		
		StockDepotEntity stockDepotEntity = stockDepotJpaRepository.findOne(id);
		
		StockDepot stockDepot = stockDepotFactoryForTest.newStockDepot();
		when(stockDepotServiceMapper.mapStockDepotEntityToStockDepot(stockDepotEntity)).thenReturn(stockDepot);

		// When
		StockDepot stockDepotFound = stockDepotService.findById(id);

		// Then
		assertEquals(stockDepot.getId(),stockDepotFound.getId());
	}

	@Test
	public void findAll() {
		// Given
		List<StockDepotEntity> stockDepotEntitys = new ArrayList<StockDepotEntity>();
		StockDepotEntity stockDepotEntity1 = stockDepotEntityFactoryForTest.newStockDepotEntity();
		stockDepotEntitys.add(stockDepotEntity1);
		StockDepotEntity stockDepotEntity2 = stockDepotEntityFactoryForTest.newStockDepotEntity();
		stockDepotEntitys.add(stockDepotEntity2);
		when(stockDepotJpaRepository.findAll()).thenReturn(stockDepotEntitys);
		
		StockDepot stockDepot1 = stockDepotFactoryForTest.newStockDepot();
		when(stockDepotServiceMapper.mapStockDepotEntityToStockDepot(stockDepotEntity1)).thenReturn(stockDepot1);
		StockDepot stockDepot2 = stockDepotFactoryForTest.newStockDepot();
		when(stockDepotServiceMapper.mapStockDepotEntityToStockDepot(stockDepotEntity2)).thenReturn(stockDepot2);

		// When
		List<StockDepot> stockDepotsFounds = stockDepotService.findAll();

		// Then
		assertTrue(stockDepot1 == stockDepotsFounds.get(0));
		assertTrue(stockDepot2 == stockDepotsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		StockDepot stockDepot = stockDepotFactoryForTest.newStockDepot();

		StockDepotEntity stockDepotEntity = stockDepotEntityFactoryForTest.newStockDepotEntity();
		when(stockDepotJpaRepository.findOne(stockDepot.getId())).thenReturn(null);
		
		stockDepotEntity = new StockDepotEntity();
		stockDepotServiceMapper.mapStockDepotToStockDepotEntity(stockDepot, stockDepotEntity);
		StockDepotEntity stockDepotEntitySaved = stockDepotJpaRepository.save(stockDepotEntity);
		
		StockDepot stockDepotSaved = stockDepotFactoryForTest.newStockDepot();
		when(stockDepotServiceMapper.mapStockDepotEntityToStockDepot(stockDepotEntitySaved)).thenReturn(stockDepotSaved);

		// When
		StockDepot stockDepotResult = stockDepotService.create(stockDepot);

		// Then
		assertTrue(stockDepotResult == stockDepotSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		StockDepot stockDepot = stockDepotFactoryForTest.newStockDepot();

		StockDepotEntity stockDepotEntity = stockDepotEntityFactoryForTest.newStockDepotEntity();
		when(stockDepotJpaRepository.findOne(stockDepot.getId())).thenReturn(stockDepotEntity);

		// When
		Exception exception = null;
		try {
			stockDepotService.create(stockDepot);
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
		StockDepot stockDepot = stockDepotFactoryForTest.newStockDepot();

		StockDepotEntity stockDepotEntity = stockDepotEntityFactoryForTest.newStockDepotEntity();
		when(stockDepotJpaRepository.findOne(stockDepot.getId())).thenReturn(stockDepotEntity);
		
		StockDepotEntity stockDepotEntitySaved = stockDepotEntityFactoryForTest.newStockDepotEntity();
		when(stockDepotJpaRepository.save(stockDepotEntity)).thenReturn(stockDepotEntitySaved);
		
		StockDepot stockDepotSaved = stockDepotFactoryForTest.newStockDepot();
		when(stockDepotServiceMapper.mapStockDepotEntityToStockDepot(stockDepotEntitySaved)).thenReturn(stockDepotSaved);

		// When
		StockDepot stockDepotResult = stockDepotService.update(stockDepot);

		// Then
		verify(stockDepotServiceMapper).mapStockDepotToStockDepotEntity(stockDepot, stockDepotEntity);
		assertTrue(stockDepotResult == stockDepotSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer id = mockValues.nextInteger();

		// When
		stockDepotService.delete(id);

		// Then
		verify(stockDepotJpaRepository).delete(id);
		
	}

}