/*
 * Created on 24 �ub 2016 ( Time 16:27:51 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.InvoiceTransFactor;
import org.demo.bean.jpa.InvoiceTransFactorEntity;
import org.demo.bean.jpa.StockCostFactorEntity;
import org.demo.bean.jpa.InvoiceTransEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class InvoiceTransFactorServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public InvoiceTransFactorServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'InvoiceTransFactorEntity' to 'InvoiceTransFactor'
	 * @param invoiceTransFactorEntity
	 */
	public InvoiceTransFactor mapInvoiceTransFactorEntityToInvoiceTransFactor(InvoiceTransFactorEntity invoiceTransFactorEntity) {
		if(invoiceTransFactorEntity == null) {
			return null;
		}

		//--- Generic mapping 
		InvoiceTransFactor invoiceTransFactor = map(invoiceTransFactorEntity, InvoiceTransFactor.class);

		//--- Link mapping ( link to StockCostFactor )
		if(invoiceTransFactorEntity.getStockCostFactor() != null) {
			invoiceTransFactor.setFactorId(invoiceTransFactorEntity.getStockCostFactor().getId());
		}
		//--- Link mapping ( link to InvoiceTrans )
		if(invoiceTransFactorEntity.getInvoiceTrans() != null) {
			invoiceTransFactor.setTransId(invoiceTransFactorEntity.getInvoiceTrans().getId());
		}
		return invoiceTransFactor;
	}
	
	/**
	 * Mapping from 'InvoiceTransFactor' to 'InvoiceTransFactorEntity'
	 * @param invoiceTransFactor
	 * @param invoiceTransFactorEntity
	 */
	public void mapInvoiceTransFactorToInvoiceTransFactorEntity(InvoiceTransFactor invoiceTransFactor, InvoiceTransFactorEntity invoiceTransFactorEntity) {
		if(invoiceTransFactor == null) {
			return;
		}

		//--- Generic mapping 
		map(invoiceTransFactor, invoiceTransFactorEntity);

		//--- Link mapping ( link : invoiceTransFactor )
		if( hasLinkToStockCostFactor(invoiceTransFactor) ) {
			StockCostFactorEntity stockCostFactor1 = new StockCostFactorEntity();
			stockCostFactor1.setId( invoiceTransFactor.getFactorId() );
			invoiceTransFactorEntity.setStockCostFactor( stockCostFactor1 );
		} else {
			invoiceTransFactorEntity.setStockCostFactor( null );
		}

		//--- Link mapping ( link : invoiceTransFactor )
		if( hasLinkToInvoiceTrans(invoiceTransFactor) ) {
			InvoiceTransEntity invoiceTrans2 = new InvoiceTransEntity();
			invoiceTrans2.setId( invoiceTransFactor.getTransId() );
			invoiceTransFactorEntity.setInvoiceTrans( invoiceTrans2 );
		} else {
			invoiceTransFactorEntity.setInvoiceTrans( null );
		}

	}
	
	/**
	 * Verify that StockCostFactor id is valid.
	 * @param StockCostFactor StockCostFactor
	 * @return boolean
	 */
	private boolean hasLinkToStockCostFactor(InvoiceTransFactor invoiceTransFactor) {
		if(invoiceTransFactor.getFactorId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that InvoiceTrans id is valid.
	 * @param InvoiceTrans InvoiceTrans
	 * @return boolean
	 */
	private boolean hasLinkToInvoiceTrans(InvoiceTransFactor invoiceTransFactor) {
		if(invoiceTransFactor.getTransId() != null) {
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