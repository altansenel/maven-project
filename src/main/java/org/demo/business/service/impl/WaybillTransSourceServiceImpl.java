/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.WaybillTransSource;
import org.demo.bean.jpa.WaybillTransSourceEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.WaybillTransSourceService;
import org.demo.business.service.mapping.WaybillTransSourceServiceMapper;
import org.demo.data.repository.jpa.WaybillTransSourceJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of WaybillTransSourceService
 */
@Component
@Transactional
public class WaybillTransSourceServiceImpl implements WaybillTransSourceService {

	@Resource
	private WaybillTransSourceJpaRepository waybillTransSourceJpaRepository;

	@Resource
	private WaybillTransSourceServiceMapper waybillTransSourceServiceMapper;
	
	public WaybillTransSource findById(Integer id) {
		WaybillTransSourceEntity waybillTransSourceEntity = waybillTransSourceJpaRepository.findOne(id);
		return waybillTransSourceServiceMapper.mapWaybillTransSourceEntityToWaybillTransSource(waybillTransSourceEntity);
	}

	public List<WaybillTransSource> findAll() {
		Iterable<WaybillTransSourceEntity> entities = waybillTransSourceJpaRepository.findAll();
		List<WaybillTransSource> beans = new ArrayList<WaybillTransSource>();
		for(WaybillTransSourceEntity waybillTransSourceEntity : entities) {
			beans.add(waybillTransSourceServiceMapper.mapWaybillTransSourceEntityToWaybillTransSource(waybillTransSourceEntity));
		}
		return beans;
	}

	public WaybillTransSource save(WaybillTransSource waybillTransSource) {
		return update(waybillTransSource) ;
	}

	public WaybillTransSource create(WaybillTransSource waybillTransSource) {
		WaybillTransSourceEntity waybillTransSourceEntity = waybillTransSourceJpaRepository.findOne(waybillTransSource.getId());
		if( waybillTransSourceEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		waybillTransSourceEntity = new WaybillTransSourceEntity();
		waybillTransSourceServiceMapper.mapWaybillTransSourceToWaybillTransSourceEntity(waybillTransSource, waybillTransSourceEntity);
		WaybillTransSourceEntity waybillTransSourceEntitySaved = waybillTransSourceJpaRepository.save(waybillTransSourceEntity);
		return waybillTransSourceServiceMapper.mapWaybillTransSourceEntityToWaybillTransSource(waybillTransSourceEntitySaved);
	}

	public WaybillTransSource update(WaybillTransSource waybillTransSource) {
		WaybillTransSourceEntity waybillTransSourceEntity = waybillTransSourceJpaRepository.findOne(waybillTransSource.getId());
		waybillTransSourceServiceMapper.mapWaybillTransSourceToWaybillTransSourceEntity(waybillTransSource, waybillTransSourceEntity);
		WaybillTransSourceEntity waybillTransSourceEntitySaved = waybillTransSourceJpaRepository.save(waybillTransSourceEntity);
		return waybillTransSourceServiceMapper.mapWaybillTransSourceEntityToWaybillTransSource(waybillTransSourceEntitySaved);
	}

	public void delete(Integer id) {
		waybillTransSourceJpaRepository.delete(id);
	}

	public WaybillTransSourceJpaRepository getWaybillTransSourceJpaRepository() {
		return waybillTransSourceJpaRepository;
	}

	public void setWaybillTransSourceJpaRepository(WaybillTransSourceJpaRepository waybillTransSourceJpaRepository) {
		this.waybillTransSourceJpaRepository = waybillTransSourceJpaRepository;
	}

	public WaybillTransSourceServiceMapper getWaybillTransSourceServiceMapper() {
		return waybillTransSourceServiceMapper;
	}

	public void setWaybillTransSourceServiceMapper(WaybillTransSourceServiceMapper waybillTransSourceServiceMapper) {
		this.waybillTransSourceServiceMapper = waybillTransSourceServiceMapper;
	}

}