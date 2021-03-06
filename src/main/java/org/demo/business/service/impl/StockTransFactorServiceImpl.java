/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.StockTransFactor;
import org.demo.bean.jpa.StockTransFactorEntity;
import org.demo.business.service.StockTransFactorService;
import org.demo.business.service.mapping.StockTransFactorServiceMapper;
import org.demo.data.repository.jpa.StockTransFactorJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of StockTransFactorService
 */
@Component
@Transactional
public class StockTransFactorServiceImpl implements StockTransFactorService {

	@Resource
	private StockTransFactorJpaRepository stockTransFactorJpaRepository;

	@Resource
	private StockTransFactorServiceMapper stockTransFactorServiceMapper;
	
	public StockTransFactor findById(Integer id) {
		StockTransFactorEntity stockTransFactorEntity = stockTransFactorJpaRepository.findOne(id);
		return stockTransFactorServiceMapper.mapStockTransFactorEntityToStockTransFactor(stockTransFactorEntity);
	}

	public List<StockTransFactor> findAll() {
		Iterable<StockTransFactorEntity> entities = stockTransFactorJpaRepository.findAll();
		List<StockTransFactor> beans = new ArrayList<StockTransFactor>();
		for(StockTransFactorEntity stockTransFactorEntity : entities) {
			beans.add(stockTransFactorServiceMapper.mapStockTransFactorEntityToStockTransFactor(stockTransFactorEntity));
		}
		return beans;
	}

	public StockTransFactor save(StockTransFactor stockTransFactor) {
		return update(stockTransFactor) ;
	}

	public StockTransFactor create(StockTransFactor stockTransFactor) {
		StockTransFactorEntity stockTransFactorEntity = stockTransFactorJpaRepository.findOne(stockTransFactor.getId());
		if( stockTransFactorEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		stockTransFactorEntity = new StockTransFactorEntity();
		stockTransFactorServiceMapper.mapStockTransFactorToStockTransFactorEntity(stockTransFactor, stockTransFactorEntity);
		StockTransFactorEntity stockTransFactorEntitySaved = stockTransFactorJpaRepository.save(stockTransFactorEntity);
		return stockTransFactorServiceMapper.mapStockTransFactorEntityToStockTransFactor(stockTransFactorEntitySaved);
	}

	public StockTransFactor update(StockTransFactor stockTransFactor) {
		StockTransFactorEntity stockTransFactorEntity = stockTransFactorJpaRepository.findOne(stockTransFactor.getId());
		stockTransFactorServiceMapper.mapStockTransFactorToStockTransFactorEntity(stockTransFactor, stockTransFactorEntity);
		StockTransFactorEntity stockTransFactorEntitySaved = stockTransFactorJpaRepository.save(stockTransFactorEntity);
		return stockTransFactorServiceMapper.mapStockTransFactorEntityToStockTransFactor(stockTransFactorEntitySaved);
	}

	public void delete(Integer id) {
		stockTransFactorJpaRepository.delete(id);
	}

	public StockTransFactorJpaRepository getStockTransFactorJpaRepository() {
		return stockTransFactorJpaRepository;
	}

	public void setStockTransFactorJpaRepository(StockTransFactorJpaRepository stockTransFactorJpaRepository) {
		this.stockTransFactorJpaRepository = stockTransFactorJpaRepository;
	}

	public StockTransFactorServiceMapper getStockTransFactorServiceMapper() {
		return stockTransFactorServiceMapper;
	}

	public void setStockTransFactorServiceMapper(StockTransFactorServiceMapper stockTransFactorServiceMapper) {
		this.stockTransFactorServiceMapper = stockTransFactorServiceMapper;
	}

}
