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

import org.demo.bean.OrderTransDetail;
import org.demo.bean.jpa.OrderTransDetailEntity;
import java.util.Date;
import org.demo.business.service.mapping.OrderTransDetailServiceMapper;
import org.demo.data.repository.jpa.OrderTransDetailJpaRepository;
import org.demo.test.OrderTransDetailFactoryForTest;
import org.demo.test.OrderTransDetailEntityFactoryForTest;
import org.demo.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of OrderTransDetailService
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderTransDetailServiceImplTest {

	@InjectMocks
	private OrderTransDetailServiceImpl orderTransDetailService;
	@Mock
	private OrderTransDetailJpaRepository orderTransDetailJpaRepository;
	@Mock
	private OrderTransDetailServiceMapper orderTransDetailServiceMapper;
	
	private OrderTransDetailFactoryForTest orderTransDetailFactoryForTest = new OrderTransDetailFactoryForTest();

	private OrderTransDetailEntityFactoryForTest orderTransDetailEntityFactoryForTest = new OrderTransDetailEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer id = mockValues.nextInteger();
		
		OrderTransDetailEntity orderTransDetailEntity = orderTransDetailJpaRepository.findOne(id);
		
		OrderTransDetail orderTransDetail = orderTransDetailFactoryForTest.newOrderTransDetail();
		when(orderTransDetailServiceMapper.mapOrderTransDetailEntityToOrderTransDetail(orderTransDetailEntity)).thenReturn(orderTransDetail);

		// When
		OrderTransDetail orderTransDetailFound = orderTransDetailService.findById(id);

		// Then
		assertEquals(orderTransDetail.getId(),orderTransDetailFound.getId());
	}

	@Test
	public void findAll() {
		// Given
		List<OrderTransDetailEntity> orderTransDetailEntitys = new ArrayList<OrderTransDetailEntity>();
		OrderTransDetailEntity orderTransDetailEntity1 = orderTransDetailEntityFactoryForTest.newOrderTransDetailEntity();
		orderTransDetailEntitys.add(orderTransDetailEntity1);
		OrderTransDetailEntity orderTransDetailEntity2 = orderTransDetailEntityFactoryForTest.newOrderTransDetailEntity();
		orderTransDetailEntitys.add(orderTransDetailEntity2);
		when(orderTransDetailJpaRepository.findAll()).thenReturn(orderTransDetailEntitys);
		
		OrderTransDetail orderTransDetail1 = orderTransDetailFactoryForTest.newOrderTransDetail();
		when(orderTransDetailServiceMapper.mapOrderTransDetailEntityToOrderTransDetail(orderTransDetailEntity1)).thenReturn(orderTransDetail1);
		OrderTransDetail orderTransDetail2 = orderTransDetailFactoryForTest.newOrderTransDetail();
		when(orderTransDetailServiceMapper.mapOrderTransDetailEntityToOrderTransDetail(orderTransDetailEntity2)).thenReturn(orderTransDetail2);

		// When
		List<OrderTransDetail> orderTransDetailsFounds = orderTransDetailService.findAll();

		// Then
		assertTrue(orderTransDetail1 == orderTransDetailsFounds.get(0));
		assertTrue(orderTransDetail2 == orderTransDetailsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		OrderTransDetail orderTransDetail = orderTransDetailFactoryForTest.newOrderTransDetail();

		OrderTransDetailEntity orderTransDetailEntity = orderTransDetailEntityFactoryForTest.newOrderTransDetailEntity();
		when(orderTransDetailJpaRepository.findOne(orderTransDetail.getId())).thenReturn(null);
		
		orderTransDetailEntity = new OrderTransDetailEntity();
		orderTransDetailServiceMapper.mapOrderTransDetailToOrderTransDetailEntity(orderTransDetail, orderTransDetailEntity);
		OrderTransDetailEntity orderTransDetailEntitySaved = orderTransDetailJpaRepository.save(orderTransDetailEntity);
		
		OrderTransDetail orderTransDetailSaved = orderTransDetailFactoryForTest.newOrderTransDetail();
		when(orderTransDetailServiceMapper.mapOrderTransDetailEntityToOrderTransDetail(orderTransDetailEntitySaved)).thenReturn(orderTransDetailSaved);

		// When
		OrderTransDetail orderTransDetailResult = orderTransDetailService.create(orderTransDetail);

		// Then
		assertTrue(orderTransDetailResult == orderTransDetailSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		OrderTransDetail orderTransDetail = orderTransDetailFactoryForTest.newOrderTransDetail();

		OrderTransDetailEntity orderTransDetailEntity = orderTransDetailEntityFactoryForTest.newOrderTransDetailEntity();
		when(orderTransDetailJpaRepository.findOne(orderTransDetail.getId())).thenReturn(orderTransDetailEntity);

		// When
		Exception exception = null;
		try {
			orderTransDetailService.create(orderTransDetail);
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
		OrderTransDetail orderTransDetail = orderTransDetailFactoryForTest.newOrderTransDetail();

		OrderTransDetailEntity orderTransDetailEntity = orderTransDetailEntityFactoryForTest.newOrderTransDetailEntity();
		when(orderTransDetailJpaRepository.findOne(orderTransDetail.getId())).thenReturn(orderTransDetailEntity);
		
		OrderTransDetailEntity orderTransDetailEntitySaved = orderTransDetailEntityFactoryForTest.newOrderTransDetailEntity();
		when(orderTransDetailJpaRepository.save(orderTransDetailEntity)).thenReturn(orderTransDetailEntitySaved);
		
		OrderTransDetail orderTransDetailSaved = orderTransDetailFactoryForTest.newOrderTransDetail();
		when(orderTransDetailServiceMapper.mapOrderTransDetailEntityToOrderTransDetail(orderTransDetailEntitySaved)).thenReturn(orderTransDetailSaved);

		// When
		OrderTransDetail orderTransDetailResult = orderTransDetailService.update(orderTransDetail);

		// Then
		verify(orderTransDetailServiceMapper).mapOrderTransDetailToOrderTransDetailEntity(orderTransDetail, orderTransDetailEntity);
		assertTrue(orderTransDetailResult == orderTransDetailSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer id = mockValues.nextInteger();

		// When
		orderTransDetailService.delete(id);

		// Then
		verify(orderTransDetailJpaRepository).delete(id);
		
	}

}
