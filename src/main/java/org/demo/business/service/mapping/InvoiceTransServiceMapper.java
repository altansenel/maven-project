/*
 * Created on 24 �ub 2016 ( Time 16:27:51 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.InvoiceTrans;
import org.demo.bean.jpa.InvoiceTransEntity;
import org.demo.bean.jpa.GlobalTransPointEntity;
import org.demo.bean.jpa.SaleSellerEntity;
import org.demo.bean.jpa.ContactEntity;
import org.demo.bean.jpa.GlobalPrivateCodeEntity;
import org.demo.bean.jpa.StockDepotEntity;
import org.demo.bean.jpa.InvoiceTransStatusEntity;
import org.demo.bean.jpa.InvoiceTransSourceEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class InvoiceTransServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public InvoiceTransServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'InvoiceTransEntity' to 'InvoiceTrans'
	 * @param invoiceTransEntity
	 */
	public InvoiceTrans mapInvoiceTransEntityToInvoiceTrans(InvoiceTransEntity invoiceTransEntity) {
		if(invoiceTransEntity == null) {
			return null;
		}

		//--- Generic mapping 
		InvoiceTrans invoiceTrans = map(invoiceTransEntity, InvoiceTrans.class);

		//--- Link mapping ( link to GlobalTransPoint )
		if(invoiceTransEntity.getGlobalTransPoint() != null) {
			invoiceTrans.setTransPointId(invoiceTransEntity.getGlobalTransPoint().getId());
		}
		//--- Link mapping ( link to SaleSeller )
		if(invoiceTransEntity.getSaleSeller() != null) {
			invoiceTrans.setSellerId(invoiceTransEntity.getSaleSeller().getId());
		}
		//--- Link mapping ( link to Contact )
		if(invoiceTransEntity.getContact() != null) {
			invoiceTrans.setContactId(invoiceTransEntity.getContact().getId());
		}
		//--- Link mapping ( link to GlobalPrivateCode )
		if(invoiceTransEntity.getGlobalPrivateCode() != null) {
			invoiceTrans.setPrivateCodeId(invoiceTransEntity.getGlobalPrivateCode().getId());
		}
		//--- Link mapping ( link to StockDepot )
		if(invoiceTransEntity.getStockDepot() != null) {
			invoiceTrans.setDepotId(invoiceTransEntity.getStockDepot().getId());
		}
		//--- Link mapping ( link to InvoiceTransStatus )
		if(invoiceTransEntity.getInvoiceTransStatus() != null) {
			invoiceTrans.setStatusId(invoiceTransEntity.getInvoiceTransStatus().getId());
		}
		//--- Link mapping ( link to InvoiceTransSource )
		if(invoiceTransEntity.getInvoiceTransSource() != null) {
			invoiceTrans.setTransSourceId(invoiceTransEntity.getInvoiceTransSource().getId());
		}
		return invoiceTrans;
	}
	
	/**
	 * Mapping from 'InvoiceTrans' to 'InvoiceTransEntity'
	 * @param invoiceTrans
	 * @param invoiceTransEntity
	 */
	public void mapInvoiceTransToInvoiceTransEntity(InvoiceTrans invoiceTrans, InvoiceTransEntity invoiceTransEntity) {
		if(invoiceTrans == null) {
			return;
		}

		//--- Generic mapping 
		map(invoiceTrans, invoiceTransEntity);

		//--- Link mapping ( link : invoiceTrans )
		if( hasLinkToGlobalTransPoint(invoiceTrans) ) {
			GlobalTransPointEntity globalTransPoint1 = new GlobalTransPointEntity();
			globalTransPoint1.setId( invoiceTrans.getTransPointId() );
			invoiceTransEntity.setGlobalTransPoint( globalTransPoint1 );
		} else {
			invoiceTransEntity.setGlobalTransPoint( null );
		}

		//--- Link mapping ( link : invoiceTrans )
		if( hasLinkToSaleSeller(invoiceTrans) ) {
			SaleSellerEntity saleSeller2 = new SaleSellerEntity();
			saleSeller2.setId( invoiceTrans.getSellerId() );
			invoiceTransEntity.setSaleSeller( saleSeller2 );
		} else {
			invoiceTransEntity.setSaleSeller( null );
		}

		//--- Link mapping ( link : invoiceTrans )
		if( hasLinkToContact(invoiceTrans) ) {
			ContactEntity contact3 = new ContactEntity();
			contact3.setId( invoiceTrans.getContactId() );
			invoiceTransEntity.setContact( contact3 );
		} else {
			invoiceTransEntity.setContact( null );
		}

		//--- Link mapping ( link : invoiceTrans )
		if( hasLinkToGlobalPrivateCode(invoiceTrans) ) {
			GlobalPrivateCodeEntity globalPrivateCode4 = new GlobalPrivateCodeEntity();
			globalPrivateCode4.setId( invoiceTrans.getPrivateCodeId() );
			invoiceTransEntity.setGlobalPrivateCode( globalPrivateCode4 );
		} else {
			invoiceTransEntity.setGlobalPrivateCode( null );
		}

		//--- Link mapping ( link : invoiceTrans )
		if( hasLinkToStockDepot(invoiceTrans) ) {
			StockDepotEntity stockDepot5 = new StockDepotEntity();
			stockDepot5.setId( invoiceTrans.getDepotId() );
			invoiceTransEntity.setStockDepot( stockDepot5 );
		} else {
			invoiceTransEntity.setStockDepot( null );
		}

		//--- Link mapping ( link : invoiceTrans )
		if( hasLinkToInvoiceTransStatus(invoiceTrans) ) {
			InvoiceTransStatusEntity invoiceTransStatus6 = new InvoiceTransStatusEntity();
			invoiceTransStatus6.setId( invoiceTrans.getStatusId() );
			invoiceTransEntity.setInvoiceTransStatus( invoiceTransStatus6 );
		} else {
			invoiceTransEntity.setInvoiceTransStatus( null );
		}

		//--- Link mapping ( link : invoiceTrans )
		if( hasLinkToInvoiceTransSource(invoiceTrans) ) {
			InvoiceTransSourceEntity invoiceTransSource7 = new InvoiceTransSourceEntity();
			invoiceTransSource7.setId( invoiceTrans.getTransSourceId() );
			invoiceTransEntity.setInvoiceTransSource( invoiceTransSource7 );
		} else {
			invoiceTransEntity.setInvoiceTransSource( null );
		}

	}
	
	/**
	 * Verify that GlobalTransPoint id is valid.
	 * @param GlobalTransPoint GlobalTransPoint
	 * @return boolean
	 */
	private boolean hasLinkToGlobalTransPoint(InvoiceTrans invoiceTrans) {
		if(invoiceTrans.getTransPointId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that SaleSeller id is valid.
	 * @param SaleSeller SaleSeller
	 * @return boolean
	 */
	private boolean hasLinkToSaleSeller(InvoiceTrans invoiceTrans) {
		if(invoiceTrans.getSellerId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that Contact id is valid.
	 * @param Contact Contact
	 * @return boolean
	 */
	private boolean hasLinkToContact(InvoiceTrans invoiceTrans) {
		if(invoiceTrans.getContactId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that GlobalPrivateCode id is valid.
	 * @param GlobalPrivateCode GlobalPrivateCode
	 * @return boolean
	 */
	private boolean hasLinkToGlobalPrivateCode(InvoiceTrans invoiceTrans) {
		if(invoiceTrans.getPrivateCodeId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that StockDepot id is valid.
	 * @param StockDepot StockDepot
	 * @return boolean
	 */
	private boolean hasLinkToStockDepot(InvoiceTrans invoiceTrans) {
		if(invoiceTrans.getDepotId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that InvoiceTransStatus id is valid.
	 * @param InvoiceTransStatus InvoiceTransStatus
	 * @return boolean
	 */
	private boolean hasLinkToInvoiceTransStatus(InvoiceTrans invoiceTrans) {
		if(invoiceTrans.getStatusId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that InvoiceTransSource id is valid.
	 * @param InvoiceTransSource InvoiceTransSource
	 * @return boolean
	 */
	private boolean hasLinkToInvoiceTransSource(InvoiceTrans invoiceTrans) {
		if(invoiceTrans.getTransSourceId() != null) {
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