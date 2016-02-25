/*
 * Created on 24 �ub 2016 ( Time 16:27:52 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.demo.bean.StockCosting;
import org.demo.bean.jpa.GlobalTransPointEntity;
import org.demo.bean.jpa.StockCategoryEntity;
import org.demo.bean.jpa.StockCostingEntity;
import org.demo.bean.jpa.StockDepotEntity;
import org.demo.bean.jpa.StockEntity;
import org.demo.bean.jpa.StockExtraFieldsEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class StockCostingServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public StockCostingServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'StockCostingEntity' to 'StockCosting'
	 * @param stockCostingEntity
	 */
	public StockCosting mapStockCostingEntityToStockCosting(StockCostingEntity stockCostingEntity) {
		if(stockCostingEntity == null) {
			return null;
		}

		//--- Generic mapping 
		StockCosting stockCosting = map(stockCostingEntity, StockCosting.class);

		//--- Link mapping ( link to StockExtraFields )
		if(stockCostingEntity.getStockExtraFields7() != null) {
			stockCosting.setExtraField1Id(stockCostingEntity.getStockExtraFields7().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(stockCostingEntity.getStockExtraFields5() != null) {
			stockCosting.setExtraField9Id(stockCostingEntity.getStockExtraFields5().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(stockCostingEntity.getStockExtraFields() != null) {
			stockCosting.setExtraField5Id(stockCostingEntity.getStockExtraFields().getId());
		}
		//--- Link mapping ( link to StockCategory )
		if(stockCostingEntity.getStockCategory() != null) {
			stockCosting.setCategoryId(stockCostingEntity.getStockCategory().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(stockCostingEntity.getStockExtraFields8() != null) {
			stockCosting.setExtraField2Id(stockCostingEntity.getStockExtraFields8().getId());
		}
		//--- Link mapping ( link to Stock )
		if(stockCostingEntity.getStock() != null) {
			stockCosting.setStockId(stockCostingEntity.getStock().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(stockCostingEntity.getStockExtraFields2() != null) {
			stockCosting.setExtraField6Id(stockCostingEntity.getStockExtraFields2().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(stockCostingEntity.getStockExtraFields9() != null) {
			stockCosting.setExtraField3Id(stockCostingEntity.getStockExtraFields9().getId());
		}
		//--- Link mapping ( link to StockDepot )
		if(stockCostingEntity.getStockDepot() != null) {
			stockCosting.setDepotId(stockCostingEntity.getStockDepot().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(stockCostingEntity.getStockExtraFields3() != null) {
			stockCosting.setExtraField7Id(stockCostingEntity.getStockExtraFields3().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(stockCostingEntity.getStockExtraFields10() != null) {
			stockCosting.setExtraField4Id(stockCostingEntity.getStockExtraFields10().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(stockCostingEntity.getStockExtraFields6() != null) {
			stockCosting.setExtraField0Id(stockCostingEntity.getStockExtraFields6().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(stockCostingEntity.getStockExtraFields4() != null) {
			stockCosting.setExtraField8Id(stockCostingEntity.getStockExtraFields4().getId());
		}
		//--- Link mapping ( link to GlobalTransPoint )
		if(stockCostingEntity.getGlobalTransPoint() != null) {
			stockCosting.setTransPointId(stockCostingEntity.getGlobalTransPoint().getId());
		}
		return stockCosting;
	}
	
	/**
	 * Mapping from 'StockCosting' to 'StockCostingEntity'
	 * @param stockCosting
	 * @param stockCostingEntity
	 */
	public void mapStockCostingToStockCostingEntity(StockCosting stockCosting, StockCostingEntity stockCostingEntity) {
		if(stockCosting == null) {
			return;
		}

		//--- Generic mapping 
		map(stockCosting, stockCostingEntity);

		//--- Link mapping ( link : stockCosting )
		if( hasLinkToStockExtraFields(stockCosting) ) {
			StockExtraFieldsEntity stockExtraFields1 = new StockExtraFieldsEntity();
			stockExtraFields1.setId( stockCosting.getExtraField1Id() );
			stockCostingEntity.setStockExtraFields7( stockExtraFields1 );
		} else {
			stockCostingEntity.setStockExtraFields7( null );
		}

		//--- Link mapping ( link : stockCosting )
		if( hasLinkToStockExtraFields(stockCosting) ) {
			StockExtraFieldsEntity stockExtraFields2 = new StockExtraFieldsEntity();
			stockExtraFields2.setId( stockCosting.getExtraField9Id() );
			stockCostingEntity.setStockExtraFields5( stockExtraFields2 );
		} else {
			stockCostingEntity.setStockExtraFields5( null );
		}

		//--- Link mapping ( link : stockCosting )
		if( hasLinkToStockExtraFields(stockCosting) ) {
			StockExtraFieldsEntity stockExtraFields3 = new StockExtraFieldsEntity();
			stockExtraFields3.setId( stockCosting.getExtraField5Id() );
			stockCostingEntity.setStockExtraFields( stockExtraFields3 );
		} else {
			stockCostingEntity.setStockExtraFields( null );
		}

		//--- Link mapping ( link : stockCosting )
		if( hasLinkToStockCategory(stockCosting) ) {
			StockCategoryEntity stockCategory4 = new StockCategoryEntity();
			stockCategory4.setId( stockCosting.getCategoryId() );
			stockCostingEntity.setStockCategory( stockCategory4 );
		} else {
			stockCostingEntity.setStockCategory( null );
		}

		//--- Link mapping ( link : stockCosting )
		if( hasLinkToStockExtraFields(stockCosting) ) {
			StockExtraFieldsEntity stockExtraFields5 = new StockExtraFieldsEntity();
			stockExtraFields5.setId( stockCosting.getExtraField2Id() );
			stockCostingEntity.setStockExtraFields8( stockExtraFields5 );
		} else {
			stockCostingEntity.setStockExtraFields8( null );
		}

		//--- Link mapping ( link : stockCosting )
		if( hasLinkToStock(stockCosting) ) {
			StockEntity stock6 = new StockEntity();
			stock6.setId( stockCosting.getStockId() );
			stockCostingEntity.setStock( stock6 );
		} else {
			stockCostingEntity.setStock( null );
		}

		//--- Link mapping ( link : stockCosting )
		if( hasLinkToStockExtraFields(stockCosting) ) {
			StockExtraFieldsEntity stockExtraFields7 = new StockExtraFieldsEntity();
			stockExtraFields7.setId( stockCosting.getExtraField6Id() );
			stockCostingEntity.setStockExtraFields2( stockExtraFields7 );
		} else {
			stockCostingEntity.setStockExtraFields2( null );
		}

		//--- Link mapping ( link : stockCosting )
		if( hasLinkToStockExtraFields(stockCosting) ) {
			StockExtraFieldsEntity stockExtraFields8 = new StockExtraFieldsEntity();
			stockExtraFields8.setId( stockCosting.getExtraField3Id() );
			stockCostingEntity.setStockExtraFields9( stockExtraFields8 );
		} else {
			stockCostingEntity.setStockExtraFields9( null );
		}

		//--- Link mapping ( link : stockCosting )
		if( hasLinkToStockDepot(stockCosting) ) {
			StockDepotEntity stockDepot9 = new StockDepotEntity();
			stockDepot9.setId( stockCosting.getDepotId() );
			stockCostingEntity.setStockDepot( stockDepot9 );
		} else {
			stockCostingEntity.setStockDepot( null );
		}

		//--- Link mapping ( link : stockCosting )
		if( hasLinkToStockExtraFields(stockCosting) ) {
			StockExtraFieldsEntity stockExtraFields10 = new StockExtraFieldsEntity();
			stockExtraFields10.setId( stockCosting.getExtraField7Id() );
			stockCostingEntity.setStockExtraFields3( stockExtraFields10 );
		} else {
			stockCostingEntity.setStockExtraFields3( null );
		}

		//--- Link mapping ( link : stockCosting )
		if( hasLinkToStockExtraFields(stockCosting) ) {
			StockExtraFieldsEntity stockExtraFields11 = new StockExtraFieldsEntity();
			stockExtraFields11.setId( stockCosting.getExtraField4Id() );
			stockCostingEntity.setStockExtraFields10( stockExtraFields11 );
		} else {
			stockCostingEntity.setStockExtraFields10( null );
		}

		//--- Link mapping ( link : stockCosting )
		if( hasLinkToStockExtraFields(stockCosting) ) {
			StockExtraFieldsEntity stockExtraFields12 = new StockExtraFieldsEntity();
			stockExtraFields12.setId( stockCosting.getExtraField0Id() );
			stockCostingEntity.setStockExtraFields6( stockExtraFields12 );
		} else {
			stockCostingEntity.setStockExtraFields6( null );
		}

		//--- Link mapping ( link : stockCosting )
		if( hasLinkToStockExtraFields(stockCosting) ) {
			StockExtraFieldsEntity stockExtraFields13 = new StockExtraFieldsEntity();
			stockExtraFields13.setId( stockCosting.getExtraField8Id() );
			stockCostingEntity.setStockExtraFields4( stockExtraFields13 );
		} else {
			stockCostingEntity.setStockExtraFields4( null );
		}

		//--- Link mapping ( link : stockCosting )
		if( hasLinkToGlobalTransPoint(stockCosting) ) {
			GlobalTransPointEntity globalTransPoint14 = new GlobalTransPointEntity();
			globalTransPoint14.setId( stockCosting.getTransPointId() );
			stockCostingEntity.setGlobalTransPoint( globalTransPoint14 );
		} else {
			stockCostingEntity.setGlobalTransPoint( null );
		}

	}
	
	/**
	 * Verify that StockExtraFields id is valid.
	 * @param StockExtraFields StockExtraFields
	 * @return boolean
	 */
	private boolean hasLinkToStockExtraFields(StockCosting stockCosting) {
		if(stockCosting.getExtraField1Id() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that StockCategory id is valid.
	 * @param StockCategory StockCategory
	 * @return boolean
	 */
	private boolean hasLinkToStockCategory(StockCosting stockCosting) {
		if(stockCosting.getCategoryId() != null) {
			return true;
		}
		return false;
	}


	/**
	 * Verify that Stock id is valid.
	 * @param Stock Stock
	 * @return boolean
	 */
	private boolean hasLinkToStock(StockCosting stockCosting) {
		if(stockCosting.getStockId() != null) {
			return true;
		}
		return false;
	}


	/**
	 * Verify that StockDepot id is valid.
	 * @param StockDepot StockDepot
	 * @return boolean
	 */
	private boolean hasLinkToStockDepot(StockCosting stockCosting) {
		if(stockCosting.getDepotId() != null) {
			return true;
		}
		return false;
	}


	/**
	 * Verify that GlobalTransPoint id is valid.
	 * @param GlobalTransPoint GlobalTransPoint
	 * @return boolean
	 */
	private boolean hasLinkToGlobalTransPoint(StockCosting stockCosting) {
		if(stockCosting.getTransPointId() != null) {
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