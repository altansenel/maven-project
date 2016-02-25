/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.StockCostingDetail;
import org.demo.bean.jpa.StockCostingDetailEntity;
import java.util.Date;
import org.demo.business.service.StockCostingDetailService;
import org.demo.business.service.mapping.StockCostingDetailServiceMapper;
import org.demo.data.repository.jpa.StockCostingDetailJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of StockCostingDetailService
 */
@Component
@Transactional
public class StockCostingDetailServiceImpl implements StockCostingDetailService {

	@Resource
	private StockCostingDetailJpaRepository stockCostingDetailJpaRepository;

	@Resource
	private StockCostingDetailServiceMapper stockCostingDetailServiceMapper;
	
	public StockCostingDetail findById(Integer id) {
		StockCostingDetailEntity stockCostingDetailEntity = stockCostingDetailJpaRepository.findOne(id);
		return stockCostingDetailServiceMapper.mapStockCostingDetailEntityToStockCostingDetail(stockCostingDetailEntity);
	}

	public List<StockCostingDetail> findAll() {
		Iterable<StockCostingDetailEntity> entities = stockCostingDetailJpaRepository.findAll();
		List<StockCostingDetail> beans = new ArrayList<StockCostingDetail>();
		for(StockCostingDetailEntity stockCostingDetailEntity : entities) {
			beans.add(stockCostingDetailServiceMapper.mapStockCostingDetailEntityToStockCostingDetail(stockCostingDetailEntity));
		}
		return beans;
	}

	public StockCostingDetail save(StockCostingDetail stockCostingDetail) {
		return update(stockCostingDetail) ;
	}

	public StockCostingDetail create(StockCostingDetail stockCostingDetail) {
		StockCostingDetailEntity stockCostingDetailEntity = stockCostingDetailJpaRepository.findOne(stockCostingDetail.getId());
		if( stockCostingDetailEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		stockCostingDetailEntity = new StockCostingDetailEntity();
		stockCostingDetailServiceMapper.mapStockCostingDetailToStockCostingDetailEntity(stockCostingDetail, stockCostingDetailEntity);
		StockCostingDetailEntity stockCostingDetailEntitySaved = stockCostingDetailJpaRepository.save(stockCostingDetailEntity);
		return stockCostingDetailServiceMapper.mapStockCostingDetailEntityToStockCostingDetail(stockCostingDetailEntitySaved);
	}

	public StockCostingDetail update(StockCostingDetail stockCostingDetail) {
		StockCostingDetailEntity stockCostingDetailEntity = stockCostingDetailJpaRepository.findOne(stockCostingDetail.getId());
		stockCostingDetailServiceMapper.mapStockCostingDetailToStockCostingDetailEntity(stockCostingDetail, stockCostingDetailEntity);
		StockCostingDetailEntity stockCostingDetailEntitySaved = stockCostingDetailJpaRepository.save(stockCostingDetailEntity);
		return stockCostingDetailServiceMapper.mapStockCostingDetailEntityToStockCostingDetail(stockCostingDetailEntitySaved);
	}

	public void delete(Integer id) {
		stockCostingDetailJpaRepository.delete(id);
	}

	public StockCostingDetailJpaRepository getStockCostingDetailJpaRepository() {
		return stockCostingDetailJpaRepository;
	}

	public void setStockCostingDetailJpaRepository(StockCostingDetailJpaRepository stockCostingDetailJpaRepository) {
		this.stockCostingDetailJpaRepository = stockCostingDetailJpaRepository;
	}

	public StockCostingDetailServiceMapper getStockCostingDetailServiceMapper() {
		return stockCostingDetailServiceMapper;
	}

	public void setStockCostingDetailServiceMapper(StockCostingDetailServiceMapper stockCostingDetailServiceMapper) {
		this.stockCostingDetailServiceMapper = stockCostingDetailServiceMapper;
	}

}
