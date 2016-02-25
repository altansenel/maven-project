/*
 * Created on 24 �ub 2016 ( Time 16:27:53 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.StockUnit;
import org.demo.bean.jpa.StockUnitEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class StockUnitServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public StockUnitServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'StockUnitEntity' to 'StockUnit'
	 * @param stockUnitEntity
	 */
	public StockUnit mapStockUnitEntityToStockUnit(StockUnitEntity stockUnitEntity) {
		if(stockUnitEntity == null) {
			return null;
		}

		//--- Generic mapping 
		StockUnit stockUnit = map(stockUnitEntity, StockUnit.class);

		return stockUnit;
	}
	
	/**
	 * Mapping from 'StockUnit' to 'StockUnitEntity'
	 * @param stockUnit
	 * @param stockUnitEntity
	 */
	public void mapStockUnitToStockUnitEntity(StockUnit stockUnit, StockUnitEntity stockUnitEntity) {
		if(stockUnit == null) {
			return;
		}

		//--- Generic mapping 
		map(stockUnit, stockUnitEntity);

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