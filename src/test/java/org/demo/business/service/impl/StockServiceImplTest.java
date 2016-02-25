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

import org.demo.bean.Stock;
import org.demo.bean.jpa.StockEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.mapping.StockServiceMapper;
import org.demo.data.repository.jpa.StockJpaRepository;
import org.demo.test.StockFactoryForTest;
import org.demo.test.StockEntityFactoryForTest;
import org.demo.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of StockService
 */
@RunWith(MockitoJUnitRunner.class)
public class StockServiceImplTest {

	@InjectMocks
	private StockServiceImpl stockService;
	@Mock
	private StockJpaRepository stockJpaRepository;
	@Mock
	private StockServiceMapper stockServiceMapper;
	
	private StockFactoryForTest stockFactoryForTest = new StockFactoryForTest();

	private StockEntityFactoryForTest stockEntityFactoryForTest = new StockEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer id = mockValues.nextInteger();
		
		StockEntity stockEntity = stockJpaRepository.findOne(id);
		
		Stock stock = stockFactoryForTest.newStock();
		when(stockServiceMapper.mapStockEntityToStock(stockEntity)).thenReturn(stock);

		// When
		Stock stockFound = stockService.findById(id);

		// Then
		assertEquals(stock.getId(),stockFound.getId());
	}

	@Test
	public void findAll() {
		// Given
		List<StockEntity> stockEntitys = new ArrayList<StockEntity>();
		StockEntity stockEntity1 = stockEntityFactoryForTest.newStockEntity();
		stockEntitys.add(stockEntity1);
		StockEntity stockEntity2 = stockEntityFactoryForTest.newStockEntity();
		stockEntitys.add(stockEntity2);
		when(stockJpaRepository.findAll()).thenReturn(stockEntitys);
		
		Stock stock1 = stockFactoryForTest.newStock();
		when(stockServiceMapper.mapStockEntityToStock(stockEntity1)).thenReturn(stock1);
		Stock stock2 = stockFactoryForTest.newStock();
		when(stockServiceMapper.mapStockEntityToStock(stockEntity2)).thenReturn(stock2);

		// When
		List<Stock> stocksFounds = stockService.findAll();

		// Then
		assertTrue(stock1 == stocksFounds.get(0));
		assertTrue(stock2 == stocksFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		Stock stock = stockFactoryForTest.newStock();

		StockEntity stockEntity = stockEntityFactoryForTest.newStockEntity();
		when(stockJpaRepository.findOne(stock.getId())).thenReturn(null);
		
		stockEntity = new StockEntity();
		stockServiceMapper.mapStockToStockEntity(stock, stockEntity);
		StockEntity stockEntitySaved = stockJpaRepository.save(stockEntity);
		
		Stock stockSaved = stockFactoryForTest.newStock();
		when(stockServiceMapper.mapStockEntityToStock(stockEntitySaved)).thenReturn(stockSaved);

		// When
		Stock stockResult = stockService.create(stock);

		// Then
		assertTrue(stockResult == stockSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		Stock stock = stockFactoryForTest.newStock();

		StockEntity stockEntity = stockEntityFactoryForTest.newStockEntity();
		when(stockJpaRepository.findOne(stock.getId())).thenReturn(stockEntity);

		// When
		Exception exception = null;
		try {
			stockService.create(stock);
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
		Stock stock = stockFactoryForTest.newStock();

		StockEntity stockEntity = stockEntityFactoryForTest.newStockEntity();
		when(stockJpaRepository.findOne(stock.getId())).thenReturn(stockEntity);
		
		StockEntity stockEntitySaved = stockEntityFactoryForTest.newStockEntity();
		when(stockJpaRepository.save(stockEntity)).thenReturn(stockEntitySaved);
		
		Stock stockSaved = stockFactoryForTest.newStock();
		when(stockServiceMapper.mapStockEntityToStock(stockEntitySaved)).thenReturn(stockSaved);

		// When
		Stock stockResult = stockService.update(stock);

		// Then
		verify(stockServiceMapper).mapStockToStockEntity(stock, stockEntity);
		assertTrue(stockResult == stockSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer id = mockValues.nextInteger();

		// When
		stockService.delete(id);

		// Then
		verify(stockJpaRepository).delete(id);
		
	}

}
