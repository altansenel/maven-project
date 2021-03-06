/*
 * Created on 24 �ub 2016 ( Time 16:27:53 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.StockTransFactor;
import org.demo.bean.jpa.StockTransFactorEntity;
import org.demo.bean.jpa.StockCostFactorEntity;
import org.demo.bean.jpa.StockTransEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class StockTransFactorServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public StockTransFactorServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'StockTransFactorEntity' to 'StockTransFactor'
	 * @param stockTransFactorEntity
	 */
	public StockTransFactor mapStockTransFactorEntityToStockTransFactor(StockTransFactorEntity stockTransFactorEntity) {
		if(stockTransFactorEntity == null) {
			return null;
		}

		//--- Generic mapping 
		StockTransFactor stockTransFactor = map(stockTransFactorEntity, StockTransFactor.class);

		//--- Link mapping ( link to StockCostFactor )
		if(stockTransFactorEntity.getStockCostFactor() != null) {
			stockTransFactor.setFactorId(stockTransFactorEntity.getStockCostFactor().getId());
		}
		//--- Link mapping ( link to StockTrans )
		if(stockTransFactorEntity.getStockTrans() != null) {
			stockTransFactor.setTransId(stockTransFactorEntity.getStockTrans().getId());
		}
		return stockTransFactor;
	}
	
	/**
	 * Mapping from 'StockTransFactor' to 'StockTransFactorEntity'
	 * @param stockTransFactor
	 * @param stockTransFactorEntity
	 */
	public void mapStockTransFactorToStockTransFactorEntity(StockTransFactor stockTransFactor, StockTransFactorEntity stockTransFactorEntity) {
		if(stockTransFactor == null) {
			return;
		}

		//--- Generic mapping 
		map(stockTransFactor, stockTransFactorEntity);

		//--- Link mapping ( link : stockTransFactor )
		if( hasLinkToStockCostFactor(stockTransFactor) ) {
			StockCostFactorEntity stockCostFactor1 = new StockCostFactorEntity();
			stockCostFactor1.setId( stockTransFactor.getFactorId() );
			stockTransFactorEntity.setStockCostFactor( stockCostFactor1 );
		} else {
			stockTransFactorEntity.setStockCostFactor( null );
		}

		//--- Link mapping ( link : stockTransFactor )
		if( hasLinkToStockTrans(stockTransFactor) ) {
			StockTransEntity stockTrans2 = new StockTransEntity();
			stockTrans2.setId( stockTransFactor.getTransId() );
			stockTransFactorEntity.setStockTrans( stockTrans2 );
		} else {
			stockTransFactorEntity.setStockTrans( null );
		}

	}
	
	/**
	 * Verify that StockCostFactor id is valid.
	 * @param StockCostFactor StockCostFactor
	 * @return boolean
	 */
	private boolean hasLinkToStockCostFactor(StockTransFactor stockTransFactor) {
		if(stockTransFactor.getFactorId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that StockTrans id is valid.
	 * @param StockTrans StockTrans
	 * @return boolean
	 */
	private boolean hasLinkToStockTrans(StockTransFactor stockTransFactor) {
		if(stockTransFactor.getTransId() != null) {
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