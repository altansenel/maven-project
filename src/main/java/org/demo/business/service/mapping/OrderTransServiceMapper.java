/*
 * Created on 24 �ub 2016 ( Time 16:27:51 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.OrderTrans;
import org.demo.bean.jpa.OrderTransEntity;
import org.demo.bean.jpa.OrderTransStatusEntity;
import org.demo.bean.jpa.OrderTransSourceEntity;
import org.demo.bean.jpa.GlobalTransPointEntity;
import org.demo.bean.jpa.SaleSellerEntity;
import org.demo.bean.jpa.ContactEntity;
import org.demo.bean.jpa.GlobalPrivateCodeEntity;
import org.demo.bean.jpa.StockDepotEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class OrderTransServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public OrderTransServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'OrderTransEntity' to 'OrderTrans'
	 * @param orderTransEntity
	 */
	public OrderTrans mapOrderTransEntityToOrderTrans(OrderTransEntity orderTransEntity) {
		if(orderTransEntity == null) {
			return null;
		}

		//--- Generic mapping 
		OrderTrans orderTrans = map(orderTransEntity, OrderTrans.class);

		//--- Link mapping ( link to OrderTransStatus )
		if(orderTransEntity.getOrderTransStatus() != null) {
			orderTrans.setStatusId(orderTransEntity.getOrderTransStatus().getId());
		}
		//--- Link mapping ( link to OrderTransSource )
		if(orderTransEntity.getOrderTransSource() != null) {
			orderTrans.setTransSourceId(orderTransEntity.getOrderTransSource().getId());
		}
		//--- Link mapping ( link to GlobalTransPoint )
		if(orderTransEntity.getGlobalTransPoint() != null) {
			orderTrans.setTransPointId(orderTransEntity.getGlobalTransPoint().getId());
		}
		//--- Link mapping ( link to SaleSeller )
		if(orderTransEntity.getSaleSeller() != null) {
			orderTrans.setSellerId(orderTransEntity.getSaleSeller().getId());
		}
		//--- Link mapping ( link to Contact )
		if(orderTransEntity.getContact() != null) {
			orderTrans.setContactId(orderTransEntity.getContact().getId());
		}
		//--- Link mapping ( link to GlobalPrivateCode )
		if(orderTransEntity.getGlobalPrivateCode() != null) {
			orderTrans.setPrivateCodeId(orderTransEntity.getGlobalPrivateCode().getId());
		}
		//--- Link mapping ( link to StockDepot )
		if(orderTransEntity.getStockDepot() != null) {
			orderTrans.setDepotId(orderTransEntity.getStockDepot().getId());
		}
		return orderTrans;
	}
	
	/**
	 * Mapping from 'OrderTrans' to 'OrderTransEntity'
	 * @param orderTrans
	 * @param orderTransEntity
	 */
	public void mapOrderTransToOrderTransEntity(OrderTrans orderTrans, OrderTransEntity orderTransEntity) {
		if(orderTrans == null) {
			return;
		}

		//--- Generic mapping 
		map(orderTrans, orderTransEntity);

		//--- Link mapping ( link : orderTrans )
		if( hasLinkToOrderTransStatus(orderTrans) ) {
			OrderTransStatusEntity orderTransStatus1 = new OrderTransStatusEntity();
			orderTransStatus1.setId( orderTrans.getStatusId() );
			orderTransEntity.setOrderTransStatus( orderTransStatus1 );
		} else {
			orderTransEntity.setOrderTransStatus( null );
		}

		//--- Link mapping ( link : orderTrans )
		if( hasLinkToOrderTransSource(orderTrans) ) {
			OrderTransSourceEntity orderTransSource2 = new OrderTransSourceEntity();
			orderTransSource2.setId( orderTrans.getTransSourceId() );
			orderTransEntity.setOrderTransSource( orderTransSource2 );
		} else {
			orderTransEntity.setOrderTransSource( null );
		}

		//--- Link mapping ( link : orderTrans )
		if( hasLinkToGlobalTransPoint(orderTrans) ) {
			GlobalTransPointEntity globalTransPoint3 = new GlobalTransPointEntity();
			globalTransPoint3.setId( orderTrans.getTransPointId() );
			orderTransEntity.setGlobalTransPoint( globalTransPoint3 );
		} else {
			orderTransEntity.setGlobalTransPoint( null );
		}

		//--- Link mapping ( link : orderTrans )
		if( hasLinkToSaleSeller(orderTrans) ) {
			SaleSellerEntity saleSeller4 = new SaleSellerEntity();
			saleSeller4.setId( orderTrans.getSellerId() );
			orderTransEntity.setSaleSeller( saleSeller4 );
		} else {
			orderTransEntity.setSaleSeller( null );
		}

		//--- Link mapping ( link : orderTrans )
		if( hasLinkToContact(orderTrans) ) {
			ContactEntity contact5 = new ContactEntity();
			contact5.setId( orderTrans.getContactId() );
			orderTransEntity.setContact( contact5 );
		} else {
			orderTransEntity.setContact( null );
		}

		//--- Link mapping ( link : orderTrans )
		if( hasLinkToGlobalPrivateCode(orderTrans) ) {
			GlobalPrivateCodeEntity globalPrivateCode6 = new GlobalPrivateCodeEntity();
			globalPrivateCode6.setId( orderTrans.getPrivateCodeId() );
			orderTransEntity.setGlobalPrivateCode( globalPrivateCode6 );
		} else {
			orderTransEntity.setGlobalPrivateCode( null );
		}

		//--- Link mapping ( link : orderTrans )
		if( hasLinkToStockDepot(orderTrans) ) {
			StockDepotEntity stockDepot7 = new StockDepotEntity();
			stockDepot7.setId( orderTrans.getDepotId() );
			orderTransEntity.setStockDepot( stockDepot7 );
		} else {
			orderTransEntity.setStockDepot( null );
		}

	}
	
	/**
	 * Verify that OrderTransStatus id is valid.
	 * @param OrderTransStatus OrderTransStatus
	 * @return boolean
	 */
	private boolean hasLinkToOrderTransStatus(OrderTrans orderTrans) {
		if(orderTrans.getStatusId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that OrderTransSource id is valid.
	 * @param OrderTransSource OrderTransSource
	 * @return boolean
	 */
	private boolean hasLinkToOrderTransSource(OrderTrans orderTrans) {
		if(orderTrans.getTransSourceId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that GlobalTransPoint id is valid.
	 * @param GlobalTransPoint GlobalTransPoint
	 * @return boolean
	 */
	private boolean hasLinkToGlobalTransPoint(OrderTrans orderTrans) {
		if(orderTrans.getTransPointId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that SaleSeller id is valid.
	 * @param SaleSeller SaleSeller
	 * @return boolean
	 */
	private boolean hasLinkToSaleSeller(OrderTrans orderTrans) {
		if(orderTrans.getSellerId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that Contact id is valid.
	 * @param Contact Contact
	 * @return boolean
	 */
	private boolean hasLinkToContact(OrderTrans orderTrans) {
		if(orderTrans.getContactId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that GlobalPrivateCode id is valid.
	 * @param GlobalPrivateCode GlobalPrivateCode
	 * @return boolean
	 */
	private boolean hasLinkToGlobalPrivateCode(OrderTrans orderTrans) {
		if(orderTrans.getPrivateCodeId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that StockDepot id is valid.
	 * @param StockDepot StockDepot
	 * @return boolean
	 */
	private boolean hasLinkToStockDepot(OrderTrans orderTrans) {
		if(orderTrans.getDepotId() != null) {
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