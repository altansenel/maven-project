/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.StockTransDetail;
import org.demo.bean.jpa.StockTransDetailEntity;
import java.util.Date;
import org.demo.business.service.StockTransDetailService;
import org.demo.business.service.mapping.StockTransDetailServiceMapper;
import org.demo.data.repository.jpa.StockTransDetailJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of StockTransDetailService
 */
@Component
@Transactional
public class StockTransDetailServiceImpl implements StockTransDetailService {

	@Resource
	private StockTransDetailJpaRepository stockTransDetailJpaRepository;

	@Resource
	private StockTransDetailServiceMapper stockTransDetailServiceMapper;
	
	public StockTransDetail findById(Integer id) {
		StockTransDetailEntity stockTransDetailEntity = stockTransDetailJpaRepository.findOne(id);
		return stockTransDetailServiceMapper.mapStockTransDetailEntityToStockTransDetail(stockTransDetailEntity);
	}

	public List<StockTransDetail> findAll() {
		Iterable<StockTransDetailEntity> entities = stockTransDetailJpaRepository.findAll();
		List<StockTransDetail> beans = new ArrayList<StockTransDetail>();
		for(StockTransDetailEntity stockTransDetailEntity : entities) {
			beans.add(stockTransDetailServiceMapper.mapStockTransDetailEntityToStockTransDetail(stockTransDetailEntity));
		}
		return beans;
	}

	public StockTransDetail save(StockTransDetail stockTransDetail) {
		return update(stockTransDetail) ;
	}

	public StockTransDetail create(StockTransDetail stockTransDetail) {
		StockTransDetailEntity stockTransDetailEntity = stockTransDetailJpaRepository.findOne(stockTransDetail.getId());
		if( stockTransDetailEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		stockTransDetailEntity = new StockTransDetailEntity();
		stockTransDetailServiceMapper.mapStockTransDetailToStockTransDetailEntity(stockTransDetail, stockTransDetailEntity);
		StockTransDetailEntity stockTransDetailEntitySaved = stockTransDetailJpaRepository.save(stockTransDetailEntity);
		return stockTransDetailServiceMapper.mapStockTransDetailEntityToStockTransDetail(stockTransDetailEntitySaved);
	}

	public StockTransDetail update(StockTransDetail stockTransDetail) {
		StockTransDetailEntity stockTransDetailEntity = stockTransDetailJpaRepository.findOne(stockTransDetail.getId());
		stockTransDetailServiceMapper.mapStockTransDetailToStockTransDetailEntity(stockTransDetail, stockTransDetailEntity);
		StockTransDetailEntity stockTransDetailEntitySaved = stockTransDetailJpaRepository.save(stockTransDetailEntity);
		return stockTransDetailServiceMapper.mapStockTransDetailEntityToStockTransDetail(stockTransDetailEntitySaved);
	}

	public void delete(Integer id) {
		stockTransDetailJpaRepository.delete(id);
	}

	public StockTransDetailJpaRepository getStockTransDetailJpaRepository() {
		return stockTransDetailJpaRepository;
	}

	public void setStockTransDetailJpaRepository(StockTransDetailJpaRepository stockTransDetailJpaRepository) {
		this.stockTransDetailJpaRepository = stockTransDetailJpaRepository;
	}

	public StockTransDetailServiceMapper getStockTransDetailServiceMapper() {
		return stockTransDetailServiceMapper;
	}

	public void setStockTransDetailServiceMapper(StockTransDetailServiceMapper stockTransDetailServiceMapper) {
		this.stockTransDetailServiceMapper = stockTransDetailServiceMapper;
	}

}