/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.WaybillTransStatus;
import org.demo.bean.jpa.WaybillTransStatusEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.WaybillTransStatusService;
import org.demo.business.service.mapping.WaybillTransStatusServiceMapper;
import org.demo.data.repository.jpa.WaybillTransStatusJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of WaybillTransStatusService
 */
@Component
@Transactional
public class WaybillTransStatusServiceImpl implements WaybillTransStatusService {

	@Resource
	private WaybillTransStatusJpaRepository waybillTransStatusJpaRepository;

	@Resource
	private WaybillTransStatusServiceMapper waybillTransStatusServiceMapper;
	
	public WaybillTransStatus findById(Integer id) {
		WaybillTransStatusEntity waybillTransStatusEntity = waybillTransStatusJpaRepository.findOne(id);
		return waybillTransStatusServiceMapper.mapWaybillTransStatusEntityToWaybillTransStatus(waybillTransStatusEntity);
	}

	public List<WaybillTransStatus> findAll() {
		Iterable<WaybillTransStatusEntity> entities = waybillTransStatusJpaRepository.findAll();
		List<WaybillTransStatus> beans = new ArrayList<WaybillTransStatus>();
		for(WaybillTransStatusEntity waybillTransStatusEntity : entities) {
			beans.add(waybillTransStatusServiceMapper.mapWaybillTransStatusEntityToWaybillTransStatus(waybillTransStatusEntity));
		}
		return beans;
	}

	public WaybillTransStatus save(WaybillTransStatus waybillTransStatus) {
		return update(waybillTransStatus) ;
	}

	public WaybillTransStatus create(WaybillTransStatus waybillTransStatus) {
		WaybillTransStatusEntity waybillTransStatusEntity = waybillTransStatusJpaRepository.findOne(waybillTransStatus.getId());
		if( waybillTransStatusEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		waybillTransStatusEntity = new WaybillTransStatusEntity();
		waybillTransStatusServiceMapper.mapWaybillTransStatusToWaybillTransStatusEntity(waybillTransStatus, waybillTransStatusEntity);
		WaybillTransStatusEntity waybillTransStatusEntitySaved = waybillTransStatusJpaRepository.save(waybillTransStatusEntity);
		return waybillTransStatusServiceMapper.mapWaybillTransStatusEntityToWaybillTransStatus(waybillTransStatusEntitySaved);
	}

	public WaybillTransStatus update(WaybillTransStatus waybillTransStatus) {
		WaybillTransStatusEntity waybillTransStatusEntity = waybillTransStatusJpaRepository.findOne(waybillTransStatus.getId());
		waybillTransStatusServiceMapper.mapWaybillTransStatusToWaybillTransStatusEntity(waybillTransStatus, waybillTransStatusEntity);
		WaybillTransStatusEntity waybillTransStatusEntitySaved = waybillTransStatusJpaRepository.save(waybillTransStatusEntity);
		return waybillTransStatusServiceMapper.mapWaybillTransStatusEntityToWaybillTransStatus(waybillTransStatusEntitySaved);
	}

	public void delete(Integer id) {
		waybillTransStatusJpaRepository.delete(id);
	}

	public WaybillTransStatusJpaRepository getWaybillTransStatusJpaRepository() {
		return waybillTransStatusJpaRepository;
	}

	public void setWaybillTransStatusJpaRepository(WaybillTransStatusJpaRepository waybillTransStatusJpaRepository) {
		this.waybillTransStatusJpaRepository = waybillTransStatusJpaRepository;
	}

	public WaybillTransStatusServiceMapper getWaybillTransStatusServiceMapper() {
		return waybillTransStatusServiceMapper;
	}

	public void setWaybillTransStatusServiceMapper(WaybillTransStatusServiceMapper waybillTransStatusServiceMapper) {
		this.waybillTransStatusServiceMapper = waybillTransStatusServiceMapper;
	}

}
