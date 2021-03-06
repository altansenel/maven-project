/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.InvoiceTransCurrency;
import org.demo.bean.jpa.InvoiceTransCurrencyEntity;
import org.demo.business.service.InvoiceTransCurrencyService;
import org.demo.business.service.mapping.InvoiceTransCurrencyServiceMapper;
import org.demo.data.repository.jpa.InvoiceTransCurrencyJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of InvoiceTransCurrencyService
 */
@Component
@Transactional
public class InvoiceTransCurrencyServiceImpl implements InvoiceTransCurrencyService {

	@Resource
	private InvoiceTransCurrencyJpaRepository invoiceTransCurrencyJpaRepository;

	@Resource
	private InvoiceTransCurrencyServiceMapper invoiceTransCurrencyServiceMapper;
	
	public InvoiceTransCurrency findById(Integer id) {
		InvoiceTransCurrencyEntity invoiceTransCurrencyEntity = invoiceTransCurrencyJpaRepository.findOne(id);
		return invoiceTransCurrencyServiceMapper.mapInvoiceTransCurrencyEntityToInvoiceTransCurrency(invoiceTransCurrencyEntity);
	}

	public List<InvoiceTransCurrency> findAll() {
		Iterable<InvoiceTransCurrencyEntity> entities = invoiceTransCurrencyJpaRepository.findAll();
		List<InvoiceTransCurrency> beans = new ArrayList<InvoiceTransCurrency>();
		for(InvoiceTransCurrencyEntity invoiceTransCurrencyEntity : entities) {
			beans.add(invoiceTransCurrencyServiceMapper.mapInvoiceTransCurrencyEntityToInvoiceTransCurrency(invoiceTransCurrencyEntity));
		}
		return beans;
	}

	public InvoiceTransCurrency save(InvoiceTransCurrency invoiceTransCurrency) {
		return update(invoiceTransCurrency) ;
	}

	public InvoiceTransCurrency create(InvoiceTransCurrency invoiceTransCurrency) {
		InvoiceTransCurrencyEntity invoiceTransCurrencyEntity = invoiceTransCurrencyJpaRepository.findOne(invoiceTransCurrency.getId());
		if( invoiceTransCurrencyEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		invoiceTransCurrencyEntity = new InvoiceTransCurrencyEntity();
		invoiceTransCurrencyServiceMapper.mapInvoiceTransCurrencyToInvoiceTransCurrencyEntity(invoiceTransCurrency, invoiceTransCurrencyEntity);
		InvoiceTransCurrencyEntity invoiceTransCurrencyEntitySaved = invoiceTransCurrencyJpaRepository.save(invoiceTransCurrencyEntity);
		return invoiceTransCurrencyServiceMapper.mapInvoiceTransCurrencyEntityToInvoiceTransCurrency(invoiceTransCurrencyEntitySaved);
	}

	public InvoiceTransCurrency update(InvoiceTransCurrency invoiceTransCurrency) {
		InvoiceTransCurrencyEntity invoiceTransCurrencyEntity = invoiceTransCurrencyJpaRepository.findOne(invoiceTransCurrency.getId());
		invoiceTransCurrencyServiceMapper.mapInvoiceTransCurrencyToInvoiceTransCurrencyEntity(invoiceTransCurrency, invoiceTransCurrencyEntity);
		InvoiceTransCurrencyEntity invoiceTransCurrencyEntitySaved = invoiceTransCurrencyJpaRepository.save(invoiceTransCurrencyEntity);
		return invoiceTransCurrencyServiceMapper.mapInvoiceTransCurrencyEntityToInvoiceTransCurrency(invoiceTransCurrencyEntitySaved);
	}

	public void delete(Integer id) {
		invoiceTransCurrencyJpaRepository.delete(id);
	}

	public InvoiceTransCurrencyJpaRepository getInvoiceTransCurrencyJpaRepository() {
		return invoiceTransCurrencyJpaRepository;
	}

	public void setInvoiceTransCurrencyJpaRepository(InvoiceTransCurrencyJpaRepository invoiceTransCurrencyJpaRepository) {
		this.invoiceTransCurrencyJpaRepository = invoiceTransCurrencyJpaRepository;
	}

	public InvoiceTransCurrencyServiceMapper getInvoiceTransCurrencyServiceMapper() {
		return invoiceTransCurrencyServiceMapper;
	}

	public void setInvoiceTransCurrencyServiceMapper(InvoiceTransCurrencyServiceMapper invoiceTransCurrencyServiceMapper) {
		this.invoiceTransCurrencyServiceMapper = invoiceTransCurrencyServiceMapper;
	}

}
