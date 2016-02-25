/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.OrderTransSource;
import org.demo.bean.jpa.OrderTransSourceEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.OrderTransSourceService;
import org.demo.business.service.mapping.OrderTransSourceServiceMapper;
import org.demo.data.repository.jpa.OrderTransSourceJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of OrderTransSourceService
 */
@Component
@Transactional
public class OrderTransSourceServiceImpl implements OrderTransSourceService {

	@Resource
	private OrderTransSourceJpaRepository orderTransSourceJpaRepository;

	@Resource
	private OrderTransSourceServiceMapper orderTransSourceServiceMapper;
	
	public OrderTransSource findById(Integer id) {
		OrderTransSourceEntity orderTransSourceEntity = orderTransSourceJpaRepository.findOne(id);
		return orderTransSourceServiceMapper.mapOrderTransSourceEntityToOrderTransSource(orderTransSourceEntity);
	}

	public List<OrderTransSource> findAll() {
		Iterable<OrderTransSourceEntity> entities = orderTransSourceJpaRepository.findAll();
		List<OrderTransSource> beans = new ArrayList<OrderTransSource>();
		for(OrderTransSourceEntity orderTransSourceEntity : entities) {
			beans.add(orderTransSourceServiceMapper.mapOrderTransSourceEntityToOrderTransSource(orderTransSourceEntity));
		}
		return beans;
	}

	public OrderTransSource save(OrderTransSource orderTransSource) {
		return update(orderTransSource) ;
	}

	public OrderTransSource create(OrderTransSource orderTransSource) {
		OrderTransSourceEntity orderTransSourceEntity = orderTransSourceJpaRepository.findOne(orderTransSource.getId());
		if( orderTransSourceEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		orderTransSourceEntity = new OrderTransSourceEntity();
		orderTransSourceServiceMapper.mapOrderTransSourceToOrderTransSourceEntity(orderTransSource, orderTransSourceEntity);
		OrderTransSourceEntity orderTransSourceEntitySaved = orderTransSourceJpaRepository.save(orderTransSourceEntity);
		return orderTransSourceServiceMapper.mapOrderTransSourceEntityToOrderTransSource(orderTransSourceEntitySaved);
	}

	public OrderTransSource update(OrderTransSource orderTransSource) {
		OrderTransSourceEntity orderTransSourceEntity = orderTransSourceJpaRepository.findOne(orderTransSource.getId());
		orderTransSourceServiceMapper.mapOrderTransSourceToOrderTransSourceEntity(orderTransSource, orderTransSourceEntity);
		OrderTransSourceEntity orderTransSourceEntitySaved = orderTransSourceJpaRepository.save(orderTransSourceEntity);
		return orderTransSourceServiceMapper.mapOrderTransSourceEntityToOrderTransSource(orderTransSourceEntitySaved);
	}

	public void delete(Integer id) {
		orderTransSourceJpaRepository.delete(id);
	}

	public OrderTransSourceJpaRepository getOrderTransSourceJpaRepository() {
		return orderTransSourceJpaRepository;
	}

	public void setOrderTransSourceJpaRepository(OrderTransSourceJpaRepository orderTransSourceJpaRepository) {
		this.orderTransSourceJpaRepository = orderTransSourceJpaRepository;
	}

	public OrderTransSourceServiceMapper getOrderTransSourceServiceMapper() {
		return orderTransSourceServiceMapper;
	}

	public void setOrderTransSourceServiceMapper(OrderTransSourceServiceMapper orderTransSourceServiceMapper) {
		this.orderTransSourceServiceMapper = orderTransSourceServiceMapper;
	}

}
