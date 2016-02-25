/*
 * Created on 24 �ub 2016 ( Time 16:27:53 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.StockTransTax;
import org.demo.bean.jpa.StockTransTaxEntity;
import org.demo.bean.jpa.StockTransEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class StockTransTaxServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public StockTransTaxServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'StockTransTaxEntity' to 'StockTransTax'
	 * @param stockTransTaxEntity
	 */
	public StockTransTax mapStockTransTaxEntityToStockTransTax(StockTransTaxEntity stockTransTaxEntity) {
		if(stockTransTaxEntity == null) {
			return null;
		}

		//--- Generic mapping 
		StockTransTax stockTransTax = map(stockTransTaxEntity, StockTransTax.class);

		//--- Link mapping ( link to StockTrans )
		if(stockTransTaxEntity.getStockTrans() != null) {
			stockTransTax.setTransId(stockTransTaxEntity.getStockTrans().getId());
		}
		return stockTransTax;
	}
	
	/**
	 * Mapping from 'StockTransTax' to 'StockTransTaxEntity'
	 * @param stockTransTax
	 * @param stockTransTaxEntity
	 */
	public void mapStockTransTaxToStockTransTaxEntity(StockTransTax stockTransTax, StockTransTaxEntity stockTransTaxEntity) {
		if(stockTransTax == null) {
			return;
		}

		//--- Generic mapping 
		map(stockTransTax, stockTransTaxEntity);

		//--- Link mapping ( link : stockTransTax )
		if( hasLinkToStockTrans(stockTransTax) ) {
			StockTransEntity stockTrans1 = new StockTransEntity();
			stockTrans1.setId( stockTransTax.getTransId() );
			stockTransTaxEntity.setStockTrans( stockTrans1 );
		} else {
			stockTransTaxEntity.setStockTrans( null );
		}

	}
	
	/**
	 * Verify that StockTrans id is valid.
	 * @param StockTrans StockTrans
	 * @return boolean
	 */
	private boolean hasLinkToStockTrans(StockTransTax stockTransTax) {
		if(stockTransTax.getTransId() != null) {
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