/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.OrderTrans;
import org.demo.bean.jpa.OrderTransEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.OrderTransService;
import org.demo.business.service.mapping.OrderTransServiceMapper;
import org.demo.data.repository.jpa.OrderTransJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of OrderTransService
 */
@Component
@Transactional
public class OrderTransServiceImpl implements OrderTransService {

	@Resource
	private OrderTransJpaRepository orderTransJpaRepository;

	@Resource
	private OrderTransServiceMapper orderTransServiceMapper;
	
	public OrderTrans findById(Integer id) {
		OrderTransEntity orderTransEntity = orderTransJpaRepository.findOne(id);
		return orderTransServiceMapper.mapOrderTransEntityToOrderTrans(orderTransEntity);
	}

	public List<OrderTrans> findAll() {
		Iterable<OrderTransEntity> entities = orderTransJpaRepository.findAll();
		List<OrderTrans> beans = new ArrayList<OrderTrans>();
		for(OrderTransEntity orderTransEntity : entities) {
			beans.add(orderTransServiceMapper.mapOrderTransEntityToOrderTrans(orderTransEntity));
		}
		return beans;
	}

	public OrderTrans save(OrderTrans orderTrans) {
		return update(orderTrans) ;
	}

	public OrderTrans create(OrderTrans orderTrans) {
		OrderTransEntity orderTransEntity = orderTransJpaRepository.findOne(orderTrans.getId());
		if( orderTransEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		orderTransEntity = new OrderTransEntity();
		orderTransServiceMapper.mapOrderTransToOrderTransEntity(orderTrans, orderTransEntity);
		OrderTransEntity orderTransEntitySaved = orderTransJpaRepository.save(orderTransEntity);
		return orderTransServiceMapper.mapOrderTransEntityToOrderTrans(orderTransEntitySaved);
	}

	public OrderTrans update(OrderTrans orderTrans) {
		OrderTransEntity orderTransEntity = orderTransJpaRepository.findOne(orderTrans.getId());
		orderTransServiceMapper.mapOrderTransToOrderTransEntity(orderTrans, orderTransEntity);
		OrderTransEntity orderTransEntitySaved = orderTransJpaRepository.save(orderTransEntity);
		return orderTransServiceMapper.mapOrderTransEntityToOrderTrans(orderTransEntitySaved);
	}

	public void delete(Integer id) {
		orderTransJpaRepository.delete(id);
	}

	public OrderTransJpaRepository getOrderTransJpaRepository() {
		return orderTransJpaRepository;
	}

	public void setOrderTransJpaRepository(OrderTransJpaRepository orderTransJpaRepository) {
		this.orderTransJpaRepository = orderTransJpaRepository;
	}

	public OrderTransServiceMapper getOrderTransServiceMapper() {
		return orderTransServiceMapper;
	}

	public void setOrderTransServiceMapper(OrderTransServiceMapper orderTransServiceMapper) {
		this.orderTransServiceMapper = orderTransServiceMapper;
	}

}
