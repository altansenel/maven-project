/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.OrderTransStatus;
import org.demo.bean.jpa.OrderTransStatusEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.OrderTransStatusService;
import org.demo.business.service.mapping.OrderTransStatusServiceMapper;
import org.demo.data.repository.jpa.OrderTransStatusJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of OrderTransStatusService
 */
@Component
@Transactional
public class OrderTransStatusServiceImpl implements OrderTransStatusService {

	@Resource
	private OrderTransStatusJpaRepository orderTransStatusJpaRepository;

	@Resource
	private OrderTransStatusServiceMapper orderTransStatusServiceMapper;
	
	public OrderTransStatus findById(Integer id) {
		OrderTransStatusEntity orderTransStatusEntity = orderTransStatusJpaRepository.findOne(id);
		return orderTransStatusServiceMapper.mapOrderTransStatusEntityToOrderTransStatus(orderTransStatusEntity);
	}

	public List<OrderTransStatus> findAll() {
		Iterable<OrderTransStatusEntity> entities = orderTransStatusJpaRepository.findAll();
		List<OrderTransStatus> beans = new ArrayList<OrderTransStatus>();
		for(OrderTransStatusEntity orderTransStatusEntity : entities) {
			beans.add(orderTransStatusServiceMapper.mapOrderTransStatusEntityToOrderTransStatus(orderTransStatusEntity));
		}
		return beans;
	}

	public OrderTransStatus save(OrderTransStatus orderTransStatus) {
		return update(orderTransStatus) ;
	}

	public OrderTransStatus create(OrderTransStatus orderTransStatus) {
		OrderTransStatusEntity orderTransStatusEntity = orderTransStatusJpaRepository.findOne(orderTransStatus.getId());
		if( orderTransStatusEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		orderTransStatusEntity = new OrderTransStatusEntity();
		orderTransStatusServiceMapper.mapOrderTransStatusToOrderTransStatusEntity(orderTransStatus, orderTransStatusEntity);
		OrderTransStatusEntity orderTransStatusEntitySaved = orderTransStatusJpaRepository.save(orderTransStatusEntity);
		return orderTransStatusServiceMapper.mapOrderTransStatusEntityToOrderTransStatus(orderTransStatusEntitySaved);
	}

	public OrderTransStatus update(OrderTransStatus orderTransStatus) {
		OrderTransStatusEntity orderTransStatusEntity = orderTransStatusJpaRepository.findOne(orderTransStatus.getId());
		orderTransStatusServiceMapper.mapOrderTransStatusToOrderTransStatusEntity(orderTransStatus, orderTransStatusEntity);
		OrderTransStatusEntity orderTransStatusEntitySaved = orderTransStatusJpaRepository.save(orderTransStatusEntity);
		return orderTransStatusServiceMapper.mapOrderTransStatusEntityToOrderTransStatus(orderTransStatusEntitySaved);
	}

	public void delete(Integer id) {
		orderTransStatusJpaRepository.delete(id);
	}

	public OrderTransStatusJpaRepository getOrderTransStatusJpaRepository() {
		return orderTransStatusJpaRepository;
	}

	public void setOrderTransStatusJpaRepository(OrderTransStatusJpaRepository orderTransStatusJpaRepository) {
		this.orderTransStatusJpaRepository = orderTransStatusJpaRepository;
	}

	public OrderTransStatusServiceMapper getOrderTransStatusServiceMapper() {
		return orderTransStatusServiceMapper;
	}

	public void setOrderTransStatusServiceMapper(OrderTransStatusServiceMapper orderTransStatusServiceMapper) {
		this.orderTransStatusServiceMapper = orderTransStatusServiceMapper;
	}

}