/*
 * Created on 24 �ub 2016 ( Time 16:27:49 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.demo.bean.AdminDocumentField;
import org.demo.bean.jpa.AdminDocumentEntity;
import org.demo.bean.jpa.AdminDocumentFieldEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class AdminDocumentFieldServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public AdminDocumentFieldServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'AdminDocumentFieldEntity' to 'AdminDocumentField'
	 * @param adminDocumentFieldEntity
	 */
	public AdminDocumentField mapAdminDocumentFieldEntityToAdminDocumentField(AdminDocumentFieldEntity adminDocumentFieldEntity) {
		if(adminDocumentFieldEntity == null) {
			return null;
		}

		//--- Generic mapping 
		AdminDocumentField adminDocumentField = map(adminDocumentFieldEntity, AdminDocumentField.class);

		//--- Link mapping ( link to AdminDocument )
		if(adminDocumentFieldEntity.getAdminDocument4() != null) {
			adminDocumentField.setPageFooterDocId(adminDocumentFieldEntity.getAdminDocument4().getId());
		}
		//--- Link mapping ( link to AdminDocument )
		if(adminDocumentFieldEntity.getAdminDocument() != null) {
			adminDocumentField.setReportTitleDocId(adminDocumentFieldEntity.getAdminDocument().getId());
		}
		//--- Link mapping ( link to AdminDocument )
		if(adminDocumentFieldEntity.getAdminDocument3() != null) {
			adminDocumentField.setDetailDocId(adminDocumentFieldEntity.getAdminDocument3().getId());
		}
		//--- Link mapping ( link to AdminDocument )
		if(adminDocumentFieldEntity.getAdminDocument5() != null) {
			adminDocumentField.setReportFooterDocId(adminDocumentFieldEntity.getAdminDocument5().getId());
		}
		//--- Link mapping ( link to AdminDocument )
		if(adminDocumentFieldEntity.getAdminDocument2() != null) {
			adminDocumentField.setPageTitleDocId(adminDocumentFieldEntity.getAdminDocument2().getId());
		}
		return adminDocumentField;
	}
	
	/**
	 * Mapping from 'AdminDocumentField' to 'AdminDocumentFieldEntity'
	 * @param adminDocumentField
	 * @param adminDocumentFieldEntity
	 */
	public void mapAdminDocumentFieldToAdminDocumentFieldEntity(AdminDocumentField adminDocumentField, AdminDocumentFieldEntity adminDocumentFieldEntity) {
		if(adminDocumentField == null) {
			return;
		}

		//--- Generic mapping 
		map(adminDocumentField, adminDocumentFieldEntity);

		//--- Link mapping ( link : adminDocumentField )
		if( hasLinkToAdminDocument(adminDocumentField) ) {
			AdminDocumentEntity adminDocument1 = new AdminDocumentEntity();
			adminDocument1.setId( adminDocumentField.getPageFooterDocId() );
			adminDocumentFieldEntity.setAdminDocument4( adminDocument1 );
		} else {
			adminDocumentFieldEntity.setAdminDocument4( null );
		}

		//--- Link mapping ( link : adminDocumentField )
		if( hasLinkToAdminDocument(adminDocumentField) ) {
			AdminDocumentEntity adminDocument2 = new AdminDocumentEntity();
			adminDocument2.setId( adminDocumentField.getReportTitleDocId() );
			adminDocumentFieldEntity.setAdminDocument( adminDocument2 );
		} else {
			adminDocumentFieldEntity.setAdminDocument( null );
		}

		//--- Link mapping ( link : adminDocumentField )
		if( hasLinkToAdminDocument(adminDocumentField) ) {
			AdminDocumentEntity adminDocument3 = new AdminDocumentEntity();
			adminDocument3.setId( adminDocumentField.getDetailDocId() );
			adminDocumentFieldEntity.setAdminDocument3( adminDocument3 );
		} else {
			adminDocumentFieldEntity.setAdminDocument3( null );
		}

		//--- Link mapping ( link : adminDocumentField )
		if( hasLinkToAdminDocument(adminDocumentField) ) {
			AdminDocumentEntity adminDocument4 = new AdminDocumentEntity();
			adminDocument4.setId( adminDocumentField.getReportFooterDocId() );
			adminDocumentFieldEntity.setAdminDocument5( adminDocument4 );
		} else {
			adminDocumentFieldEntity.setAdminDocument5( null );
		}

		//--- Link mapping ( link : adminDocumentField )
		if( hasLinkToAdminDocument(adminDocumentField) ) {
			AdminDocumentEntity adminDocument5 = new AdminDocumentEntity();
			adminDocument5.setId( adminDocumentField.getPageTitleDocId() );
			adminDocumentFieldEntity.setAdminDocument2( adminDocument5 );
		} else {
			adminDocumentFieldEntity.setAdminDocument2( null );
		}

	}
	
	/**
	 * Verify that AdminDocument id is valid.
	 * @param AdminDocument AdminDocument
	 * @return boolean
	 */
	private boolean hasLinkToAdminDocument(AdminDocumentField adminDocumentField) {
		if(adminDocumentField.getPageTitleDocId() != null) {
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