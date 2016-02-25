/*
 * Created on 24 �ub 2016 ( Time 16:27:51 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.Safe;
import org.demo.bean.jpa.SafeEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class SafeServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public SafeServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'SafeEntity' to 'Safe'
	 * @param safeEntity
	 */
	public Safe mapSafeEntityToSafe(SafeEntity safeEntity) {
		if(safeEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Safe safe = map(safeEntity, Safe.class);

		return safe;
	}
	
	/**
	 * Mapping from 'Safe' to 'SafeEntity'
	 * @param safe
	 * @param safeEntity
	 */
	public void mapSafeToSafeEntity(Safe safe, SafeEntity safeEntity) {
		if(safe == null) {
			return;
		}

		//--- Generic mapping 
		map(safe, safeEntity);

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