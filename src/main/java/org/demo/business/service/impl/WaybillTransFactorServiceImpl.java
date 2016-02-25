/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.WaybillTransFactor;
import org.demo.bean.jpa.WaybillTransFactorEntity;
import org.demo.business.service.WaybillTransFactorService;
import org.demo.business.service.mapping.WaybillTransFactorServiceMapper;
import org.demo.data.repository.jpa.WaybillTransFactorJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of WaybillTransFactorService
 */
@Component
@Transactional
public class WaybillTransFactorServiceImpl implements WaybillTransFactorService {

	@Resource
	private WaybillTransFactorJpaRepository waybillTransFactorJpaRepository;

	@Resource
	private WaybillTransFactorServiceMapper waybillTransFactorServiceMapper;
	
	public WaybillTransFactor findById(Integer id) {
		WaybillTransFactorEntity waybillTransFactorEntity = waybillTransFactorJpaRepository.findOne(id);
		return waybillTransFactorServiceMapper.mapWaybillTransFactorEntityToWaybillTransFactor(waybillTransFactorEntity);
	}

	public List<WaybillTransFactor> findAll() {
		Iterable<WaybillTransFactorEntity> entities = waybillTransFactorJpaRepository.findAll();
		List<WaybillTransFactor> beans = new ArrayList<WaybillTransFactor>();
		for(WaybillTransFactorEntity waybillTransFactorEntity : entities) {
			beans.add(waybillTransFactorServiceMapper.mapWaybillTransFactorEntityToWaybillTransFactor(waybillTransFactorEntity));
		}
		return beans;
	}

	public WaybillTransFactor save(WaybillTransFactor waybillTransFactor) {
		return update(waybillTransFactor) ;
	}

	public WaybillTransFactor create(WaybillTransFactor waybillTransFactor) {
		WaybillTransFactorEntity waybillTransFactorEntity = waybillTransFactorJpaRepository.findOne(waybillTransFactor.getId());
		if( waybillTransFactorEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		waybillTransFactorEntity = new WaybillTransFactorEntity();
		waybillTransFactorServiceMapper.mapWaybillTransFactorToWaybillTransFactorEntity(waybillTransFactor, waybillTransFactorEntity);
		WaybillTransFactorEntity waybillTransFactorEntitySaved = waybillTransFactorJpaRepository.save(waybillTransFactorEntity);
		return waybillTransFactorServiceMapper.mapWaybillTransFactorEntityToWaybillTransFactor(waybillTransFactorEntitySaved);
	}

	public WaybillTransFactor update(WaybillTransFactor waybillTransFactor) {
		WaybillTransFactorEntity waybillTransFactorEntity = waybillTransFactorJpaRepository.findOne(waybillTransFactor.getId());
		waybillTransFactorServiceMapper.mapWaybillTransFactorToWaybillTransFactorEntity(waybillTransFactor, waybillTransFactorEntity);
		WaybillTransFactorEntity waybillTransFactorEntitySaved = waybillTransFactorJpaRepository.save(waybillTransFactorEntity);
		return waybillTransFactorServiceMapper.mapWaybillTransFactorEntityToWaybillTransFactor(waybillTransFactorEntitySaved);
	}

	public void delete(Integer id) {
		waybillTransFactorJpaRepository.delete(id);
	}

	public WaybillTransFactorJpaRepository getWaybillTransFactorJpaRepository() {
		return waybillTransFactorJpaRepository;
	}

	public void setWaybillTransFactorJpaRepository(WaybillTransFactorJpaRepository waybillTransFactorJpaRepository) {
		this.waybillTransFactorJpaRepository = waybillTransFactorJpaRepository;
	}

	public WaybillTransFactorServiceMapper getWaybillTransFactorServiceMapper() {
		return waybillTransFactorServiceMapper;
	}

	public void setWaybillTransFactorServiceMapper(WaybillTransFactorServiceMapper waybillTransFactorServiceMapper) {
		this.waybillTransFactorServiceMapper = waybillTransFactorServiceMapper;
	}

}