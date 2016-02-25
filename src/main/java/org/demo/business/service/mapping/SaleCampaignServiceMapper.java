/*
 * Created on 24 �ub 2016 ( Time 16:27:52 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.demo.bean.SaleCampaign;
import org.demo.bean.jpa.SaleCampaignEntity;
import org.demo.bean.jpa.StockCategoryEntity;
import org.demo.bean.jpa.StockExtraFieldsEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class SaleCampaignServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public SaleCampaignServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'SaleCampaignEntity' to 'SaleCampaign'
	 * @param saleCampaignEntity
	 */
	public SaleCampaign mapSaleCampaignEntityToSaleCampaign(SaleCampaignEntity saleCampaignEntity) {
		if(saleCampaignEntity == null) {
			return null;
		}

		//--- Generic mapping 
		SaleCampaign saleCampaign = map(saleCampaignEntity, SaleCampaign.class);

		//--- Link mapping ( link to StockExtraFields )
		if(saleCampaignEntity.getStockExtraFields9() != null) {
			saleCampaign.setExtraField6Id(saleCampaignEntity.getStockExtraFields9().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(saleCampaignEntity.getStockExtraFields5() != null) {
			saleCampaign.setExtraField2Id(saleCampaignEntity.getStockExtraFields5().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(saleCampaignEntity.getStockExtraFields2() != null) {
			saleCampaign.setExtraField9Id(saleCampaignEntity.getStockExtraFields2().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(saleCampaignEntity.getStockExtraFields10() != null) {
			saleCampaign.setExtraField7Id(saleCampaignEntity.getStockExtraFields10().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(saleCampaignEntity.getStockExtraFields6() != null) {
			saleCampaign.setExtraField3Id(saleCampaignEntity.getStockExtraFields6().getId());
		}
		//--- Link mapping ( link to StockCategory )
		if(saleCampaignEntity.getStockCategory() != null) {
			saleCampaign.setStockCategoryId(saleCampaignEntity.getStockCategory().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(saleCampaignEntity.getStockExtraFields7() != null) {
			saleCampaign.setExtraField4Id(saleCampaignEntity.getStockExtraFields7().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(saleCampaignEntity.getStockExtraFields3() != null) {
			saleCampaign.setExtraField0Id(saleCampaignEntity.getStockExtraFields3().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(saleCampaignEntity.getStockExtraFields8() != null) {
			saleCampaign.setExtraField5Id(saleCampaignEntity.getStockExtraFields8().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(saleCampaignEntity.getStockExtraFields4() != null) {
			saleCampaign.setExtraField1Id(saleCampaignEntity.getStockExtraFields4().getId());
		}
		//--- Link mapping ( link to StockExtraFields )
		if(saleCampaignEntity.getStockExtraFields() != null) {
			saleCampaign.setExtraField8Id(saleCampaignEntity.getStockExtraFields().getId());
		}
		return saleCampaign;
	}
	
	/**
	 * Mapping from 'SaleCampaign' to 'SaleCampaignEntity'
	 * @param saleCampaign
	 * @param saleCampaignEntity
	 */
	public void mapSaleCampaignToSaleCampaignEntity(SaleCampaign saleCampaign, SaleCampaignEntity saleCampaignEntity) {
		if(saleCampaign == null) {
			return;
		}

		//--- Generic mapping 
		map(saleCampaign, saleCampaignEntity);

		//--- Link mapping ( link : saleCampaign )
		if( hasLinkToStockExtraFields(saleCampaign) ) {
			StockExtraFieldsEntity stockExtraFields1 = new StockExtraFieldsEntity();
			stockExtraFields1.setId( saleCampaign.getExtraField6Id() );
			saleCampaignEntity.setStockExtraFields9( stockExtraFields1 );
		} else {
			saleCampaignEntity.setStockExtraFields9( null );
		}

		//--- Link mapping ( link : saleCampaign )
		if( hasLinkToStockExtraFields(saleCampaign) ) {
			StockExtraFieldsEntity stockExtraFields2 = new StockExtraFieldsEntity();
			stockExtraFields2.setId( saleCampaign.getExtraField2Id() );
			saleCampaignEntity.setStockExtraFields5( stockExtraFields2 );
		} else {
			saleCampaignEntity.setStockExtraFields5( null );
		}

		//--- Link mapping ( link : saleCampaign )
		if( hasLinkToStockExtraFields(saleCampaign) ) {
			StockExtraFieldsEntity stockExtraFields3 = new StockExtraFieldsEntity();
			stockExtraFields3.setId( saleCampaign.getExtraField9Id() );
			saleCampaignEntity.setStockExtraFields2( stockExtraFields3 );
		} else {
			saleCampaignEntity.setStockExtraFields2( null );
		}

		//--- Link mapping ( link : saleCampaign )
		if( hasLinkToStockExtraFields(saleCampaign) ) {
			StockExtraFieldsEntity stockExtraFields4 = new StockExtraFieldsEntity();
			stockExtraFields4.setId( saleCampaign.getExtraField7Id() );
			saleCampaignEntity.setStockExtraFields10( stockExtraFields4 );
		} else {
			saleCampaignEntity.setStockExtraFields10( null );
		}

		//--- Link mapping ( link : saleCampaign )
		if( hasLinkToStockExtraFields(saleCampaign) ) {
			StockExtraFieldsEntity stockExtraFields5 = new StockExtraFieldsEntity();
			stockExtraFields5.setId( saleCampaign.getExtraField3Id() );
			saleCampaignEntity.setStockExtraFields6( stockExtraFields5 );
		} else {
			saleCampaignEntity.setStockExtraFields6( null );
		}

		//--- Link mapping ( link : saleCampaign )
		if( hasLinkToStockCategory(saleCampaign) ) {
			StockCategoryEntity stockCategory6 = new StockCategoryEntity();
			stockCategory6.setId( saleCampaign.getStockCategoryId() );
			saleCampaignEntity.setStockCategory( stockCategory6 );
		} else {
			saleCampaignEntity.setStockCategory( null );
		}

		//--- Link mapping ( link : saleCampaign )
		if( hasLinkToStockExtraFields(saleCampaign) ) {
			StockExtraFieldsEntity stockExtraFields7 = new StockExtraFieldsEntity();
			stockExtraFields7.setId( saleCampaign.getExtraField4Id() );
			saleCampaignEntity.setStockExtraFields7( stockExtraFields7 );
		} else {
			saleCampaignEntity.setStockExtraFields7( null );
		}

		//--- Link mapping ( link : saleCampaign )
		if( hasLinkToStockExtraFields(saleCampaign) ) {
			StockExtraFieldsEntity stockExtraFields8 = new StockExtraFieldsEntity();
			stockExtraFields8.setId( saleCampaign.getExtraField0Id() );
			saleCampaignEntity.setStockExtraFields3( stockExtraFields8 );
		} else {
			saleCampaignEntity.setStockExtraFields3( null );
		}

		//--- Link mapping ( link : saleCampaign )
		if( hasLinkToStockExtraFields(saleCampaign) ) {
			StockExtraFieldsEntity stockExtraFields9 = new StockExtraFieldsEntity();
			stockExtraFields9.setId( saleCampaign.getExtraField5Id() );
			saleCampaignEntity.setStockExtraFields8( stockExtraFields9 );
		} else {
			saleCampaignEntity.setStockExtraFields8( null );
		}

		//--- Link mapping ( link : saleCampaign )
		if( hasLinkToStockExtraFields(saleCampaign) ) {
			StockExtraFieldsEntity stockExtraFields10 = new StockExtraFieldsEntity();
			stockExtraFields10.setId( saleCampaign.getExtraField1Id() );
			saleCampaignEntity.setStockExtraFields4( stockExtraFields10 );
		} else {
			saleCampaignEntity.setStockExtraFields4( null );
		}

		//--- Link mapping ( link : saleCampaign )
		if( hasLinkToStockExtraFields(saleCampaign) ) {
			StockExtraFieldsEntity stockExtraFields11 = new StockExtraFieldsEntity();
			stockExtraFields11.setId( saleCampaign.getExtraField8Id() );
			saleCampaignEntity.setStockExtraFields( stockExtraFields11 );
		} else {
			saleCampaignEntity.setStockExtraFields( null );
		}

	}
	
	/**
	 * Verify that StockExtraFields id is valid.
	 * @param StockExtraFields StockExtraFields
	 * @return boolean
	 */
	private boolean hasLinkToStockExtraFields(SaleCampaign saleCampaign) {
		if(saleCampaign.getExtraField6Id() != null) {
			return true;
		}
		return false;
	}


	/**
	 * Verify that StockCategory id is valid.
	 * @param StockCategory StockCategory
	 * @return boolean
	 */
	private boolean hasLinkToStockCategory(SaleCampaign saleCampaign) {
		if(saleCampaign.getStockCategoryId() != null) {
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