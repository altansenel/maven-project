/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.ContactTransSource;
import org.demo.bean.jpa.ContactTransSourceEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.ContactTransSourceService;
import org.demo.business.service.mapping.ContactTransSourceServiceMapper;
import org.demo.data.repository.jpa.ContactTransSourceJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of ContactTransSourceService
 */
@Component
@Transactional
public class ContactTransSourceServiceImpl implements ContactTransSourceService {

	@Resource
	private ContactTransSourceJpaRepository contactTransSourceJpaRepository;

	@Resource
	private ContactTransSourceServiceMapper contactTransSourceServiceMapper;
	
	public ContactTransSource findById(Integer id) {
		ContactTransSourceEntity contactTransSourceEntity = contactTransSourceJpaRepository.findOne(id);
		return contactTransSourceServiceMapper.mapContactTransSourceEntityToContactTransSource(contactTransSourceEntity);
	}

	public List<ContactTransSource> findAll() {
		Iterable<ContactTransSourceEntity> entities = contactTransSourceJpaRepository.findAll();
		List<ContactTransSource> beans = new ArrayList<ContactTransSource>();
		for(ContactTransSourceEntity contactTransSourceEntity : entities) {
			beans.add(contactTransSourceServiceMapper.mapContactTransSourceEntityToContactTransSource(contactTransSourceEntity));
		}
		return beans;
	}

	public ContactTransSource save(ContactTransSource contactTransSource) {
		return update(contactTransSource) ;
	}

	public ContactTransSource create(ContactTransSource contactTransSource) {
		ContactTransSourceEntity contactTransSourceEntity = contactTransSourceJpaRepository.findOne(contactTransSource.getId());
		if( contactTransSourceEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		contactTransSourceEntity = new ContactTransSourceEntity();
		contactTransSourceServiceMapper.mapContactTransSourceToContactTransSourceEntity(contactTransSource, contactTransSourceEntity);
		ContactTransSourceEntity contactTransSourceEntitySaved = contactTransSourceJpaRepository.save(contactTransSourceEntity);
		return contactTransSourceServiceMapper.mapContactTransSourceEntityToContactTransSource(contactTransSourceEntitySaved);
	}

	public ContactTransSource update(ContactTransSource contactTransSource) {
		ContactTransSourceEntity contactTransSourceEntity = contactTransSourceJpaRepository.findOne(contactTransSource.getId());
		contactTransSourceServiceMapper.mapContactTransSourceToContactTransSourceEntity(contactTransSource, contactTransSourceEntity);
		ContactTransSourceEntity contactTransSourceEntitySaved = contactTransSourceJpaRepository.save(contactTransSourceEntity);
		return contactTransSourceServiceMapper.mapContactTransSourceEntityToContactTransSource(contactTransSourceEntitySaved);
	}

	public void delete(Integer id) {
		contactTransSourceJpaRepository.delete(id);
	}

	public ContactTransSourceJpaRepository getContactTransSourceJpaRepository() {
		return contactTransSourceJpaRepository;
	}

	public void setContactTransSourceJpaRepository(ContactTransSourceJpaRepository contactTransSourceJpaRepository) {
		this.contactTransSourceJpaRepository = contactTransSourceJpaRepository;
	}

	public ContactTransSourceServiceMapper getContactTransSourceServiceMapper() {
		return contactTransSourceServiceMapper;
	}

	public void setContactTransSourceServiceMapper(ContactTransSourceServiceMapper contactTransSourceServiceMapper) {
		this.contactTransSourceServiceMapper = contactTransSourceServiceMapper;
	}

}
