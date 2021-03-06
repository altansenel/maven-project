/*
 * Created on 24 �ub 2016 ( Time 16:27:51 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.GlobalTransPoint;
import org.demo.bean.jpa.GlobalTransPointEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class GlobalTransPointServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public GlobalTransPointServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'GlobalTransPointEntity' to 'GlobalTransPoint'
	 * @param globalTransPointEntity
	 */
	public GlobalTransPoint mapGlobalTransPointEntityToGlobalTransPoint(GlobalTransPointEntity globalTransPointEntity) {
		if(globalTransPointEntity == null) {
			return null;
		}

		//--- Generic mapping 
		GlobalTransPoint globalTransPoint = map(globalTransPointEntity, GlobalTransPoint.class);

		return globalTransPoint;
	}
	
	/**
	 * Mapping from 'GlobalTransPoint' to 'GlobalTransPointEntity'
	 * @param globalTransPoint
	 * @param globalTransPointEntity
	 */
	public void mapGlobalTransPointToGlobalTransPointEntity(GlobalTransPoint globalTransPoint, GlobalTransPointEntity globalTransPointEntity) {
		if(globalTransPoint == null) {
			return;
		}

		//--- Generic mapping 
		map(globalTransPoint, globalTransPointEntity);

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