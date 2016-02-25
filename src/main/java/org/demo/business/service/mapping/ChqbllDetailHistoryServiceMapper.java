/*
 * Created on 24 �ub 2016 ( Time 16:27:50 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.ChqbllDetailHistory;
import org.demo.bean.jpa.ChqbllDetailHistoryEntity;
import org.demo.bean.jpa.ContactEntity;
import org.demo.bean.jpa.SafeEntity;
import org.demo.bean.jpa.BankEntity;
import org.demo.bean.jpa.ChqbllPayrollDetailEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class ChqbllDetailHistoryServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public ChqbllDetailHistoryServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'ChqbllDetailHistoryEntity' to 'ChqbllDetailHistory'
	 * @param chqbllDetailHistoryEntity
	 */
	public ChqbllDetailHistory mapChqbllDetailHistoryEntityToChqbllDetailHistory(ChqbllDetailHistoryEntity chqbllDetailHistoryEntity) {
		if(chqbllDetailHistoryEntity == null) {
			return null;
		}

		//--- Generic mapping 
		ChqbllDetailHistory chqbllDetailHistory = map(chqbllDetailHistoryEntity, ChqbllDetailHistory.class);

		//--- Link mapping ( link to Contact )
		if(chqbllDetailHistoryEntity.getContact() != null) {
			chqbllDetailHistory.setContactId(chqbllDetailHistoryEntity.getContact().getId());
		}
		//--- Link mapping ( link to Safe )
		if(chqbllDetailHistoryEntity.getSafe() != null) {
			chqbllDetailHistory.setSafeId(chqbllDetailHistoryEntity.getSafe().getId());
		}
		//--- Link mapping ( link to Bank )
		if(chqbllDetailHistoryEntity.getBank() != null) {
			chqbllDetailHistory.setBankId(chqbllDetailHistoryEntity.getBank().getId());
		}
		//--- Link mapping ( link to ChqbllPayrollDetail )
		if(chqbllDetailHistoryEntity.getChqbllPayrollDetail() != null) {
			chqbllDetailHistory.setDetailId(chqbllDetailHistoryEntity.getChqbllPayrollDetail().getId());
		}
		return chqbllDetailHistory;
	}
	
	/**
	 * Mapping from 'ChqbllDetailHistory' to 'ChqbllDetailHistoryEntity'
	 * @param chqbllDetailHistory
	 * @param chqbllDetailHistoryEntity
	 */
	public void mapChqbllDetailHistoryToChqbllDetailHistoryEntity(ChqbllDetailHistory chqbllDetailHistory, ChqbllDetailHistoryEntity chqbllDetailHistoryEntity) {
		if(chqbllDetailHistory == null) {
			return;
		}

		//--- Generic mapping 
		map(chqbllDetailHistory, chqbllDetailHistoryEntity);

		//--- Link mapping ( link : chqbllDetailHistory )
		if( hasLinkToContact(chqbllDetailHistory) ) {
			ContactEntity contact1 = new ContactEntity();
			contact1.setId( chqbllDetailHistory.getContactId() );
			chqbllDetailHistoryEntity.setContact( contact1 );
		} else {
			chqbllDetailHistoryEntity.setContact( null );
		}

		//--- Link mapping ( link : chqbllDetailHistory )
		if( hasLinkToSafe(chqbllDetailHistory) ) {
			SafeEntity safe2 = new SafeEntity();
			safe2.setId( chqbllDetailHistory.getSafeId() );
			chqbllDetailHistoryEntity.setSafe( safe2 );
		} else {
			chqbllDetailHistoryEntity.setSafe( null );
		}

		//--- Link mapping ( link : chqbllDetailHistory )
		if( hasLinkToBank(chqbllDetailHistory) ) {
			BankEntity bank3 = new BankEntity();
			bank3.setId( chqbllDetailHistory.getBankId() );
			chqbllDetailHistoryEntity.setBank( bank3 );
		} else {
			chqbllDetailHistoryEntity.setBank( null );
		}

		//--- Link mapping ( link : chqbllDetailHistory )
		if( hasLinkToChqbllPayrollDetail(chqbllDetailHistory) ) {
			ChqbllPayrollDetailEntity chqbllPayrollDetail4 = new ChqbllPayrollDetailEntity();
			chqbllPayrollDetail4.setId( chqbllDetailHistory.getDetailId() );
			chqbllDetailHistoryEntity.setChqbllPayrollDetail( chqbllPayrollDetail4 );
		} else {
			chqbllDetailHistoryEntity.setChqbllPayrollDetail( null );
		}

	}
	
	/**
	 * Verify that Contact id is valid.
	 * @param Contact Contact
	 * @return boolean
	 */
	private boolean hasLinkToContact(ChqbllDetailHistory chqbllDetailHistory) {
		if(chqbllDetailHistory.getContactId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that Safe id is valid.
	 * @param Safe Safe
	 * @return boolean
	 */
	private boolean hasLinkToSafe(ChqbllDetailHistory chqbllDetailHistory) {
		if(chqbllDetailHistory.getSafeId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that Bank id is valid.
	 * @param Bank Bank
	 * @return boolean
	 */
	private boolean hasLinkToBank(ChqbllDetailHistory chqbllDetailHistory) {
		if(chqbllDetailHistory.getBankId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that ChqbllPayrollDetail id is valid.
	 * @param ChqbllPayrollDetail ChqbllPayrollDetail
	 * @return boolean
	 */
	private boolean hasLinkToChqbllPayrollDetail(ChqbllDetailHistory chqbllDetailHistory) {
		if(chqbllDetailHistory.getDetailId() != null) {
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