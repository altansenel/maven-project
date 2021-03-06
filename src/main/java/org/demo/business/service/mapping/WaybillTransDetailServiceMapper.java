/*
 * Created on 24 �ub 2016 ( Time 16:27:53 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.WaybillTransDetail;
import org.demo.bean.jpa.WaybillTransDetailEntity;
import org.demo.bean.jpa.WaybillTransStatusEntity;
import org.demo.bean.jpa.SaleSellerEntity;
import org.demo.bean.jpa.WaybillTransEntity;
import org.demo.bean.jpa.WaybillTransSourceEntity;
import org.demo.bean.jpa.StockEntity;
import org.demo.bean.jpa.GlobalTransPointEntity;
import org.demo.bean.jpa.StockDepotEntity;
import org.demo.bean.jpa.GlobalPrivateCodeEntity;
import org.demo.bean.jpa.ContactEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class WaybillTransDetailServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public WaybillTransDetailServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'WaybillTransDetailEntity' to 'WaybillTransDetail'
	 * @param waybillTransDetailEntity
	 */
	public WaybillTransDetail mapWaybillTransDetailEntityToWaybillTransDetail(WaybillTransDetailEntity waybillTransDetailEntity) {
		if(waybillTransDetailEntity == null) {
			return null;
		}

		//--- Generic mapping 
		WaybillTransDetail waybillTransDetail = map(waybillTransDetailEntity, WaybillTransDetail.class);

		//--- Link mapping ( link to WaybillTransStatus )
		if(waybillTransDetailEntity.getWaybillTransStatus() != null) {
			waybillTransDetail.setStatusId(waybillTransDetailEntity.getWaybillTransStatus().getId());
		}
		//--- Link mapping ( link to SaleSeller )
		if(waybillTransDetailEntity.getSaleSeller() != null) {
			waybillTransDetail.setSellerId(waybillTransDetailEntity.getSaleSeller().getId());
		}
		//--- Link mapping ( link to WaybillTrans )
		if(waybillTransDetailEntity.getWaybillTrans() != null) {
			waybillTransDetail.setTransId(waybillTransDetailEntity.getWaybillTrans().getId());
		}
		//--- Link mapping ( link to WaybillTransSource )
		if(waybillTransDetailEntity.getWaybillTransSource() != null) {
			waybillTransDetail.setTransSourceId(waybillTransDetailEntity.getWaybillTransSource().getId());
		}
		//--- Link mapping ( link to Stock )
		if(waybillTransDetailEntity.getStock() != null) {
			waybillTransDetail.setStockId(waybillTransDetailEntity.getStock().getId());
		}
		//--- Link mapping ( link to GlobalTransPoint )
		if(waybillTransDetailEntity.getGlobalTransPoint() != null) {
			waybillTransDetail.setTransPointId(waybillTransDetailEntity.getGlobalTransPoint().getId());
		}
		//--- Link mapping ( link to StockDepot )
		if(waybillTransDetailEntity.getStockDepot() != null) {
			waybillTransDetail.setDepotId(waybillTransDetailEntity.getStockDepot().getId());
		}
		//--- Link mapping ( link to GlobalPrivateCode )
		if(waybillTransDetailEntity.getGlobalPrivateCode() != null) {
			waybillTransDetail.setPrivateCodeId(waybillTransDetailEntity.getGlobalPrivateCode().getId());
		}
		//--- Link mapping ( link to Contact )
		if(waybillTransDetailEntity.getContact() != null) {
			waybillTransDetail.setContactId(waybillTransDetailEntity.getContact().getId());
		}
		return waybillTransDetail;
	}
	
	/**
	 * Mapping from 'WaybillTransDetail' to 'WaybillTransDetailEntity'
	 * @param waybillTransDetail
	 * @param waybillTransDetailEntity
	 */
	public void mapWaybillTransDetailToWaybillTransDetailEntity(WaybillTransDetail waybillTransDetail, WaybillTransDetailEntity waybillTransDetailEntity) {
		if(waybillTransDetail == null) {
			return;
		}

		//--- Generic mapping 
		map(waybillTransDetail, waybillTransDetailEntity);

		//--- Link mapping ( link : waybillTransDetail )
		if( hasLinkToWaybillTransStatus(waybillTransDetail) ) {
			WaybillTransStatusEntity waybillTransStatus1 = new WaybillTransStatusEntity();
			waybillTransStatus1.setId( waybillTransDetail.getStatusId() );
			waybillTransDetailEntity.setWaybillTransStatus( waybillTransStatus1 );
		} else {
			waybillTransDetailEntity.setWaybillTransStatus( null );
		}

		//--- Link mapping ( link : waybillTransDetail )
		if( hasLinkToSaleSeller(waybillTransDetail) ) {
			SaleSellerEntity saleSeller2 = new SaleSellerEntity();
			saleSeller2.setId( waybillTransDetail.getSellerId() );
			waybillTransDetailEntity.setSaleSeller( saleSeller2 );
		} else {
			waybillTransDetailEntity.setSaleSeller( null );
		}

		//--- Link mapping ( link : waybillTransDetail )
		if( hasLinkToWaybillTrans(waybillTransDetail) ) {
			WaybillTransEntity waybillTrans3 = new WaybillTransEntity();
			waybillTrans3.setId( waybillTransDetail.getTransId() );
			waybillTransDetailEntity.setWaybillTrans( waybillTrans3 );
		} else {
			waybillTransDetailEntity.setWaybillTrans( null );
		}

		//--- Link mapping ( link : waybillTransDetail )
		if( hasLinkToWaybillTransSource(waybillTransDetail) ) {
			WaybillTransSourceEntity waybillTransSource4 = new WaybillTransSourceEntity();
			waybillTransSource4.setId( waybillTransDetail.getTransSourceId() );
			waybillTransDetailEntity.setWaybillTransSource( waybillTransSource4 );
		} else {
			waybillTransDetailEntity.setWaybillTransSource( null );
		}

		//--- Link mapping ( link : waybillTransDetail )
		if( hasLinkToStock(waybillTransDetail) ) {
			StockEntity stock5 = new StockEntity();
			stock5.setId( waybillTransDetail.getStockId() );
			waybillTransDetailEntity.setStock( stock5 );
		} else {
			waybillTransDetailEntity.setStock( null );
		}

		//--- Link mapping ( link : waybillTransDetail )
		if( hasLinkToGlobalTransPoint(waybillTransDetail) ) {
			GlobalTransPointEntity globalTransPoint6 = new GlobalTransPointEntity();
			globalTransPoint6.setId( waybillTransDetail.getTransPointId() );
			waybillTransDetailEntity.setGlobalTransPoint( globalTransPoint6 );
		} else {
			waybillTransDetailEntity.setGlobalTransPoint( null );
		}

		//--- Link mapping ( link : waybillTransDetail )
		if( hasLinkToStockDepot(waybillTransDetail) ) {
			StockDepotEntity stockDepot7 = new StockDepotEntity();
			stockDepot7.setId( waybillTransDetail.getDepotId() );
			waybillTransDetailEntity.setStockDepot( stockDepot7 );
		} else {
			waybillTransDetailEntity.setStockDepot( null );
		}

		//--- Link mapping ( link : waybillTransDetail )
		if( hasLinkToGlobalPrivateCode(waybillTransDetail) ) {
			GlobalPrivateCodeEntity globalPrivateCode8 = new GlobalPrivateCodeEntity();
			globalPrivateCode8.setId( waybillTransDetail.getPrivateCodeId() );
			waybillTransDetailEntity.setGlobalPrivateCode( globalPrivateCode8 );
		} else {
			waybillTransDetailEntity.setGlobalPrivateCode( null );
		}

		//--- Link mapping ( link : waybillTransDetail )
		if( hasLinkToContact(waybillTransDetail) ) {
			ContactEntity contact9 = new ContactEntity();
			contact9.setId( waybillTransDetail.getContactId() );
			waybillTransDetailEntity.setContact( contact9 );
		} else {
			waybillTransDetailEntity.setContact( null );
		}

	}
	
	/**
	 * Verify that WaybillTransStatus id is valid.
	 * @param WaybillTransStatus WaybillTransStatus
	 * @return boolean
	 */
	private boolean hasLinkToWaybillTransStatus(WaybillTransDetail waybillTransDetail) {
		if(waybillTransDetail.getStatusId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that SaleSeller id is valid.
	 * @param SaleSeller SaleSeller
	 * @return boolean
	 */
	private boolean hasLinkToSaleSeller(WaybillTransDetail waybillTransDetail) {
		if(waybillTransDetail.getSellerId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that WaybillTrans id is valid.
	 * @param WaybillTrans WaybillTrans
	 * @return boolean
	 */
	private boolean hasLinkToWaybillTrans(WaybillTransDetail waybillTransDetail) {
		if(waybillTransDetail.getTransId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that WaybillTransSource id is valid.
	 * @param WaybillTransSource WaybillTransSource
	 * @return boolean
	 */
	private boolean hasLinkToWaybillTransSource(WaybillTransDetail waybillTransDetail) {
		if(waybillTransDetail.getTransSourceId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that Stock id is valid.
	 * @param Stock Stock
	 * @return boolean
	 */
	private boolean hasLinkToStock(WaybillTransDetail waybillTransDetail) {
		if(waybillTransDetail.getStockId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that GlobalTransPoint id is valid.
	 * @param GlobalTransPoint GlobalTransPoint
	 * @return boolean
	 */
	private boolean hasLinkToGlobalTransPoint(WaybillTransDetail waybillTransDetail) {
		if(waybillTransDetail.getTransPointId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that StockDepot id is valid.
	 * @param StockDepot StockDepot
	 * @return boolean
	 */
	private boolean hasLinkToStockDepot(WaybillTransDetail waybillTransDetail) {
		if(waybillTransDetail.getDepotId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that GlobalPrivateCode id is valid.
	 * @param GlobalPrivateCode GlobalPrivateCode
	 * @return boolean
	 */
	private boolean hasLinkToGlobalPrivateCode(WaybillTransDetail waybillTransDetail) {
		if(waybillTransDetail.getPrivateCodeId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that Contact id is valid.
	 * @param Contact Contact
	 * @return boolean
	 */
	private boolean hasLinkToContact(WaybillTransDetail waybillTransDetail) {
		if(waybillTransDetail.getContactId() != null) {
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