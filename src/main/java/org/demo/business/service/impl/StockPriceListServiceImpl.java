/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.StockPriceList;
import org.demo.bean.jpa.StockPriceListEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.StockPriceListService;
import org.demo.business.service.mapping.StockPriceListServiceMapper;
import org.demo.data.repository.jpa.StockPriceListJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of StockPriceListService
 */
@Component
@Transactional
public class StockPriceListServiceImpl implements StockPriceListService {

	@Resource
	private StockPriceListJpaRepository stockPriceListJpaRepository;

	@Resource
	private StockPriceListServiceMapper stockPriceListServiceMapper;
	
	public StockPriceList findById(Integer id) {
		StockPriceListEntity stockPriceListEntity = stockPriceListJpaRepository.findOne(id);
		return stockPriceListServiceMapper.mapStockPriceListEntityToStockPriceList(stockPriceListEntity);
	}

	public List<StockPriceList> findAll() {
		Iterable<StockPriceListEntity> entities = stockPriceListJpaRepository.findAll();
		List<StockPriceList> beans = new ArrayList<StockPriceList>();
		for(StockPriceListEntity stockPriceListEntity : entities) {
			beans.add(stockPriceListServiceMapper.mapStockPriceListEntityToStockPriceList(stockPriceListEntity));
		}
		return beans;
	}

	public StockPriceList save(StockPriceList stockPriceList) {
		return update(stockPriceList) ;
	}

	public StockPriceList create(StockPriceList stockPriceList) {
		StockPriceListEntity stockPriceListEntity = stockPriceListJpaRepository.findOne(stockPriceList.getId());
		if( stockPriceListEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		stockPriceListEntity = new StockPriceListEntity();
		stockPriceListServiceMapper.mapStockPriceListToStockPriceListEntity(stockPriceList, stockPriceListEntity);
		StockPriceListEntity stockPriceListEntitySaved = stockPriceListJpaRepository.save(stockPriceListEntity);
		return stockPriceListServiceMapper.mapStockPriceListEntityToStockPriceList(stockPriceListEntitySaved);
	}

	public StockPriceList update(StockPriceList stockPriceList) {
		StockPriceListEntity stockPriceListEntity = stockPriceListJpaRepository.findOne(stockPriceList.getId());
		stockPriceListServiceMapper.mapStockPriceListToStockPriceListEntity(stockPriceList, stockPriceListEntity);
		StockPriceListEntity stockPriceListEntitySaved = stockPriceListJpaRepository.save(stockPriceListEntity);
		return stockPriceListServiceMapper.mapStockPriceListEntityToStockPriceList(stockPriceListEntitySaved);
	}

	public void delete(Integer id) {
		stockPriceListJpaRepository.delete(id);
	}

	public StockPriceListJpaRepository getStockPriceListJpaRepository() {
		return stockPriceListJpaRepository;
	}

	public void setStockPriceListJpaRepository(StockPriceListJpaRepository stockPriceListJpaRepository) {
		this.stockPriceListJpaRepository = stockPriceListJpaRepository;
	}

	public StockPriceListServiceMapper getStockPriceListServiceMapper() {
		return stockPriceListServiceMapper;
	}

	public void setStockPriceListServiceMapper(StockPriceListServiceMapper stockPriceListServiceMapper) {
		this.stockPriceListServiceMapper = stockPriceListServiceMapper;
	}

}