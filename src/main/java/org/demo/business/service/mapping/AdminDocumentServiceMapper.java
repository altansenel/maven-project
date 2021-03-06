/*
 * Created on 24 �ub 2016 ( Time 16:27:49 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.AdminDocument;
import org.demo.bean.jpa.AdminDocumentEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class AdminDocumentServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public AdminDocumentServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'AdminDocumentEntity' to 'AdminDocument'
	 * @param adminDocumentEntity
	 */
	public AdminDocument mapAdminDocumentEntityToAdminDocument(AdminDocumentEntity adminDocumentEntity) {
		if(adminDocumentEntity == null) {
			return null;
		}

		//--- Generic mapping 
		AdminDocument adminDocument = map(adminDocumentEntity, AdminDocument.class);

		return adminDocument;
	}
	
	/**
	 * Mapping from 'AdminDocument' to 'AdminDocumentEntity'
	 * @param adminDocument
	 * @param adminDocumentEntity
	 */
	public void mapAdminDocumentToAdminDocumentEntity(AdminDocument adminDocument, AdminDocumentEntity adminDocumentEntity) {
		if(adminDocument == null) {
			return;
		}

		//--- Generic mapping 
		map(adminDocument, adminDocumentEntity);

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