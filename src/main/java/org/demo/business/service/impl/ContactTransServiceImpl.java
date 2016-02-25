/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.ContactTrans;
import org.demo.bean.jpa.ContactTransEntity;
import java.util.Date;
import org.demo.business.service.ContactTransService;
import org.demo.business.service.mapping.ContactTransServiceMapper;
import org.demo.data.repository.jpa.ContactTransJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of ContactTransService
 */
@Component
@Transactional
public class ContactTransServiceImpl implements ContactTransService {

	@Resource
	private ContactTransJpaRepository contactTransJpaRepository;

	@Resource
	private ContactTransServiceMapper contactTransServiceMapper;
	
	public ContactTrans findById(Integer id) {
		ContactTransEntity contactTransEntity = contactTransJpaRepository.findOne(id);
		return contactTransServiceMapper.mapContactTransEntityToContactTrans(contactTransEntity);
	}

	public List<ContactTrans> findAll() {
		Iterable<ContactTransEntity> entities = contactTransJpaRepository.findAll();
		List<ContactTrans> beans = new ArrayList<ContactTrans>();
		for(ContactTransEntity contactTransEntity : entities) {
			beans.add(contactTransServiceMapper.mapContactTransEntityToContactTrans(contactTransEntity));
		}
		return beans;
	}

	public ContactTrans save(ContactTrans contactTrans) {
		return update(contactTrans) ;
	}

	public ContactTrans create(ContactTrans contactTrans) {
		ContactTransEntity contactTransEntity = contactTransJpaRepository.findOne(contactTrans.getId());
		if( contactTransEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		contactTransEntity = new ContactTransEntity();
		contactTransServiceMapper.mapContactTransToContactTransEntity(contactTrans, contactTransEntity);
		ContactTransEntity contactTransEntitySaved = contactTransJpaRepository.save(contactTransEntity);
		return contactTransServiceMapper.mapContactTransEntityToContactTrans(contactTransEntitySaved);
	}

	public ContactTrans update(ContactTrans contactTrans) {
		ContactTransEntity contactTransEntity = contactTransJpaRepository.findOne(contactTrans.getId());
		contactTransServiceMapper.mapContactTransToContactTransEntity(contactTrans, contactTransEntity);
		ContactTransEntity contactTransEntitySaved = contactTransJpaRepository.save(contactTransEntity);
		return contactTransServiceMapper.mapContactTransEntityToContactTrans(contactTransEntitySaved);
	}

	public void delete(Integer id) {
		contactTransJpaRepository.delete(id);
	}

	public ContactTransJpaRepository getContactTransJpaRepository() {
		return contactTransJpaRepository;
	}

	public void setContactTransJpaRepository(ContactTransJpaRepository contactTransJpaRepository) {
		this.contactTransJpaRepository = contactTransJpaRepository;
	}

	public ContactTransServiceMapper getContactTransServiceMapper() {
		return contactTransServiceMapper;
	}

	public void setContactTransServiceMapper(ContactTransServiceMapper contactTransServiceMapper) {
		this.contactTransServiceMapper = contactTransServiceMapper;
	}

}