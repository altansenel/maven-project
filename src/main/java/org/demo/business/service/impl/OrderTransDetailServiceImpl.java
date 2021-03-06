/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.OrderTransDetail;
import org.demo.bean.jpa.OrderTransDetailEntity;
import java.util.Date;
import org.demo.business.service.OrderTransDetailService;
import org.demo.business.service.mapping.OrderTransDetailServiceMapper;
import org.demo.data.repository.jpa.OrderTransDetailJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of OrderTransDetailService
 */
@Component
@Transactional
public class OrderTransDetailServiceImpl implements OrderTransDetailService {

	@Resource
	private OrderTransDetailJpaRepository orderTransDetailJpaRepository;

	@Resource
	private OrderTransDetailServiceMapper orderTransDetailServiceMapper;
	
	public OrderTransDetail findById(Integer id) {
		OrderTransDetailEntity orderTransDetailEntity = orderTransDetailJpaRepository.findOne(id);
		return orderTransDetailServiceMapper.mapOrderTransDetailEntityToOrderTransDetail(orderTransDetailEntity);
	}

	public List<OrderTransDetail> findAll() {
		Iterable<OrderTransDetailEntity> entities = orderTransDetailJpaRepository.findAll();
		List<OrderTransDetail> beans = new ArrayList<OrderTransDetail>();
		for(OrderTransDetailEntity orderTransDetailEntity : entities) {
			beans.add(orderTransDetailServiceMapper.mapOrderTransDetailEntityToOrderTransDetail(orderTransDetailEntity));
		}
		return beans;
	}

	public OrderTransDetail save(OrderTransDetail orderTransDetail) {
		return update(orderTransDetail) ;
	}

	public OrderTransDetail create(OrderTransDetail orderTransDetail) {
		OrderTransDetailEntity orderTransDetailEntity = orderTransDetailJpaRepository.findOne(orderTransDetail.getId());
		if( orderTransDetailEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		orderTransDetailEntity = new OrderTransDetailEntity();
		orderTransDetailServiceMapper.mapOrderTransDetailToOrderTransDetailEntity(orderTransDetail, orderTransDetailEntity);
		OrderTransDetailEntity orderTransDetailEntitySaved = orderTransDetailJpaRepository.save(orderTransDetailEntity);
		return orderTransDetailServiceMapper.mapOrderTransDetailEntityToOrderTransDetail(orderTransDetailEntitySaved);
	}

	public OrderTransDetail update(OrderTransDetail orderTransDetail) {
		OrderTransDetailEntity orderTransDetailEntity = orderTransDetailJpaRepository.findOne(orderTransDetail.getId());
		orderTransDetailServiceMapper.mapOrderTransDetailToOrderTransDetailEntity(orderTransDetail, orderTransDetailEntity);
		OrderTransDetailEntity orderTransDetailEntitySaved = orderTransDetailJpaRepository.save(orderTransDetailEntity);
		return orderTransDetailServiceMapper.mapOrderTransDetailEntityToOrderTransDetail(orderTransDetailEntitySaved);
	}

	public void delete(Integer id) {
		orderTransDetailJpaRepository.delete(id);
	}

	public OrderTransDetailJpaRepository getOrderTransDetailJpaRepository() {
		return orderTransDetailJpaRepository;
	}

	public void setOrderTransDetailJpaRepository(OrderTransDetailJpaRepository orderTransDetailJpaRepository) {
		this.orderTransDetailJpaRepository = orderTransDetailJpaRepository;
	}

	public OrderTransDetailServiceMapper getOrderTransDetailServiceMapper() {
		return orderTransDetailServiceMapper;
	}

	public void setOrderTransDetailServiceMapper(OrderTransDetailServiceMapper orderTransDetailServiceMapper) {
		this.orderTransDetailServiceMapper = orderTransDetailServiceMapper;
	}

}
