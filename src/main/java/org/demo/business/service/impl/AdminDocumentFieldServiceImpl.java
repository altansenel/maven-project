/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.AdminDocumentField;
import org.demo.bean.jpa.AdminDocumentFieldEntity;
import org.demo.business.service.AdminDocumentFieldService;
import org.demo.business.service.mapping.AdminDocumentFieldServiceMapper;
import org.demo.data.repository.jpa.AdminDocumentFieldJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of AdminDocumentFieldService
 */
@Component
@Transactional
public class AdminDocumentFieldServiceImpl implements AdminDocumentFieldService {

	@Resource
	private AdminDocumentFieldJpaRepository adminDocumentFieldJpaRepository;

	@Resource
	private AdminDocumentFieldServiceMapper adminDocumentFieldServiceMapper;
	
	public AdminDocumentField findById(Integer id) {
		AdminDocumentFieldEntity adminDocumentFieldEntity = adminDocumentFieldJpaRepository.findOne(id);
		return adminDocumentFieldServiceMapper.mapAdminDocumentFieldEntityToAdminDocumentField(adminDocumentFieldEntity);
	}

	public List<AdminDocumentField> findAll() {
		Iterable<AdminDocumentFieldEntity> entities = adminDocumentFieldJpaRepository.findAll();
		List<AdminDocumentField> beans = new ArrayList<AdminDocumentField>();
		for(AdminDocumentFieldEntity adminDocumentFieldEntity : entities) {
			beans.add(adminDocumentFieldServiceMapper.mapAdminDocumentFieldEntityToAdminDocumentField(adminDocumentFieldEntity));
		}
		return beans;
	}

	public AdminDocumentField save(AdminDocumentField adminDocumentField) {
		return update(adminDocumentField) ;
	}

	public AdminDocumentField create(AdminDocumentField adminDocumentField) {
		AdminDocumentFieldEntity adminDocumentFieldEntity = adminDocumentFieldJpaRepository.findOne(adminDocumentField.getId());
		if( adminDocumentFieldEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		adminDocumentFieldEntity = new AdminDocumentFieldEntity();
		adminDocumentFieldServiceMapper.mapAdminDocumentFieldToAdminDocumentFieldEntity(adminDocumentField, adminDocumentFieldEntity);
		AdminDocumentFieldEntity adminDocumentFieldEntitySaved = adminDocumentFieldJpaRepository.save(adminDocumentFieldEntity);
		return adminDocumentFieldServiceMapper.mapAdminDocumentFieldEntityToAdminDocumentField(adminDocumentFieldEntitySaved);
	}

	public AdminDocumentField update(AdminDocumentField adminDocumentField) {
		AdminDocumentFieldEntity adminDocumentFieldEntity = adminDocumentFieldJpaRepository.findOne(adminDocumentField.getId());
		adminDocumentFieldServiceMapper.mapAdminDocumentFieldToAdminDocumentFieldEntity(adminDocumentField, adminDocumentFieldEntity);
		AdminDocumentFieldEntity adminDocumentFieldEntitySaved = adminDocumentFieldJpaRepository.save(adminDocumentFieldEntity);
		return adminDocumentFieldServiceMapper.mapAdminDocumentFieldEntityToAdminDocumentField(adminDocumentFieldEntitySaved);
	}

	public void delete(Integer id) {
		adminDocumentFieldJpaRepository.delete(id);
	}

	public AdminDocumentFieldJpaRepository getAdminDocumentFieldJpaRepository() {
		return adminDocumentFieldJpaRepository;
	}

	public void setAdminDocumentFieldJpaRepository(AdminDocumentFieldJpaRepository adminDocumentFieldJpaRepository) {
		this.adminDocumentFieldJpaRepository = adminDocumentFieldJpaRepository;
	}

	public AdminDocumentFieldServiceMapper getAdminDocumentFieldServiceMapper() {
		return adminDocumentFieldServiceMapper;
	}

	public void setAdminDocumentFieldServiceMapper(AdminDocumentFieldServiceMapper adminDocumentFieldServiceMapper) {
		this.adminDocumentFieldServiceMapper = adminDocumentFieldServiceMapper;
	}

}