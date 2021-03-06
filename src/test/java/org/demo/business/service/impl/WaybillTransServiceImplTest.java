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

import org.demo.bean.WaybillTrans;
import org.demo.bean.jpa.WaybillTransEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.mapping.WaybillTransServiceMapper;
import org.demo.data.repository.jpa.WaybillTransJpaRepository;
import org.demo.test.WaybillTransFactoryForTest;
import org.demo.test.WaybillTransEntityFactoryForTest;
import org.demo.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of WaybillTransService
 */
@RunWith(MockitoJUnitRunner.class)
public class WaybillTransServiceImplTest {

	@InjectMocks
	private WaybillTransServiceImpl waybillTransService;
	@Mock
	private WaybillTransJpaRepository waybillTransJpaRepository;
	@Mock
	private WaybillTransServiceMapper waybillTransServiceMapper;
	
	private WaybillTransFactoryForTest waybillTransFactoryForTest = new WaybillTransFactoryForTest();

	private WaybillTransEntityFactoryForTest waybillTransEntityFactoryForTest = new WaybillTransEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer id = mockValues.nextInteger();
		
		WaybillTransEntity waybillTransEntity = waybillTransJpaRepository.findOne(id);
		
		WaybillTrans waybillTrans = waybillTransFactoryForTest.newWaybillTrans();
		when(waybillTransServiceMapper.mapWaybillTransEntityToWaybillTrans(waybillTransEntity)).thenReturn(waybillTrans);

		// When
		WaybillTrans waybillTransFound = waybillTransService.findById(id);

		// Then
		assertEquals(waybillTrans.getId(),waybillTransFound.getId());
	}

	@Test
	public void findAll() {
		// Given
		List<WaybillTransEntity> waybillTransEntitys = new ArrayList<WaybillTransEntity>();
		WaybillTransEntity waybillTransEntity1 = waybillTransEntityFactoryForTest.newWaybillTransEntity();
		waybillTransEntitys.add(waybillTransEntity1);
		WaybillTransEntity waybillTransEntity2 = waybillTransEntityFactoryForTest.newWaybillTransEntity();
		waybillTransEntitys.add(waybillTransEntity2);
		when(waybillTransJpaRepository.findAll()).thenReturn(waybillTransEntitys);
		
		WaybillTrans waybillTrans1 = waybillTransFactoryForTest.newWaybillTrans();
		when(waybillTransServiceMapper.mapWaybillTransEntityToWaybillTrans(waybillTransEntity1)).thenReturn(waybillTrans1);
		WaybillTrans waybillTrans2 = waybillTransFactoryForTest.newWaybillTrans();
		when(waybillTransServiceMapper.mapWaybillTransEntityToWaybillTrans(waybillTransEntity2)).thenReturn(waybillTrans2);

		// When
		List<WaybillTrans> waybillTranssFounds = waybillTransService.findAll();

		// Then
		assertTrue(waybillTrans1 == waybillTranssFounds.get(0));
		assertTrue(waybillTrans2 == waybillTranssFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		WaybillTrans waybillTrans = waybillTransFactoryForTest.newWaybillTrans();

		WaybillTransEntity waybillTransEntity = waybillTransEntityFactoryForTest.newWaybillTransEntity();
		when(waybillTransJpaRepository.findOne(waybillTrans.getId())).thenReturn(null);
		
		waybillTransEntity = new WaybillTransEntity();
		waybillTransServiceMapper.mapWaybillTransToWaybillTransEntity(waybillTrans, waybillTransEntity);
		WaybillTransEntity waybillTransEntitySaved = waybillTransJpaRepository.save(waybillTransEntity);
		
		WaybillTrans waybillTransSaved = waybillTransFactoryForTest.newWaybillTrans();
		when(waybillTransServiceMapper.mapWaybillTransEntityToWaybillTrans(waybillTransEntitySaved)).thenReturn(waybillTransSaved);

		// When
		WaybillTrans waybillTransResult = waybillTransService.create(waybillTrans);

		// Then
		assertTrue(waybillTransResult == waybillTransSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		WaybillTrans waybillTrans = waybillTransFactoryForTest.newWaybillTrans();

		WaybillTransEntity waybillTransEntity = waybillTransEntityFactoryForTest.newWaybillTransEntity();
		when(waybillTransJpaRepository.findOne(waybillTrans.getId())).thenReturn(waybillTransEntity);

		// When
		Exception exception = null;
		try {
			waybillTransService.create(waybillTrans);
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
		WaybillTrans waybillTrans = waybillTransFactoryForTest.newWaybillTrans();

		WaybillTransEntity waybillTransEntity = waybillTransEntityFactoryForTest.newWaybillTransEntity();
		when(waybillTransJpaRepository.findOne(waybillTrans.getId())).thenReturn(waybillTransEntity);
		
		WaybillTransEntity waybillTransEntitySaved = waybillTransEntityFactoryForTest.newWaybillTransEntity();
		when(waybillTransJpaRepository.save(waybillTransEntity)).thenReturn(waybillTransEntitySaved);
		
		WaybillTrans waybillTransSaved = waybillTransFactoryForTest.newWaybillTrans();
		when(waybillTransServiceMapper.mapWaybillTransEntityToWaybillTrans(waybillTransEntitySaved)).thenReturn(waybillTransSaved);

		// When
		WaybillTrans waybillTransResult = waybillTransService.update(waybillTrans);

		// Then
		verify(waybillTransServiceMapper).mapWaybillTransToWaybillTransEntity(waybillTrans, waybillTransEntity);
		assertTrue(waybillTransResult == waybillTransSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer id = mockValues.nextInteger();

		// When
		waybillTransService.delete(id);

		// Then
		verify(waybillTransJpaRepository).delete(id);
		
	}

}
