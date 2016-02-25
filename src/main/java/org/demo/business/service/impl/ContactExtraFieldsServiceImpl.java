/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.ContactExtraFields;
import org.demo.bean.jpa.ContactExtraFieldsEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.ContactExtraFieldsService;
import org.demo.business.service.mapping.ContactExtraFieldsServiceMapper;
import org.demo.data.repository.jpa.ContactExtraFieldsJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of ContactExtraFieldsService
 */
@Component
@Transactional
public class ContactExtraFieldsServiceImpl implements ContactExtraFieldsService {

	@Resource
	private ContactExtraFieldsJpaRepository contactExtraFieldsJpaRepository;

	@Resource
	private ContactExtraFieldsServiceMapper contactExtraFieldsServiceMapper;
	
	public ContactExtraFields findById(Integer id) {
		ContactExtraFieldsEntity contactExtraFieldsEntity = contactExtraFieldsJpaRepository.findOne(id);
		return contactExtraFieldsServiceMapper.mapContactExtraFieldsEntityToContactExtraFields(contactExtraFieldsEntity);
	}

	public List<ContactExtraFields> findAll() {
		Iterable<ContactExtraFieldsEntity> entities = contactExtraFieldsJpaRepository.findAll();
		List<ContactExtraFields> beans = new ArrayList<ContactExtraFields>();
		for(ContactExtraFieldsEntity contactExtraFieldsEntity : entities) {
			beans.add(contactExtraFieldsServiceMapper.mapContactExtraFieldsEntityToContactExtraFields(contactExtraFieldsEntity));
		}
		return beans;
	}

	public ContactExtraFields save(ContactExtraFields contactExtraFields) {
		return update(contactExtraFields) ;
	}

	public ContactExtraFields create(ContactExtraFields contactExtraFields) {
		ContactExtraFieldsEntity contactExtraFieldsEntity = contactExtraFieldsJpaRepository.findOne(contactExtraFields.getId());
		if( contactExtraFieldsEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		contactExtraFieldsEntity = new ContactExtraFieldsEntity();
		contactExtraFieldsServiceMapper.mapContactExtraFieldsToContactExtraFieldsEntity(contactExtraFields, contactExtraFieldsEntity);
		ContactExtraFieldsEntity contactExtraFieldsEntitySaved = contactExtraFieldsJpaRepository.save(contactExtraFieldsEntity);
		return contactExtraFieldsServiceMapper.mapContactExtraFieldsEntityToContactExtraFields(contactExtraFieldsEntitySaved);
	}

	public ContactExtraFields update(ContactExtraFields contactExtraFields) {
		ContactExtraFieldsEntity contactExtraFieldsEntity = contactExtraFieldsJpaRepository.findOne(contactExtraFields.getId());
		contactExtraFieldsServiceMapper.mapContactExtraFieldsToContactExtraFieldsEntity(contactExtraFields, contactExtraFieldsEntity);
		ContactExtraFieldsEntity contactExtraFieldsEntitySaved = contactExtraFieldsJpaRepository.save(contactExtraFieldsEntity);
		return contactExtraFieldsServiceMapper.mapContactExtraFieldsEntityToContactExtraFields(contactExtraFieldsEntitySaved);
	}

	public void delete(Integer id) {
		contactExtraFieldsJpaRepository.delete(id);
	}

	public ContactExtraFieldsJpaRepository getContactExtraFieldsJpaRepository() {
		return contactExtraFieldsJpaRepository;
	}

	public void setContactExtraFieldsJpaRepository(ContactExtraFieldsJpaRepository contactExtraFieldsJpaRepository) {
		this.contactExtraFieldsJpaRepository = contactExtraFieldsJpaRepository;
	}

	public ContactExtraFieldsServiceMapper getContactExtraFieldsServiceMapper() {
		return contactExtraFieldsServiceMapper;
	}

	public void setContactExtraFieldsServiceMapper(ContactExtraFieldsServiceMapper contactExtraFieldsServiceMapper) {
		this.contactExtraFieldsServiceMapper = contactExtraFieldsServiceMapper;
	}

}
