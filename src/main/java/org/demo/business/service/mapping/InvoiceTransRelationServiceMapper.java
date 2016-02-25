/*
 * Created on 24 �ub 2016 ( Time 16:27:51 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.InvoiceTransRelation;
import org.demo.bean.jpa.InvoiceTransRelationEntity;
import org.demo.bean.jpa.InvoiceTransEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class InvoiceTransRelationServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public InvoiceTransRelationServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'InvoiceTransRelationEntity' to 'InvoiceTransRelation'
	 * @param invoiceTransRelationEntity
	 */
	public InvoiceTransRelation mapInvoiceTransRelationEntityToInvoiceTransRelation(InvoiceTransRelationEntity invoiceTransRelationEntity) {
		if(invoiceTransRelationEntity == null) {
			return null;
		}

		//--- Generic mapping 
		InvoiceTransRelation invoiceTransRelation = map(invoiceTransRelationEntity, InvoiceTransRelation.class);

		//--- Link mapping ( link to InvoiceTrans )
		if(invoiceTransRelationEntity.getInvoiceTrans() != null) {
			invoiceTransRelation.setTransId(invoiceTransRelationEntity.getInvoiceTrans().getId());
		}
		return invoiceTransRelation;
	}
	
	/**
	 * Mapping from 'InvoiceTransRelation' to 'InvoiceTransRelationEntity'
	 * @param invoiceTransRelation
	 * @param invoiceTransRelationEntity
	 */
	public void mapInvoiceTransRelationToInvoiceTransRelationEntity(InvoiceTransRelation invoiceTransRelation, InvoiceTransRelationEntity invoiceTransRelationEntity) {
		if(invoiceTransRelation == null) {
			return;
		}

		//--- Generic mapping 
		map(invoiceTransRelation, invoiceTransRelationEntity);

		//--- Link mapping ( link : invoiceTransRelation )
		if( hasLinkToInvoiceTrans(invoiceTransRelation) ) {
			InvoiceTransEntity invoiceTrans1 = new InvoiceTransEntity();
			invoiceTrans1.setId( invoiceTransRelation.getTransId() );
			invoiceTransRelationEntity.setInvoiceTrans( invoiceTrans1 );
		} else {
			invoiceTransRelationEntity.setInvoiceTrans( null );
		}

	}
	
	/**
	 * Verify that InvoiceTrans id is valid.
	 * @param InvoiceTrans InvoiceTrans
	 * @return boolean
	 */
	private boolean hasLinkToInvoiceTrans(InvoiceTransRelation invoiceTransRelation) {
		if(invoiceTransRelation.getTransId() != null) {
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