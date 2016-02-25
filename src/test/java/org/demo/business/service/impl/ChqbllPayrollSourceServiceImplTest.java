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

import org.demo.bean.ChqbllPayrollSource;
import org.demo.bean.jpa.ChqbllPayrollSourceEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.mapping.ChqbllPayrollSourceServiceMapper;
import org.demo.data.repository.jpa.ChqbllPayrollSourceJpaRepository;
import org.demo.test.ChqbllPayrollSourceFactoryForTest;
import org.demo.test.ChqbllPayrollSourceEntityFactoryForTest;
import org.demo.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of ChqbllPayrollSourceService
 */
@RunWith(MockitoJUnitRunner.class)
public class ChqbllPayrollSourceServiceImplTest {

	@InjectMocks
	private ChqbllPayrollSourceServiceImpl chqbllPayrollSourceService;
	@Mock
	private ChqbllPayrollSourceJpaRepository chqbllPayrollSourceJpaRepository;
	@Mock
	private ChqbllPayrollSourceServiceMapper chqbllPayrollSourceServiceMapper;
	
	private ChqbllPayrollSourceFactoryForTest chqbllPayrollSourceFactoryForTest = new ChqbllPayrollSourceFactoryForTest();

	private ChqbllPayrollSourceEntityFactoryForTest chqbllPayrollSourceEntityFactoryForTest = new ChqbllPayrollSourceEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer id = mockValues.nextInteger();
		
		ChqbllPayrollSourceEntity chqbllPayrollSourceEntity = chqbllPayrollSourceJpaRepository.findOne(id);
		
		ChqbllPayrollSource chqbllPayrollSource = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();
		when(chqbllPayrollSourceServiceMapper.mapChqbllPayrollSourceEntityToChqbllPayrollSource(chqbllPayrollSourceEntity)).thenReturn(chqbllPayrollSource);

		// When
		ChqbllPayrollSource chqbllPayrollSourceFound = chqbllPayrollSourceService.findById(id);

		// Then
		assertEquals(chqbllPayrollSource.getId(),chqbllPayrollSourceFound.getId());
	}

	@Test
	public void findAll() {
		// Given
		List<ChqbllPayrollSourceEntity> chqbllPayrollSourceEntitys = new ArrayList<ChqbllPayrollSourceEntity>();
		ChqbllPayrollSourceEntity chqbllPayrollSourceEntity1 = chqbllPayrollSourceEntityFactoryForTest.newChqbllPayrollSourceEntity();
		chqbllPayrollSourceEntitys.add(chqbllPayrollSourceEntity1);
		ChqbllPayrollSourceEntity chqbllPayrollSourceEntity2 = chqbllPayrollSourceEntityFactoryForTest.newChqbllPayrollSourceEntity();
		chqbllPayrollSourceEntitys.add(chqbllPayrollSourceEntity2);
		when(chqbllPayrollSourceJpaRepository.findAll()).thenReturn(chqbllPayrollSourceEntitys);
		
		ChqbllPayrollSource chqbllPayrollSource1 = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();
		when(chqbllPayrollSourceServiceMapper.mapChqbllPayrollSourceEntityToChqbllPayrollSource(chqbllPayrollSourceEntity1)).thenReturn(chqbllPayrollSource1);
		ChqbllPayrollSource chqbllPayrollSource2 = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();
		when(chqbllPayrollSourceServiceMapper.mapChqbllPayrollSourceEntityToChqbllPayrollSource(chqbllPayrollSourceEntity2)).thenReturn(chqbllPayrollSource2);

		// When
		List<ChqbllPayrollSource> chqbllPayrollSourcesFounds = chqbllPayrollSourceService.findAll();

		// Then
		assertTrue(chqbllPayrollSource1 == chqbllPayrollSourcesFounds.get(0));
		assertTrue(chqbllPayrollSource2 == chqbllPayrollSourcesFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		ChqbllPayrollSource chqbllPayrollSource = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();

		ChqbllPayrollSourceEntity chqbllPayrollSourceEntity = chqbllPayrollSourceEntityFactoryForTest.newChqbllPayrollSourceEntity();
		when(chqbllPayrollSourceJpaRepository.findOne(chqbllPayrollSource.getId())).thenReturn(null);
		
		chqbllPayrollSourceEntity = new ChqbllPayrollSourceEntity();
		chqbllPayrollSourceServiceMapper.mapChqbllPayrollSourceToChqbllPayrollSourceEntity(chqbllPayrollSource, chqbllPayrollSourceEntity);
		ChqbllPayrollSourceEntity chqbllPayrollSourceEntitySaved = chqbllPayrollSourceJpaRepository.save(chqbllPayrollSourceEntity);
		
		ChqbllPayrollSource chqbllPayrollSourceSaved = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();
		when(chqbllPayrollSourceServiceMapper.mapChqbllPayrollSourceEntityToChqbllPayrollSource(chqbllPayrollSourceEntitySaved)).thenReturn(chqbllPayrollSourceSaved);

		// When
		ChqbllPayrollSource chqbllPayrollSourceResult = chqbllPayrollSourceService.create(chqbllPayrollSource);

		// Then
		assertTrue(chqbllPayrollSourceResult == chqbllPayrollSourceSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		ChqbllPayrollSource chqbllPayrollSource = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();

		ChqbllPayrollSourceEntity chqbllPayrollSourceEntity = chqbllPayrollSourceEntityFactoryForTest.newChqbllPayrollSourceEntity();
		when(chqbllPayrollSourceJpaRepository.findOne(chqbllPayrollSource.getId())).thenReturn(chqbllPayrollSourceEntity);

		// When
		Exception exception = null;
		try {
			chqbllPayrollSourceService.create(chqbllPayrollSource);
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
		ChqbllPayrollSource chqbllPayrollSource = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();

		ChqbllPayrollSourceEntity chqbllPayrollSourceEntity = chqbllPayrollSourceEntityFactoryForTest.newChqbllPayrollSourceEntity();
		when(chqbllPayrollSourceJpaRepository.findOne(chqbllPayrollSource.getId())).thenReturn(chqbllPayrollSourceEntity);
		
		ChqbllPayrollSourceEntity chqbllPayrollSourceEntitySaved = chqbllPayrollSourceEntityFactoryForTest.newChqbllPayrollSourceEntity();
		when(chqbllPayrollSourceJpaRepository.save(chqbllPayrollSourceEntity)).thenReturn(chqbllPayrollSourceEntitySaved);
		
		ChqbllPayrollSource chqbllPayrollSourceSaved = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();
		when(chqbllPayrollSourceServiceMapper.mapChqbllPayrollSourceEntityToChqbllPayrollSource(chqbllPayrollSourceEntitySaved)).thenReturn(chqbllPayrollSourceSaved);

		// When
		ChqbllPayrollSource chqbllPayrollSourceResult = chqbllPayrollSourceService.update(chqbllPayrollSource);

		// Then
		verify(chqbllPayrollSourceServiceMapper).mapChqbllPayrollSourceToChqbllPayrollSourceEntity(chqbllPayrollSource, chqbllPayrollSourceEntity);
		assertTrue(chqbllPayrollSourceResult == chqbllPayrollSourceSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer id = mockValues.nextInteger();

		// When
		chqbllPayrollSourceService.delete(id);

		// Then
		verify(chqbllPayrollSourceJpaRepository).delete(id);
		
	}

}
