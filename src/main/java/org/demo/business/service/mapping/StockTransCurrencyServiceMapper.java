/*
 * Created on 24 �ub 2016 ( Time 16:27:52 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.StockTransCurrency;
import org.demo.bean.jpa.StockTransCurrencyEntity;
import org.demo.bean.jpa.StockTransEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class StockTransCurrencyServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public StockTransCurrencyServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'StockTransCurrencyEntity' to 'StockTransCurrency'
	 * @param stockTransCurrencyEntity
	 */
	public StockTransCurrency mapStockTransCurrencyEntityToStockTransCurrency(StockTransCurrencyEntity stockTransCurrencyEntity) {
		if(stockTransCurrencyEntity == null) {
			return null;
		}

		//--- Generic mapping 
		StockTransCurrency stockTransCurrency = map(stockTransCurrencyEntity, StockTransCurrency.class);

		//--- Link mapping ( link to StockTrans )
		if(stockTransCurrencyEntity.getStockTrans() != null) {
			stockTransCurrency.setTransId(stockTransCurrencyEntity.getStockTrans().getId());
		}
		return stockTransCurrency;
	}
	
	/**
	 * Mapping from 'StockTransCurrency' to 'StockTransCurrencyEntity'
	 * @param stockTransCurrency
	 * @param stockTransCurrencyEntity
	 */
	public void mapStockTransCurrencyToStockTransCurrencyEntity(StockTransCurrency stockTransCurrency, StockTransCurrencyEntity stockTransCurrencyEntity) {
		if(stockTransCurrency == null) {
			return;
		}

		//--- Generic mapping 
		map(stockTransCurrency, stockTransCurrencyEntity);

		//--- Link mapping ( link : stockTransCurrency )
		if( hasLinkToStockTrans(stockTransCurrency) ) {
			StockTransEntity stockTrans1 = new StockTransEntity();
			stockTrans1.setId( stockTransCurrency.getTransId() );
			stockTransCurrencyEntity.setStockTrans( stockTrans1 );
		} else {
			stockTransCurrencyEntity.setStockTrans( null );
		}

	}
	
	/**
	 * Verify that StockTrans id is valid.
	 * @param StockTrans StockTrans
	 * @return boolean
	 */
	private boolean hasLinkToStockTrans(StockTransCurrency stockTransCurrency) {
		if(stockTransCurrency.getTransId() != null) {
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