/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.GlobalProfile;
import org.demo.bean.jpa.GlobalProfileEntity;
import org.demo.business.service.GlobalProfileService;
import org.demo.business.service.mapping.GlobalProfileServiceMapper;
import org.demo.data.repository.jpa.GlobalProfileJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of GlobalProfileService
 */
@Component
@Transactional
public class GlobalProfileServiceImpl implements GlobalProfileService {

	@Resource
	private GlobalProfileJpaRepository globalProfileJpaRepository;

	@Resource
	private GlobalProfileServiceMapper globalProfileServiceMapper;
	
	public GlobalProfile findById(Integer id) {
		GlobalProfileEntity globalProfileEntity = globalProfileJpaRepository.findOne(id);
		return globalProfileServiceMapper.mapGlobalProfileEntityToGlobalProfile(globalProfileEntity);
	}

	public List<GlobalProfile> findAll() {
		Iterable<GlobalProfileEntity> entities = globalProfileJpaRepository.findAll();
		List<GlobalProfile> beans = new ArrayList<GlobalProfile>();
		for(GlobalProfileEntity globalProfileEntity : entities) {
			beans.add(globalProfileServiceMapper.mapGlobalProfileEntityToGlobalProfile(globalProfileEntity));
		}
		return beans;
	}

	public GlobalProfile save(GlobalProfile globalProfile) {
		return update(globalProfile) ;
	}

	public GlobalProfile create(GlobalProfile globalProfile) {
		GlobalProfileEntity globalProfileEntity = globalProfileJpaRepository.findOne(globalProfile.getId());
		if( globalProfileEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		globalProfileEntity = new GlobalProfileEntity();
		globalProfileServiceMapper.mapGlobalProfileToGlobalProfileEntity(globalProfile, globalProfileEntity);
		GlobalProfileEntity globalProfileEntitySaved = globalProfileJpaRepository.save(globalProfileEntity);
		return globalProfileServiceMapper.mapGlobalProfileEntityToGlobalProfile(globalProfileEntitySaved);
	}

	public GlobalProfile update(GlobalProfile globalProfile) {
		GlobalProfileEntity globalProfileEntity = globalProfileJpaRepository.findOne(globalProfile.getId());
		globalProfileServiceMapper.mapGlobalProfileToGlobalProfileEntity(globalProfile, globalProfileEntity);
		GlobalProfileEntity globalProfileEntitySaved = globalProfileJpaRepository.save(globalProfileEntity);
		return globalProfileServiceMapper.mapGlobalProfileEntityToGlobalProfile(globalProfileEntitySaved);
	}

	public void delete(Integer id) {
		globalProfileJpaRepository.delete(id);
	}

	public GlobalProfileJpaRepository getGlobalProfileJpaRepository() {
		return globalProfileJpaRepository;
	}

	public void setGlobalProfileJpaRepository(GlobalProfileJpaRepository globalProfileJpaRepository) {
		this.globalProfileJpaRepository = globalProfileJpaRepository;
	}

	public GlobalProfileServiceMapper getGlobalProfileServiceMapper() {
		return globalProfileServiceMapper;
	}

	public void setGlobalProfileServiceMapper(GlobalProfileServiceMapper globalProfileServiceMapper) {
		this.globalProfileServiceMapper = globalProfileServiceMapper;
	}

}