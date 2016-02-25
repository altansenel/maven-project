/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.ContactCategory;
import org.demo.bean.jpa.ContactCategoryEntity;
import java.util.Date;
import java.util.List;
import org.demo.business.service.ContactCategoryService;
import org.demo.business.service.mapping.ContactCategoryServiceMapper;
import org.demo.data.repository.jpa.ContactCategoryJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of ContactCategoryService
 */
@Component
@Transactional
public class ContactCategoryServiceImpl implements ContactCategoryService {

	@Resource
	private ContactCategoryJpaRepository contactCategoryJpaRepository;

	@Resource
	private ContactCategoryServiceMapper contactCategoryServiceMapper;
	
	public ContactCategory findById(Integer id) {
		ContactCategoryEntity contactCategoryEntity = contactCategoryJpaRepository.findOne(id);
		return contactCategoryServiceMapper.mapContactCategoryEntityToContactCategory(contactCategoryEntity);
	}

	public List<ContactCategory> findAll() {
		Iterable<ContactCategoryEntity> entities = contactCategoryJpaRepository.findAll();
		List<ContactCategory> beans = new ArrayList<ContactCategory>();
		for(ContactCategoryEntity contactCategoryEntity : entities) {
			beans.add(contactCategoryServiceMapper.mapContactCategoryEntityToContactCategory(contactCategoryEntity));
		}
		return beans;
	}

	public ContactCategory save(ContactCategory contactCategory) {
		return update(contactCategory) ;
	}

	public ContactCategory create(ContactCategory contactCategory) {
		ContactCategoryEntity contactCategoryEntity = contactCategoryJpaRepository.findOne(contactCategory.getId());
		if( contactCategoryEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		contactCategoryEntity = new ContactCategoryEntity();
		contactCategoryServiceMapper.mapContactCategoryToContactCategoryEntity(contactCategory, contactCategoryEntity);
		ContactCategoryEntity contactCategoryEntitySaved = contactCategoryJpaRepository.save(contactCategoryEntity);
		return contactCategoryServiceMapper.mapContactCategoryEntityToContactCategory(contactCategoryEntitySaved);
	}

	public ContactCategory update(ContactCategory contactCategory) {
		ContactCategoryEntity contactCategoryEntity = contactCategoryJpaRepository.findOne(contactCategory.getId());
		contactCategoryServiceMapper.mapContactCategoryToContactCategoryEntity(contactCategory, contactCategoryEntity);
		ContactCategoryEntity contactCategoryEntitySaved = contactCategoryJpaRepository.save(contactCategoryEntity);
		return contactCategoryServiceMapper.mapContactCategoryEntityToContactCategory(contactCategoryEntitySaved);
	}

	public void delete(Integer id) {
		contactCategoryJpaRepository.delete(id);
	}

	public ContactCategoryJpaRepository getContactCategoryJpaRepository() {
		return contactCategoryJpaRepository;
	}

	public void setContactCategoryJpaRepository(ContactCategoryJpaRepository contactCategoryJpaRepository) {
		this.contactCategoryJpaRepository = contactCategoryJpaRepository;
	}

	public ContactCategoryServiceMapper getContactCategoryServiceMapper() {
		return contactCategoryServiceMapper;
	}

	public void setContactCategoryServiceMapper(ContactCategoryServiceMapper contactCategoryServiceMapper) {
		this.contactCategoryServiceMapper = contactCategoryServiceMapper;
	}

}
