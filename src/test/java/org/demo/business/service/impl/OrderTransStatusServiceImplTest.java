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

import org.demo.bean.OrderTransStatus;
import org.demo.bean.jpa.OrderTransStatusEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.mapping.OrderTransStatusServiceMapper;
import org.demo.data.repository.jpa.OrderTransStatusJpaRepository;
import org.demo.test.OrderTransStatusFactoryForTest;
import org.demo.test.OrderTransStatusEntityFactoryForTest;
import org.demo.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of OrderTransStatusService
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderTransStatusServiceImplTest {

	@InjectMocks
	private OrderTransStatusServiceImpl orderTransStatusService;
	@Mock
	private OrderTransStatusJpaRepository orderTransStatusJpaRepository;
	@Mock
	private OrderTransStatusServiceMapper orderTransStatusServiceMapper;
	
	private OrderTransStatusFactoryForTest orderTransStatusFactoryForTest = new OrderTransStatusFactoryForTest();

	private OrderTransStatusEntityFactoryForTest orderTransStatusEntityFactoryForTest = new OrderTransStatusEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer id = mockValues.nextInteger();
		
		OrderTransStatusEntity orderTransStatusEntity = orderTransStatusJpaRepository.findOne(id);
		
		OrderTransStatus orderTransStatus = orderTransStatusFactoryForTest.newOrderTransStatus();
		when(orderTransStatusServiceMapper.mapOrderTransStatusEntityToOrderTransStatus(orderTransStatusEntity)).thenReturn(orderTransStatus);

		// When
		OrderTransStatus orderTransStatusFound = orderTransStatusService.findById(id);

		// Then
		assertEquals(orderTransStatus.getId(),orderTransStatusFound.getId());
	}

	@Test
	public void findAll() {
		// Given
		List<OrderTransStatusEntity> orderTransStatusEntitys = new ArrayList<OrderTransStatusEntity>();
		OrderTransStatusEntity orderTransStatusEntity1 = orderTransStatusEntityFactoryForTest.newOrderTransStatusEntity();
		orderTransStatusEntitys.add(orderTransStatusEntity1);
		OrderTransStatusEntity orderTransStatusEntity2 = orderTransStatusEntityFactoryForTest.newOrderTransStatusEntity();
		orderTransStatusEntitys.add(orderTransStatusEntity2);
		when(orderTransStatusJpaRepository.findAll()).thenReturn(orderTransStatusEntitys);
		
		OrderTransStatus orderTransStatus1 = orderTransStatusFactoryForTest.newOrderTransStatus();
		when(orderTransStatusServiceMapper.mapOrderTransStatusEntityToOrderTransStatus(orderTransStatusEntity1)).thenReturn(orderTransStatus1);
		OrderTransStatus orderTransStatus2 = orderTransStatusFactoryForTest.newOrderTransStatus();
		when(orderTransStatusServiceMapper.mapOrderTransStatusEntityToOrderTransStatus(orderTransStatusEntity2)).thenReturn(orderTransStatus2);

		// When
		List<OrderTransStatus> orderTransStatussFounds = orderTransStatusService.findAll();

		// Then
		assertTrue(orderTransStatus1 == orderTransStatussFounds.get(0));
		assertTrue(orderTransStatus2 == orderTransStatussFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		OrderTransStatus orderTransStatus = orderTransStatusFactoryForTest.newOrderTransStatus();

		OrderTransStatusEntity orderTransStatusEntity = orderTransStatusEntityFactoryForTest.newOrderTransStatusEntity();
		when(orderTransStatusJpaRepository.findOne(orderTransStatus.getId())).thenReturn(null);
		
		orderTransStatusEntity = new OrderTransStatusEntity();
		orderTransStatusServiceMapper.mapOrderTransStatusToOrderTransStatusEntity(orderTransStatus, orderTransStatusEntity);
		OrderTransStatusEntity orderTransStatusEntitySaved = orderTransStatusJpaRepository.save(orderTransStatusEntity);
		
		OrderTransStatus orderTransStatusSaved = orderTransStatusFactoryForTest.newOrderTransStatus();
		when(orderTransStatusServiceMapper.mapOrderTransStatusEntityToOrderTransStatus(orderTransStatusEntitySaved)).thenReturn(orderTransStatusSaved);

		// When
		OrderTransStatus orderTransStatusResult = orderTransStatusService.create(orderTransStatus);

		// Then
		assertTrue(orderTransStatusResult == orderTransStatusSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		OrderTransStatus orderTransStatus = orderTransStatusFactoryForTest.newOrderTransStatus();

		OrderTransStatusEntity orderTransStatusEntity = orderTransStatusEntityFactoryForTest.newOrderTransStatusEntity();
		when(orderTransStatusJpaRepository.findOne(orderTransStatus.getId())).thenReturn(orderTransStatusEntity);

		// When
		Exception exception = null;
		try {
			orderTransStatusService.create(orderTransStatus);
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
		OrderTransStatus orderTransStatus = orderTransStatusFactoryForTest.newOrderTransStatus();

		OrderTransStatusEntity orderTransStatusEntity = orderTransStatusEntityFactoryForTest.newOrderTransStatusEntity();
		when(orderTransStatusJpaRepository.findOne(orderTransStatus.getId())).thenReturn(orderTransStatusEntity);
		
		OrderTransStatusEntity orderTransStatusEntitySaved = orderTransStatusEntityFactoryForTest.newOrderTransStatusEntity();
		when(orderTransStatusJpaRepository.save(orderTransStatusEntity)).thenReturn(orderTransStatusEntitySaved);
		
		OrderTransStatus orderTransStatusSaved = orderTransStatusFactoryForTest.newOrderTransStatus();
		when(orderTransStatusServiceMapper.mapOrderTransStatusEntityToOrderTransStatus(orderTransStatusEntitySaved)).thenReturn(orderTransStatusSaved);

		// When
		OrderTransStatus orderTransStatusResult = orderTransStatusService.update(orderTransStatus);

		// Then
		verify(orderTransStatusServiceMapper).mapOrderTransStatusToOrderTransStatusEntity(orderTransStatus, orderTransStatusEntity);
		assertTrue(orderTransStatusResult == orderTransStatusSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer id = mockValues.nextInteger();

		// When
		orderTransStatusService.delete(id);

		// Then
		verify(orderTransStatusJpaRepository).delete(id);
		
	}

}
