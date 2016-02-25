/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.StockCosting;
import org.demo.bean.jpa.StockCostingEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.StockCostingService;
import org.demo.business.service.mapping.StockCostingServiceMapper;
import org.demo.data.repository.jpa.StockCostingJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of StockCostingService
 */
@Component
@Transactional
public class StockCostingServiceImpl implements StockCostingService {

	@Resource
	private StockCostingJpaRepository stockCostingJpaRepository;

	@Resource
	private StockCostingServiceMapper stockCostingServiceMapper;
	
	public StockCosting findById(Integer id) {
		StockCostingEntity stockCostingEntity = stockCostingJpaRepository.findOne(id);
		return stockCostingServiceMapper.mapStockCostingEntityToStockCosting(stockCostingEntity);
	}

	public List<StockCosting> findAll() {
		Iterable<StockCostingEntity> entities = stockCostingJpaRepository.findAll();
		List<StockCosting> beans = new ArrayList<StockCosting>();
		for(StockCostingEntity stockCostingEntity : entities) {
			beans.add(stockCostingServiceMapper.mapStockCostingEntityToStockCosting(stockCostingEntity));
		}
		return beans;
	}

	public StockCosting save(StockCosting stockCosting) {
		return update(stockCosting) ;
	}

	public StockCosting create(StockCosting stockCosting) {
		StockCostingEntity stockCostingEntity = stockCostingJpaRepository.findOne(stockCosting.getId());
		if( stockCostingEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		stockCostingEntity = new StockCostingEntity();
		stockCostingServiceMapper.mapStockCostingToStockCostingEntity(stockCosting, stockCostingEntity);
		StockCostingEntity stockCostingEntitySaved = stockCostingJpaRepository.save(stockCostingEntity);
		return stockCostingServiceMapper.mapStockCostingEntityToStockCosting(stockCostingEntitySaved);
	}

	public StockCosting update(StockCosting stockCosting) {
		StockCostingEntity stockCostingEntity = stockCostingJpaRepository.findOne(stockCosting.getId());
		stockCostingServiceMapper.mapStockCostingToStockCostingEntity(stockCosting, stockCostingEntity);
		StockCostingEntity stockCostingEntitySaved = stockCostingJpaRepository.save(stockCostingEntity);
		return stockCostingServiceMapper.mapStockCostingEntityToStockCosting(stockCostingEntitySaved);
	}

	public void delete(Integer id) {
		stockCostingJpaRepository.delete(id);
	}

	public StockCostingJpaRepository getStockCostingJpaRepository() {
		return stockCostingJpaRepository;
	}

	public void setStockCostingJpaRepository(StockCostingJpaRepository stockCostingJpaRepository) {
		this.stockCostingJpaRepository = stockCostingJpaRepository;
	}

	public StockCostingServiceMapper getStockCostingServiceMapper() {
		return stockCostingServiceMapper;
	}

	public void setStockCostingServiceMapper(StockCostingServiceMapper stockCostingServiceMapper) {
		this.stockCostingServiceMapper = stockCostingServiceMapper;
	}

}
