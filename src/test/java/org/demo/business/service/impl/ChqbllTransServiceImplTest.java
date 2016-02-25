/*
 * Created on 24 �ub 2016 ( Time 16:27:50 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.demo.bean.ChqbllTrans;
import org.demo.bean.jpa.ChqbllTransEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.mapping.ChqbllTransServiceMapper;
import org.demo.data.repository.jpa.ChqbllTransJpaRepository;
import org.demo.test.ChqbllTransFactoryForTest;
import org.demo.test.ChqbllTransEntityFactoryForTest;
import org.demo.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of ChqbllTransService
 */
@RunWith(MockitoJUnitRunner.class)
public class ChqbllTransServiceImplTest {

	@InjectMocks
	private ChqbllTransServiceImpl chqbllTransService;
	@Mock
	private ChqbllTransJpaRepository chqbllTransJpaRepository;
	@Mock
	private ChqbllTransServiceMapper chqbllTransServiceMapper;
	
	private ChqbllTransFactoryForTest chqbllTransFactoryForTest = new ChqbllTransFactoryForTest();

	private ChqbllTransEntityFactoryForTest chqbllTransEntityFactoryForTest = new ChqbllTransEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer id = mockValues.nextInteger();
		
		ChqbllTransEntity chqbllTransEntity = chqbllTransJpaRepository.findOne(id);
		
		ChqbllTrans chqbllTrans = chqbllTransFactoryForTest.newChqbllTrans();
		when(chqbllTransServiceMapper.mapChqbllTransEntityToChqbllTrans(chqbllTransEntity)).thenReturn(chqbllTrans);

		// When
		ChqbllTrans chqbllTransFound = chqbllTransService.findById(id);

		// Then
		assertEquals(chqbllTrans.getId(),chqbllTransFound.getId());
	}

	@Test
	public void findAll() {
		// Given
		List<ChqbllTransEntity> chqbllTransEntitys = new ArrayList<ChqbllTransEntity>();
		ChqbllTransEntity chqbllTransEntity1 = chqbllTransEntityFactoryForTest.newChqbllTransEntity();
		chqbllTransEntitys.add(chqbllTransEntity1);
		ChqbllTransEntity chqbllTransEntity2 = chqbllTransEntityFactoryForTest.newChqbllTransEntity();
		chqbllTransEntitys.add(chqbllTransEntity2);
		when(chqbllTransJpaRepository.findAll()).thenReturn(chqbllTransEntitys);
		
		ChqbllTrans chqbllTrans1 = chqbllTransFactoryForTest.newChqbllTrans();
		when(chqbllTransServiceMapper.mapChqbllTransEntityToChqbllTrans(chqbllTransEntity1)).thenReturn(chqbllTrans1);
		ChqbllTrans chqbllTrans2 = chqbllTransFactoryForTest.newChqbllTrans();
		when(chqbllTransServiceMapper.mapChqbllTransEntityToChqbllTrans(chqbllTransEntity2)).thenReturn(chqbllTrans2);

		// When
		List<ChqbllTrans> chqbllTranssFounds = chqbllTransService.findAll();

		// Then
		assertTrue(chqbllTrans1 == chqbllTranssFounds.get(0));
		assertTrue(chqbllTrans2 == chqbllTranssFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		ChqbllTrans chqbllTrans = chqbllTransFactoryForTest.newChqbllTrans();

		ChqbllTransEntity chqbllTransEntity = chqbllTransEntityFactoryForTest.newChqbllTransEntity();
		when(chqbllTransJpaRepository.findOne(chqbllTrans.getId())).thenReturn(null);
		
		chqbllTransEntity = new ChqbllTransEntity();
		chqbllTransServiceMapper.mapChqbllTransToChqbllTransEntity(chqbllTrans, chqbllTransEntity);
		ChqbllTransEntity chqbllTransEntitySaved = chqbllTransJpaRepository.save(chqbllTransEntity);
		
		ChqbllTrans chqbllTransSaved = chqbllTransFactoryForTest.newChqbllTrans();
		when(chqbllTransServiceMapper.mapChqbllTransEntityToChqbllTrans(chqbllTransEntitySaved)).thenReturn(chqbllTransSaved);

		// When
		ChqbllTrans chqbllTransResult = chqbllTransService.create(chqbllTrans);

		// Then
		assertTrue(chqbllTransResult == chqbllTransSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		ChqbllTrans chqbllTrans = chqbllTransFactoryForTest.newChqbllTrans();

		ChqbllTransEntity chqbllTransEntity = chqbllTransEntityFactoryForTest.newChqbllTransEntity();
		when(chqbllTransJpaRepository.findOne(chqbllTrans.getId())).thenReturn(chqbllTransEntity);

		// When
		Exception exception = null;
		try {
			chqbllTransService.create(chqbllTrans);
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
		ChqbllTrans chqbllTrans = chqbllTransFactoryForTest.newChqbllTrans();

		ChqbllTransEntity chqbllTransEntity = chqbllTransEntityFactoryForTest.newChqbllTransEntity();
		when(chqbllTransJpaRepository.findOne(chqbllTrans.getId())).thenReturn(chqbllTransEntity);
		
		ChqbllTransEntity chqbllTransEntitySaved = chqbllTransEntityFactoryForTest.newChqbllTransEntity();
		when(chqbllTransJpaRepository.save(chqbllTransEntity)).thenReturn(chqbllTransEntitySaved);
		
		ChqbllTrans chqbllTransSaved = chqbllTransFactoryForTest.newChqbllTrans();
		when(chqbllTransServiceMapper.mapChqbllTransEntityToChqbllTrans(chqbllTransEntitySaved)).thenReturn(chqbllTransSaved);

		// When
		ChqbllTrans chqbllTransResult = chqbllTransService.update(chqbllTrans);

		// Then
		verify(chqbllTransServiceMapper).mapChqbllTransToChqbllTransEntity(chqbllTrans, chqbllTransEntity);
		assertTrue(chqbllTransResult == chqbllTransSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer id = mockValues.nextInteger();

		// When
		chqbllTransService.delete(id);

		// Then
		verify(chqbllTransJpaRepository).delete(id);
		
	}

}
