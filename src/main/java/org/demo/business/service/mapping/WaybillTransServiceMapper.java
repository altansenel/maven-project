/*
 * Created on 24 �ub 2016 ( Time 16:27:53 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.WaybillTrans;
import org.demo.bean.jpa.WaybillTransEntity;
import org.demo.bean.jpa.GlobalPrivateCodeEntity;
import org.demo.bean.jpa.StockDepotEntity;
import org.demo.bean.jpa.WaybillTransStatusEntity;
import org.demo.bean.jpa.WaybillTransSourceEntity;
import org.demo.bean.jpa.GlobalTransPointEntity;
import org.demo.bean.jpa.SaleSellerEntity;
import org.demo.bean.jpa.ContactEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class WaybillTransServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public WaybillTransServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'WaybillTransEntity' to 'WaybillTrans'
	 * @param waybillTransEntity
	 */
	public WaybillTrans mapWaybillTransEntityToWaybillTrans(WaybillTransEntity waybillTransEntity) {
		if(waybillTransEntity == null) {
			return null;
		}

		//--- Generic mapping 
		WaybillTrans waybillTrans = map(waybillTransEntity, WaybillTrans.class);

		//--- Link mapping ( link to GlobalPrivateCode )
		if(waybillTransEntity.getGlobalPrivateCode() != null) {
			waybillTrans.setPrivateCodeId(waybillTransEntity.getGlobalPrivateCode().getId());
		}
		//--- Link mapping ( link to StockDepot )
		if(waybillTransEntity.getStockDepot() != null) {
			waybillTrans.setDepotId(waybillTransEntity.getStockDepot().getId());
		}
		//--- Link mapping ( link to WaybillTransStatus )
		if(waybillTransEntity.getWaybillTransStatus() != null) {
			waybillTrans.setStatusId(waybillTransEntity.getWaybillTransStatus().getId());
		}
		//--- Link mapping ( link to WaybillTransSource )
		if(waybillTransEntity.getWaybillTransSource() != null) {
			waybillTrans.setTransSourceId(waybillTransEntity.getWaybillTransSource().getId());
		}
		//--- Link mapping ( link to GlobalTransPoint )
		if(waybillTransEntity.getGlobalTransPoint() != null) {
			waybillTrans.setTransPointId(waybillTransEntity.getGlobalTransPoint().getId());
		}
		//--- Link mapping ( link to SaleSeller )
		if(waybillTransEntity.getSaleSeller() != null) {
			waybillTrans.setSellerId(waybillTransEntity.getSaleSeller().getId());
		}
		//--- Link mapping ( link to Contact )
		if(waybillTransEntity.getContact() != null) {
			waybillTrans.setContactId(waybillTransEntity.getContact().getId());
		}
		return waybillTrans;
	}
	
	/**
	 * Mapping from 'WaybillTrans' to 'WaybillTransEntity'
	 * @param waybillTrans
	 * @param waybillTransEntity
	 */
	public void mapWaybillTransToWaybillTransEntity(WaybillTrans waybillTrans, WaybillTransEntity waybillTransEntity) {
		if(waybillTrans == null) {
			return;
		}

		//--- Generic mapping 
		map(waybillTrans, waybillTransEntity);

		//--- Link mapping ( link : waybillTrans )
		if( hasLinkToGlobalPrivateCode(waybillTrans) ) {
			GlobalPrivateCodeEntity globalPrivateCode1 = new GlobalPrivateCodeEntity();
			globalPrivateCode1.setId( waybillTrans.getPrivateCodeId() );
			waybillTransEntity.setGlobalPrivateCode( globalPrivateCode1 );
		} else {
			waybillTransEntity.setGlobalPrivateCode( null );
		}

		//--- Link mapping ( link : waybillTrans )
		if( hasLinkToStockDepot(waybillTrans) ) {
			StockDepotEntity stockDepot2 = new StockDepotEntity();
			stockDepot2.setId( waybillTrans.getDepotId() );
			waybillTransEntity.setStockDepot( stockDepot2 );
		} else {
			waybillTransEntity.setStockDepot( null );
		}

		//--- Link mapping ( link : waybillTrans )
		if( hasLinkToWaybillTransStatus(waybillTrans) ) {
			WaybillTransStatusEntity waybillTransStatus3 = new WaybillTransStatusEntity();
			waybillTransStatus3.setId( waybillTrans.getStatusId() );
			waybillTransEntity.setWaybillTransStatus( waybillTransStatus3 );
		} else {
			waybillTransEntity.setWaybillTransStatus( null );
		}

		//--- Link mapping ( link : waybillTrans )
		if( hasLinkToWaybillTransSource(waybillTrans) ) {
			WaybillTransSourceEntity waybillTransSource4 = new WaybillTransSourceEntity();
			waybillTransSource4.setId( waybillTrans.getTransSourceId() );
			waybillTransEntity.setWaybillTransSource( waybillTransSource4 );
		} else {
			waybillTransEntity.setWaybillTransSource( null );
		}

		//--- Link mapping ( link : waybillTrans )
		if( hasLinkToGlobalTransPoint(waybillTrans) ) {
			GlobalTransPointEntity globalTransPoint5 = new GlobalTransPointEntity();
			globalTransPoint5.setId( waybillTrans.getTransPointId() );
			waybillTransEntity.setGlobalTransPoint( globalTransPoint5 );
		} else {
			waybillTransEntity.setGlobalTransPoint( null );
		}

		//--- Link mapping ( link : waybillTrans )
		if( hasLinkToSaleSeller(waybillTrans) ) {
			SaleSellerEntity saleSeller6 = new SaleSellerEntity();
			saleSeller6.setId( waybillTrans.getSellerId() );
			waybillTransEntity.setSaleSeller( saleSeller6 );
		} else {
			waybillTransEntity.setSaleSeller( null );
		}

		//--- Link mapping ( link : waybillTrans )
		if( hasLinkToContact(waybillTrans) ) {
			ContactEntity contact7 = new ContactEntity();
			contact7.setId( waybillTrans.getContactId() );
			waybillTransEntity.setContact( contact7 );
		} else {
			waybillTransEntity.setContact( null );
		}

	}
	
	/**
	 * Verify that GlobalPrivateCode id is valid.
	 * @param GlobalPrivateCode GlobalPrivateCode
	 * @return boolean
	 */
	private boolean hasLinkToGlobalPrivateCode(WaybillTrans waybillTrans) {
		if(waybillTrans.getPrivateCodeId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that StockDepot id is valid.
	 * @param StockDepot StockDepot
	 * @return boolean
	 */
	private boolean hasLinkToStockDepot(WaybillTrans waybillTrans) {
		if(waybillTrans.getDepotId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that WaybillTransStatus id is valid.
	 * @param WaybillTransStatus WaybillTransStatus
	 * @return boolean
	 */
	private boolean hasLinkToWaybillTransStatus(WaybillTrans waybillTrans) {
		if(waybillTrans.getStatusId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that WaybillTransSource id is valid.
	 * @param WaybillTransSource WaybillTransSource
	 * @return boolean
	 */
	private boolean hasLinkToWaybillTransSource(WaybillTrans waybillTrans) {
		if(waybillTrans.getTransSourceId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that GlobalTransPoint id is valid.
	 * @param GlobalTransPoint GlobalTransPoint
	 * @return boolean
	 */
	private boolean hasLinkToGlobalTransPoint(WaybillTrans waybillTrans) {
		if(waybillTrans.getTransPointId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that SaleSeller id is valid.
	 * @param SaleSeller SaleSeller
	 * @return boolean
	 */
	private boolean hasLinkToSaleSeller(WaybillTrans waybillTrans) {
		if(waybillTrans.getSellerId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that Contact id is valid.
	 * @param Contact Contact
	 * @return boolean
	 */
	private boolean hasLinkToContact(WaybillTrans waybillTrans) {
		if(waybillTrans.getContactId() != null) {
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