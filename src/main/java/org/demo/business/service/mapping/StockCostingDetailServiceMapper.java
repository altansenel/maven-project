/*
 * Created on 24 �ub 2016 ( Time 16:27:52 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.StockCostingDetail;
import org.demo.bean.jpa.StockCostingDetailEntity;
import org.demo.bean.jpa.StockEntity;
import org.demo.bean.jpa.StockCostingEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class StockCostingDetailServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public StockCostingDetailServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'StockCostingDetailEntity' to 'StockCostingDetail'
	 * @param stockCostingDetailEntity
	 */
	public StockCostingDetail mapStockCostingDetailEntityToStockCostingDetail(StockCostingDetailEntity stockCostingDetailEntity) {
		if(stockCostingDetailEntity == null) {
			return null;
		}

		//--- Generic mapping 
		StockCostingDetail stockCostingDetail = map(stockCostingDetailEntity, StockCostingDetail.class);

		//--- Link mapping ( link to Stock )
		if(stockCostingDetailEntity.getStock() != null) {
			stockCostingDetail.setStockId(stockCostingDetailEntity.getStock().getId());
		}
		//--- Link mapping ( link to StockCosting )
		if(stockCostingDetailEntity.getStockCosting() != null) {
			stockCostingDetail.setCostingId(stockCostingDetailEntity.getStockCosting().getId());
		}
		return stockCostingDetail;
	}
	
	/**
	 * Mapping from 'StockCostingDetail' to 'StockCostingDetailEntity'
	 * @param stockCostingDetail
	 * @param stockCostingDetailEntity
	 */
	public void mapStockCostingDetailToStockCostingDetailEntity(StockCostingDetail stockCostingDetail, StockCostingDetailEntity stockCostingDetailEntity) {
		if(stockCostingDetail == null) {
			return;
		}

		//--- Generic mapping 
		map(stockCostingDetail, stockCostingDetailEntity);

		//--- Link mapping ( link : stockCostingDetail )
		if( hasLinkToStock(stockCostingDetail) ) {
			StockEntity stock1 = new StockEntity();
			stock1.setId( stockCostingDetail.getStockId() );
			stockCostingDetailEntity.setStock( stock1 );
		} else {
			stockCostingDetailEntity.setStock( null );
		}

		//--- Link mapping ( link : stockCostingDetail )
		if( hasLinkToStockCosting(stockCostingDetail) ) {
			StockCostingEntity stockCosting2 = new StockCostingEntity();
			stockCosting2.setId( stockCostingDetail.getCostingId() );
			stockCostingDetailEntity.setStockCosting( stockCosting2 );
		} else {
			stockCostingDetailEntity.setStockCosting( null );
		}

	}
	
	/**
	 * Verify that Stock id is valid.
	 * @param Stock Stock
	 * @return boolean
	 */
	private boolean hasLinkToStock(StockCostingDetail stockCostingDetail) {
		if(stockCostingDetail.getStockId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that StockCosting id is valid.
	 * @param StockCosting StockCosting
	 * @return boolean
	 */
	private boolean hasLinkToStockCosting(StockCostingDetail stockCostingDetail) {
		if(stockCostingDetail.getCostingId() != null) {
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