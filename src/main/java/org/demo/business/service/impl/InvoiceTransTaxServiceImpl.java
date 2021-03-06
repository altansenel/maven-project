/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.InvoiceTransTax;
import org.demo.bean.jpa.InvoiceTransTaxEntity;
import org.demo.business.service.InvoiceTransTaxService;
import org.demo.business.service.mapping.InvoiceTransTaxServiceMapper;
import org.demo.data.repository.jpa.InvoiceTransTaxJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of InvoiceTransTaxService
 */
@Component
@Transactional
public class InvoiceTransTaxServiceImpl implements InvoiceTransTaxService {

	@Resource
	private InvoiceTransTaxJpaRepository invoiceTransTaxJpaRepository;

	@Resource
	private InvoiceTransTaxServiceMapper invoiceTransTaxServiceMapper;
	
	public InvoiceTransTax findById(Integer id) {
		InvoiceTransTaxEntity invoiceTransTaxEntity = invoiceTransTaxJpaRepository.findOne(id);
		return invoiceTransTaxServiceMapper.mapInvoiceTransTaxEntityToInvoiceTransTax(invoiceTransTaxEntity);
	}

	public List<InvoiceTransTax> findAll() {
		Iterable<InvoiceTransTaxEntity> entities = invoiceTransTaxJpaRepository.findAll();
		List<InvoiceTransTax> beans = new ArrayList<InvoiceTransTax>();
		for(InvoiceTransTaxEntity invoiceTransTaxEntity : entities) {
			beans.add(invoiceTransTaxServiceMapper.mapInvoiceTransTaxEntityToInvoiceTransTax(invoiceTransTaxEntity));
		}
		return beans;
	}

	public InvoiceTransTax save(InvoiceTransTax invoiceTransTax) {
		return update(invoiceTransTax) ;
	}

	public InvoiceTransTax create(InvoiceTransTax invoiceTransTax) {
		InvoiceTransTaxEntity invoiceTransTaxEntity = invoiceTransTaxJpaRepository.findOne(invoiceTransTax.getId());
		if( invoiceTransTaxEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		invoiceTransTaxEntity = new InvoiceTransTaxEntity();
		invoiceTransTaxServiceMapper.mapInvoiceTransTaxToInvoiceTransTaxEntity(invoiceTransTax, invoiceTransTaxEntity);
		InvoiceTransTaxEntity invoiceTransTaxEntitySaved = invoiceTransTaxJpaRepository.save(invoiceTransTaxEntity);
		return invoiceTransTaxServiceMapper.mapInvoiceTransTaxEntityToInvoiceTransTax(invoiceTransTaxEntitySaved);
	}

	public InvoiceTransTax update(InvoiceTransTax invoiceTransTax) {
		InvoiceTransTaxEntity invoiceTransTaxEntity = invoiceTransTaxJpaRepository.findOne(invoiceTransTax.getId());
		invoiceTransTaxServiceMapper.mapInvoiceTransTaxToInvoiceTransTaxEntity(invoiceTransTax, invoiceTransTaxEntity);
		InvoiceTransTaxEntity invoiceTransTaxEntitySaved = invoiceTransTaxJpaRepository.save(invoiceTransTaxEntity);
		return invoiceTransTaxServiceMapper.mapInvoiceTransTaxEntityToInvoiceTransTax(invoiceTransTaxEntitySaved);
	}

	public void delete(Integer id) {
		invoiceTransTaxJpaRepository.delete(id);
	}

	public InvoiceTransTaxJpaRepository getInvoiceTransTaxJpaRepository() {
		return invoiceTransTaxJpaRepository;
	}

	public void setInvoiceTransTaxJpaRepository(InvoiceTransTaxJpaRepository invoiceTransTaxJpaRepository) {
		this.invoiceTransTaxJpaRepository = invoiceTransTaxJpaRepository;
	}

	public InvoiceTransTaxServiceMapper getInvoiceTransTaxServiceMapper() {
		return invoiceTransTaxServiceMapper;
	}

	public void setInvoiceTransTaxServiceMapper(InvoiceTransTaxServiceMapper invoiceTransTaxServiceMapper) {
		this.invoiceTransTaxServiceMapper = invoiceTransTaxServiceMapper;
	}

}
