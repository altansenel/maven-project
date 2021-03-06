/*
 * Created on 24 �ub 2016 ( Time 16:27:49 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.Bank;
import org.demo.bean.jpa.BankEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class BankServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public BankServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'BankEntity' to 'Bank'
	 * @param bankEntity
	 */
	public Bank mapBankEntityToBank(BankEntity bankEntity) {
		if(bankEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Bank bank = map(bankEntity, Bank.class);

		return bank;
	}
	
	/**
	 * Mapping from 'Bank' to 'BankEntity'
	 * @param bank
	 * @param bankEntity
	 */
	public void mapBankToBankEntity(Bank bank, BankEntity bankEntity) {
		if(bank == null) {
			return;
		}

		//--- Generic mapping 
		map(bank, bankEntity);

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