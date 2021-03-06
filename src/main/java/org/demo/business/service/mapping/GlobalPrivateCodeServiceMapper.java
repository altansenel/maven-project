/*
 * Created on 24 �ub 2016 ( Time 16:27:50 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.GlobalPrivateCode;
import org.demo.bean.jpa.GlobalPrivateCodeEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class GlobalPrivateCodeServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public GlobalPrivateCodeServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'GlobalPrivateCodeEntity' to 'GlobalPrivateCode'
	 * @param globalPrivateCodeEntity
	 */
	public GlobalPrivateCode mapGlobalPrivateCodeEntityToGlobalPrivateCode(GlobalPrivateCodeEntity globalPrivateCodeEntity) {
		if(globalPrivateCodeEntity == null) {
			return null;
		}

		//--- Generic mapping 
		GlobalPrivateCode globalPrivateCode = map(globalPrivateCodeEntity, GlobalPrivateCode.class);

		return globalPrivateCode;
	}
	
	/**
	 * Mapping from 'GlobalPrivateCode' to 'GlobalPrivateCodeEntity'
	 * @param globalPrivateCode
	 * @param globalPrivateCodeEntity
	 */
	public void mapGlobalPrivateCodeToGlobalPrivateCodeEntity(GlobalPrivateCode globalPrivateCode, GlobalPrivateCodeEntity globalPrivateCodeEntity) {
		if(globalPrivateCode == null) {
			return;
		}

		//--- Generic mapping 
		map(globalPrivateCode, globalPrivateCodeEntity);

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