/*
 * Created on 24 �ub 2016 ( Time 16:27:49 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.AdminUserGivenRole;
import org.demo.bean.jpa.AdminUserGivenRoleEntity;
import org.demo.bean.jpa.AdminUserGroupEntity;
import org.demo.bean.jpa.AdminUserRoleEntity;
import org.demo.bean.jpa.AdminWorkspaceEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class AdminUserGivenRoleServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public AdminUserGivenRoleServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'AdminUserGivenRoleEntity' to 'AdminUserGivenRole'
	 * @param adminUserGivenRoleEntity
	 */
	public AdminUserGivenRole mapAdminUserGivenRoleEntityToAdminUserGivenRole(AdminUserGivenRoleEntity adminUserGivenRoleEntity) {
		if(adminUserGivenRoleEntity == null) {
			return null;
		}

		//--- Generic mapping 
		AdminUserGivenRole adminUserGivenRole = map(adminUserGivenRoleEntity, AdminUserGivenRole.class);

		//--- Link mapping ( link to AdminUserGroup )
		if(adminUserGivenRoleEntity.getAdminUserGroup() != null) {
			adminUserGivenRole.setUserGroupId(adminUserGivenRoleEntity.getAdminUserGroup().getId());
		}
		//--- Link mapping ( link to AdminUserRole )
		if(adminUserGivenRoleEntity.getAdminUserRole() != null) {
			adminUserGivenRole.setUserRoleId(adminUserGivenRoleEntity.getAdminUserRole().getId());
		}
		//--- Link mapping ( link to AdminWorkspace )
		if(adminUserGivenRoleEntity.getAdminWorkspace() != null) {
			adminUserGivenRole.setWorkspaceId(adminUserGivenRoleEntity.getAdminWorkspace().getId());
		}
		return adminUserGivenRole;
	}
	
	/**
	 * Mapping from 'AdminUserGivenRole' to 'AdminUserGivenRoleEntity'
	 * @param adminUserGivenRole
	 * @param adminUserGivenRoleEntity
	 */
	public void mapAdminUserGivenRoleToAdminUserGivenRoleEntity(AdminUserGivenRole adminUserGivenRole, AdminUserGivenRoleEntity adminUserGivenRoleEntity) {
		if(adminUserGivenRole == null) {
			return;
		}

		//--- Generic mapping 
		map(adminUserGivenRole, adminUserGivenRoleEntity);

		//--- Link mapping ( link : adminUserGivenRole )
		if( hasLinkToAdminUserGroup(adminUserGivenRole) ) {
			AdminUserGroupEntity adminUserGroup1 = new AdminUserGroupEntity();
			adminUserGroup1.setId( adminUserGivenRole.getUserGroupId() );
			adminUserGivenRoleEntity.setAdminUserGroup( adminUserGroup1 );
		} else {
			adminUserGivenRoleEntity.setAdminUserGroup( null );
		}

		//--- Link mapping ( link : adminUserGivenRole )
		if( hasLinkToAdminUserRole(adminUserGivenRole) ) {
			AdminUserRoleEntity adminUserRole2 = new AdminUserRoleEntity();
			adminUserRole2.setId( adminUserGivenRole.getUserRoleId() );
			adminUserGivenRoleEntity.setAdminUserRole( adminUserRole2 );
		} else {
			adminUserGivenRoleEntity.setAdminUserRole( null );
		}

		//--- Link mapping ( link : adminUserGivenRole )
		if( hasLinkToAdminWorkspace(adminUserGivenRole) ) {
			AdminWorkspaceEntity adminWorkspace3 = new AdminWorkspaceEntity();
			adminWorkspace3.setId( adminUserGivenRole.getWorkspaceId() );
			adminUserGivenRoleEntity.setAdminWorkspace( adminWorkspace3 );
		} else {
			adminUserGivenRoleEntity.setAdminWorkspace( null );
		}

	}
	
	/**
	 * Verify that AdminUserGroup id is valid.
	 * @param AdminUserGroup AdminUserGroup
	 * @return boolean
	 */
	private boolean hasLinkToAdminUserGroup(AdminUserGivenRole adminUserGivenRole) {
		if(adminUserGivenRole.getUserGroupId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that AdminUserRole id is valid.
	 * @param AdminUserRole AdminUserRole
	 * @return boolean
	 */
	private boolean hasLinkToAdminUserRole(AdminUserGivenRole adminUserGivenRole) {
		if(adminUserGivenRole.getUserRoleId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that AdminWorkspace id is valid.
	 * @param AdminWorkspace AdminWorkspace
	 * @return boolean
	 */
	private boolean hasLinkToAdminWorkspace(AdminUserGivenRole adminUserGivenRole) {
		if(adminUserGivenRole.getWorkspaceId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}