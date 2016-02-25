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

import org.demo.bean.ChqbllDetailPartial;
import org.demo.bean.jpa.ChqbllDetailPartialEntity;
import java.util.Date;
import org.demo.business.service.mapping.ChqbllDetailPartialServiceMapper;
import org.demo.data.repository.jpa.ChqbllDetailPartialJpaRepository;
import org.demo.test.ChqbllDetailPartialFactoryForTest;
import org.demo.test.ChqbllDetailPartialEntityFactoryForTest;
import org.demo.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of ChqbllDetailPartialService
 */
@RunWith(MockitoJUnitRunner.class)
public class ChqbllDetailPartialServiceImplTest {

	@InjectMocks
	private ChqbllDetailPartialServiceImpl chqbllDetailPartialService;
	@Mock
	private ChqbllDetailPartialJpaRepository chqbllDetailPartialJpaRepository;
	@Mock
	private ChqbllDetailPartialServiceMapper chqbllDetailPartialServiceMapper;
	
	private ChqbllDetailPartialFactoryForTest chqbllDetailPartialFactoryForTest = new ChqbllDetailPartialFactoryForTest();

	private ChqbllDetailPartialEntityFactoryForTest chqbllDetailPartialEntityFactoryForTest = new ChqbllDetailPartialEntityFactoryForTest();

	private MockValues mockValues = new MockValues();
	
	@Test
	public void findById() {
		// Given
		Integer id = mockValues.nextInteger();
		
		ChqbllDetailPartialEntity chqbllDetailPartialEntity = chqbllDetailPartialJpaRepository.findOne(id);
		
		ChqbllDetailPartial chqbllDetailPartial = chqbllDetailPartialFactoryForTest.newChqbllDetailPartial();
		when(chqbllDetailPartialServiceMapper.mapChqbllDetailPartialEntityToChqbllDetailPartial(chqbllDetailPartialEntity)).thenReturn(chqbllDetailPartial);

		// When
		ChqbllDetailPartial chqbllDetailPartialFound = chqbllDetailPartialService.findById(id);

		// Then
		assertEquals(chqbllDetailPartial.getId(),chqbllDetailPartialFound.getId());
	}

	@Test
	public void findAll() {
		// Given
		List<ChqbllDetailPartialEntity> chqbllDetailPartialEntitys = new ArrayList<ChqbllDetailPartialEntity>();
		ChqbllDetailPartialEntity chqbllDetailPartialEntity1 = chqbllDetailPartialEntityFactoryForTest.newChqbllDetailPartialEntity();
		chqbllDetailPartialEntitys.add(chqbllDetailPartialEntity1);
		ChqbllDetailPartialEntity chqbllDetailPartialEntity2 = chqbllDetailPartialEntityFactoryForTest.newChqbllDetailPartialEntity();
		chqbllDetailPartialEntitys.add(chqbllDetailPartialEntity2);
		when(chqbllDetailPartialJpaRepository.findAll()).thenReturn(chqbllDetailPartialEntitys);
		
		ChqbllDetailPartial chqbllDetailPartial1 = chqbllDetailPartialFactoryForTest.newChqbllDetailPartial();
		when(chqbllDetailPartialServiceMapper.mapChqbllDetailPartialEntityToChqbllDetailPartial(chqbllDetailPartialEntity1)).thenReturn(chqbllDetailPartial1);
		ChqbllDetailPartial chqbllDetailPartial2 = chqbllDetailPartialFactoryForTest.newChqbllDetailPartial();
		when(chqbllDetailPartialServiceMapper.mapChqbllDetailPartialEntityToChqbllDetailPartial(chqbllDetailPartialEntity2)).thenReturn(chqbllDetailPartial2);

		// When
		List<ChqbllDetailPartial> chqbllDetailPartialsFounds = chqbllDetailPartialService.findAll();

		// Then
		assertTrue(chqbllDetailPartial1 == chqbllDetailPartialsFounds.get(0));
		assertTrue(chqbllDetailPartial2 == chqbllDetailPartialsFounds.get(1));
	}

	@Test
	public void create() {
		// Given
		ChqbllDetailPartial chqbllDetailPartial = chqbllDetailPartialFactoryForTest.newChqbllDetailPartial();

		ChqbllDetailPartialEntity chqbllDetailPartialEntity = chqbllDetailPartialEntityFactoryForTest.newChqbllDetailPartialEntity();
		when(chqbllDetailPartialJpaRepository.findOne(chqbllDetailPartial.getId())).thenReturn(null);
		
		chqbllDetailPartialEntity = new ChqbllDetailPartialEntity();
		chqbllDetailPartialServiceMapper.mapChqbllDetailPartialToChqbllDetailPartialEntity(chqbllDetailPartial, chqbllDetailPartialEntity);
		ChqbllDetailPartialEntity chqbllDetailPartialEntitySaved = chqbllDetailPartialJpaRepository.save(chqbllDetailPartialEntity);
		
		ChqbllDetailPartial chqbllDetailPartialSaved = chqbllDetailPartialFactoryForTest.newChqbllDetailPartial();
		when(chqbllDetailPartialServiceMapper.mapChqbllDetailPartialEntityToChqbllDetailPartial(chqbllDetailPartialEntitySaved)).thenReturn(chqbllDetailPartialSaved);

		// When
		ChqbllDetailPartial chqbllDetailPartialResult = chqbllDetailPartialService.create(chqbllDetailPartial);

		// Then
		assertTrue(chqbllDetailPartialResult == chqbllDetailPartialSaved);
	}

	@Test
	public void createKOExists() {
		// Given
		ChqbllDetailPartial chqbllDetailPartial = chqbllDetailPartialFactoryForTest.newChqbllDetailPartial();

		ChqbllDetailPartialEntity chqbllDetailPartialEntity = chqbllDetailPartialEntityFactoryForTest.newChqbllDetailPartialEntity();
		when(chqbllDetailPartialJpaRepository.findOne(chqbllDetailPartial.getId())).thenReturn(chqbllDetailPartialEntity);

		// When
		Exception exception = null;
		try {
			chqbllDetailPartialService.create(chqbllDetailPartial);
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
		ChqbllDetailPartial chqbllDetailPartial = chqbllDetailPartialFactoryForTest.newChqbllDetailPartial();

		ChqbllDetailPartialEntity chqbllDetailPartialEntity = chqbllDetailPartialEntityFactoryForTest.newChqbllDetailPartialEntity();
		when(chqbllDetailPartialJpaRepository.findOne(chqbllDetailPartial.getId())).thenReturn(chqbllDetailPartialEntity);
		
		ChqbllDetailPartialEntity chqbllDetailPartialEntitySaved = chqbllDetailPartialEntityFactoryForTest.newChqbllDetailPartialEntity();
		when(chqbllDetailPartialJpaRepository.save(chqbllDetailPartialEntity)).thenReturn(chqbllDetailPartialEntitySaved);
		
		ChqbllDetailPartial chqbllDetailPartialSaved = chqbllDetailPartialFactoryForTest.newChqbllDetailPartial();
		when(chqbllDetailPartialServiceMapper.mapChqbllDetailPartialEntityToChqbllDetailPartial(chqbllDetailPartialEntitySaved)).thenReturn(chqbllDetailPartialSaved);

		// When
		ChqbllDetailPartial chqbllDetailPartialResult = chqbllDetailPartialService.update(chqbllDetailPartial);

		// Then
		verify(chqbllDetailPartialServiceMapper).mapChqbllDetailPartialToChqbllDetailPartialEntity(chqbllDetailPartial, chqbllDetailPartialEntity);
		assertTrue(chqbllDetailPartialResult == chqbllDetailPartialSaved);
	}

	@Test
	public void delete() {
		// Given
		Integer id = mockValues.nextInteger();

		// When
		chqbllDetailPartialService.delete(id);

		// Then
		verify(chqbllDetailPartialJpaRepository).delete(id);
		
	}

}
