/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.ChqbllPayrollDetail;
import org.demo.bean.jpa.ChqbllPayrollDetailEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.ChqbllPayrollDetailService;
import org.demo.business.service.mapping.ChqbllPayrollDetailServiceMapper;
import org.demo.data.repository.jpa.ChqbllPayrollDetailJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of ChqbllPayrollDetailService
 */
@Component
@Transactional
public class ChqbllPayrollDetailServiceImpl implements ChqbllPayrollDetailService {

	@Resource
	private ChqbllPayrollDetailJpaRepository chqbllPayrollDetailJpaRepository;

	@Resource
	private ChqbllPayrollDetailServiceMapper chqbllPayrollDetailServiceMapper;
	
	public ChqbllPayrollDetail findById(Integer id) {
		ChqbllPayrollDetailEntity chqbllPayrollDetailEntity = chqbllPayrollDetailJpaRepository.findOne(id);
		return chqbllPayrollDetailServiceMapper.mapChqbllPayrollDetailEntityToChqbllPayrollDetail(chqbllPayrollDetailEntity);
	}

	public List<ChqbllPayrollDetail> findAll() {
		Iterable<ChqbllPayrollDetailEntity> entities = chqbllPayrollDetailJpaRepository.findAll();
		List<ChqbllPayrollDetail> beans = new ArrayList<ChqbllPayrollDetail>();
		for(ChqbllPayrollDetailEntity chqbllPayrollDetailEntity : entities) {
			beans.add(chqbllPayrollDetailServiceMapper.mapChqbllPayrollDetailEntityToChqbllPayrollDetail(chqbllPayrollDetailEntity));
		}
		return beans;
	}

	public ChqbllPayrollDetail save(ChqbllPayrollDetail chqbllPayrollDetail) {
		return update(chqbllPayrollDetail) ;
	}

	public ChqbllPayrollDetail create(ChqbllPayrollDetail chqbllPayrollDetail) {
		ChqbllPayrollDetailEntity chqbllPayrollDetailEntity = chqbllPayrollDetailJpaRepository.findOne(chqbllPayrollDetail.getId());
		if( chqbllPayrollDetailEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		chqbllPayrollDetailEntity = new ChqbllPayrollDetailEntity();
		chqbllPayrollDetailServiceMapper.mapChqbllPayrollDetailToChqbllPayrollDetailEntity(chqbllPayrollDetail, chqbllPayrollDetailEntity);
		ChqbllPayrollDetailEntity chqbllPayrollDetailEntitySaved = chqbllPayrollDetailJpaRepository.save(chqbllPayrollDetailEntity);
		return chqbllPayrollDetailServiceMapper.mapChqbllPayrollDetailEntityToChqbllPayrollDetail(chqbllPayrollDetailEntitySaved);
	}

	public ChqbllPayrollDetail update(ChqbllPayrollDetail chqbllPayrollDetail) {
		ChqbllPayrollDetailEntity chqbllPayrollDetailEntity = chqbllPayrollDetailJpaRepository.findOne(chqbllPayrollDetail.getId());
		chqbllPayrollDetailServiceMapper.mapChqbllPayrollDetailToChqbllPayrollDetailEntity(chqbllPayrollDetail, chqbllPayrollDetailEntity);
		ChqbllPayrollDetailEntity chqbllPayrollDetailEntitySaved = chqbllPayrollDetailJpaRepository.save(chqbllPayrollDetailEntity);
		return chqbllPayrollDetailServiceMapper.mapChqbllPayrollDetailEntityToChqbllPayrollDetail(chqbllPayrollDetailEntitySaved);
	}

	public void delete(Integer id) {
		chqbllPayrollDetailJpaRepository.delete(id);
	}

	public ChqbllPayrollDetailJpaRepository getChqbllPayrollDetailJpaRepository() {
		return chqbllPayrollDetailJpaRepository;
	}

	public void setChqbllPayrollDetailJpaRepository(ChqbllPayrollDetailJpaRepository chqbllPayrollDetailJpaRepository) {
		this.chqbllPayrollDetailJpaRepository = chqbllPayrollDetailJpaRepository;
	}

	public ChqbllPayrollDetailServiceMapper getChqbllPayrollDetailServiceMapper() {
		return chqbllPayrollDetailServiceMapper;
	}

	public void setChqbllPayrollDetailServiceMapper(ChqbllPayrollDetailServiceMapper chqbllPayrollDetailServiceMapper) {
		this.chqbllPayrollDetailServiceMapper = chqbllPayrollDetailServiceMapper;
	}

}
