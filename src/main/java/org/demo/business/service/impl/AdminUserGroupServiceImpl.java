/*
 * Created on 24 �ub 2016 ( Time 16:36:11 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.AdminUserGroup;
import org.demo.bean.jpa.AdminUserGroupEntity;
import java.util.List;
import org.demo.business.service.AdminUserGroupService;
import org.demo.business.service.mapping.AdminUserGroupServiceMapper;
import org.demo.data.repository.jpa.AdminUserGroupJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of AdminUserGroupService
 */
@Component
@Transactional
public class AdminUserGroupServiceImpl implements AdminUserGroupService {

	@Resource
	private AdminUserGroupJpaRepository adminUserGroupJpaRepository;

	@Resource
	private AdminUserGroupServiceMapper adminUserGroupServiceMapper;
	
	public AdminUserGroup findById(Integer id) {
		AdminUserGroupEntity adminUserGroupEntity = adminUserGroupJpaRepository.findOne(id);
		return adminUserGroupServiceMapper.mapAdminUserGroupEntityToAdminUserGroup(adminUserGroupEntity);
	}

	public List<AdminUserGroup> findAll() {
		Iterable<AdminUserGroupEntity> entities = adminUserGroupJpaRepository.findAll();
		List<AdminUserGroup> beans = new ArrayList<AdminUserGroup>();
		for(AdminUserGroupEntity adminUserGroupEntity : entities) {
			beans.add(adminUserGroupServiceMapper.mapAdminUserGroupEntityToAdminUserGroup(adminUserGroupEntity));
		}
		return beans;
	}

	public AdminUserGroup save(AdminUserGroup adminUserGroup) {
		return update(adminUserGroup) ;
	}

	public AdminUserGroup create(AdminUserGroup adminUserGroup) {
		AdminUserGroupEntity adminUserGroupEntity = adminUserGroupJpaRepository.findOne(adminUserGroup.getId());
		if( adminUserGroupEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		adminUserGroupEntity = new AdminUserGroupEntity();
		adminUserGroupServiceMapper.mapAdminUserGroupToAdminUserGroupEntity(adminUserGroup, adminUserGroupEntity);
		AdminUserGroupEntity adminUserGroupEntitySaved = adminUserGroupJpaRepository.save(adminUserGroupEntity);
		return adminUserGroupServiceMapper.mapAdminUserGroupEntityToAdminUserGroup(adminUserGroupEntitySaved);
	}

	public AdminUserGroup update(AdminUserGroup adminUserGroup) {
		AdminUserGroupEntity adminUserGroupEntity = adminUserGroupJpaRepository.findOne(adminUserGroup.getId());
		adminUserGroupServiceMapper.mapAdminUserGroupToAdminUserGroupEntity(adminUserGroup, adminUserGroupEntity);
		AdminUserGroupEntity adminUserGroupEntitySaved = adminUserGroupJpaRepository.save(adminUserGroupEntity);
		return adminUserGroupServiceMapper.mapAdminUserGroupEntityToAdminUserGroup(adminUserGroupEntitySaved);
	}

	public void delete(Integer id) {
		adminUserGroupJpaRepository.delete(id);
	}

	public AdminUserGroupJpaRepository getAdminUserGroupJpaRepository() {
		return adminUserGroupJpaRepository;
	}

	public void setAdminUserGroupJpaRepository(AdminUserGroupJpaRepository adminUserGroupJpaRepository) {
		this.adminUserGroupJpaRepository = adminUserGroupJpaRepository;
	}

	public AdminUserGroupServiceMapper getAdminUserGroupServiceMapper() {
		return adminUserGroupServiceMapper;
	}

	public void setAdminUserGroupServiceMapper(AdminUserGroupServiceMapper adminUserGroupServiceMapper) {
		this.adminUserGroupServiceMapper = adminUserGroupServiceMapper;
	}

}