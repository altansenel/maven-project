/*
 * Created on 24 �ub 2016 ( Time 16:27:52 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.StockBarcode;
import org.demo.bean.jpa.StockBarcodeEntity;
import org.demo.bean.jpa.StockEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class StockBarcodeServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public StockBarcodeServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'StockBarcodeEntity' to 'StockBarcode'
	 * @param stockBarcodeEntity
	 */
	public StockBarcode mapStockBarcodeEntityToStockBarcode(StockBarcodeEntity stockBarcodeEntity) {
		if(stockBarcodeEntity == null) {
			return null;
		}

		//--- Generic mapping 
		StockBarcode stockBarcode = map(stockBarcodeEntity, StockBarcode.class);

		//--- Link mapping ( link to Stock )
		if(stockBarcodeEntity.getStock() != null) {
			stockBarcode.setStockId(stockBarcodeEntity.getStock().getId());
		}
		return stockBarcode;
	}
	
	/**
	 * Mapping from 'StockBarcode' to 'StockBarcodeEntity'
	 * @param stockBarcode
	 * @param stockBarcodeEntity
	 */
	public void mapStockBarcodeToStockBarcodeEntity(StockBarcode stockBarcode, StockBarcodeEntity stockBarcodeEntity) {
		if(stockBarcode == null) {
			return;
		}

		//--- Generic mapping 
		map(stockBarcode, stockBarcodeEntity);

		//--- Link mapping ( link : stockBarcode )
		if( hasLinkToStock(stockBarcode) ) {
			StockEntity stock1 = new StockEntity();
			stock1.setId( stockBarcode.getStockId() );
			stockBarcodeEntity.setStock( stock1 );
		} else {
			stockBarcodeEntity.setStock( null );
		}

	}
	
	/**
	 * Verify that Stock id is valid.
	 * @param Stock Stock
	 * @return boolean
	 */
	private boolean hasLinkToStock(StockBarcode stockBarcode) {
		if(stockBarcode.getStockId() != null) {
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