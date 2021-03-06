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

import org.demo.bean.ChqbllType;
import org.demo.bean.jpa.ChqbllTypeEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.mapping.ChqbllTypeServiceMapper;
import org.demo.data.repository.jpa.ChqbllTypeJpaRepository;
import org.demo.test.ChqbllTypeFactoryForTest;
import org.demo.test.ChqbllTypeEntityFactoryForTest;
import org.demo.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of ChqbllTypeService
 */
@RunWith(MockitoJUnitRunner.class)
public class ChqbllTypeServiceImplTest {

	@InjectMocks
	private ChqbllTypeServiceImpl chqbllTypeService;
	@Mock
	private ChqbllTypeJpaRepository chqbllTypeJpaRepository;
	@Mock
	private ChqbllTypeServiceMapper chqbllTypeServiceMapper;
	
	private ChqbllTypeFactoryForTest chqbllTypeFactoryForTest = new ChqbllTypeFactoryForTest();

	private ChqbllTypeEntityFactoryForTest chqbllTypeEntityFactoryForTest = new ChqbllTypeEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer id = mockValues.nextInteger();
		
		ChqbllTypeEntity chqbllTypeEntity = chqbllTypeJpaRepository.findOne(id);
		
		ChqbllType chqbllType = chqbllTypeFactoryForTest.newChqbllType();
		when(chqbllTypeServiceMapper.mapChqbllTypeEntityToChqbllType(chqbllTypeEntity)).thenReturn(chqbllType);

		// When
		ChqbllType chqbllTypeFound = chqbllTypeService.findById(id);

		// Then
		assertEquals(chqbllType.getId(),chqbllTypeFound.getId());
	}

	@Test
	public void findAll() {
		// Given
		List<ChqbllTypeEntity> chqbllTypeEntitys = new ArrayList<ChqbllTypeEntity>();
		ChqbllTypeEntity chqbllTypeEntity1 = chqbllTypeEntityFactoryForTest.newChqbllTypeEntity();
		chqbllTypeEntitys.add(chqbllTypeEntity1);
		ChqbllTypeEntity chqbllTypeEntity2 = chqbllTypeEntityFactoryForTest.newChqbllTypeEntity();
		chqbllTypeEntitys.add(chqbllTypeEntity2);
		when(chqbllTypeJpaRepository.findAll()).thenReturn(chqbllTypeEntitys);
		
		ChqbllType chqbllType1 = chqbllTypeFactoryForTest.newChqbllType();
		when(chqbllTypeServiceMapper.mapChqbllTypeEntityToChqbllType(chqbllTypeEntity1)).thenReturn(chqbllType1);
		ChqbllType chqbllType2 = chqbllTypeFactoryForTest.newChqbllType();
		when(chqbllTypeServiceMapper.mapChqbllTypeEntityToChqbllType(chqbllTypeEntity2)).thenReturn(chqbllType2);

		// When
		List<ChqbllType> chqbllTypesFounds = chqbllTypeService.findAll();

		// Then
		assertTrue(chqbllType1 == chqbllTypesFounds.get(0));
		assertTrue(chqbllType2 == chqbllTypesFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		ChqbllType chqbllType = chqbllTypeFactoryForTest.newChqbllType();

		ChqbllTypeEntity chqbllTypeEntity = chqbllTypeEntityFactoryForTest.newChqbllTypeEntity();
		when(chqbllTypeJpaRepository.findOne(chqbllType.getId())).thenReturn(null);
		
		chqbllTypeEntity = new ChqbllTypeEntity();
		chqbllTypeServiceMapper.mapChqbllTypeToChqbllTypeEntity(chqbllType, chqbllTypeEntity);
		ChqbllTypeEntity chqbllTypeEntitySaved = chqbllTypeJpaRepository.save(chqbllTypeEntity);
		
		ChqbllType chqbllTypeSaved = chqbllTypeFactoryForTest.newChqbllType();
		when(chqbllTypeServiceMapper.mapChqbllTypeEntityToChqbllType(chqbllTypeEntitySaved)).thenReturn(chqbllTypeSaved);

		// When
		ChqbllType chqbllTypeResult = chqbllTypeService.create(chqbllType);

		// Then
		assertTrue(chqbllTypeResult == chqbllTypeSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		ChqbllType chqbllType = chqbllTypeFactoryForTest.newChqbllType();

		ChqbllTypeEntity chqbllTypeEntity = chqbllTypeEntityFactoryForTest.newChqbllTypeEntity();
		when(chqbllTypeJpaRepository.findOne(chqbllType.getId())).thenReturn(chqbllTypeEntity);

		// When
		Exception exception = null;
		try {
			chqbllTypeService.create(chqbllType);
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
		ChqbllType chqbllType = chqbllTypeFactoryForTest.newChqbllType();

		ChqbllTypeEntity chqbllTypeEntity = chqbllTypeEntityFactoryForTest.newChqbllTypeEntity();
		when(chqbllTypeJpaRepository.findOne(chqbllType.getId())).thenReturn(chqbllTypeEntity);
		
		ChqbllTypeEntity chqbllTypeEntitySaved = chqbllTypeEntityFactoryForTest.newChqbllTypeEntity();
		when(chqbllTypeJpaRepository.save(chqbllTypeEntity)).thenReturn(chqbllTypeEntitySaved);
		
		ChqbllType chqbllTypeSaved = chqbllTypeFactoryForTest.newChqbllType();
		when(chqbllTypeServiceMapper.mapChqbllTypeEntityToChqbllType(chqbllTypeEntitySaved)).thenReturn(chqbllTypeSaved);

		// When
		ChqbllType chqbllTypeResult = chqbllTypeService.update(chqbllType);

		// Then
		verify(chqbllTypeServiceMapper).mapChqbllTypeToChqbllTypeEntity(chqbllType, chqbllTypeEntity);
		assertTrue(chqbllTypeResult == chqbllTypeSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer id = mockValues.nextInteger();

		// When
		chqbllTypeService.delete(id);

		// Then
		verify(chqbllTypeJpaRepository).delete(id);
		
	}

}
