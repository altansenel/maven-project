/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.SafeTransSource;
import org.demo.bean.jpa.SafeTransSourceEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.SafeTransSourceService;
import org.demo.business.service.mapping.SafeTransSourceServiceMapper;
import org.demo.data.repository.jpa.SafeTransSourceJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of SafeTransSourceService
 */
@Component
@Transactional
public class SafeTransSourceServiceImpl implements SafeTransSourceService {

	@Resource
	private SafeTransSourceJpaRepository safeTransSourceJpaRepository;

	@Resource
	private SafeTransSourceServiceMapper safeTransSourceServiceMapper;
	
	public SafeTransSource findById(Integer id) {
		SafeTransSourceEntity safeTransSourceEntity = safeTransSourceJpaRepository.findOne(id);
		return safeTransSourceServiceMapper.mapSafeTransSourceEntityToSafeTransSource(safeTransSourceEntity);
	}

	public List<SafeTransSource> findAll() {
		Iterable<SafeTransSourceEntity> entities = safeTransSourceJpaRepository.findAll();
		List<SafeTransSource> beans = new ArrayList<SafeTransSource>();
		for(SafeTransSourceEntity safeTransSourceEntity : entities) {
			beans.add(safeTransSourceServiceMapper.mapSafeTransSourceEntityToSafeTransSource(safeTransSourceEntity));
		}
		return beans;
	}

	public SafeTransSource save(SafeTransSource safeTransSource) {
		return update(safeTransSource) ;
	}

	public SafeTransSource create(SafeTransSource safeTransSource) {
		SafeTransSourceEntity safeTransSourceEntity = safeTransSourceJpaRepository.findOne(safeTransSource.getId());
		if( safeTransSourceEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		safeTransSourceEntity = new SafeTransSourceEntity();
		safeTransSourceServiceMapper.mapSafeTransSourceToSafeTransSourceEntity(safeTransSource, safeTransSourceEntity);
		SafeTransSourceEntity safeTransSourceEntitySaved = safeTransSourceJpaRepository.save(safeTransSourceEntity);
		return safeTransSourceServiceMapper.mapSafeTransSourceEntityToSafeTransSource(safeTransSourceEntitySaved);
	}

	public SafeTransSource update(SafeTransSource safeTransSource) {
		SafeTransSourceEntity safeTransSourceEntity = safeTransSourceJpaRepository.findOne(safeTransSource.getId());
		safeTransSourceServiceMapper.mapSafeTransSourceToSafeTransSourceEntity(safeTransSource, safeTransSourceEntity);
		SafeTransSourceEntity safeTransSourceEntitySaved = safeTransSourceJpaRepository.save(safeTransSourceEntity);
		return safeTransSourceServiceMapper.mapSafeTransSourceEntityToSafeTransSource(safeTransSourceEntitySaved);
	}

	public void delete(Integer id) {
		safeTransSourceJpaRepository.delete(id);
	}

	public SafeTransSourceJpaRepository getSafeTransSourceJpaRepository() {
		return safeTransSourceJpaRepository;
	}

	public void setSafeTransSourceJpaRepository(SafeTransSourceJpaRepository safeTransSourceJpaRepository) {
		this.safeTransSourceJpaRepository = safeTransSourceJpaRepository;
	}

	public SafeTransSourceServiceMapper getSafeTransSourceServiceMapper() {
		return safeTransSourceServiceMapper;
	}

	public void setSafeTransSourceServiceMapper(SafeTransSourceServiceMapper safeTransSourceServiceMapper) {
		this.safeTransSourceServiceMapper = safeTransSourceServiceMapper;
	}

}
