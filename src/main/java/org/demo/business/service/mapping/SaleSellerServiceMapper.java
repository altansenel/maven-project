/*
 * Created on 24 �ub 2016 ( Time 16:27:52 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.SaleSeller;
import org.demo.bean.jpa.SaleSellerEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class SaleSellerServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public SaleSellerServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'SaleSellerEntity' to 'SaleSeller'
	 * @param saleSellerEntity
	 */
	public SaleSeller mapSaleSellerEntityToSaleSeller(SaleSellerEntity saleSellerEntity) {
		if(saleSellerEntity == null) {
			return null;
		}

		//--- Generic mapping 
		SaleSeller saleSeller = map(saleSellerEntity, SaleSeller.class);

		return saleSeller;
	}
	
	/**
	 * Mapping from 'SaleSeller' to 'SaleSellerEntity'
	 * @param saleSeller
	 * @param saleSellerEntity
	 */
	public void mapSaleSellerToSaleSellerEntity(SaleSeller saleSeller, SaleSellerEntity saleSellerEntity) {
		if(saleSeller == null) {
			return;
		}

		//--- Generic mapping 
		map(saleSeller, saleSellerEntity);

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