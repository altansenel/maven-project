/*
 * Created on 24 �ub 2016 ( Time 16:27:49 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.BankExpense;
import org.demo.bean.jpa.BankExpenseEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class BankExpenseServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public BankExpenseServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'BankExpenseEntity' to 'BankExpense'
	 * @param bankExpenseEntity
	 */
	public BankExpense mapBankExpenseEntityToBankExpense(BankExpenseEntity bankExpenseEntity) {
		if(bankExpenseEntity == null) {
			return null;
		}

		//--- Generic mapping 
		BankExpense bankExpense = map(bankExpenseEntity, BankExpense.class);

		return bankExpense;
	}
	
	/**
	 * Mapping from 'BankExpense' to 'BankExpenseEntity'
	 * @param bankExpense
	 * @param bankExpenseEntity
	 */
	public void mapBankExpenseToBankExpenseEntity(BankExpense bankExpense, BankExpenseEntity bankExpenseEntity) {
		if(bankExpense == null) {
			return;
		}

		//--- Generic mapping 
		map(bankExpense, bankExpenseEntity);

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