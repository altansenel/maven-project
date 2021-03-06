/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.InvoiceTransSource;
import org.demo.bean.jpa.InvoiceTransSourceEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.InvoiceTransSourceService;
import org.demo.business.service.mapping.InvoiceTransSourceServiceMapper;
import org.demo.data.repository.jpa.InvoiceTransSourceJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of InvoiceTransSourceService
 */
@Component
@Transactional
public class InvoiceTransSourceServiceImpl implements InvoiceTransSourceService {

	@Resource
	private InvoiceTransSourceJpaRepository invoiceTransSourceJpaRepository;

	@Resource
	private InvoiceTransSourceServiceMapper invoiceTransSourceServiceMapper;
	
	public InvoiceTransSource findById(Integer id) {
		InvoiceTransSourceEntity invoiceTransSourceEntity = invoiceTransSourceJpaRepository.findOne(id);
		return invoiceTransSourceServiceMapper.mapInvoiceTransSourceEntityToInvoiceTransSource(invoiceTransSourceEntity);
	}

	public List<InvoiceTransSource> findAll() {
		Iterable<InvoiceTransSourceEntity> entities = invoiceTransSourceJpaRepository.findAll();
		List<InvoiceTransSource> beans = new ArrayList<InvoiceTransSource>();
		for(InvoiceTransSourceEntity invoiceTransSourceEntity : entities) {
			beans.add(invoiceTransSourceServiceMapper.mapInvoiceTransSourceEntityToInvoiceTransSource(invoiceTransSourceEntity));
		}
		return beans;
	}

	public InvoiceTransSource save(InvoiceTransSource invoiceTransSource) {
		return update(invoiceTransSource) ;
	}

	public InvoiceTransSource create(InvoiceTransSource invoiceTransSource) {
		InvoiceTransSourceEntity invoiceTransSourceEntity = invoiceTransSourceJpaRepository.findOne(invoiceTransSource.getId());
		if( invoiceTransSourceEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		invoiceTransSourceEntity = new InvoiceTransSourceEntity();
		invoiceTransSourceServiceMapper.mapInvoiceTransSourceToInvoiceTransSourceEntity(invoiceTransSource, invoiceTransSourceEntity);
		InvoiceTransSourceEntity invoiceTransSourceEntitySaved = invoiceTransSourceJpaRepository.save(invoiceTransSourceEntity);
		return invoiceTransSourceServiceMapper.mapInvoiceTransSourceEntityToInvoiceTransSource(invoiceTransSourceEntitySaved);
	}

	public InvoiceTransSource update(InvoiceTransSource invoiceTransSource) {
		InvoiceTransSourceEntity invoiceTransSourceEntity = invoiceTransSourceJpaRepository.findOne(invoiceTransSource.getId());
		invoiceTransSourceServiceMapper.mapInvoiceTransSourceToInvoiceTransSourceEntity(invoiceTransSource, invoiceTransSourceEntity);
		InvoiceTransSourceEntity invoiceTransSourceEntitySaved = invoiceTransSourceJpaRepository.save(invoiceTransSourceEntity);
		return invoiceTransSourceServiceMapper.mapInvoiceTransSourceEntityToInvoiceTransSource(invoiceTransSourceEntitySaved);
	}

	public void delete(Integer id) {
		invoiceTransSourceJpaRepository.delete(id);
	}

	public InvoiceTransSourceJpaRepository getInvoiceTransSourceJpaRepository() {
		return invoiceTransSourceJpaRepository;
	}

	public void setInvoiceTransSourceJpaRepository(InvoiceTransSourceJpaRepository invoiceTransSourceJpaRepository) {
		this.invoiceTransSourceJpaRepository = invoiceTransSourceJpaRepository;
	}

	public InvoiceTransSourceServiceMapper getInvoiceTransSourceServiceMapper() {
		return invoiceTransSourceServiceMapper;
	}

	public void setInvoiceTransSourceServiceMapper(InvoiceTransSourceServiceMapper invoiceTransSourceServiceMapper) {
		this.invoiceTransSourceServiceMapper = invoiceTransSourceServiceMapper;
	}

}
