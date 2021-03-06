/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.GlobalCurrencyRateDetail;
import org.demo.bean.jpa.GlobalCurrencyRateDetailEntity;
import java.util.Date;
import org.demo.business.service.GlobalCurrencyRateDetailService;
import org.demo.business.service.mapping.GlobalCurrencyRateDetailServiceMapper;
import org.demo.data.repository.jpa.GlobalCurrencyRateDetailJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of GlobalCurrencyRateDetailService
 */
@Component
@Transactional
public class GlobalCurrencyRateDetailServiceImpl implements GlobalCurrencyRateDetailService {

	@Resource
	private GlobalCurrencyRateDetailJpaRepository globalCurrencyRateDetailJpaRepository;

	@Resource
	private GlobalCurrencyRateDetailServiceMapper globalCurrencyRateDetailServiceMapper;
	
	public GlobalCurrencyRateDetail findById(Integer id) {
		GlobalCurrencyRateDetailEntity globalCurrencyRateDetailEntity = globalCurrencyRateDetailJpaRepository.findOne(id);
		return globalCurrencyRateDetailServiceMapper.mapGlobalCurrencyRateDetailEntityToGlobalCurrencyRateDetail(globalCurrencyRateDetailEntity);
	}

	public List<GlobalCurrencyRateDetail> findAll() {
		Iterable<GlobalCurrencyRateDetailEntity> entities = globalCurrencyRateDetailJpaRepository.findAll();
		List<GlobalCurrencyRateDetail> beans = new ArrayList<GlobalCurrencyRateDetail>();
		for(GlobalCurrencyRateDetailEntity globalCurrencyRateDetailEntity : entities) {
			beans.add(globalCurrencyRateDetailServiceMapper.mapGlobalCurrencyRateDetailEntityToGlobalCurrencyRateDetail(globalCurrencyRateDetailEntity));
		}
		return beans;
	}

	public GlobalCurrencyRateDetail save(GlobalCurrencyRateDetail globalCurrencyRateDetail) {
		return update(globalCurrencyRateDetail) ;
	}

	public GlobalCurrencyRateDetail create(GlobalCurrencyRateDetail globalCurrencyRateDetail) {
		GlobalCurrencyRateDetailEntity globalCurrencyRateDetailEntity = globalCurrencyRateDetailJpaRepository.findOne(globalCurrencyRateDetail.getId());
		if( globalCurrencyRateDetailEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		globalCurrencyRateDetailEntity = new GlobalCurrencyRateDetailEntity();
		globalCurrencyRateDetailServiceMapper.mapGlobalCurrencyRateDetailToGlobalCurrencyRateDetailEntity(globalCurrencyRateDetail, globalCurrencyRateDetailEntity);
		GlobalCurrencyRateDetailEntity globalCurrencyRateDetailEntitySaved = globalCurrencyRateDetailJpaRepository.save(globalCurrencyRateDetailEntity);
		return globalCurrencyRateDetailServiceMapper.mapGlobalCurrencyRateDetailEntityToGlobalCurrencyRateDetail(globalCurrencyRateDetailEntitySaved);
	}

	public GlobalCurrencyRateDetail update(GlobalCurrencyRateDetail globalCurrencyRateDetail) {
		GlobalCurrencyRateDetailEntity globalCurrencyRateDetailEntity = globalCurrencyRateDetailJpaRepository.findOne(globalCurrencyRateDetail.getId());
		globalCurrencyRateDetailServiceMapper.mapGlobalCurrencyRateDetailToGlobalCurrencyRateDetailEntity(globalCurrencyRateDetail, globalCurrencyRateDetailEntity);
		GlobalCurrencyRateDetailEntity globalCurrencyRateDetailEntitySaved = globalCurrencyRateDetailJpaRepository.save(globalCurrencyRateDetailEntity);
		return globalCurrencyRateDetailServiceMapper.mapGlobalCurrencyRateDetailEntityToGlobalCurrencyRateDetail(globalCurrencyRateDetailEntitySaved);
	}

	public void delete(Integer id) {
		globalCurrencyRateDetailJpaRepository.delete(id);
	}

	public GlobalCurrencyRateDetailJpaRepository getGlobalCurrencyRateDetailJpaRepository() {
		return globalCurrencyRateDetailJpaRepository;
	}

	public void setGlobalCurrencyRateDetailJpaRepository(GlobalCurrencyRateDetailJpaRepository globalCurrencyRateDetailJpaRepository) {
		this.globalCurrencyRateDetailJpaRepository = globalCurrencyRateDetailJpaRepository;
	}

	public GlobalCurrencyRateDetailServiceMapper getGlobalCurrencyRateDetailServiceMapper() {
		return globalCurrencyRateDetailServiceMapper;
	}

	public void setGlobalCurrencyRateDetailServiceMapper(GlobalCurrencyRateDetailServiceMapper globalCurrencyRateDetailServiceMapper) {
		this.globalCurrencyRateDetailServiceMapper = globalCurrencyRateDetailServiceMapper;
	}

}
