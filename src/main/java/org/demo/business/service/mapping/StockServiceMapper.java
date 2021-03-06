/*
 * Created on 24 �ub 2016 ( Time 16:27:52 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.demo.bean.Stock;
import org.demo.bean.jpa.StockCategoryEntity;
import org.demo.bean.jpa.StockEntity;
import org.demo.bean.jpa.StockExtraFieldsEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class StockServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public StockServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'StockEntity' to 'Stock'
	 * @param stockEntity
	 */
	public Stock mapStockEntityToStock(StockEntity stockEntity) {
		if(stockEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Stock stock = map(stockEntity, Stock.class);

		//--- Link mapping ( link to StockCategory )
		if(stockEntity.getStockCategory() != null) {
			stock.setCategoryId(stockEntity.getStockCategory().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(stockEntity.getStockExtraFields4() != null) {
			stock.setExtraField1Id(stockEntity.getStockExtraFields4().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(stockEntity.getStockExtraFields6() != null) {
			stock.setExtraField3Id(stockEntity.getStockExtraFields6().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(stockEntity.getStockExtraFields2() != null) {
			stock.setExtraField9Id(stockEntity.getStockExtraFields2().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(stockEntity.getStockExtraFields8() != null) {
			stock.setExtraField5Id(stockEntity.getStockExtraFields8().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(stockEntity.getStockExtraFields10() != null) {
			stock.setExtraField7Id(stockEntity.getStockExtraFields10().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(stockEntity.getStockExtraFields3() != null) {
			stock.setExtraField0Id(stockEntity.getStockExtraFields3().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(stockEntity.getStockExtraFields5() != null) {
			stock.setExtraField2Id(stockEntity.getStockExtraFields5().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(stockEntity.getStockExtraFields() != null) {
			stock.setExtraField8Id(stockEntity.getStockExtraFields().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(stockEntity.getStockExtraFields7() != null) {
			stock.setExtraField4Id(stockEntity.getStockExtraFields7().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(stockEntity.getStockExtraFields9() != null) {
			stock.setExtraField6Id(stockEntity.getStockExtraFields9().getId());
		}
		return stock;
	}
	
	/**
	 * Mapping from 'Stock' to 'StockEntity'
	 * @param stock
	 * @param stockEntity
	 */
	public void mapStockToStockEntity(Stock stock, StockEntity stockEntity) {
		if(stock == null) {
			return;
		}

		//--- Generic mapping 
		map(stock, stockEntity);

		//--- Link mapping ( link : stock )
		if( hasLinkToStockCategory(stock) ) {
			StockCategoryEntity stockCategory1 = new StockCategoryEntity();
			stockCategory1.setId( stock.getCategoryId() );
			stockEntity.setStockCategory( stockCategory1 );
		} else {
			stockEntity.setStockCategory( null );
		}

		//--- Link mapping ( link : stock )
		if( hasLinkToStockExtraFields(stock) ) {
			StockExtraFieldsEntity stockExtraFields2 = new StockExtraFieldsEntity();
			stockExtraFields2.setId( stock.getExtraField1Id() );
			stockEntity.setStockExtraFields4( stockExtraFields2 );
		} else {
			stockEntity.setStockExtraFields4( null );
		}

		//--- Link mapping ( link : stock )
		if( hasLinkToStockExtraFields(stock) ) {
			StockExtraFieldsEntity stockExtraFields3 = new StockExtraFieldsEntity();
			stockExtraFields3.setId( stock.getExtraField3Id() );
			stockEntity.setStockExtraFields6( stockExtraFields3 );
		} else {
			stockEntity.setStockExtraFields6( null );
		}

		//--- Link mapping ( link : stock )
		if( hasLinkToStockExtraFields(stock) ) {
			StockExtraFieldsEntity stockExtraFields4 = new StockExtraFieldsEntity();
			stockExtraFields4.setId( stock.getExtraField9Id() );
			stockEntity.setStockExtraFields2( stockExtraFields4 );
		} else {
			stockEntity.setStockExtraFields2( null );
		}

		//--- Link mapping ( link : stock )
		if( hasLinkToStockExtraFields(stock) ) {
			StockExtraFieldsEntity stockExtraFields5 = new StockExtraFieldsEntity();
			stockExtraFields5.setId( stock.getExtraField5Id() );
			stockEntity.setStockExtraFields8( stockExtraFields5 );
		} else {
			stockEntity.setStockExtraFields8( null );
		}

		//--- Link mapping ( link : stock )
		if( hasLinkToStockExtraFields(stock) ) {
			StockExtraFieldsEntity stockExtraFields6 = new StockExtraFieldsEntity();
			stockExtraFields6.setId( stock.getExtraField7Id() );
			stockEntity.setStockExtraFields10( stockExtraFields6 );
		} else {
			stockEntity.setStockExtraFields10( null );
		}

		//--- Link mapping ( link : stock )
		if( hasLinkToStockExtraFields(stock) ) {
			StockExtraFieldsEntity stockExtraFields7 = new StockExtraFieldsEntity();
			stockExtraFields7.setId( stock.getExtraField0Id() );
			stockEntity.setStockExtraFields3( stockExtraFields7 );
		} else {
			stockEntity.setStockExtraFields3( null );
		}

		//--- Link mapping ( link : stock )
		if( hasLinkToStockExtraFields(stock) ) {
			StockExtraFieldsEntity stockExtraFields8 = new StockExtraFieldsEntity();
			stockExtraFields8.setId( stock.getExtraField2Id() );
			stockEntity.setStockExtraFields5( stockExtraFields8 );
		} else {
			stockEntity.setStockExtraFields5( null );
		}

		//--- Link mapping ( link : stock )
		if( hasLinkToStockExtraFields(stock) ) {
			StockExtraFieldsEntity stockExtraFields9 = new StockExtraFieldsEntity();
			stockExtraFields9.setId( stock.getExtraField8Id() );
			stockEntity.setStockExtraFields( stockExtraFields9 );
		} else {
			stockEntity.setStockExtraFields( null );
		}

		//--- Link mapping ( link : stock )
		if( hasLinkToStockExtraFields(stock) ) {
			StockExtraFieldsEntity stockExtraFields10 = new StockExtraFieldsEntity();
			stockExtraFields10.setId( stock.getExtraField4Id() );
			stockEntity.setStockExtraFields7( stockExtraFields10 );
		} else {
			stockEntity.setStockExtraFields7( null );
		}

		//--- Link mapping ( link : stock )
		if( hasLinkToStockExtraFields(stock) ) {
			StockExtraFieldsEntity stockExtraFields11 = new StockExtraFieldsEntity();
			stockExtraFields11.setId( stock.getExtraField6Id() );
			stockEntity.setStockExtraFields9( stockExtraFields11 );
		} else {
			stockEntity.setStockExtraFields9( null );
		}

	}
	
	/**
	 * Verify that StockCategory id is valid.
	 * @param StockCategory StockCategory
	 * @return boolean
	 */
	private boolean hasLinkToStockCategory(Stock stock) {
		if(stock.getCategoryId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that StockExtraFields id is valid.
	 * @param StockExtraFields StockExtraFields
	 * @return boolean
	 */
	private boolean hasLinkToStockExtraFields(Stock stock) {
		if(stock.getExtraField1Id() != null) {
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