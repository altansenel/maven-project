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

import org.demo.bean.OrderTrans;
import org.demo.bean.jpa.OrderTransEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.mapping.OrderTransServiceMapper;
import org.demo.data.repository.jpa.OrderTransJpaRepository;
import org.demo.test.OrderTransFactoryForTest;
import org.demo.test.OrderTransEntityFactoryForTest;
import org.demo.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of OrderTransService
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderTransServiceImplTest {

	@InjectMocks
	private OrderTransServiceImpl orderTransService;
	@Mock
	private OrderTransJpaRepository orderTransJpaRepository;
	@Mock
	private OrderTransServiceMapper orderTransServiceMapper;
	
	private OrderTransFactoryForTest orderTransFactoryForTest = new OrderTransFactoryForTest();

	private OrderTransEntityFactoryForTest orderTransEntityFactoryForTest = new OrderTransEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer id = mockValues.nextInteger();
		
		OrderTransEntity orderTransEntity = orderTransJpaRepository.findOne(id);
		
		OrderTrans orderTrans = orderTransFactoryForTest.newOrderTrans();
		when(orderTransServiceMapper.mapOrderTransEntityToOrderTrans(orderTransEntity)).thenReturn(orderTrans);

		// When
		OrderTrans orderTransFound = orderTransService.findById(id);

		// Then
		assertEquals(orderTrans.getId(),orderTransFound.getId());
	}

	@Test
	public void findAll() {
		// Given
		List<OrderTransEntity> orderTransEntitys = new ArrayList<OrderTransEntity>();
		OrderTransEntity orderTransEntity1 = orderTransEntityFactoryForTest.newOrderTransEntity();
		orderTransEntitys.add(orderTransEntity1);
		OrderTransEntity orderTransEntity2 = orderTransEntityFactoryForTest.newOrderTransEntity();
		orderTransEntitys.add(orderTransEntity2);
		when(orderTransJpaRepository.findAll()).thenReturn(orderTransEntitys);
		
		OrderTrans orderTrans1 = orderTransFactoryForTest.newOrderTrans();
		when(orderTransServiceMapper.mapOrderTransEntityToOrderTrans(orderTransEntity1)).thenReturn(orderTrans1);
		OrderTrans orderTrans2 = orderTransFactoryForTest.newOrderTrans();
		when(orderTransServiceMapper.mapOrderTransEntityToOrderTrans(orderTransEntity2)).thenReturn(orderTrans2);

		// When
		List<OrderTrans> orderTranssFounds = orderTransService.findAll();

		// Then
		assertTrue(orderTrans1 == orderTranssFounds.get(0));
		assertTrue(orderTrans2 == orderTranssFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		OrderTrans orderTrans = orderTransFactoryForTest.newOrderTrans();

		OrderTransEntity orderTransEntity = orderTransEntityFactoryForTest.newOrderTransEntity();
		when(orderTransJpaRepository.findOne(orderTrans.getId())).thenReturn(null);
		
		orderTransEntity = new OrderTransEntity();
		orderTransServiceMapper.mapOrderTransToOrderTransEntity(orderTrans, orderTransEntity);
		OrderTransEntity orderTransEntitySaved = orderTransJpaRepository.save(orderTransEntity);
		
		OrderTrans orderTransSaved = orderTransFactoryForTest.newOrderTrans();
		when(orderTransServiceMapper.mapOrderTransEntityToOrderTrans(orderTransEntitySaved)).thenReturn(orderTransSaved);

		// When
		OrderTrans orderTransResult = orderTransService.create(orderTrans);

		// Then
		assertTrue(orderTransResult == orderTransSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		OrderTrans orderTrans = orderTransFactoryForTest.newOrderTrans();

		OrderTransEntity orderTransEntity = orderTransEntityFactoryForTest.newOrderTransEntity();
		when(orderTransJpaRepository.findOne(orderTrans.getId())).thenReturn(orderTransEntity);

		// When
		Exception exception = null;
		try {
			orderTransService.create(orderTrans);
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
		OrderTrans orderTrans = orderTransFactoryForTest.newOrderTrans();

		OrderTransEntity orderTransEntity = orderTransEntityFactoryForTest.newOrderTransEntity();
		when(orderTransJpaRepository.findOne(orderTrans.getId())).thenReturn(orderTransEntity);
		
		OrderTransEntity orderTransEntitySaved = orderTransEntityFactoryForTest.newOrderTransEntity();
		when(orderTransJpaRepository.save(orderTransEntity)).thenReturn(orderTransEntitySaved);
		
		OrderTrans orderTransSaved = orderTransFactoryForTest.newOrderTrans();
		when(orderTransServiceMapper.mapOrderTransEntityToOrderTrans(orderTransEntitySaved)).thenReturn(orderTransSaved);

		// When
		OrderTrans orderTransResult = orderTransService.update(orderTrans);

		// Then
		verify(orderTransServiceMapper).mapOrderTransToOrderTransEntity(orderTrans, orderTransEntity);
		assertTrue(orderTransResult == orderTransSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer id = mockValues.nextInteger();

		// When
		orderTransService.delete(id);

		// Then
		verify(orderTransJpaRepository).delete(id);
		
	}

}
