/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.WaybillTransStatusHistory;
import org.demo.bean.jpa.WaybillTransStatusHistoryEntity;
import java.util.Date;
import org.demo.business.service.WaybillTransStatusHistoryService;
import org.demo.business.service.mapping.WaybillTransStatusHistoryServiceMapper;
import org.demo.data.repository.jpa.WaybillTransStatusHistoryJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of WaybillTransStatusHistoryService
 */
@Component
@Transactional
public class WaybillTransStatusHistoryServiceImpl implements WaybillTransStatusHistoryService {

	@Resource
	private WaybillTransStatusHistoryJpaRepository waybillTransStatusHistoryJpaRepository;

	@Resource
	private WaybillTransStatusHistoryServiceMapper waybillTransStatusHistoryServiceMapper;
	
	public WaybillTransStatusHistory findById(Integer id) {
		WaybillTransStatusHistoryEntity waybillTransStatusHistoryEntity = waybillTransStatusHistoryJpaRepository.findOne(id);
		return waybillTransStatusHistoryServiceMapper.mapWaybillTransStatusHistoryEntityToWaybillTransStatusHistory(waybillTransStatusHistoryEntity);
	}

	public List<WaybillTransStatusHistory> findAll() {
		Iterable<WaybillTransStatusHistoryEntity> entities = waybillTransStatusHistoryJpaRepository.findAll();
		List<WaybillTransStatusHistory> beans = new ArrayList<WaybillTransStatusHistory>();
		for(WaybillTransStatusHistoryEntity waybillTransStatusHistoryEntity : entities) {
			beans.add(waybillTransStatusHistoryServiceMapper.mapWaybillTransStatusHistoryEntityToWaybillTransStatusHistory(waybillTransStatusHistoryEntity));
		}
		return beans;
	}

	public WaybillTransStatusHistory save(WaybillTransStatusHistory waybillTransStatusHistory) {
		return update(waybillTransStatusHistory) ;
	}

	public WaybillTransStatusHistory create(WaybillTransStatusHistory waybillTransStatusHistory) {
		WaybillTransStatusHistoryEntity waybillTransStatusHistoryEntity = waybillTransStatusHistoryJpaRepository.findOne(waybillTransStatusHistory.getId());
		if( waybillTransStatusHistoryEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		waybillTransStatusHistoryEntity = new WaybillTransStatusHistoryEntity();
		waybillTransStatusHistoryServiceMapper.mapWaybillTransStatusHistoryToWaybillTransStatusHistoryEntity(waybillTransStatusHistory, waybillTransStatusHistoryEntity);
		WaybillTransStatusHistoryEntity waybillTransStatusHistoryEntitySaved = waybillTransStatusHistoryJpaRepository.save(waybillTransStatusHistoryEntity);
		return waybillTransStatusHistoryServiceMapper.mapWaybillTransStatusHistoryEntityToWaybillTransStatusHistory(waybillTransStatusHistoryEntitySaved);
	}

	public WaybillTransStatusHistory update(WaybillTransStatusHistory waybillTransStatusHistory) {
		WaybillTransStatusHistoryEntity waybillTransStatusHistoryEntity = waybillTransStatusHistoryJpaRepository.findOne(waybillTransStatusHistory.getId());
		waybillTransStatusHistoryServiceMapper.mapWaybillTransStatusHistoryToWaybillTransStatusHistoryEntity(waybillTransStatusHistory, waybillTransStatusHistoryEntity);
		WaybillTransStatusHistoryEntity waybillTransStatusHistoryEntitySaved = waybillTransStatusHistoryJpaRepository.save(waybillTransStatusHistoryEntity);
		return waybillTransStatusHistoryServiceMapper.mapWaybillTransStatusHistoryEntityToWaybillTransStatusHistory(waybillTransStatusHistoryEntitySaved);
	}

	public void delete(Integer id) {
		waybillTransStatusHistoryJpaRepository.delete(id);
	}

	public WaybillTransStatusHistoryJpaRepository getWaybillTransStatusHistoryJpaRepository() {
		return waybillTransStatusHistoryJpaRepository;
	}

	public void setWaybillTransStatusHistoryJpaRepository(WaybillTransStatusHistoryJpaRepository waybillTransStatusHistoryJpaRepository) {
		this.waybillTransStatusHistoryJpaRepository = waybillTransStatusHistoryJpaRepository;
	}

	public WaybillTransStatusHistoryServiceMapper getWaybillTransStatusHistoryServiceMapper() {
		return waybillTransStatusHistoryServiceMapper;
	}

	public void setWaybillTransStatusHistoryServiceMapper(WaybillTransStatusHistoryServiceMapper waybillTransStatusHistoryServiceMapper) {
		this.waybillTransStatusHistoryServiceMapper = waybillTransStatusHistoryServiceMapper;
	}

}
